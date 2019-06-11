package q9_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Summer class that runs sum algorithm 
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public class Summer {

	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		Summer test = new Summer();
		System.out.println("Adder of 500: " + test.sum(500,5));
		System.out.println("Adder of 50000: " + test.sum(50000,83));
		System.out.println("Adder of 33333: " + test.sum(33333,93));
	}
	
	/**
	 *@param n the upper limit
	 *@param k the number of threads
	 *@return the sum 1 + 2 + ... + n computed with k threads 
	 */
	public int sum(int n, int k) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		for (int i = 0; i < k; i++) {
			int value1 = (int) (i*(n/(double)k)+1);
			int value2 = (int) ((i+1)*n/(double)k);
			threads.add(new Thread(new ThreadAdder(value1,value2,list)));
		}
		threads.forEach(t -> t.start());
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		System.out.println("List size: " + list.size());
		return list.stream().mapToInt(i -> i.intValue()).sum();	
	}
}