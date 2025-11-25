package ua.opnu;

public class MyOptional<T> {

    private final T value;
    private final boolean present;

    // Конструктор для порожнього об'єкта
    public MyOptional() {
        this.value = null;
        this.present = false;
    }

    // Конструктор для об'єкта зі значенням
    public MyOptional(T value) {
        if (value == null) {
            throw new IllegalArgumentException("MyOptional не приймає null");
        }
        this.value = value;
        this.present = true;
    }

    public boolean isPresent() {
        return present;
    }

    public boolean isEmpty() {
        return !present;
    }

    public T get() {
        if (!present) {
            throw new IllegalStateException("Спроба отримати значення з порожнього MyOptional");
        }
        return value;
    }

    public T orElse(T defaultValue) {
        return present ? value : defaultValue;
    }

    @Override
    public String toString() {
        return present ? "MyOptional[value=" + value + "]" : "MyOptional[empty]";
    }
}