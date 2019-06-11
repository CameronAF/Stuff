package math;

import java.rmi.UnexpectedException;

/**
*
* @author Cameron Anzola
*/
public class Complex {
	private double real;
	private double imaginary;
 
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
		String str = Double.toString(this.r());
		if (this.i() < 0) {
			str = str + " - ";
		}
		else if (this.i() > 0) {
			str = str + " + ";
		}
		else {
			return (str);
		}   
		return (str + Double.toString(Math.abs(this.i())) + "i");
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