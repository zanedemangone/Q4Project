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
	
	public void evaluationMade(boolean wasCorrect, boolean accepting) {
		if(accepting) {
			if(wasCorrect) {
				points += reward;
			}
			else if(wasCorrect == false) {
				points -= reward;
			}
		}
		
		else {
			if(wasCorrect == false) {
				points += reward;
			}
			else if(wasCorrect) {
				points -= reward;
			}
		}
	}
	
}
