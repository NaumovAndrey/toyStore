package org.example.menu;

public class MenuItem {
    private int id;
    private String name;
    private Runnable action;



    public MenuItem(int id, String name, Runnable action) {
        this.id = id;
        this.name = name;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void run() {
        if (action != null){
            action.run();
        }
    }
}
