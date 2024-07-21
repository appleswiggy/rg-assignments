import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // Create an Optional object that contains a non-null value
        Optional<String> optionalValue = Optional.of("Hello, World!");

        // Create an Optional object that is empty
        Optional<String> emptyOptional = Optional.empty();

        // Using ifPresent to execute a lambda expression if a value is present
        optionalValue.ifPresent(value -> System.out.println("Value is present: " + value));

        // Using orElse to provide a default value if the Optional is empty
        String defaultValue = emptyOptional.orElse("Default Value");
        System.out.println("Value from empty Optional: " + defaultValue);

        // Using map to transform the value if present
        Optional<Integer> length = optionalValue.map(String::length);
        length.ifPresent(len -> System.out.println("Length of the value: " + len));
    }
}
