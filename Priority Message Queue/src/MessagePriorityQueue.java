import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * @author rileyp
 *
 */
public class MessagePriorityQueue {
	private ArrayList<Queue<Message>> priorities;
	
	public MessagePriorityQueue() {
		for(int i = 0; i < 5; i++)
			priorities.add(new PriorityQueue<Message>());
	}
}
