package com.company.cglib;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.sf.cglib.beans.BeanGenerator;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.FixedValue;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.Proxy;

/**
 * @author dkorolev
 *         Date: 4/4/2019
 *         Time: 4:32 PM
 */
public class CglibMain {
    public static void main(String[] args) {
        //original
        PersonalServiceImpl personalServiceImpl = new PersonalServiceImpl();
        System.out.println(personalServiceImpl.sayHello("Tom"));

        //Fixed output
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonalServiceImpl.class);
        enhancer.setCallback((FixedValue) () -> "Hello, Jack!");
        PersonalServiceImpl personalServiceImplProxy = (PersonalServiceImpl) enhancer.create();
        System.out.println(personalServiceImplProxy.sayHello("Tom"));
        //System.out.println(personalServiceImplProxy.lengthOfName("Hello, Tom")); ClassCastException (String -> Integer)


        //Complex behavior (lengthOfName won't be intercepted)
        Enhancer enhancer1 = new Enhancer();
        enhancer1.setSuperclass(PersonalServiceImpl.class);
        enhancer1.setCallback((MethodInterceptor) (obj, method, arg1, proxy) -> {
            if (method.getReturnType() == String.class) {
                return "Hello, Jack!";
            } else {
                return proxy.invokeSuper(obj, arg1);
            }
        });
        PersonalServiceImpl personalServiceImplProxy1 = (PersonalServiceImpl) enhancer1.create();
        System.out.println(personalServiceImplProxy1.sayHello("Tom"));
        System.out.println(personalServiceImplProxy1.lengthOfName("Hello, Tom"));
        System.out.println();


        //with searching per annotation
        System.out.println("CGLib Annotation searching:");
        Enhancer enhancer2 = new Enhancer();
        enhancer2.setSuperclass(PersonalServiceImpl.class);
        enhancer2.setCallback((MethodInterceptor) (obj, method, arg2, proxy) -> {
            LazyString lazyStringAnnotation = method.getDeclaredAnnotation(LazyString.class);
            if (Objects.nonNull(lazyStringAnnotation)) {
                return "Hello, Jack!";
            }
            return proxy.invokeSuper(obj, arg2);
        });
        PersonalServiceImpl personalServiceImplProxy2 = (PersonalServiceImpl) enhancer2.create();
        System.out.println(personalServiceImplProxy2.sayHello("Tom"));
        System.out.println(personalServiceImplProxy2.lengthOfName("Hello, Tom"));
        System.out.println();


        //with Dynamic proxy reflection
        System.out.println("Dynamic proxy:");
        PersonalServiceImpl personalServiceReal = new PersonalServiceImpl();
        PersonalService personalServiceImplProxy3 = (PersonalService) Proxy.newProxyInstance(
                PersonalService.class.getClassLoader(),
                new Class[]{PersonalService.class},
                (obj, method, arg3 ) -> {
                    LazyString lazyString = method.getDeclaredAnnotation(LazyString.class);
                    if (!Objects.isNull(lazyString)) {
                        return "Hello, Jack!";
                    }
                    return method.invoke(personalServiceReal, arg3);
                }
        );
        System.out.println(personalServiceImplProxy3.sayHello("Tom"));
        System.out.println(personalServiceImplProxy3.lengthOfName("Hello, Tom"));
        System.out.println();


        //using Byte buddy
        System.out.println("ByteBuddy:");
        try {
            PersonalService personalServiceImplProxy4 = new ByteBuddy()
                    .subclass(PersonalService.class)
                    .method(ElementMatchers.named("sayHello")
                        .or(ElementMatchers.named("lengthOfName")))
                    .intercept(MethodDelegation.to(new MyInterceptor()))
                    .make()
                    .load(PersonalService.class.getClassLoader())
                    .getLoaded()
                    .newInstance();
            System.out.println(personalServiceImplProxy4.sayHello("Tom"));
            System.out.println(personalServiceImplProxy4.lengthOfName("Hello, Tom"));
            System.out.println();
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {

        }


        //Bean Creator
        System.out.println("Bean creator:");
        BeanGenerator beanGenerator = new BeanGenerator();
        beanGenerator.addProperty("name", String.class);
        Object myBean = beanGenerator.create();
        try {
            Method setter = myBean.getClass().getMethod("setName", String.class);
            setter.invoke(myBean, "some string value");
            Method getter = myBean.getClass().getMethod("getName");
            System.out.println(getter.invoke(myBean));
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException e) {

        } catch (IllegalAccessException e) {

        }


    }
}