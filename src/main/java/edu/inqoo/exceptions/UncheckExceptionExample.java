package edu.inqoo.exceptions;

public class UncheckExceptionExample {

    public String someString(){
        return null;
    }

    public static void main(String[] args){
        UncheckExceptionExample example = new UncheckExceptionExample();
        String someString = example.someString();
        someString.split(":");
    }
}
