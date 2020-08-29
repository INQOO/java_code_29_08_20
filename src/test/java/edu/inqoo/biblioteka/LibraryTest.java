package edu.inqoo.biblioteka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LibraryTest {
    @Test
    public void should(){
        Library<Book> library = new Library<Book>();

        library.rentBook("12345");
        int rented = library.getFreeBooks().size();

        Assertions.assertEquals(9, rented);



        int terminated = library.getTerminated().size();

        Assertions.assertEquals(1, terminated);
    }







}