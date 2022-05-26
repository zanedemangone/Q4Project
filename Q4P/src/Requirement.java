public class Requirement {
	
	//all components of a requirment, including the control codes
	private String loc1;
	private String loc2;
	private String loc3;
	private double gpa;
	private int don;
	private String donS;
	private boolean c1;
	private boolean c2;
	private boolean c3;
	
	//dataset for requirement
	private static DatasetGenerator g = new DatasetGenerator();
	
	public Requirement() {
		String[] rC = new String[8];
		rC = g.generateRequirements();
		loc1 = rC[0]; //is not from, is from
		loc2 = rC[1]; //is not from, is from
		loc3 = rC[2]; //is not from, is from
		gpa =  Double.parseDouble(rC[3]); //higher or lower
		if(gpa>4.70) {
			gpa = 4.70; //don't want absurdly high criteria
		}
		if(gpa<1.00) {
			gpa = 1.00; //don't want absurdly low criteria
		}
		
		donS = rC[4];
		don = (int) Double.parseDouble(rC[4].replaceAll(",", "").substring(1)); //remove , delimit and $, control code is higher or lower
		
		
		if(rC[5].equals("0")) { //0 is lower, 1 is higher
			c2=false;
		}
		else {
			c2=true;
		}
		
		if(rC[6].equals("0")) { //0 is lower, 1 is higher
			c3=false;
		}
		else {
			c3=true;
		}
	}
	
	public String[] ParsedList() {
		String[] s = new String[3];
		
		s[0]="Do not admit students from "+loc1+", "+loc2+", and "+loc3+", they aren't worthy of Yamford.";
		
		if(c2) { //control code true, GPA higher
			s[1]="Admit students with a GPA higher than "+gpa+".";
		}
		else { //control code false, GPA lower
			s[1]="Admit students with a GPA lower than or equal to "+gpa+". Ever since the incident, we need to tone it down.";
		}
		
		if(c3) { //control code true, donation higher than
			if(don!=0) { 
				s[2] = "Admit students whose family has contributed more than "+donS+".";
			}
			else { //more than $0.00 sounds blah
				s[2] = "Admit students whose family has contributed to the school foundation.";
			}
			
		}
		else { //control code false, donation lower than
			if(don!=0) {
				s[2] = "Admit students whose family has contributed less than or equal to "+donS+". We don't want repeats of last time.";
			}
			else { //less than or equal to $0.00 sounds blah
				s[2] = "Admit students whose family have not contributed to the Yamford foundation. We have to lie low right now.";
			}
			
		}
		
		return s;
	}
	
	public boolean correctDecision(String l, double gp, int d) {
		boolean isLocation = false; //location fits criteria
		boolean isGPA = false; //GPA fits criteria
		boolean isDonation = false; //donation fits criteria
		
		if(c1) { //LOCATION, CC true (positive logic)
			if(l.equals(loc1) || l.equals(loc2) || l.equals(loc3)) {
				isLocation = true;
			}
		} //CC false (negative logic)
		else if(!(l.equals(loc1) || l.equals(loc2) || l.equals(loc3))) {
			isLocation = true;
		}
		
		if(c2) { //GPA, CC true (positive logic)
			if(gp>gpa) {
				isGPA = true;
			}
		} //CC false (negative logic)
		else if(gp<=gpa) {
			isGPA = true;
		}
		
		if(c3) { //DONATION, CC true (positive logic)
			if(d>don) {
				isDonation=true;
			}
		} //CC false (negative logic)
		else if(d<=don) {
			isDonation = true;
		}
		
		return isLocation && isGPA && isDonation;
	}
	
	public boolean correctDecision(Character c) {
		return correctDecision(c.getLocation(), c.getGpaAsDouble(), c.getDonationAsInt());
	}
	
}
