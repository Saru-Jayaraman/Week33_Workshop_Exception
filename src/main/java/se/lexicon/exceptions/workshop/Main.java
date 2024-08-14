package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.exception.MyExceptionHandlerClass;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

	public static void main(String[] args) {
		
		List <String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
        System.out.println("Male names: " + maleFirstNames);
        System.out.println();

        List <String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
        System.out.println("Female names: " + femaleFirstNames);
        System.out.println();

        List <String> lastNames;
        NameService nameService;
        Person test;
        try {
            lastNames = CSVReader_Writer.getLastNames();
            System.out.println("Last names: " + lastNames);
            System.out.println();

            if(maleFirstNames != null && femaleFirstNames != null && lastNames != null)
                nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);
            else
                throw new NullPointerException("Any of the names list is empty...");

            nameService.addFemaleFirstName("Emily");
//            nameService.addFemaleFirstName("Emily");
//            nameService.addFemaleFirstName("Lilly");
            System.out.println();

            nameService.addMaleFirstName("Cris");
//            nameService.addMaleFirstName("Gustav");
            System.out.println();

            nameService.addLastName("Jackson");
//            nameService.addLastName("Hansson");
            System.out.println();

            if(nameService != null) {
                test = nameService.getNewRandomPerson();
                System.out.println(test);
            }
        } catch (IOException e) {
            System.out.println("I/O EXCEPTION: " + e.getMessage());
        } catch (Exception e){
            System.out.println("============================================================");
            MyExceptionHandlerClass.handleExceptionsInMain(e);
            System.out.println("============================================================");
        }
	}
}