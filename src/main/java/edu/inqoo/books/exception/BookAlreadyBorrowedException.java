package edu.inqoo.books.exception;

public class BookAlreadyBorrowedException extends Exception{

    private static final String BOOK_ALREADY_BORROWED = "book already borrowed";

    public BookAlreadyBorrowedException() {
        super(BOOK_ALREADY_BORROWED);
    }

    public BookAlreadyBorrowedException(String message) {
        super(message);
    }

    public BookAlreadyBorrowedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BookAlreadyBorrowedException(Throwable cause) {
        super(cause);
    }
}
