package q10_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Class QueueTest that acts as main class and test LQueue
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class QueueTest {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args)
    {
		LQueue<String> que = new LQueue<String>();
		List<String> lst = new ArrayList<String>(5);
		lst.add("This");
		lst.add("is");
		lst.add("a");
		lst.add("collection");
		System.out.println("LQueue size is: " + que.size());
		que.addAll(lst);
		System.out.println("After addAll(), LQueue size is: " + que.size());
		System.out.println("Using dequeue(), LQueue contains: ");
		while (!que.isEmpty()) {
			System.out.print(que.dequeue() + " ");
		}
		System.out.println();
		que.enqueue("This");
		que.enqueue("is");	
		que.enqueue("fun");	
		while (!que.isEmpty()) {
			System.out.print(que.head() + " ");
			que.dequeue();
		}
		System.out.println();
		que.dequeue();
    }
}