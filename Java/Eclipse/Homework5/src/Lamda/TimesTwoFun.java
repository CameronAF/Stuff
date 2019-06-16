package Lamda;

/**
 * Class TimesTwoFun that implements Functor<Integer, String>
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/2/2018
 */
public class TimesTwoFun implements Functor<Integer, Integer> {
	/**
	*  Returns the two times the param
	*  @precondition none
	*  @return double the param
	*/
	@Override
	public Integer apply(Integer param) {
		return 2*param;
	}
}