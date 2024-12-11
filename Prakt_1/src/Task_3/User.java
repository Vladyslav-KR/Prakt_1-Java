package Task_3;

public class User {
    private int id;
    private String name;

    // Конструктор
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттери
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Перевизначення toString для зручного виведення
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}








