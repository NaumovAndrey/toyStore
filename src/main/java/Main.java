import org.example.toyStore.Toy;
import org.example.toyStore.ToyStore;

import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
            ToyStore store = new ToyStore();
            store.loadFromFile();

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("1. Add toy");
                System.out.println("2. Change toy weight");
                System.out.println("3. Play");
                System.out.println("4. Exit");
                System.out.print("> ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.print("Enter toy name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter toy quantity: ");
                        int quantity = scanner.nextInt();
                        System.out.print("Enter toy weight: ");
                        int weight = scanner.nextInt();
                        store.addToy(new Toy(name, quantity, weight));
                        store.saveToFile();
                        break;
                    case 2:
                        System.out.print("Enter toy id: ");
                        int id = scanner.nextInt();
                        System.out.print("Enter toy weight: ");
                        weight = scanner.nextInt();
                        store.changeToyWeight(id, weight);
                        store.saveToFile();
                        break;
                    case 3:
                        Toy toy = store.play();
                        if (toy != null) {
                            System.out.println("You won a " + toy.getName() + "!");
                        } else {
                            System.out.println("Sorry, no toy available.");
                        }
                        break;
                    case 4:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }