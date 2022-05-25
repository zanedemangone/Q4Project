import java.util.Timer;
import java.util.TimerTask;

public class ApplicationMinigame {
	
	private static int points = 0; //points in game
	private int reward = 10; //point reward base
	private int gameLength = 2700; //2700 frames * 45 frames per second = 60 seconds
	private int count;

	Timer t = new Timer();
	TimerTask tt = new TimerTask() { //keep the game running
		public void run() {
			gameLength--;	
		}
	};
	
	public void run() {
		gameLength--; 
	}
	
	public void evaluationMade(boolean wasCorrect, boolean accepting) {
		if(accepting) { //positive logic, character is within the criteria
			if(wasCorrect) {
				points += reward;
			}
			else if(wasCorrect == false) { //penalize losing more
				points -= reward * 10;
			}
		}
		
		if (!accepting){ //negative logic, character is outside of criteria, thus the decision was right
			if(wasCorrect == false) {
				points += reward;
			}
			else if(wasCorrect) { //was wrong
				points -= reward * 10;
			}
		}
	}
	
	public static int getPoints() {
		return points;
	}
	
	public static void setPoints(int p) {
		points = p; 
	}

	public int getGameLength() {
		return gameLength;
	}

	public void setGameLength(int l) {
		gameLength=l;
		
	}
	
}
