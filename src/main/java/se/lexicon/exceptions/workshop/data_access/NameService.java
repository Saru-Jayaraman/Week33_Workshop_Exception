package se.lexicon.exceptions.workshop.data_access;

import java.util.List;
import java.util.Random;

import se.lexicon.exceptions.workshop.domain.Gender;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.DuplicateNameException;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class NameService {
    private final List<String> maleFirstNames;
    private final List<String> femaleFirstNames;
    private final List<String> lastNames;
    private final static Random random = new Random();

    //should be no nulls
    public NameService(List<String> maleFirstNames, List<String> femaleFirstNames, List<String> lastNames) {

        this.maleFirstNames = maleFirstNames;
        this.femaleFirstNames = femaleFirstNames;
        this.lastNames = lastNames;
    }

    public Person getNewRandomPerson() {
        Gender gender = getRandomGender();
        Person person = null;
        switch (gender) {
            case MALE:
                person = new Person(getRandomMaleFirstName(), getRandomLastName(), gender);
                break;
            case FEMALE:
                person = new Person(getRandomFemaleFirstName(), getRandomLastName(), gender);
                break;
        }
        return person;
    }


    public String getRandomFemaleFirstName() {
        return femaleFirstNames.get(random.nextInt(femaleFirstNames.size()));
    }

    public String getRandomMaleFirstName() {
        return maleFirstNames.get(random.nextInt(maleFirstNames.size()));
    }

    public String getRandomLastName() {
        return lastNames.get(random.nextInt(lastNames.size()));
    }

    public Gender getRandomGender() {
        return random.nextInt(100) > 50 ? Gender.FEMALE : Gender.MALE;
    }


    /**
     * Here you need to check if List<String> femaleFirstNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     *
     * @param name
     */
    public void addFemaleFirstName(String name) throws DuplicateNameException {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Illegal Argument Exception: Entered name is either null or empty...");
        if (femaleFirstNames.contains(name))
            throw new DuplicateNameException("Entered Female First Name already exists in the file... ", name);
        femaleFirstNames.add(name);
        CSVReader_Writer.saveFemaleNames(femaleFirstNames);
        System.out.println("Female firstname added to the file..." + name);
    }

    /**
     * Here you need to check if List<String> maleFirstNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     *
     * @param name
     */
    public void addMaleFirstName(String name) throws DuplicateNameException {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Illegal Argument Exception: Entered name is either null or empty...");
        if (maleFirstNames.contains(name))
            throw new DuplicateNameException("Entered Male First Name already exists in the file... ", name);
        maleFirstNames.add(name);
        CSVReader_Writer.saveMaleNames(maleFirstNames);
        System.out.println("Male firstname added to the file..." + name);
    }

    /**
     * Here you need to check if List<String> lastNames already contains the name
     * If name already exists throw a new custom exception you will have to create called
     * DuplicateNameException.
     *
     * @param lastName
     */
    public void addLastName(String lastName) throws DuplicateNameException {
        if (lastName == null || lastName.trim().isEmpty())
            throw new IllegalArgumentException("Illegal Argument Exception: Entered name is either null or empty...");
        if (lastNames.contains(lastName))
            throw new DuplicateNameException("Entered Last Name already exists in the file... ", lastName);
        lastNames.add(lastName);
        CSVReader_Writer.saveLastNames(lastNames);
        System.out.println("Lastname added to the file..." + lastName);
    }
}
