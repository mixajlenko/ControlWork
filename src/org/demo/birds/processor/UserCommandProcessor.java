package org.demo.birds.processor;

import org.demo.birds.entities.Bird;
import org.demo.birds.store.AbstractBirdStore;
import org.demo.birds.store.BirdStore;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor implements IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor {

    private boolean workСycle = true;
    @Override
    public Bird createBird(Scanner userInputReader) {
        Bird bird = new Bird();
        System.out.println("Please, enter bird name");
        bird.setName(userInputReader.nextLine());
        System.out.println("Please, enter bird living area");
        bird.setLivingArea(userInputReader.nextLine());
        System.out.println(" Please, enter bird size");
        try {
            bird.setSize(userInputReader.nextDouble());
        }catch (InputMismatchException a) {
            System.out.println("!!!The object is not created. The length is not correct");
        }
        return bird;
    }

    @Override
    public void processInLoop() {
        while (workСycle) {
            Scanner k = new Scanner(System.in);
            System.out.println("\n * Please, enter command:\n" +
                    "     *      a - add new Bird\n" +
                    "     *      s - search bird by name\n" +
                    "     *      l - search bird by living area\n" +
                    "     *      exit - terminate application");
            String a = k.nextLine();
            processUserCommand(a, k);
        }
    }


    @Override
    public String processUserCommand(String command, Scanner userInputReader) {

        switch (command) {
            case "a":
                BirdStore.getInstance().addBird(createBird(userInputReader));
                break;
            case "s":
                System.out.println("Please, enter bird name to search");
                String nameToSearch = userInputReader.nextLine();
                if (BirdStore.getInstance().searchByName(nameToSearch) != null) {
                    System.out.println("Find bird : " + BirdStore.getInstance().searchByName(nameToSearch));
                } else {
                    System.out.println("does not exist");
                }
                break;
            case "l":
                System.out.println("Please, enter bird living area to search");
                String livingAreaToFind = userInputReader.nextLine();

                if (BirdStore.getInstance().searchByLivingArea(livingAreaToFind) != null) {
                    System.out.println("Found birds:" + BirdStore.getInstance().getListLivingArea().toString());
                } else {
                    System.out.println("does not exist");
                }
                break;
            case "exit":
                workСycle = false;
                break;
            default:
                System.out.println("Unknown command.");
        }
        return null;
    }
}
