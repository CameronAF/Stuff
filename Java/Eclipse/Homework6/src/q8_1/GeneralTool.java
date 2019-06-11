package q8_1;

/**
 * GeneralTool implements Tool
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public abstract class GeneralTool implements Tool{

	/**
	*  Get the Name of the Class
	*  @precondition An instance of class extending GeneralTool exist
	*  @return The name of the class as a String
	*/
	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	/**
	*  Use the Tool
	*  @precondition An instance of class extending GeneralTool exist
	*  @postcondition System print line saying Tool is used
	*/
	@Override
	public void use() {
		System.out.println("Using " + getName() + ", Hashcode: " 
				+ System.identityHashCode(System.identityHashCode(this)));
	}
	
	/**
	*  Get a cloned instance of Object
	*  @precondition An instance of class extending GeneralTool exist
	*  @return A cloned instance of Object
	*/
	@Override
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException exception) {
			return null;
		}
	}
}