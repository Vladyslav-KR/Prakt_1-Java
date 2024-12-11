package Task_1;

import java.util.Scanner;

   public class TextAnalyzer {

       // Оголошення функціональних інтерфейсів
       @FunctionalInterface
       interface SearchWord {
           boolean search(String text, String word);
       }

       @FunctionalInterface
       interface ReplaceWord {
           String replace(String text, String oldWord, String newWord);
       }

       @FunctionalInterface
       interface CountWords {
           int count(String text);
       }

       public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);

           // Введення тексту
           System.out.println("Введіть текст:");
           String text = scanner.nextLine();

           // Створення функціональних інтерфейсів за допомогою лямбда-виразів
           SearchWord searchWord = (txt, word) -> txt.contains(word);
           ReplaceWord replaceWord = (txt, oldWord, newWord) -> txt.replace(oldWord, newWord);
           CountWords countWords = txt -> txt.split("\\s+").length;

           // Меню
           while (true) {
               System.out.println("\nОберіть операцію:");
               System.out.println("1. Пошук слова");
               System.out.println("2. Заміна слова");
               System.out.println("3. Підрахунок слів");
               System.out.println("4. Вихід");

               int choice = scanner.nextInt();
               scanner.nextLine(); // Очищаємо буфер після вибору

               switch (choice) {
                   case 1:
                       // Пошук слова
                       System.out.print("Введіть слово для пошуку: ");
                       String wordToSearch = scanner.nextLine();
                       boolean found = searchWord.search(text, wordToSearch);
                       System.out.println("Слово " + (found ? "знайдено" : "не знайдено"));
                       break;
                   case 2:
                       // Заміна слова
                       System.out.print("Введіть слово для заміни: ");
                       String oldWord = scanner.nextLine();
                       System.out.print("Введіть нове слово: ");
                       String newWord = scanner.nextLine();
                       String updatedText = replaceWord.replace(text, oldWord, newWord);
                       System.out.println("Оновлений текст: " + updatedText);
                       text = updatedText; // Оновлюємо текст
                       break;
                   case 3:
                       // Підрахунок слів
                       int wordCount = countWords.count(text);
                       System.out.println("Кількість слів у тексті: " + wordCount);
                       break;
                   case 4:
                       // Вихід
                       System.out.println("До побачення!");
                       return;
                   default:
                       System.out.println("Невірний вибір. Спробуйте ще раз.");
               }
           }
       }
   }






















