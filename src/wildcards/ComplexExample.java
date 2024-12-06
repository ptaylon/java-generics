package wildcards;



import models.Animal;
import models.Dog;
import models.Snake;

import java.util.List;

public class ComplexExample {

    //Lower bound, you can handle the object in different ways
    public static void printAnimalsLowerBound(List<? super Animal> animals) {
        animals.forEach(System.out::println);
        animals.add(new Animal());
        animals.add(new Dog());
        animals.add(new Snake());

        // Cast is necessary to access animal's behavior
        ((Animal) animals.get(0)).eating();
    }

    //Upper bound
    public static void printAnimalsUpperBound(List<? extends Animal> animals) {
        animals.forEach(System.out::println);
        //animals.add(new Animal()); // Compliant error
    }

    void addAnimal(List<? super Animal> animals, Animal animal) {
        animals.add(animal); // This is valid.
    }

    // No casting needed, returns Animal type.
    Animal getAnimal(List<? extends Animal> animals, int index) {
        Animal animal = new Animal();
        //animals.add(animal); // Compliant error
        animals.get(0).eating();
        return animals.get(index); // It isn't necessary cast
    }

    Animal getAnimal(List<? super Animal> animals) {
        Animal animal = new Animal();
        animals.add(animal); // This is valid.
        //animals.get(0).eating(); Compliant error
        ((Animal) animals.get(0)).eating();
        return (Animal) animals.get(0); // It is necessary to perform a cast to return the method
    }

    public static void main(String[] args) {

    }

}
