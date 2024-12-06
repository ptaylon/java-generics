package restrictions;

import java.math.BigDecimal;

/**
 *
 *
 * When to use bounded type parameters
 * Bounded-type parameters are particularly useful in several scenarios:
 * <p>
 * 1. Enhancing type safety: By restricting the types that can be used as arguments, you ensure the methods or classes
 *    only operate on types guaranteed to support the necessary operations or methods, thus preventing runtime errors.
 * 2. Writing reusable code: Bounded type parameters allow you to write more generalized yet safe code that can operate
 *    on a family of types. You can write a single method or class that works on any type that meets the bound condition.
 * 3. Implementing algorithms: For algorithms that only make sense for certain types (like numerical operations and
 *    comparison operations), bounded generics ensure the algorithm is not misused with incompatible types.
 */
public class BoundedTypeParameter {

    // Bounded method
    public static <T extends Number> double plus2(T number) {
        return number.doubleValue() + 2;
    }

    public static void main(String[] args) {

        System.out.println(plus2(BigDecimal.ZERO));
        System.out.println(plus2(2f));
        System.out.println(plus2(2.0));
        System.out.println(plus2(1));
        // System.out.println(plus2("")); // This line will go throw an exception on development time

    }

}
