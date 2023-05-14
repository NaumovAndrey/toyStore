package org.example.toyStore;


import java.io.*;
import java.util.*;

public class ToyStore {
    private static final String FILENAME = "E:\\Документы\\Андрей\\Обучение\\GeekBrains\\java\\toyStoreR\\toyStore\\src\\main\\java\\toy.txt";
    private List<Toy> toys = new ArrayList<>();

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void changeToyWeight(int id, int weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Toy toy : toys) {
                writer.println(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getWeight());
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (Scanner scanner = new Scanner(new File(FILENAME))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                int quantity = Integer.parseInt(fields[2]);
                int weight = Integer.parseInt(fields[3]);
                toys.add(new Toy(id, name, quantity, weight));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

    public Toy play() {
        int totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }
        int randomValue = new Random().nextInt(totalWeight) + 1;
        int currentWeight = 0;
        for (Toy toy : toys) {
            currentWeight += toy.getWeight();
            if (randomValue <= currentWeight) {
                toy.setQuantity(toy.getQuantity() - 1);
                saveToFile();
                return toy;
            }
        }
        return null;
    }


}

