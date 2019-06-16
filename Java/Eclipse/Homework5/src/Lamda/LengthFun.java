package Lamda;

/**
 * Class LengthFun that implements Functor<Integer, String>
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/2/2018
 */
public class LengthFun implements Functor<Integer, String> {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthFun test = new LengthFun();
		String name = "Cameron Anzola";
		System.out.println("Using the LengthFun.apply() ");
		System.out.println("String: " + name + 
				"   Length: " + test.apply(name));
		Functor<Integer, String> length = (n) -> n.length();
		System.out.println("Using a lambda expression instance");
		System.out.println("String: " + name + 
				"   Length: " + length.apply(name));
	}

	/**
	*  Returns the length (Integer) of a String parameter
	*  @precondition none
	*  @return length of String param
	*/
	@Override
	public Integer apply(String param) {
		return param.length();
	}
}