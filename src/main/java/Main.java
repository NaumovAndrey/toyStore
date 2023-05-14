import org.example.menu.Menu;
import org.example.menu.MenuItem;
import org.example.menu.SubMenu;
import org.example.toyStore.ToyStore;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        ToyStore store = new ToyStore();
        store.loadFromFile();

        menu.addItem(new MenuItem(1, "Создать розыгрыш",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("метод чтение из файла, метод логики выбора призовой игрушки, запись в файл массива призовых игрушек и статус выдачи");
                    }
                }));
        menu.addItem(new MenuItem(2, "Итория розыгрышей",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("метод чтение из файла, метод статуса получения призовой игрушки ");

                    }
                }));

        menu.addItem(new MenuItem(3, "Опции",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("Метод показывает все игрушки, создаёт новую, изменяет старую, и удаляет");

                        SubMenu subMenu = new SubMenu();
                        subMenu.addItem(new MenuItem(1, "Сздать",
                                new Runnable() {
                                    @Override
                                    public void run() {
                                        System.out.println("Метод создания нвой игрушки");
                                    }
                                }));
                    }
                }));


        menu.addItem(new MenuItem(4, "Выйти из программы",
                new Runnable() {
                    @Override
                    public void run() {
                        System.exit(0);
                    }
                }));

        while (true) {
            menu.display();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите номер команды: ");
            int id = scanner.nextInt();
            menu.runCommand(id);
            System.out.println();
        }
    }
}