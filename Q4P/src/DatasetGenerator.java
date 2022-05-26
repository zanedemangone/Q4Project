import org.apache.commons.csv.*;
import java.io.*;
import java.util.*;

public class DatasetGenerator {

	//all the attributes in the CSV
	private static ArrayList<String> firstNames = new ArrayList<String>();
	private static ArrayList<String> lastNames = new ArrayList<String>();
	private static ArrayList<String> location = new ArrayList<String>();
	private static ArrayList<String> personalStatements = new ArrayList<String>();
	private static ArrayList<String> gpa = new ArrayList<String>();
	private static ArrayList<String> extracurriculars = new ArrayList<String>();
	private static ArrayList<String> donation = new ArrayList<String>();
	private static ArrayList<String> donated = new ArrayList<String>();

	public DatasetGenerator() {
		try {
			initializeArrays(); //initialize every one of these when the program starts
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] generatePerson() {
		Random r = new Random();
		
		String[] ret = new String[8];
		//randomly pick values from the big lists of attributes and return them to form a character
		ret[0] = firstNames.get(r.nextInt(firstNames.size()));
		ret[1] = lastNames.get(r.nextInt(lastNames.size()));
		ret[2] = location.get(r.nextInt(location.size()));
		ret[3] = personalStatements.get(r.nextInt(personalStatements.size()));
		ret[4] = gpa.get(r.nextInt(gpa.size()));
		ret[5] = extracurriculars.get(r.nextInt(extracurriculars.size()));
		ret[6] = donation.get(r.nextInt(donation.size()));
		ret[7] = donated.get(r.nextInt(donated.size()));
		
		return ret;
	}	
	
	public String[] generateRequirements() {
		Random r = new Random();
		
		String[] ret = new String[7];
		//randomly pick values from the big lists of attributes and return them to form a requirement
		//also adds logic codes to determine what the requirement will look like, whether it is evaluating over or under the value given
		ret[0] = location.get(r.nextInt(location.size())); //is not from
		ret[1] = location.get(r.nextInt(location.size())); //is not from, is from
		ret[2] = location.get(r.nextInt(location.size())); //is not from, is from
		ret[3] = gpa.get(r.nextInt(gpa.size())); //higher or lower
		ret[4] = donation.get(r.nextInt(donation.size())); //higher or lower
		//logic codes

		if((int)r.nextInt()+100<=5) {
			ret[5] = 0+""; //0 is lower, 1 is higher
		}
		else { //(MORE LIKELY)
			ret[5] = 1+""; //0 is lower, 1 is higher
		}
		
		if((int)r.nextInt()+100<=5) {
			ret[6] = 0+""; //0 is lower, 1 is higher
		}
		else { //(MORE LIKELY)
			ret[6] = 1+""; //0 is lower, 1 is higher 
		}

		return ret;
	}

	private static void initializeArrays() throws Exception {
		String [] header = {"firstNames", "lastNames", "location", "personalStatements", "gpa", "extracurriculars", "donation", "donated"}; //all the headers in the CSV
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
