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

//    public static void main(String[] args) {
//        ToyStore store = new ToyStore();
//        store.loadFromFile();
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//            System.out.println("1. Add toy");
//            System.out.println("2. Change toy weight");
//            System.out.println("3. Play");
//            System.out.println("4. Exit");
//            System.out.print("> ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
//            switch (choice) {
//                case 1:
//                    System.out.print("Enter toy name: ");
//                    String name = scanner.nextLine();
//                    System.out.print("Enter toy quantity: ");
//                    int quantity = scanner.nextInt();
//                    System.out.print("Enter toy weight: ");
//                    int weight = scanner.nextInt();
//                    store.addToy(new Toy(name, quantity, weight));
//                    store.saveToFile();
//                    break;
//                case 2:
//                    System.out.print("Enter toy id: ");
//                    int id = scanner.nextInt();
//                    System.out.print("Enter toy weight: ");
//                    weight = scanner.nextInt();
//                    store.changeToyWeight(id, weight);
//                    store.saveToFile();
//                    break;
//                case 3:
//                    Toy toy = store.play();
//                    if (toy != null) {
//                        System.out.println("You won a " + toy.getName() + "!");
//                    } else {
//                        System.out.println("Sorry, no toy available.");
//                    }
//                    break;
//                case 4:
//                    return;
//                default:
//                    System.out.println("Invalid choice.");
//            }
//        }
//    }
}

