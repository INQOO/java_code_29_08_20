package edu.inqoo.books;

import edu.inqoo.books.exception.BookAlreadyBorrowedException;
import edu.inqoo.books.exception.BookExistsException;
import edu.inqoo.books.exception.BookNotFoundException;
import edu.inqoo.books.model.Book;
import edu.inqoo.books.model.BookCover;
import edu.inqoo.books.model.BookType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.time.LocalDate;
import java.util.Collection;


import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LibraryTest {

    private Library library;
    private Book newTestBook;
    private Book existingTestBook;


    @BeforeEach
    public void beforeAll(){
        library = new Library();
        newTestBook = new Book("author11", "title11", "ibsn11", BookType.horror, BookCover.hardCover);
        existingTestBook = new Book("author10", "title10", "ibsn10", BookType.poetic, BookCover.softCover);
    }

    @Test
    public void testGetAllBooks_then_OK(){
        Collection<Book> allBooks = library.getAllBooks();
        assertNotNull(allBooks);
        assertEquals(10, allBooks.size());
    }

    @Test
    public void test_Add_Existing_Book_then_BookExistsException(){
        assertThrows(BookExistsException.class,()-> library.addBook(existingTestBook));
    }

    @Test
    public void testAddNewBook_withNull_then_NullPointerException(){
       assertThrows(NullPointerException.class, ()->library.addBook(null));
    }

    @Test
    public void testAddNewBook_then_OK() throws BookExistsException {
        Collection<Book> allBooks = library.getAllBooks();
        assertEquals(10, allBooks.size());
        library.addBook(newTestBook);
        assertEquals(11, allBooks.size());
    }

    @Test
    public void testRemoveBook_then_OK() throws BookExistsException, BookNotFoundException {
        Collection<Book> allBooks = library.getAllBooks();
        library.addBook(newTestBook);
        assertEquals(11, allBooks.size());
        Book book = library.removeBookByIBSN(newTestBook.getIbsn());
        assertEquals(newTestBook, book);
    }

    @Test
    public void testRemoveNonExistingBook_then_BookNotFoundException() {
        assertThrows(BookNotFoundException.class, ()->library.removeBookByIBSN(newTestBook.getIbsn()));
    }

    @Test
    public void testBorrowNoNExistingBook_then_BookNotFoundException(){
        assertThrows(BookNotFoundException.class, ()->library.borrowBookDefaultDays(newTestBook.getIbsn()));
    }

    @Test
    public void testBorrowBook_with_wrongInput_then_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->library.borrowBookDefaultDays(null));
        assertThrows(IllegalArgumentException.class, ()->library.borrowBookDefaultDays(""));
    }


    @Test
    public void testBorrowBookDefaultDays_then_OK() throws BookNotFoundException, BookAlreadyBorrowedException {
        Book borrowedBook = library.borrowBookDefaultDays(existingTestBook.getIbsn());
        assertEquals(existingTestBook, borrowedBook);
        assertEquals(LocalDate.now().plusDays(Library.DEFAULT_BORROW_DAYS), borrowedBook.getDueDate());
    }

    @Test
    public void testBorrowBook_then_OK() throws BookNotFoundException, BookAlreadyBorrowedException {
        int addDays = 3;
        Book borrowedBook = library.borrowBook(existingTestBook.getIbsn(), LocalDate.now().plusDays(addDays));
        assertEquals(existingTestBook, borrowedBook);
        assertEquals(LocalDate.now().plusDays(addDays), borrowedBook.getDueDate());
    }

    @Test
    public void testReturnNonExistingBook_then_BookNotFoundException(){
        assertThrows(BookNotFoundException.class, ()->library.returnBook(newTestBook.getIbsn()));
    }

    @Test
    public void testReturnBook_with_wrongInput_then_IllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->library.returnBook(null));
        assertThrows(IllegalArgumentException.class, ()->library.returnBook(""));
    }

    @Test
    public void testGetAvailableBooks_and_testReturnBook_then_OK()
            throws BookNotFoundException, BookAlreadyBorrowedException {
        library.borrowBookDefaultDays(existingTestBook.getIbsn());
        assertEquals(9, library.getAvailableBooks().size());
        library.returnBook(existingTestBook.getIbsn());
        assertEquals(10, library.getAvailableBooks().size());
    }

    @Test
    public void testGetOverdueBooks_then_OK()
            throws BookNotFoundException, BookAlreadyBorrowedException {
        library.borrowBook(existingTestBook.getIbsn(), LocalDate.now().minusDays(1));
        assertEquals(1, library.getOverdueBooks().size());
    }
}