package se.lexicon.exceptions.workshop.exception;

public class DuplicateNameException extends Exception {
    private String name;

    public DuplicateNameException(String name) {
        this.name = name;
    }

    public DuplicateNameException(String message, String name) {
        super(message);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}