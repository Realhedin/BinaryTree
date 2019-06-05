package com.company.concurrency.notifyExamle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dkorolev
 *         Date: 5/24/2019
 *         Time: 4:55 PM
 */
public class Message {

    private final List<String> synchronizedList;

    public Message(List synchronizedList) {
        this.synchronizedList = synchronizedList;
    }


    public void addElement(String element) {
        System.out.println("Starting adding element.");
        synchronized (synchronizedList) {
            synchronizedList.add(element);
            System.out.println("Element was added: "+ element);
            synchronizedList.notifyAll();
            System.out.println("Threads were notified about adding element");
        }
        System.out.println("Closing add element");
    }


    public void deleteElement() throws InterruptedException {
        System.out.println("Starting deleting element. Thread " + Thread.currentThread().getName());
        synchronized (synchronizedList) {
            while (synchronizedList.isEmpty()) {
                System.out.println("List is empty. going to sleep" + Thread.currentThread().getName());
                synchronizedList.wait(300);
                System.out.println("After 1s of waiting"+ Thread.currentThread().getName());
            }

            String removed = synchronizedList.remove(0);
            System.out.println("Element " + removed + " was deleted" + Thread.currentThread().getName());
        }
        System.out.println("Closing delete element" + Thread.currentThread().getName());
    }


    public static void main(String[] args) throws InterruptedException {
        Message message = new Message(new ArrayList<>());

        Runnable del = () -> {
            try {
                message.deleteElement();
            } catch (InterruptedException e) {

            }
        };

        Runnable add = () -> message.addElement("Hello");


        Thread threadDel1 = new Thread(del, "Delete 1");
        threadDel1.start();


        Thread threadDel2 = new Thread(del, "Delete 2");
        threadDel2.start();

        Thread.sleep(500);
        new Thread(add, "Add").start();

        Thread.sleep(500);

        threadDel1.interrupt();
        threadDel2.interrupt();





    }
}