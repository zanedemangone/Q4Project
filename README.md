# The Yamford Way
Have you ever wanted to be an admissions officer at an elite college? Leap into the shadowy and cuthroat world of undergraduate admissions at the highest echelons of society? No? Too bad!

Welcome to the Yamford admissions office. Don't say I didn't warn you.

![Your office at Yamford](/Q4P/src/imgs/desk_bg.png)

Navigate around your computer and office with your mouse. Make sure to check out the rules on the right side pinboard! You can back out of menus with escape, but not out of the admissions portal once you've begun admitting students!

![Yamford Admissions portal](/Q4P/src/imgs/ao_bg.png)

Yamie, our mascot of undergraduate admissions, will ever so helpfully guide you through the process to ensure that you make the right decisions every time. He can't do it for you, of course. Make as many correct admissions decisions as you can in the time alloted, being sure to meet your admissions quota!

![Yamie](/Q4P/src/imgs/yamie.PNG)

Off you go! Good luck, and don't mess up. Really, don't. Don't. Do not mess up.

# Architecture
To make the admissions game tick, the prospective students and the requirements Yamie gives the player are both dynamically generated from a very large list of attributes. These values are ingested into the DatasetGenerator class, which then chooses them at random to generate a character or a requirement set.
```java
public String[] generatePerson() {
  Random r = new Random();
  
	String[] ret = new String[8];
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
```
On the other side, the Character object contains all the values needed to make an admissions decision, and is matched by the Requirement object. These are both presented to the player during the admissions game.
```java
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
	if(getDonationAsInt()==0) {
		donated = "Nothing";
	}
}
```
These characteristics are matched against admissions requirements, and a determination is made to whether the player made the correct decision or not, upon which their score will be adjusted accordingly.
```java
public void evaluationMade(boolean wasCorrect, boolean accepting) {
	if(accepting) {
		if(wasCorrect) {
			points += reward;
		}
		else if(wasCorrect == false) {
			points -= reward * 10;
		}
	}
    
	else {
		if(wasCorrect == false) {
			points += reward;
		}
		else if(wasCorrect) {
			points -= reward * 10;
		}
	}
}
 ```
