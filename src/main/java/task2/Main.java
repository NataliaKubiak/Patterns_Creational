package task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");

        Scanner scanner = new Scanner(System.in);
        logger.log("Просим пользователя ввести входные данные для списка");
        System.out.print("Введите размер списка: ");
        int listSize = scanner.nextInt();

        System.out.print("Введите верхнюю границу для значений: ");
        int maxValue = scanner.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> intList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < listSize; i++) {
            intList.add(random.nextInt(maxValue));
        }
        System.out.print("Вот случайный список: ");
        printList(intList);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int treshold = scanner.nextInt();
        Filter filter = new Filter(treshold);
        List<Integer> filteredList = filter.filterOut(intList);
        logger.log("Выводим результат на экран");
        System.out.print("Отфильтрованный список: ");
        printList(filteredList);
        logger.log("Завершаем программу");
    }

    private static void printList(List<Integer> list) {
        for (int i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
