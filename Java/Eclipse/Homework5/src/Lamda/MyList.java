package Lamda;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Class MyList<T> that extends LinkedList<T>
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/4/2018
 */
public class MyList<T> extends LinkedList<T> {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		MyList<Integer> lst = new MyList<Integer>();
		lst.add(-2);
		lst.add(1);
		lst.add(0);
		lst.add(4);
		System.out.println("MyList:");
		System.out.println(Arrays.toString(lst.toArray()));
		Integer sum = lst.reduce(new Summer(), 0);
		System.out.println("MyList after TimesTwoFun: " + sum);
		Integer sum1 = lst.reduce((num1, num2) -> num1 + num2, 0);
		System.out.println("MyList after lambda expression: " + sum1 );
	}
	
	/**
	*  Returns an instance of MyList with double the values in this
	*  @precondition none
	*  @return instance of MyList
	*/
	public <R> MyList<R> map(Functor<R,T> fo) {
		MyList<T> test = new MyList<T>();
		for (T var: this) {
			T temp = (T) fo.apply(var);
			test.add(temp);
		};
		return (MyList<R>) test;
	}
	
	/**
	*  Returns sum of all values in this
	*  @precondition none
	*  @return Sum of MyList
	*/
	public <R, T2> R reduce(Functor2<R,T,T2> fo2, T2 initialValue) {
		T2 sum = initialValue;
		for (T var: this) {
			sum = (T2) fo2.apply(var, sum);
		};
		return (R) sum;
	}
}