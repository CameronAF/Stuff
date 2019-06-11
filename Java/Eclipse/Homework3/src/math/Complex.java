package math;
import java.rmi.UnexpectedException;

/**
* An immutable class for representing complex numbers
* @author Cameron Anzola
* @class COP5339 001
* @data 2/17/2018
*/
public class Complex {
	private double real;
	private double imaginary;
 
	/**
	*  Main method, demonstrates the use of Complex class
	*  @precondition none
	*  @postcondition program will have executed
	*/
	public static void main(String[] args) {
		Complex num1 = new Complex(5,2);
		Complex num2 = new Complex(3,-7);
		System.out.println("Complex number 1: " + num1.toString());
		System.out.println("Complex number 2: " + num2.toString());
		Complex add = num1.add(num2);
		System.out.println(num1.toString() + " + " +  num2.toString() + " = " + add.toString());
		Complex sub = num1.sub(num2);
		System.out.println(num1.toString() + " - " +  num2.toString() + " = " + sub.toString());
		Complex mul = num1.mult(num2);
		System.out.println(num1.toString() + " X " +  num2.toString() + " = " + mul.toString());
		try
		{
			Complex div = num1.div(num2);
			System.out.println(num1.toString() + " / " +  num2.toString() + " = " + div.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {}
	}
	
	/**
	*  Constructor for Complex object
	*  @precondition a double to represent a real part and imaginary part
	*  @postcondition new instance of complex
	*/
	public Complex(double r, double i) {
		real = r;
		imaginary = i;
	}
   
	/**
	*  Constructor for Complex object that has a zero imaginary part
	*  @precondition a double to represent a real part
	*  @postcondition new instance of complex
	*/
	public Complex(double r) {
		real = r;
		imaginary = 0;
	}
 
	/**
	*  override toString method to get a Complex object in format (A +/- Bi) or (A)
	*  @precondition an instance of Complex exist
	*  @return a string representation of Complex object
	*/
	@Override
	public String toString() {
		String str = "(" + Double.toString(this.r());
		if (this.i() < 0) {
			str = str + " - ";
		}
		else if (this.i() > 0) {
			str = str + " + ";
		}
		else {
			return (str + ")");
		}   
		return (str + Double.toString(Math.abs(this.i())) + "i)");
	}
 
	/**
	*  get the real value of a complex object
	*  @precondition an instance of Complex exist
	*  @return a double of real value
	*/
	public double r() {
		return this.real;
	}
 
	/**
	*  get the imaginary value of a complex object
	*  @precondition an instance of Complex exist
	*  @return a double of imaginary value
	*/
	public double i() {
		return this.imaginary;
	}
	
	/**
	*  Add two Complex numbers
	*  @precondition an instance of Complex exist
	*  @return new instance of Complex object
	*/
	public Complex add(Complex other) {
		return ( new Complex((this.r() + other.r()),(this.i() + other.i())));
	}
	
	/**
	*  Subtract two Complex numbers
	*  @precondition an instance of Complex exist
	*  @return new instance of Complex object
	*/
	public Complex sub(Complex other) {
		return ( new Complex((this.r() - other.r()),(this.i() - other.i())));	
	}
	
	/**
	*  get the conjugate of a Complex numbers
	*  @precondition an instance of Complex exist
	*  @return new instance of Complex object
	*/
	public Complex conj() {
		return ( new Complex((this.r()),(this.i()*(-1))));
	}
	
	/**
	*  Multiply two Complex numbers
	*  @precondition an instance of Complex exist
	*  @return new instance of Complex object
	*/
	public Complex mult(Complex other) {
		//(A + Bi)(C + Di) = (AB) + (ADi) + (BCi) + (-BD) = (AB - BD)) + (ADi + BCi) 
		double ab = this.r()*other.r();
		double adI = this.r()*other.i();
		double bcI = this.i()*other.r();
		double bd = this.i()*other.i();
		return ( new Complex((ab - bd),(adI + bcI)));		
	}
	
	/**
	*  Divide two Complex numbers
	*  @precondition an instance of Complex exist
	*  @return new instance of Complex object
	 * @throws Exception 
	*/
	public Complex div(Complex other) throws Exception {
		Complex conjugate = other.conj();
		Complex numertor = this.mult(conjugate);
		Complex denominator = other.mult(conjugate);
		if (denominator.i() != 0) {
			throw new UnexpectedException("There was an issue with the divisor");
		}
		if (denominator.r() == 0) {
			throw new IllegalArgumentException("Argument 'divisor' is 0");
		}
		double newR = numertor.r() / denominator.r();
		double newI = numertor.i() / denominator.r();
		return ( new Complex(newR, newI));
	}
	
	/**
	*  Compare two Complex numbers
	*  @precondition an instance of Complex exist
	*  @return true if both numbers are equal
	*/
	public boolean equals(Complex other) {
		if ((this.r() == other.r()) || (this.i() == other.i())) {
			return true;
		}
		return false;
	}
}