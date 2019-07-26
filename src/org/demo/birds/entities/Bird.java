package org.demo.birds.entities;

import java.util.Objects;

/**
 * Bird.
 *
 * Должны быть следущие свойства:
 *
 * name  тип String
 * livingArea тип String
 * size – число с плавающей точкой, может быть незаполненным (Double).
 *
 */
public class Bird {

    private int id;

    private String name;

    private String livingArea;

    private Double size;

    @Override
    public String toString() {
        return "\nid - '" + id + '\'' +
                ", name - '" + name + '\'' +
                ", livingArea - '" + livingArea + '\'' +
                ", size - " + size;
    }

    public String getName() {
        return name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLivingArea(String livingArea) {
        this.livingArea = livingArea;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
