package org.demo.birds.application;

import org.demo.birds.processor.IInfiniteLoopProcessor;
import org.demo.birds.processor.UserCommandProcessor;


public class BirdStoreApplication {

    public static void main(String[] args) {
        IInfiniteLoopProcessor iInfiniteLoopProcessor = new UserCommandProcessor();
        iInfiniteLoopProcessor.processInLoop();
    }
}
