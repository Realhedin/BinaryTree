package com.company.goldmanSachsInterview.valuesFromReflection;

import java.lang.reflect.Field;

import org.apache.commons.lang3.ClassUtils;

/**
 * @author dkorolev
 *         Date: 4/17/2019
 *         Time: 11:06 AM
 */
public class GetValuesFromObjectViaReflection {

    public static void main(String[] args) {
        Engine engine = new Engine(12,200);
        Car car = new Car("red",2012,"bmv",engine);
        printValuesFromObject(car);
    }


      public static void printValuesFromObject(Object obj)  {
              Class<?> aClass = obj.getClass();
              Field[] declaredFields = aClass.getDeclaredFields();
              for (Field declaredField : declaredFields) {
                  try {
                      //make field visible, because private!
                      declaredField.setAccessible(true);
                      //get value for field
                      Object o = declaredField.get(obj);
                      //check if complex object
                      if (!checkForPrimitiveObject(o)) {
                          printValuesFromObject(o);
                      } else {
                          System.out.println(o);
                      }
                  } catch (IllegalAccessException e) {

                  }
              }
      }

    //checking 3 points: primitive, Wrapper for primitive and String class
    private static boolean checkForPrimitiveObject(Object o) {
        Class<?> aClass = o.getClass();
        return (aClass.isPrimitive() || ClassUtils.isPrimitiveWrapper(aClass)
                || aClass.equals(String.class));
    }
}