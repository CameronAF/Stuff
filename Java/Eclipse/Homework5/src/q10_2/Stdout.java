package q10_2;

/**
 * Class Stdout and uses Singleton Pattern
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class Stdout {
	private static Stdout instance = new Stdout();

	/**
    * Private Constructs
    */
	private Stdout() {}

	/**
	*  Returns the private static instance of Stdout
	*  @precondition none
	*/
	public static Stdout getInstance() {
		return instance;
	}
	
	/**
	*  Print line of a String
	*  @precondition none
	*  @postcondition a string has been printed using System.out
	*/
	public void printline(String s) {
		System.out.println(s);
	}
}