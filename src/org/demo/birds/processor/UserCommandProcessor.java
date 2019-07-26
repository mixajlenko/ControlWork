package org.demo.birds.processor;

import org.demo.birds.entities.Bird;
import org.demo.birds.store.AbstractBirdStore;
import org.demo.birds.store.BirdStore;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализовать интерфейсы IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor
 */
public class UserCommandProcessor extends BirdThreads implements IBirdCreator, IUserCommandProcessor, IInfiniteLoopProcessor{

    private boolean workСycle = true;

    public UserCommandProcessor(String name) {
        super(name);
    }

    @Override
    public Bird createBird(Scanner userInputReader) {
        Bird bird = new Bird();
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter bird id");
        bird.setId(userInputReader.nextInt());
        System.out.println("Please, enter bird name");
        bird.setName(scan.nextLine());
        System.out.println("Please, enter bird living area");
        bird.setLivingArea(scan.nextLine());
        System.out.println(" Please, enter bird size");
        try {
            bird.setSize(scan.nextDouble());
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
                    "     *      r - remove bird\n" +
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
            case "r":
                System.out.println("Please, enter bird name which you want delete");
                String nameToDelete = userInputReader.nextLine();
                BirdStore.getInstance().removeBird(nameToDelete);
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
