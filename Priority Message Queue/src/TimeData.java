
public class TimeData {
	private int timeRemoved, waitTime;
	
	public TimeData(int tr, int wt){
		timeRemoved = tr;
		waitTime = wt;
		
	}
	
	public String toString(){
		return "R: " + timeRemoved + " W:" + waitTime;
	}

	public int getTimeRemoved() {
		return timeRemoved;
	}

	public int getWaitTime() {
		return waitTime;
	}

	public void setTimeRemoved(int timeRemoved) {
		this.timeRemoved = timeRemoved;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}
	
	
}
