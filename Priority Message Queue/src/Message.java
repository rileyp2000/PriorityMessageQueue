/**
 * 
 * @author rileyp
 *
 */
public class Message implements Comparable{
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
	

	@Override
	public int compareTo(Object m) {
		return priority - ((Message) m).getPriority();
	}
}
