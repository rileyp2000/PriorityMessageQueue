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
		priorities = new ArrayList<Queue<Message>>();
		for (int i = 0; i < 5; i++)
			priorities.add(new PriorityQueue<Message>());
	}

	public void sort(Message m) {
		System.out.println("S " + m);
		int pri = m.getPriority();
		priorities.get(pri).add(m);
	}

	public void processMessages(int cur) {
		for (Queue<Message> q : priorities) {
			if (q.peek() != null) {
				if (cur - q.peek().getArrival() > 4) {
					System.out.println(q.remove());
					return;
				}
			}
		}
	}

	public int prefill() {
		int i = 1;
		for (i=1; i <= 15; i++) {
			Message m = new Message(i);
			sort(m);
		}
		return i;
	}
	
	public void removeRest(int i){
		while(priorities.get(0).peek() != null || priorities.get(1).peek() != null 
				|| priorities.get(2).peek() != null || priorities.get(3).peek() != null 
					|| priorities.get(4).peek() != null){
			processMessages(i);
			i++;
		}
	
	}
	
	public static void main(String[] args) {
		MessagePriorityQueue sim = new MessagePriorityQueue();
		int i = sim.prefill();
		
		for (i = i+1; i <= 35; i++) {
			Message m = new Message(i);
			sim.sort(m);
			sim.processMessages(i);
		}
		sim.removeRest(i);
		/*
		 * for(int i = 1; i < 101; i++){ System.out.println(new Message(i)); }
		 */

	}
}
