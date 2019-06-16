package Lamda;

/**
 * Class MRExample that shows MyList using Strings
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/4/2018
 */
public class MRExample {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		MyList<String> ls = new MyList<String>();
		ls.add("This");
		ls.add("is");
		ls.add("MyList");
		ls.add("that");
		ls.add("holds");
		ls.add("Strings");
		System.out.println("MyList:");
		ls.forEach(x -> System.out.print(x + " "));
		System.out.println();
		MyList<Integer> ls2 = ls.map(new LengthFun());
		System.out.println("Length of items in MyList:");
		ls2.forEach(x -> System.out.print(x + " "));
		System.out.println();
		Integer sum = ls.map(new LengthFun()).reduce(new Summer(), 0);
		System.out.println("Total chars in MyList: " + sum);
	}
}