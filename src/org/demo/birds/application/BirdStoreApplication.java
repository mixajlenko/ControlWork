package org.demo.birds.application;

import org.demo.birds.processor.BirdThreads;
import org.demo.birds.processor.IInfiniteLoopProcessor;
import org.demo.birds.processor.UserCommandProcessor;
import org.demo.birds.store.BirdStore;


public class BirdStoreApplication {

    public static void main(String[] args) throws InterruptedException {

        IInfiniteLoopProcessor iInfiniteLoopProcessor = new UserCommandProcessor("MainBird");
        iInfiniteLoopProcessor.processInLoop();








    }
}
