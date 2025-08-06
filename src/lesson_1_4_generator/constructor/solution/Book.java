package lesson_1_4_generator.constructor.solution;

public class Book {
    String title;
    String author;
    int page;

    Book(String title, String author, int page) {
        this.title = title;
        this.author = author;
        this.page = page;
    }
    Book(String title, String author) {
        this(title, author, 0);
    }
    Book() {
        this(" "," ",0);
    }

    void displayInfo() {
        System.out.println("Title : " + title + " Author: " + author + " Age: " + page);
    }
}
