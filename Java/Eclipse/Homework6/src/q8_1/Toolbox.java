package q8_1;

/**
 * Toolbox Interface, acts as cloning factory
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public interface Toolbox {
	public void add(Tool tool);
	public Tool get(String toolName);
}