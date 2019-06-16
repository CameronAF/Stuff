package q10_2;

/**
 * Class StdoutTest that acts as main class and test Stdout
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class StdoutTest {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		Stdout.getInstance().printline("Printing without saving instance");
		Stdout syt = Stdout.getInstance();
		syt.printline("Printing from saved instance");
	}
}