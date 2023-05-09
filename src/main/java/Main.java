import org.example.menu.Menu;
import org.example.menu.MenuItem;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.addItem(new MenuItem(1, "Создать розыгрыш",
                new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("метод чтение из файла, метод логики выбора призовой игрушки, запись в файл массива призовых игрушек и статус выдачи");
                    }
                }));
        menu.addItem(new MenuItem(2, "Итория розыгрышов",
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
                        System.out.println("Методы: Показать игрушки, Создать игрушку, Изменить игрушку, Удалить игрушку");
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