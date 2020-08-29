package edu.inqoo.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class CheckedExceptionExample {


    public void readFile() throws FileNotFoundException {


            FileInputStream fis = new FileInputStream("test.txt");

    }

    public static void main(String[] args){
        CheckedExceptionExample example = new CheckedExceptionExample();
        try {
            example.readFile();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException " + e.getMessage());
        }
    }
}
