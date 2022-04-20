import java.util.*;

public class ApplicationMinigame {
	
	public int points = 0;
	private int reward = 10;
	private Timer t = new Timer();
	private int gameLength = 10000;
	
	public void runMinigame() {
		
		TimerTask tt = new TimerTask() {  
		    public void run() {  
		    		System.out.println("Time's up!");    
		    		//call interview game logic
		    };
		};	
		t.schedule(tt, gameLength);
		//call other method
	}
	
	public void gameCompleted(boolean wasCorrect) {
		
		if(wasCorrect) {
			points += 10;
		}
		t.cancel();
		
		TimerTask interGameDelay = new TimerTask() {  
		    public void run() {  
		    		runMinigame();
		    };
		};	
		
		t.schedule(interGameDelay, 1000);
	}
	
	public void gameExit() {
		t.cancel();
		//safe to replace this panel since nothing will be running. call runMinigame again to begin the cycle
	}
	
}
