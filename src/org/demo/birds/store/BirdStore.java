
package org.demo.birds.store;

import org.demo.birds.entities.Bird;
import org.demo.birds.processor.BirdThreads;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 *
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {

    private static BirdStore instance;

    BirdThreads birds = new BirdThreads("first");

    private List<Bird> listLivingArea = new ArrayList<>();

    private Map<String, Bird> birdStore1 = new HashMap<>();

    private Map<String, Integer> ids = new HashMap();

    private BirdStore() {
    }

    public static BirdStore getInstance() {
        if (instance == null) {
            instance = new BirdStore();
        }
        return instance;
    }

    public List<Bird> getListLivingArea() {
        return listLivingArea;
    }

    @Override
    public synchronized void addBird(Bird b) {
            if (!ids.containsValue(b.getId())) {
                birdStore1.put(b.getName(), b);
                System.out.println("Bird is created");
                ids.put(b.getName(), b.getId());
            } else {
                System.out.println("Bird with such ID already exist, try again.");
                Thread.yield();
            }
        }

    @Override
    public Bird searchByName(String nameToSearch) {
        Set<String> searchByName = birdStore1.keySet();
        for (String b : searchByName) {
            if (b.equals(nameToSearch)) {
                return birdStore1.get(b);
            }
        }
        return null;
    }

    @Override
    public List searchByLivingArea(String livingAreaSearch) {
        Set<String> searchByLivingArea = birdStore1.keySet();
        for (String b : searchByLivingArea) {
            if (birdStore1.get(b).getLivingArea().equals(livingAreaSearch)) {
                listLivingArea.add(birdStore1.get(b));
            }
        }
        return listLivingArea;
    }

    public synchronized void removeBird(String name) {
        if (!birdStore1.containsKey(name)) {
            System.out.println("Bird not found");
            Thread.yield();
        } else {
            birdStore1.remove(name);
            ids.remove(name);
            System.out.println("Bird " + name + " was deleted");
        }
    }
}



