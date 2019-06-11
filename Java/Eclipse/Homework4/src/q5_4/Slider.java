package q5_4;

import javax.swing.JSlider;

/**
 * Class Slider that extends JSlider and implements Subject
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/25/2018
 */
public class Slider extends JSlider implements Subject {
	// private attributes
	private Observer recObserver;
	private String color;
	
	/**
	*  Constructor for class Slider
	*  @precondition none
	*  @postcondition a instance of Slider would have been initialized
	*/
	public Slider(String c) {
		this.color = c;
		this.setMinimum(0);
		this.setMaximum(255);
		this.setOrientation(JSlider.HORIZONTAL);
		this.setValue(128);
		this.setMajorTickSpacing(10);
		this.setPaintTicks(true);
	}
	
	/**
	*  Add and Observer to Slider.
	*  @precondition An object of Observer is instantiated 
	*  @postcondition Slider will have a object observing its changes
	*/
	@Override
	public void addObserver(Observer O) {
		this.recObserver = O;
	}

	/**
	*  Notify observer and update observer with Slider Text.
	*  @precondition Slider has an Observer
	*  @postcondition update Observer
	*/
	@Override
	public void notifyObserver() {
		recObserver.update(color, this.getValue()); 
	}
}