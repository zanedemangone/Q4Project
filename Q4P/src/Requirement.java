public class Requirement {
	
	private String loc1;
	private String loc2;
	private String loc3;
	private double gpa;
	private int don;
	private String donS;
	private boolean c1;
	private boolean c2;
	private boolean c3;
	
	private static DatasetGenerator g = new DatasetGenerator();
	
	public Requirement() {
		String[] rC = new String[8];
		rC = g.generateRequirements();
		loc1 = rC[0]; //is not from, is from
		loc2 = rC[1]; //is not from, is from
		loc3 = rC[2]; //is not from, is from
		gpa =  Double.parseDouble(rC[3]); //higher or lower
		if(gpa>4.70) {
			gpa = 4.70;
		}
		donS = rC[4];
		don = (int) Double.parseDouble(rC[4].replaceAll(",", "").substring(1)); //higher or lower
		
		if(rC[5].equals("0")) { //0 for is not from, 1 is from
			c1=false;
		}
		else {
			c1=true;
		}
		
		if(rC[6].equals("0")) { //0 is lower, 1 is higher
			c2=false;
		}
		else {
			c2=true;
		}
		
		if(rC[7].equals("0")) { //0 is lower, 1 is higher
			c3=false;
		}
		else {
			c3=true;
		}
	}
	
	public String[] ParsedList() {
		String[] s = new String[3];
		if(c1) {
			s[0]="Admit students from "+loc1+", "+loc2+", and "+loc3+".";
		}
		else {
			s[0]="Do not admit students from "+loc1+", "+loc2+", and "+loc3+", they aren't worthy of Yamford.";
		}
		
		if(c2) {
			s[1]="Admit students with a GPA higher than "+gpa+".";
		}
		else {
			s[1]="Admit students with a GPA lower than or equal to "+gpa+". Ever since the incident, we need to tone it down.";
		}
		
		if(c3) {
			if(don!=0) {
				s[2] = "Admit students whose family has contributed more than "+donS+".";
			}
			else {
				s[2] = "Admit students whose family has contributed to the school foundation.";
			}
			
		}
		else {
			if(don!=0) {
				s[2] = "Admit students whose family has contributed less than or equal to "+donS+". We don't want repeats of last time.";
			}
			else {
				s[2] = "Admit students whose family have not contributed to the Yamford foundation. We have to lie low right now.";
			}
			
		}
		
		return s;
	}
	
	public boolean correctDecision(String l, double gp, int d) {
		boolean isLocation = false;
		boolean isGPA = false;
		boolean isDonation = false;
		
		if(c1) { //LOCATION
			if(l.equals(loc1) || l.equals(loc2) || l.equals(loc3)) {
				isLocation = true;
			}
		}
		else if(!(l.equals(loc1) || l.equals(loc2) || l.equals(loc3))) {
			isLocation = true;
		}
		
		if(c2) { //GPA
			if(gp>gpa) {
				isGPA = true;
			}
		}
		else if(gp<=gpa) {
			isGPA = true;
		}
		
		if(c3) { //DONATION
			if(d>don) {
				isDonation=true;
			}
		}
		else if(d<=don) {
			isDonation = true;
		}
		System.out.println(isLocation + " " + isGPA + " " + isDonation);
		return isLocation && isGPA && isDonation;
	}
	
	public boolean correctDecision(Character c) {
		return correctDecision(c.getLocation(), c.getGpaAsDouble(), c.getDonationAsInt());
	}

	public String getLoc1() {
		return loc1;
	}

	public String getLoc2() {
		return loc2;
	}

	public String getLoc3() {
		return loc3;
	}

	public double getGpa() {
		return gpa;
	}

	public int getDonation() {
		return don;
	}
	
}
