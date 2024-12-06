package models;

public class Snake extends Animal implements Crawl {

    @Override
    public void crawling() {
        System.out.println("Crawling...");
    }

}