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

	public DatasetGenerator() {
		try {
			initializeArrays();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String[] generatePerson() {
		Random r = new Random();
		
		String[] ret = new String[9];
		ret[0] = firstNames.get(r.nextInt(firstNames.size()));
		ret[1] = lastNames.get(r.nextInt(lastNames.size()));
		ret[2] = location.get(r.nextInt(location.size()));
		ret[3] = personalStatements.get(r.nextInt(personalStatements.size()));
		ret[4] = gpa.get(r.nextInt(gpa.size()));
		ret[5] = extracurriculars.get(r.nextInt(extracurriculars.size()));
		ret[6] = donation.get(r.nextInt(donation.size()));
		ret[7] = donated.get(r.nextInt(donated.size()));
		ret[8] = r.nextInt(10)+"";
		
		return ret;
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
