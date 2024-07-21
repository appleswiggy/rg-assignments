import java.util.function.*;

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        // Predicate example
        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        System.out.println("Is 'Java' not empty? " + isNotEmpty.test("Java"));

        // Function example
        Function<String, Integer> stringLength = String::length;
        System.out.println("Length of 'Java': " + stringLength.apply("Java"));

        // Consumer example
        Consumer<String> print = System.out::println;
        print.accept("Hello, World!");

        // Supplier example
        Supplier<String> stringSupplier = () -> "Supplied String";
        System.out.println(stringSupplier.get());

        // BiFunction example
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println("3 * 4 = " + multiply.apply(3, 4));

        // UnaryOperator example
        UnaryOperator<Integer> doubleValue = x -> x * 2;
        System.out.println("Double of 5: " + doubleValue.apply(5));

        // BinaryOperator example
        BinaryOperator<Integer> add = (a, b) -> a + b;
        System.out.println("5 + 3 = " + add.apply(5, 3));
    }
}
