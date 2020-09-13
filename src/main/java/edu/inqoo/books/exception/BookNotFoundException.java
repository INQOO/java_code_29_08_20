package edu.inqoo.books.exception;

public class BookNotFoundException extends Exception{

    private static final String BOOK_NOT_FOUND = "book not found";

    public BookNotFoundException() {
        super(BOOK_NOT_FOUND);
    }

    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookNotFoundException(Throwable cause) {
        super(cause);
    }
}
