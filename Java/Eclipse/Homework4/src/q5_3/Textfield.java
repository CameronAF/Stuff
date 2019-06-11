package q5_3;

import javax.swing.JTextField;

/**
 * Class Textfield that extends JTextField and implements Subject
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
 */
public class Textfield extends JTextField implements Subject {
	// private attributes
	private Observer recObserver;
	
	/**
	*  Constructor for class Textfield
	*  @precondition none
	*  @postcondition a instance of Textfield would have been initialized
	*/
	public Textfield(int value) {
		this.setText(Integer.toString(value));
		this.setColumns(5);
		this.setHorizontalAlignment(JTextField.CENTER);
	}
	
	/**
	*  Add and Observer to Textfield.
	*  @precondition An object of Observer is instantiated 
	*  @postcondition Textfield will have a object observing its changes
	*/
	@Override
	public void addObserver(Observer O) {
		this.recObserver = O;
	}

	/**
	*  Notify observer and update observer with Textfield Text.
	*  @precondition Textfield has an Observer
	*  @postcondition update Observer
	*/
	@Override
	public void notifyObserver() {
		recObserver.update(Double.parseDouble(this.getText())); 
	}
}
