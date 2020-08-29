package edu.inqoo.biblioteka;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static edu.inqoo.biblioteka.Cover.HARD;
import static edu.inqoo.biblioteka.Cover.SOFT;
import static edu.inqoo.biblioteka.Genre.*;

public class Library<B> {

    public List<Book> getBooks() {
        return books;
    }

    private List<Book> books = new ArrayList<>();

    public Library() {

        books.add(new Book("Ludka Skrzydlewska", "Po Godzinach", POETRY, "12345", SOFT));
        books.add(new Book("Ludka Skrzydlewska", "Sentymentalna Bzdura", HORROR, "23456", SOFT));
        books.add(new Book("Ludka Skrzydlewska", "Negatyw szczęścia cz.1", SCIFI, "34567", HARD));
        books.add(new Book("Ludka Skrzydlewska", "Negatyw szczęścia cz.2", SCIFI, "45678", HARD));
        books.add(new Book("Graham Masterton", "Zemsta Manitou", HORROR, "56789", SOFT));
        books.add(new Book("Graham Masterton", "Powrót Manitou", HORROR, "67890", SOFT));
        books.add(new Book("Stephen King", "Bastion", SCIFI, "78901", HARD));
        books.add(new Book("Stephen King", "Podpalaczka", HORROR, "89012", HARD));
        books.add(new Book("Charles Bukowski", "O kotach", POETRY, "90123", SOFT));
        books.add(new Book("Charles Bukowski", "Notatnik poplamiony winem", POETRY, "01234", SOFT));

    }

    public void rentBook(String ISBN){
       for (Book bookDate : books ){
           if (ISBN.equals(bookDate.getISBN()))
               bookDate.setRentDate(LocalDate.now().plusDays(7));
            }
    }

    public List<Book> getFreeBooks() {
        return books.stream().filter(bookDate -> bookDate.getRentDate() == null).collect(Collectors.toList());
    }

    public List<Book> getTerminated() {

        return books.stream().filter(bookDate -> bookDate.getRentDate() == bookDate.getRentDate().plusDays(8)).collect(Collectors.toList());
    }



}



