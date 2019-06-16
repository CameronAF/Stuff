package Lamda;

import java.util.Arrays;

/**
 * Class SummerTest that acts as main class
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/4/2018
 */
public class SummerTest {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		MyList<Integer> lst = new MyList<Integer>();
		lst.add(3);
		lst.add(-1);
		lst.add(1);
		lst.add(4);
		System.out.println("MyList:");
		System.out.println(Arrays.toString(lst.toArray()));
		Summer ss = new Summer();
		Integer sum = lst.reduce(ss, 0);
		System.out.println("MyList after TimesTwoFun: " + sum);
		Integer sum1 = lst.reduce((num1, num2) -> num1 + num2, 0);
		System.out.println("MyList after lambda expression: " + sum1 );
	}
}