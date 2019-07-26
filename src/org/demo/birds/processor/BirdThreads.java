package org.demo.birds.processor;

import org.demo.birds.store.BirdStore;

import java.util.Scanner;

public class BirdThreads extends Thread {

    public BirdThreads(String name) {
        super(name);
    }
    Scanner scan = new Scanner(System.in);
    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        BirdStore.getInstance().addBird(new UserCommandProcessor("one").createBird(scan));
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}
