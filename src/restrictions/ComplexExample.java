package restrictions;


import models.*;

public class ComplexExample {

    public static <T extends Animal & Walk> void dogBehavior(T animal) {

        animal.walking();
        animal.eating();

    }

    public static <T extends Animal & Crawl> void snakeBehavior(T animal) {

        animal.crawling();
        animal.eating();

    }

    public static void main(String[] args) {

        Snake snake = new Snake();
        Dog dog = new Dog();

        dogBehavior(dog);
        //dogBehavior(snake); // This parameter is not accept, because the method is bounded and throw show an error on developer time

        snakeBehavior(snake);
        //snakeBehavior(dog); // This parameter is not accept, because the method is bounded and throw show an error on developer time

    }

}