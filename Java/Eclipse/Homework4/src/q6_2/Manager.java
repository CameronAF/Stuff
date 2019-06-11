package q6_2;

/**
 * Class Manager that extends Employee
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public class Manager extends Employee{
	private int salaryBonus;

	/**
	*  Constructor for class Manager
	*  @precondition none
	*  @return a instance of Manager would have been initialized
	*/
	public Manager (String first, String last, int base, int bonus) {
		super(first, last, base);
		this.salaryBonus = bonus;
	}
	
	/**
	*  Gets Employees total salary
	*  @precondition instance of Manager exist
	*  @return the sum of base salary and bonus
	*/
	@Override
	int getSalary() {
		return baseSalary + salaryBonus;
	}

	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has run
	*/
	public static void main(String[] args) {  
		Manager me = new Manager("Cameron","Anzola",45000,0);
		Manager futureMe = new Manager("Cameron","Anzola",90000,20000);
		System.out.println(me.toString());
		System.out.println(futureMe.toString());
		
	}
}
