package models;

public class Animal implements Eat {

    @Override
    public void eating() {
        System.out.println("Eating something ...");
    }

}