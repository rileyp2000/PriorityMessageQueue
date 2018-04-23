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
	private ArrayList<ArrayList<Integer>> times;
	private final static int TOTAL_MESSAGES = 35;

	public MessagePriorityQueue() {
		priorities = new ArrayList<Queue<Message>>();
		times = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 5; i++)
			priorities.add(new PriorityQueue<Message>());
		for (int i = 0; i < 5; i++)
			times.add(new ArrayList<Integer>());
	}

	public void sort(Message m) {
		System.out.println("S " + m);
		int pri = m.getPriority();
		priorities.get(pri).add(m);
	}

	public void processMessages(int cur) {
		for (int i = 0; i < 5; i++) {
			if (priorities.get(i).peek() != null) {
				if (cur - priorities.get(i).peek().getArrival() > 4) {
					Message m = priorities.get(i).remove();
					System.out.println(m);
					times.get(m.getPriority()).add(cur - m.getArrival());
					return;
				}
			}
		}
	}

	public int prefill() {
		int i = 1;
		for (i = 1; i <= 15; i++) {
			Message m = new Message(i);
			sort(m);
		}
		return i;
	}

	public void removeRest(int i) {
		while (priorities.get(0).peek() != null || priorities.get(1).peek() != null || priorities.get(2).peek() != null
				|| priorities.get(3).peek() != null || priorities.get(4).peek() != null) {
			processMessages(i);
			i++;
		}

	}

	public void analyzeWait() {
		int sum = 0;
		for (int queue = 0; queue < 5; queue++) {
			for (int i : times.get(queue)) {
				sum += i;
			}
			System.out.println("Message of Priority " + queue + " has average wait of :"
					+ ((sum + 0.0) / times.get(queue).size()) + " minutes");
			sum = 0;
		}
	}

	public static void main(String[] args) {
		MessagePriorityQueue sim = new MessagePriorityQueue();

		int i = sim.prefill();

		for (i = i + 1; i <= TOTAL_MESSAGES; i++) {
			Message m = new Message(i);
			sim.sort(m);
			sim.processMessages(i);
		}
		sim.removeRest(i);
		sim.analyzeWait();
		/*
		 * for(int i = 1; i < 101; i++){ System.out.println(new Message(i)); }
		 */

	}
}
