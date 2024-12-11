package Task_1;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

    public class TextAnalyzerLambda {

        // Функціональний інтерфейс для операцій з текстом
        @FunctionalInterface
        interface TextOperation {
            String apply(String text);
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            // Введення тексту користувачем
            System.out.println("Введіть текст:");
            String text = scanner.nextLine();

            // Операція для пошуку слова в тексті
            TextOperation searchWord = (String inputText) -> {
                System.out.println("Введіть слово для пошуку:");
                String wordToFind = scanner.nextLine();
                return inputText.contains(wordToFind) ? "Слово знайдено!" : "Слово не знайдено.";
            };

            // Операція для заміни слова в тексті
            TextOperation replaceWord = (String inputText) -> {
                System.out.println("Введіть слово для заміни:");
                String wordToReplace = scanner.nextLine();
                System.out.println("Введіть слово на заміну:");
                String replacementWord = scanner.nextLine();
                return inputText.replace(wordToReplace, replacementWord);
            };

            // Операція для підрахунку кількості слів
            TextOperation countWords = (String inputText) -> {
                String[] words = inputText.split("\\s+");
                return "Кількість слів: " + words.length;
            };

            // Виведення меню для вибору операції
            System.out.println("\nОберіть операцію:");
            System.out.println("1. Пошук слова");
            System.out.println("2. Заміна слова");
            System.out.println("3. Підрахунок слів");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Скидаємо новий рядок після вибору числа

            String result = "";
            switch (choice) {
                case 1:
                    result = searchWord.apply(text);
                    break;
                case 2:
                    result = replaceWord.apply(text);
                    break;
                case 3:
                    result = countWords.apply(text);
                    break;
                default:
                    System.out.println("Невірний вибір.");
            }

            // Виведення результату операції
            System.out.println("\nРезультат операції: " + result);
        }
    }

