package Task_2;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

    public class TextAnalyzerStream {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            String text;

            // Зчитування тексту з файлу або введення тексту користувачем
            System.out.println("Виберіть спосіб введення тексту:");
            System.out.println("1. Ввести текст вручну");
            System.out.println("2. Завантажити текст з файлу");

            int choice = scanner.nextInt();
            scanner.nextLine(); // очищаємо буфер

            if (choice == 1) {
                System.out.println("Введіть текст:");
                text = scanner.nextLine();
            } else {
                System.out.println("Введіть шлях до файлу:");
                String filePath = scanner.nextLine();
                try {
                    text = new String(Files.readAllBytes(Paths.get(filePath)));
                } catch (IOException e) {
                    System.out.println("Помилка при зчитуванні файлу: " + e.getMessage());
                    return;
                }
            }

            // Операції з використанням Stream API
            // 1. Розбиття тексту на слова
            List<String> words = Arrays.asList(text.split("\\W+"));

            // 2. Фільтрація слів, що починаються з певної літери (наприклад, "A")
            System.out.print("Введіть літеру для фільтрації слів: ");
            char letter = scanner.nextLine().charAt(0);
            List<String> filteredWords = words.stream()
                    .filter(word -> word.toLowerCase().startsWith(String.valueOf(letter).toLowerCase()))
                    .collect(Collectors.toList());

            // 3. Сортування слів за алфавітом
            List<String> sortedWords = words.stream()
                    .sorted()
                    .collect(Collectors.toList());

            // 4. Підрахунок кількості унікальних слів
            long uniqueCount = words.stream()
                    .map(String::toLowerCase) // щоб уникнути подвійного рахунку слів з різними регістрами
                    .distinct()
                    .count();

            // Виведення результатів
            System.out.println("\nВсі слова: " + words);
            System.out.println("\nВідфільтровані слова, що починаються з '" + letter + "': " + filteredWords);
            System.out.println("\nВідсортовані слова: " + sortedWords);
            System.out.println("\nКількість унікальних слів: " + uniqueCount);
        }
    }








