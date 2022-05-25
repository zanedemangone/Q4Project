public class Character {
	
	//all the attributes of a person
	private String firstName;
	private String lastName;
	private String location;
	private String personalStatement;
	private String gpa;
	private String extracurricular;
	private String donation;
	private String donated;
	
	//dataset generator for randomly selected attributes
	private static DatasetGenerator g = new DatasetGenerator();
	
	public Character() {
		String[] c = g.generatePerson(); //pick a set of attributes
		//assign
		firstName = c[0];
		lastName = c[1];
		location = c[2];
		personalStatement = c[3];
		gpa = c[4];
		extracurricular = c[5];
		donation = c[6];
		donated = c[7];
		if(getDonationAsInt()>=850000) {
			donated = lastName + " Memorial Library"; //lol
		}
		if(getDonationAsInt()==0) {
			donated = "Nothing"; //logical fix so that $0.00 people won't donate jets
		}
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
		return Double.parseDouble(gpa); //decimal GPA to value for comparison
	}


	public String getExtracurricular() {
		return extracurricular;
	}

	public String getDonation() {
		return donation;
	}

	public int getDonationAsInt() {
		String temp = getDonation();
		temp = temp.substring(1).replaceAll(",", ""); //remove $ and ,
		return (int) Double.parseDouble(temp); //parse sanitized donation for comparison
	}

	public String getDonated() {
		return donated;
	}
}
