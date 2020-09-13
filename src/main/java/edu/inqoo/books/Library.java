package edu.inqoo.books;

import edu.inqoo.books.exception.BookAlreadyBorrowedException;
import edu.inqoo.books.exception.BookExistsException;
import edu.inqoo.books.exception.BookNotFoundException;
import edu.inqoo.books.model.Book;
import edu.inqoo.books.model.BookCover;
import edu.inqoo.books.model.BookType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Library {

    public static final int DEFAULT_BORROW_DAYS = 7;

    public static final String WRONG_IBSN_NUMBER = "Wrong ibsn number";



    private final Set<Book> books = new HashSet<>();

    public Library() {
        books.add(new Book("author1", "title1", "ibsn1", BookType.scifi, BookCover.hardCover));
        books.add(new Book("author2", "title2", "ibsn2", BookType.horror, BookCover.softCover));
        books.add(new Book("author3", "title3", "ibsn3", BookType.poetic, BookCover.hardCover));
        books.add(new Book("author4", "title4", "ibsn4", BookType.horror, BookCover.hardCover));
        books.add(new Book("author5", "title5", "ibsn5", BookType.scifi, BookCover.softCover));
        books.add(new Book("author6", "title6", "ibsn6", BookType.poetic, BookCover.softCover));
        books.add(new Book("author7", "title7", "ibsn7", BookType.scifi, BookCover.hardCover));
        books.add(new Book("author8", "title8", "ibsn8", BookType.horror, BookCover.softCover));
        books.add(new Book("author9", "title9", "ibsn9", BookType.scifi, BookCover.hardCover));
        books.add(new Book("author10", "title10", "ibsn10", BookType.poetic, BookCover.softCover));
    }

    public Collection<Book> getAllBooks(){
        return Collections.unmodifiableSet(books);
    }

    public Collection<Book> getAvailableBooks(){
        return books.stream().filter(book -> Objects.isNull(book.getDueDate())).collect(Collectors.toCollection(HashSet::new));
    }

    public Collection<Book> getOverdueBooks(){
        return books.stream().filter(book -> isBookOverdue(book.getDueDate())).collect(Collectors.toCollection(HashSet::new));
    }

    public Book borrowBookDefaultDays(String ibsn) throws BookNotFoundException, BookAlreadyBorrowedException {
        return borrowBook(ibsn, LocalDate.now().plusDays(DEFAULT_BORROW_DAYS));
    }

    public Book borrowBook(String ibsn, LocalDate dueDate) throws BookNotFoundException, BookAlreadyBorrowedException {
        Book book = getBookByIBSN(ibsn);

        if(book.getDueDate() != null)
            throw  new BookAlreadyBorrowedException();

        book.setDueDate(dueDate);
        return book;
    }

    public void returnBook(String ibsn) throws BookNotFoundException {
        Book book = getBookByIBSN(ibsn);
        book.setDueDate(null);
    }

    public Book getBookByIBSN(String ibsn) throws BookNotFoundException {
        if(isEmptyInput(ibsn))
            throw new IllegalArgumentException(WRONG_IBSN_NUMBER);

       return   books
                .stream()
                .filter(book -> ibsn.equals(book.getIbsn()))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException());
    }

    private boolean isEmptyInput(String input){
        return input == null || input.isEmpty();
    }

    private boolean isBookOverdue(LocalDate dueDate){
        return dueDate != null && LocalDate.now().isAfter(dueDate);
    }

    public void addBook(Book book) throws BookExistsException {
        if(book == null)
            throw new NullPointerException("The book cannot be empty");

        int initialSize = books.size();

        books.add(book);

        if(books.size() == initialSize)
            throw new BookExistsException();
    }

    public Book removeBookByIBSN(String ibsn) throws BookNotFoundException {
        Book book = getBookByIBSN(ibsn);
        books.remove(book);
        return book;
    }







}
