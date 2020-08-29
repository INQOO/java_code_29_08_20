package edu.inqoo.biblioteka;

public class App {

    public static void main(String[] args) {

        Library<Book> library = new Library<Book>();

        System.out.println(library.getBooks());
    }

}
