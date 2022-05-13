import static java.lang.Integer.valueOf;

public class Character {
	
	private String firstName;
	private String lastName;
	private String location;
	private String personalStatement;
	private String gpa;
	private String extracurricular;
	private String donation;
	private String donated;
	private int faceNum;
	
	private static DatasetGenerator g = new DatasetGenerator();
	
	public Character() {
		String[] c = g.generatePerson();
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
		faceNum = valueOf(c[8]);
	}

	public int getFaceNum() {
		return faceNum;
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

	public boolean locationEquals(String target) {
		if(getLocation().equals(target)) {
			return true;
		}
		return false;
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

	public boolean gpaAbove(double threshold) {
		if(getGpaAsDouble()>=threshold) {
			return true;
		}
		return false;
	}

	public boolean gpaBelow(double threshold) {
		if(getGpaAsDouble()<threshold) {
			return true;
		}
		return false;
	}

	public String getExtracurricular() {
		return extracurricular;
	}

	public boolean extracurricularEquals(String target) {
		if(getExtracurricular().equals(target)) {
			return true;
		}
		return false;
	}

	public String getDonation() {
		return donation;
	}

	public int getDonationAsInt() {
		String temp = getDonation();
		temp = temp.substring(1).replaceAll(",", ""); //remove $ and ,
		return (int) Double.parseDouble(temp);
	}

	public boolean donationAbove(int threshold) {
		if(getDonationAsInt()>=threshold) {
			return true;
		}
		return false;
	}

	public boolean donationBelow(int threshold) {
		if(getDonationAsInt()<threshold) {
			return true;
		}
		return false;
	}

	public String getDonated() {
		return donated;
	}
}
