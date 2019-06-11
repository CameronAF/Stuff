package q9_1;

import java.util.List;

/**
 * ThreadAdder that implements Runnable interface
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public class ThreadAdder implements Runnable{
	private int firstNum;
	private int lastNum;
	private List<Integer> list;
	
	/**
	*  Constructor for class ThreadAdder
	*  @precondition none
	*  @postcondition a instance of ThreadAdder would have been initialized
	*/
	public ThreadAdder(int x, int y, List<Integer> l) {
		firstNum = x;
		lastNum = y;
		list = l;
	}
	
	/**
	*  Executes when thread Start is called
	*  @precondition An instance of ThreadAdder exist in thread
	*  @postcondition summed ints added to a synchronizedList
	*/
	@Override
	public void run() {
		int sum  = 0;
		int step = firstNum;
		while (step <= lastNum) {
			sum += step;
			step++;
		}
		synchronized(list) {
			list.add(sum);
		}
	}
}