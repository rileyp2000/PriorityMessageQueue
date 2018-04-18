/**
 * 
 * @author rileyp
 *
 */
public class Message {
	private int priority, arrival;
	
	public Message() {
		priority = ((int)Math.random()*4);
		arrival = 0;
	}
	
	public int getArrival() {
		return arrival;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int compareTo(Message m) {
		
	}
}
