package Lamda;

/**
 * Class Summer that implements Functor2<Integer,Integer,Integer>
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/4/2018
 */
public class Summer implements Functor2<Integer,Integer,Integer> {
	/**
	*  Returns the sum of two Integers
	*  @precondition none
	*  @return Sum
	*/
	@Override
	public Integer apply(Integer param1, Integer param2) {
		return param1 + param2;
	}
}