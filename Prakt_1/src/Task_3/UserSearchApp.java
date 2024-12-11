package Task_3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserSearchApp {

    // Метод для пошуку користувача за ідентифікатором
    public static Optional<User> findUserById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)  // Фільтруємо за ID
                .findFirst();  // Повертаємо перший знайдений елемент (Optional)
    }

    public static void main(String[] args) {
        // Створюємо список користувачів
        List<User> users = Arrays.asList(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );

        // Введення ID для пошуку
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть ID користувача для пошуку:");
        int id = scanner.nextInt();

        // Пошук користувача за ID
        Optional<User> user = findUserById(users, id);

        // Виведення результату пошуку
        user.ifPresentOrElse(
                u -> System.out.println("Користувач знайдений: " + u),
                () -> System.out.println("Користувача з таким ID не знайдено.")
        );
    }
}
