# Java Generics

Java Generics provide a way to parameterize types, allowing classes, interfaces, and methods to operate on typed data without being specific to a single data type. This enhances type safety and code reusability.

Benefits:
- Type Safety: Errors are caught at compile time, reducing runtime errors.
- Code Reusability: Write methods and classes that work with different data types.
- Avoids Explicit Casting: Eliminates the need to cast objects retrieved from collections.

## Bounded Type Parameters
- **Description:** Bounded type parameters limit the allowable types in generics to specific subclasses or interfaces, enhancing type safety and functionality.
- **Example:**
  ```java
  public class Zoo<T extends Animal> {
      private T animal;
      
      public Zoo(T animal) {
          this.animal = animal;
      }
      
      public void interact() {
          animal.eat();
      }
  }
  ```

---

## Wildcards
- **Description:** Use wildcards (`? extends` and `? super`) to allow generic methods to handle parameters of varying types. Wildcards manage covariance and contravariance, enabling methods to work with collections of unknown types.
- ? extends (Covariance): Read-only operations, ensuring elements are at least a certain type.
? super (Contravariance): Write operations, allowing addition of a specific type and its
- **Example:**
  ```java
  public void processAnimals(List<? extends Animal> animals) {
      for (Animal animal : animals) {
          animal.eat();
      }
  }
  ```

---

## Type Erasure
- **Description:** Type erasure enables backward compatibility by removing generic type information at runtime, which means generic details are not maintained post-compilation.
- **Example:**
  ```java
  public class Box<T> {
      private T item;
      
      public T getItem() {
          return item;
      }
  }
  // After type erasure, the class looks like:
  public class Box {
      private Object item;
      
      public Object getItem() {
          return item;
      }
  }
  ```

---

## Generic Methods and Type Inference
- **Description:** Type inference reduces verbosity in code by allowing the compiler to deduce types from the context, simplifying code, especially from Java 7 onwards.
- **Example:**
  ```java
  public static <T> void printArray(T[] array) {
      for (T item : array) {
          System.out.println(item);
      }
  }
  
  public static void main(String[] args) {
      String[] names = {"Alice", "Bob"};
      printArray(names); // Type inferred as String
  }
  ```

---

## Multiple Bounds <T extends Animal & Walker>
- **Description:** Use multiple bounds to enforce multiple type conditions, such as `<T extends Animal & Walker>`. This ensures parameters meet all specified requirements, promoting functional and type safety.
- **Example:**
  ```java
  public static <T extends Animal & Walker> void moveAndEat(T creature) {
      creature.walk();
      creature.eat();
  }
  ```

---

## Lower Bounds (? super)
- **Description:** Lower bounds support write operations by allowing additions of a type and its subtypes. Items retrieved are recognized as `Object`, requiring casting for specific uses.
- **Example:**
  ```java
    Animal getAnimal(List<? super Animal> animals) {
        Animal animal = new Animal();
        animals.add(animal); // This is valid.
        animals.get(0).eating(); // Compliant error -> ((Animal) animals.get(0)).eating()
        return (Animal) animals.get(0); // It is necessary to perform a cast to return the method
    }
  ```

---

## Upper Bounds (? extends)
- **Description:** Upper bounds facilitate read operations, ensuring all retrieved items are at least of the specified type. Additions (except for `null`) are restricted to maintain type integrity.
- **Example:**
  ```java
    // No casting needed, returns Animal type.
    Animal getAnimal(List<? extends Animal> animals, int index) {
        Animal animal = new Animal();
        //animals.add(animal); // Compliant error
        animals.get(0).eating();
        return animals.get(index); // It isn't necessary cast
    }
  ```

---

## Unbounded (?)
- **Description:** Unbounded wildcards (`?`) allow methods to work with any class.
- **Example:**
  ```java
  public static void printList(List<?> items) {
      for (Object item : items) {
          System.out.println(item);
      }
  }
  ```
```