package math;
import junit.framework.*;
import org.junit.jupiter.api.Test;

/**
 * jTest class for testing immutable class Complex
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 2/17/2018
 */
class ComplexTest extends TestCase {

	/**
	 * Test method for {@link math.Complex#equals(math.Complex)}.
	 */
	@Test
	public void testEquals() {
		System.out.println("run test equals");
		Complex instance = new Complex(3,-7);
	    Complex other = new Complex(3,-7);
	    boolean expResult = true;
	    boolean result = instance.equals(other);
	    assertEquals(expResult, result);
	}
	
	/**
	 * Test method for {@link math.Complex#add(math.Complex)}.
	 */
	@Test
	public void testAdd() {
		System.out.println("run test add");
		double a = 1, b = 2, c = -3, d = 4;
		double e = a + c, f = b + d;
		// set up Complex objects
		Complex instance = new Complex(a,b);
		Complex other = new Complex(c,d);
		Complex expResult = new Complex(e,f);
		Complex result = instance.add(other);
		// test condition using the Complex equals() method:
	    assertTrue(expResult.equals(result));
	}

	/**
	 * Test method for {@link math.Complex#sub(math.Complex)}.
	 */
	@Test
	public void testSub() {
		System.out.println("run test sub");
		double a = 1, b = 2, c = -3, d = 4;
		double e = a - c, f = b - d;
		// set up Complex objects
		Complex instance = new Complex(a,b);
		Complex other = new Complex(c,d);
		Complex expResult = new Complex(e,f);
		Complex result = instance.sub(other);
		// test condition using the Complex equals() method:
	    assertTrue(expResult.equals(result));
	}

	/**
	 * Test method for {@link math.Complex#mult(math.Complex)}.
	 */
	@Test
	public void testMult() {
		System.out.println("run test mult");
		double a = 1, b = 2, c = -3, d = 4;
		double e = (a * c) - (b * d), f = (b * c) + (a * d);
		// set up Complex objects
		Complex instance = new Complex(a,b);
		Complex other = new Complex(c,d);
		Complex expResult = new Complex(e,f);
		Complex result = instance.mult(other);
		// test condition using the Complex equals() method:
	    assertTrue(expResult.equals(result));
	}

	/**
	 * Test method for {@link math.Complex#div(math.Complex)}.
	 */
	@Test
	public void testDiv() {
		System.out.println("run test div");
		double a = 1, b = 2, c = -3, d = 4;
		double e = (a*c) + (b*d), f = (b*c) - (a*d), g = (c*c) + (d*d);
		// set up Complex objects
		Complex instance = new Complex(a,b);
		Complex other = new Complex(c,d);
		Complex expResult = new Complex((e/g),(f/g));
		// test condition using the Complex equals() method:
	    Complex result = null;
		try {
			result = instance.div(other);
		} catch (Exception ex) {
			fail("Error with Div method");
		}
		assertTrue(expResult.equals(result));
	}
}
