import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Using Stream API to filter, map, and sort
        List<String> filteredNames = names.stream()
            .filter(name -> name.startsWith("A") || name.startsWith("E"))
            .map(String::toUpperCase)
            .sorted()
            .collect(Collectors.toList());

        // Print the result
        filteredNames.forEach(System.out::println);
    }
}
