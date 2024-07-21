import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UppercaseConverter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Convert each name to uppercase using map
        List<String> uppercasedNames = names.stream()
                                             .map(String::toUpperCase)
                                             .collect(Collectors.toList());

        // Print the uppercased names
        uppercasedNames.forEach(System.out::println);
    }
}
