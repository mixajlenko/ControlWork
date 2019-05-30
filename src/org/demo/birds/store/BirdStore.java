
package org.demo.birds.store;

import org.demo.birds.entities.Bird;

import java.util.*;

/**
 * Отнаследоваться от AbstractBirdStore.
 *
 * Реализовать паттерн Singleton.
 */
public class BirdStore extends AbstractBirdStore {

    private static BirdStore instance;

    private List<Bird> listLivingArea = new ArrayList<>();

    private Map<String, Bird> birdStore1 = new HashMap<String, Bird>();


    private BirdStore() {
    }

    public static BirdStore getInstance() {
        if (instance == null) {
            instance = new BirdStore();
        }
        return instance;
    }

    @Override
    public void addBird(Bird b) {
        birdStore1.put(b.getName(), b);
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

    public List<Bird> getListLivingArea() {
        return listLivingArea;
    }
}


