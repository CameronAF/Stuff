package q8_1;

/**
 * Tool interface, cloneable object
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public interface Tool extends Cloneable {
	public String getName();
	public void use();
	public Object clone();
}