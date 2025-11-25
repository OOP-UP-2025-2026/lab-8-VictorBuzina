package ua.opnu;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("========== ЗАВДАННЯ 1 (MyOptional) ==========");
        // 1. Порожнє значення
        MyOptional<String> middleName = new MyOptional<>();
        System.out.println(middleName); // MyOptional[empty]
        System.out.println("isPresent: " + middleName.isPresent()); // false
        System.out.println("orElse: " + middleName.orElse("немає")); // "немає"

        // 2. Заповнене значення
        MyOptional<String> username = new MyOptional<>("admin");
        System.out.println(username); // MyOptional[value=admin]
        System.out.println("isPresent: " + username.isPresent()); // true
        try {
            System.out.println("get(): " + username.get()); // "admin"
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("orElse: " + username.orElse("guest")); // "admin"

        // 3. Перевірка помилки get()
        try {
            String test = middleName.get();
            System.out.println("unexpected: " + test);
        } catch (IllegalStateException ex) {
            System.out.println("Очікуваний виняток: " + ex.getMessage());
        }

        // 4. Перевірка null у конструкторі
        try {
            MyOptional<String> broken = new MyOptional<>(null);
            System.out.println("unexpected: " + broken);
        } catch (IllegalArgumentException ex) {
            System.out.println("Правильно не дозволив null: " + ex.getMessage());
        }


        System.out.println("\n========== ЗАВДАННЯ 2 (BookData) ==========");
        BookData b1 = new BookData("Java Basic", "Author A", 10, 50.0); // Rating 5.0
        BookData b2 = new BookData("Java Pro", "Author B", 5, 20.0);    // Rating 4.0
        BookData b3 = new BookData("Java Advanced", "Author C", 10, 50.0); // Rating 5.0

        System.out.println("b1 vs b2 (5.0 vs 4.0): " + b1.compareTo(b2)); // Має бути від'ємним (b1 вище в топі)
        System.out.println("b2 vs b1 (4.0 vs 5.0): " + b2.compareTo(b1)); // Має бути додатним
        System.out.println("b1 vs b3 (рівні рейтинги, порівняння назв): " + b1.compareTo(b3));


        System.out.println("\n========== ЗАВДАННЯ 3 (Printer) ==========");
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);


        System.out.println("\n========== ЗАВДАННЯ 4 (FilterUtils) ==========");
        Integer[] numbers = {1, 5, 10, -2, 8};
        // Фільтруємо парні числа
        Integer[] evens = FilterUtils.filter(numbers, n -> n % 2 == 0);
        System.out.println("Парні числа: " + Arrays.toString(evens));


        System.out.println("\n========== ЗАВДАННЯ 5 (SearchUtils) ==========");
        String[] names = {"Anna", "Bob", "Alex"};
        System.out.println("Contains Bob? " + SearchUtils.contains(names, "Bob")); // true
        System.out.println("Contains Max? " + SearchUtils.contains(names, "Max")); // false


        System.out.println("\n========== ЗАВДАННЯ 6 (Tuples) ==========");
        GenericTwoTuple<String, Integer> student = new GenericTwoTuple<>("Ivan", 5);
        System.out.println("TwoTuple: " + student);

        GenericThreeTuple<String, Integer, String> extended =
                new GenericThreeTuple<>("Ivan", 5, "Computer Science");
        System.out.println("ThreeTuple: " + extended);
    }
}