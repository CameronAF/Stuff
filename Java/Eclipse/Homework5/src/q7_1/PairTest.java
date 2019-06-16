package q7_1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Class PairTest that acts as main class and test Pair
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/7/2018
 */
public class PairTest {
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		Pair<Integer,String> p1 = new Pair<>(1, "one");
		ObjectOutputStream out = new ObjectOutputStream(
				new FileOutputStream("pair.dat"));
		//out.writeObject(p1);
		out.close();
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("pairs.dat"));
		Pair<Integer,String> p2 = (Pair<Integer,String>) in.readObject();
		in.close();
		Pair<Integer,String> p3 = new Pair<>(2, "one");
		System.out.println("Serialization used to save p1 and get p2");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println((p1.equals(p2)) ? 
				"using equals(), the p1 & p2 are equal" : 
				"using equals(), the p1 & p2 are not equal");
		System.out.println("p1 Hash: " + p1.hashCode());
		System.out.println("p2 Hash: " + p2.hashCode());
		System.out.println((p1.equals(p3)) ? 
				"using equals(), the p1 & p3 are equal" : 
				"using equals(), the p1 & p3 are not equal");
		System.out.println("p1 Hash: " + p1.hashCode());
		System.out.println("p3 Hash: " + p3.hashCode());
	}
}