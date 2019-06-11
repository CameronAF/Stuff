package q5_4;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class Controller that communicated between models and view
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/25/2018
 */
public class Controller {
	// private attributes
	private View view;
	
	/**
	*  Constructor for class Controller
	*  @precondition none
	*  @postcondition a instance of Controller would have been initialized
	*/
	public Controller(View V) {
		this.view = V;
		this.view.addListener(new SliderListener());
	}
	
	/**
	 * Class SliderListener that implements ChangeListener to override stateChanged
	 * @author Cameron Anzola
	 * @class COP5339 001
	 * @data 3/25/2018
	 */
	class SliderListener  implements ChangeListener {
		/**
		*  override stateChanged to notify observers
		*  @precondition stateChanged listener has been added to object
		*  @postcondition Observer has been updated.
		*/
		@Override
		public void stateChanged(ChangeEvent e) {
			Slider temp = (Slider) e.getSource();
			temp.notifyObserver();
            view.repaint();			
		}
	}
}