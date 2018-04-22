import java.util.Random;

/**
 * 
 * @author rileyp
 *
 */
public class Message implements Comparable{
	private int priority, arrival;
	private static final Random R = new Random(2000);
	
	public Message(int a) {
		priority = R.nextInt(5);
		arrival = a;
	}
	
	
	public int getArrival() {
		return arrival;
	}
	
	public int getPriority() {
		return priority;
	}
	
	@Override
	public String toString(){
		return "Message of priority " + priority + ", Arrived at " + arrival;
	}
	
	@Override
	public int compareTo(Object m) {
		return priority - ((Message) m).getPriority();
	}
}
