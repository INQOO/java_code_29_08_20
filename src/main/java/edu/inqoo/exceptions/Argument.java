package edu.inqoo.exceptions;

public class Argument {

    public String getPostFix(String input){
        if(input.length() <= 4){
            throw new IllegalArgumentException("za krotki String");
        }
        return input.substring(4);
    }

    public static void main(String[] args){
        Argument argument = new Argument();
        try {
            argument.getPostFix("aaa");

        } catch (RuntimeException e){
            System.out.println("zlapalem wyjatek");
        }
    }
}
