package restrictions;


import java.util.Arrays;
import java.util.List;

/**
 * This class has an Unbounded parameter T because none restrictions are
 * declared.
 * <p>
 * Example Unbounded parameter <T>
 * Example Bonded parameter <T extends Serializable>
 * <p>
 * Characteristics and implications of unbounded type parameters
 * 1. Maximum flexibility: Unbounded generics are completely type-agnostic, meaning they can hold any type of object.
 *    They are ideal for collections or utilities that do not require specific operations dependent on the type,
 *    such as adding, removing, and accessing elements in a list or set.
 * 2. Type safety: Although an unbounded generic can hold any type, it still provides type safety compared to raw types
 *    like a plain List or Set without generics. For example, once you declare a Set<String>, you can only add strings
 *    to this set, which prevents runtime type errors.
 * 3. Errors: Because the type of the elements is not guaranteed, operations that depend on specific methods of the
 *    elements are not possible without casting, which can lead to errors if not handled carefully.
 *
 * @param <T>
 */
public class UnboundedTypeParameter<T> {

    T value;

    public UnboundedTypeParameter(final T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    // Unbounded method
    public static <T> void printEitherArray(T[] array) {

        Arrays.stream(array).forEach(
            System.out::println
        );

    }

    public static void main(String[] args) {

        UnboundedTypeParameter<String> iAcceptEverything = new UnboundedTypeParameter<>("1");
        UnboundedTypeParameter<Double> iAcceptEverything2 = new UnboundedTypeParameter<>(2.0);

        printEitherArray(List.of(1,2,3).toArray());
        printEitherArray(List.of("test", "test1", "test2").toArray());

    }

}