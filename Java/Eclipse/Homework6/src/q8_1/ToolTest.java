package q8_1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Paper Tool that extends from GeneralTool
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/21/2018
 */
public class ToolTest implements Toolbox {
	private ArrayList<Tool> tools = new ArrayList<Tool>();
	
	/**
	*  Main Function
	*  @precondition none
	*  @postcondition Program has started
	*/
	public static void main(String[] args) {
		ToolTest toolBox = new ToolTest();
		toolBox.add(new Eraser());
		toolBox.add(new Pencil());
		toolBox.add(new Protractor());
		toolBox.add(new Ruler());
		toolBox.add(new Paper());
		
		Tool tool1 = toolBox.get("Eraser");
		Tool tool2 = toolBox.get("Pencil");
		Tool tool3 = toolBox.get("Protractor");
		Tool tool4 = toolBox.get("Ruler");
		Tool tool5 = toolBox.get("Paper");
		Tool tool6 = toolBox.get("Paper");
		
		tool1.use();
		tool2.use();
		tool3.use();
		tool4.use();
		tool5.use();
		tool6.use();
	}

	/**
	*  Add a Tool to Toolbox
	*  @precondition an instance of toolbox exist
	*  @postcondition Toolbox will contain an instance for Tool
	*/
	@Override
	public void add(Tool tool) {
		tools.add(tool);
		System.out.println(tool.getName() + " added to Toolbox, Hashcode: " 
				+ System.identityHashCode(System.identityHashCode(tool)));
	}

	/**
	*  Get a cloned tool from Toolbox
	*  @precondition Toolbox contains Tools
	*  @return a cloned copy of the Tool requested
	*/
	@Override
	public Tool get(String toolName) {
		Tool tool = tools.stream().filter(t -> t.getName().equals(toolName)).findAny().orElse(null);
		if (tool != null) {
			return (Tool) tool.clone();
		}
		else {
			throw new NoSuchElementException();
		}
	}
}