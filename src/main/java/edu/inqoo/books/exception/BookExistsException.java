package edu.inqoo.books.exception;

public class BookExistsException extends Exception{

    private static final String BOOK_EXISTS = "book already exists in Library";

    public BookExistsException() {
        super(BOOK_EXISTS);
    }

    public BookExistsException(String message) {
        super(message);
    }

    public BookExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookExistsException(Throwable cause) {
        super(cause);
    }
}
