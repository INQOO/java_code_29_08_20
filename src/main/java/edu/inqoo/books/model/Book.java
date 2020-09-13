package edu.inqoo.books.model;

import java.time.LocalDate;

public class Book {

    private final String name;
    private final String title;
    private final String ibsn;
    private final BookType bookType;
    private final BookCover bookCover;

    private LocalDate dueDate;

    public Book(String name, String title, String ibsn, BookType bookType, BookCover bookCover) {
        this.name = name;
        this.title = title;
        this.ibsn = ibsn;
        this.bookType = bookType;
        this.bookCover = bookCover;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getIbsn() {
        return ibsn;
    }

    public BookType getBookType() {
        return bookType;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Book)){
            throw new IllegalArgumentException("Not a Book");
        }
        return ibsn.equals(((Book) obj).ibsn);
    }

    @Override
    public int hashCode(){
        return this.ibsn.hashCode();
    }


}
