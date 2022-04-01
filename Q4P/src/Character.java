public class Character {
	
	private String firstName;
	private String lastName;
	private String location;
	private String personalStatement;
	private String gpa;
	private String extracurriculars;
	private String donation;
	private String donated;
	
	private static DatasetGenerator g = new DatasetGenerator();
	
	public Character() {
		String[] c = g.generatePerson();
		firstName = c[0];
		lastName = c[1];
		location = c[2];
		personalStatement = c[3];
		gpa = c[4];
		extracurriculars = c[5];
		donation = c[6];
		donated = c[7];
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getLocation() {
		return location;
	}

	public String getPersonalStatement() {
		return personalStatement;
	}

	public String getGpa() {
		return gpa;
	}
	
	public double getGpaAsDouble() {
		return Double.parseDouble(gpa);
	}

	public String getExtracurriculars() {
		return extracurriculars;
	}

	public String getDonation() {
		return donation;
	}

	public String getDonated() {
		return donated;
	}
}
