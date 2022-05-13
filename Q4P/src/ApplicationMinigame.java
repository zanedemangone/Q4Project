import java.util.*;

public class ApplicationMinigame {
	
	public static int points = 0;
	private int reward = 10;
	private Timer t = new Timer();
	private int gameLength = 5000;
	
	public void runApplication() {
		
		TimerTask tt = new TimerTask() {  
		    public void run() {  
		    		System.out.println("Time's up!");    
		    		//call interview game logic
		    };
		};	
		t.schedule(tt, gameLength);
		//call other method
	}
	
	public void evaluationMade(boolean wasCorrect) {
		
		if(wasCorrect) {
			points += reward;
		}
		else {
			points -= reward;
		}
		
		t.cancel();
		
		TimerTask interGameDelay = new TimerTask() {  
		    public void run() {  
		    	runApplication();
		    };
		};	
		
		t.schedule(interGameDelay, 500); //right or wrong delay
	}
	
	public void gameExit() {
		t.cancel();
		//safe to replace this panel since nothing will be running. call runMinigame again to begin the cycle
	}
	
}
