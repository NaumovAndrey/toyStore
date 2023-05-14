package org.example.toyStore;

public class Toy {
    private static int nextId = 1;
    private int id;
    private String name;
    private int quantity;
    private int weight;

    public Toy(String name, int quantity, int weight) {
        this.id = nextId++;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
        if (id >= nextId) {
            nextId = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
