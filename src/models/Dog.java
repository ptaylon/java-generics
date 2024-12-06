package models;

public class Dog extends Animal implements Walk {

    @Override
    public void walking() {
        System.out.println("Walking...");
    }

}