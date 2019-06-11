package q6_2;

/**
 * Abstract class Employee
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public abstract class Employee {
	// protected attributes
	protected String firstName;
	protected String lastName;
	protected int baseSalary;
	
	/**
	*  Constructor for abstract Employee
	*  @precondition none
	*  @return an instance class that extends employee
	*/
	protected Employee(String first, String last, int base) {
		this.firstName = first;
		this.lastName = last;
		this.baseSalary = base;
	}
	
	/**
	*  template method that strings together Employee attributes
	*  @precondition instance of class that extends employee exist
	*  @return string of employee name and salary
	*/
	public final String toString() {
		return (firstName + " " + lastName + 
				" - Base Salary: " + baseSalary + 
				" Total Salary: " + Integer.toString(getSalary()));
	}
	
	abstract int getSalary();	
}