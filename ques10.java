import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Using lambda expression
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted using lambda expression:");
        names.forEach(System.out::println);

        // Reinitializing the list for demonstration
        names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Using method reference
        names.sort(String::compareToIgnoreCase);
        System.out.println("Sorted using method reference:");
        names.forEach(System.out::println);
    }
}
