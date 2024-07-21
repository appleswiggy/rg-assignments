import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FunctionalInterfaceLambdaExample {
    public static void main(String[] args) {
        // List of integers to sort
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2);

        // Using a lambda expression to implement Comparator's compare method
        Comparator<Integer> comparator = (a, b) -> a - b;

        // Sorting the list using the comparator
        numbers.sort(comparator);

        // Printing the sorted list
        numbers.forEach(System.out::println);
    }
}
