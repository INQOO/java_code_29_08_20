package edu.inqoo.biblioteka;

import java.time.LocalDate;

public class Book {

    private final String author;
    private final String title;
    private final Genre genre;
    private final String ISBN;
    private final Cover cover;
    private LocalDate rentDate;

    public Book(String author, String title, Genre genre, String ISBN, Cover cover) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.ISBN = ISBN;
        this.cover = cover;
    }

    @Override
    public String toString() {
        return  "* " + author + " - " +
                title + ", " +
                genre + ", " + "ISBN: " +
                ISBN + ", " +
                cover ;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }


    public String getISBN() {
        return ISBN;
    }
}



