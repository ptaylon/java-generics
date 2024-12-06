package wildcards;

import java.util.List;

/**
 * Wildcards [?]
 * <p>
 * Key differences between type parameters and wildcards:
 * <p>
 * 1. Flexibility vs. specificity: Wildcards offer more flexibility for methods that operate on various objects without
 * specifying a particular type. Type parameters demand specific types and enforce consistency within the use of the
 * class or method where they are defined.
 * <p>
 * 2. Read vs. write: Typically, you use ? extends Type when you only need to read from a structure because the items
 * will all be instances of Type or its subtypes. ? super Type is used when you need to write to a structure,
 * ensuring that the structure can hold items of type "Type" or any type that is a superclass of Type.
 * Type parameters T are used when both operations are required or when operations depend on each other.
 * <p>
 * 3. Scope: Wildcards are generally used for broader operations in a limited scope (like a single method), while type
 * parameters define a type that can be used throughout a class or a method, providing more extensive code reuse.
 */
public class Example {

    // Wildcard without lower-bound
    static void printSomething(final List<?> something) {

        //something.add(10); // Without using the lower bound one error is released at development time
        something.forEach(System.out::println);

    }

    // Wildcart with lower-bound
    static void displayAndAdd(List<? super Integer> numbers) {

        numbers.add(10); // Using the lower bound <? super Integer> this is accepted
        numbers.forEach(System.out::println);

    }

    static void displayList(List<Object> list) {
        System.out.println(list);
    }

    public static void main(String[] args) {

        //
        // Compilation error here because displayList expects List<Object>
        //
        // List<String> stringList = Arrays.asList("hello", "world");
        // displayList(stringList);

        // How to solve this: Wildcards -> ?

        printSomething(List.of(5, 4, 3, 2, 1));
        printSomething(List.of("this", "is", "a", "simple", "example"));

        displayAndAdd(List.of(1, 2, 3, 4, 5));

    }

}
