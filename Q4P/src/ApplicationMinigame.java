import java.util.Timer;
import java.util.TimerTask;

public class ApplicationMinigame {
	
	public static int points = 0;
	private int reward = 10;
	//changed it to 60 seconds per round
	public int gameLength = 2700;
	private int count; 
	
	Timer t = new Timer();
	TimerTask tt = new TimerTask() {
		public void run() {
			gameLength--;	
			System.out.println(gameLength);
		}
	};
	
	public void run() {
		gameLength--; 
	}
	public void start() {
		//timer runs in milliseconds 
		t.scheduleAtFixedRate(tt, 0, gameLength*1000);
	}
	
	public void evaluationMade(boolean wasCorrect) {
		if(wasCorrect) {
			points += reward;
		}
		else if(wasCorrect == false) {
			points -= reward;
		}
	}
	
	public void gameExit() {
		t.cancel();
	}
	
}
