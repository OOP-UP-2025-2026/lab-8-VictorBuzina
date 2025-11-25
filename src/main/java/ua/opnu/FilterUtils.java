package ua.opnu;

import java.util.Arrays;
import java.util.function.Predicate;

public class FilterUtils {

    @SuppressWarnings("unchecked")
    public static <T> T[] filter(T[] input, Predicate<T> p) {
        // Використовуємо конструкцію з завдання для створення масиву
        T[] result = (T[]) new Object[input.length];

        int counter = 0;
        for (T i : input) {
            if (p.test(i)) {
                result[counter] = i;
                counter++;
            }
        }

        return Arrays.copyOfRange(result, 0, counter);
    }
}