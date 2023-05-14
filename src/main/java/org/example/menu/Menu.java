package org.example.menu;

import java.util.ArrayList;

public class Menu {
    private ArrayList<MenuItem> items;

    public Menu() {
        items = new ArrayList<MenuItem>();
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void display() {
        for (MenuItem item : items) {
            System.out.println(item.getId() + ". " + item.getName());
        }
    }

    public void runCommand(int id) {
        for (MenuItem item : items) {
            if (item.getId() == id) {
                item.run();
                break;
            }
        }
    }
}