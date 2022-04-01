import org.apache.commons.csv.*;
import java.io.*;
import java.util.*;

public class DatasetGenerator {

	private static ArrayList<String> firstNames = new ArrayList<String>();
	private static ArrayList<String> lastNames = new ArrayList<String>();
	private static ArrayList<String> location = new ArrayList<String>();
	private static ArrayList<String> personalStatements = new ArrayList<String>();
	private static ArrayList<String> gpa = new ArrayList<String>();
	private static ArrayList<String> extracurriculars = new ArrayList<String>();
	private static ArrayList<String> donation = new ArrayList<String>();
	private static ArrayList<String> donated = new ArrayList<String>();

	public static void main(String[] args) throws Exception {
		initializeArrays();

		//TODO add method for initializing new characters from random attributes
		//TODO add more for donated, personal statements, and extracurriculars

	}

	private static void initializeArrays() throws Exception {
		String [] header = {"firstNames", "lastNames", "location", "personalStatements", "gpa", "extracurriculars", "donation", "donated"};
		CSVFormat format = CSVFormat.EXCEL.builder().setHeader("firstNames", "lastNames", "location", "personalStatements", "gpa", "extracurriculars", "donation", "donated").setSkipHeaderRecord(true).build();

		Reader in = new FileReader("./src/data.csv");
		CSVParser parser = new CSVParser(in, format);
		for( CSVRecord record : parser) {
			//REMOVE EMPTY RECORDS IS BROKEN IN THIS LIBRARY. HAVE TO DO IT MYSELF.
			if(!record.get("firstNames").equals("")) {
				firstNames.add(record.get("firstNames"));
			}
			if(!record.get("lastNames").equals("")) {
				lastNames.add(record.get("lastNames"));
			}
			if(!record.get("location").equals("")) {
				location.add(record.get("location"));
			}
			if(!record.get("personalStatements").equals("")) {
				personalStatements.add(record.get("personalStatements"));
			}
			if(!record.get("gpa").equals("")) {
				gpa.add(record.get("gpa"));
			}
			if(!record.get("extracurriculars").equals("")) {
				extracurriculars.add(record.get("extracurriculars"));
			}
			if(!record.get("donation").equals("")) {
				donation.add(record.get("donation"));
			}
			if(!record.get("donated").equals("")) {
				donated.add(record.get("donated"));
			}
		}
	}
}
