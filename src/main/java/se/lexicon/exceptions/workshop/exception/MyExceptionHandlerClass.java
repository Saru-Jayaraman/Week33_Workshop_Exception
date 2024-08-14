package se.lexicon.exceptions.workshop.exception;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.nio.file.NoSuchFileException;

public class MyExceptionHandlerClass {
    public static void handleExceptionsInMain(Exception e) {
        if(e instanceof NullPointerException){
            System.out.println("NULL POINTER EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        } else if(e instanceof DuplicateNameException){
            System.out.println("DUPLICATE NAME EXCEPTION: " + e.getMessage() + ((DuplicateNameException) e).getName());
        } else {
            System.out.println("## UNEXPECTED ERROR ##");
            e.printStackTrace();
        }
    }

    public static void handleExceptionsInCSVReaderWriter(Exception e) {
        if(e instanceof InvalidPathException){
            System.out.println("INVALID PATH EXCEPTION: " + e.getMessage());
        } else if(e instanceof NoSuchFileException){
            System.out.println("NO SUCH FILE EXCEPTION: " + e.getMessage());
        } else if(e instanceof IOException){
            System.out.println("I/O EXCEPTION: " + e.getMessage());
            e.printStackTrace();
        } else if(e instanceof SecurityException) {
            System.out.println("SECURITY EXCEPTION: Permission denied..." + e.getMessage());
        } else {
            System.out.println("## UNEXPECTED ERROR ##");
            e.printStackTrace();
        }
    }
}