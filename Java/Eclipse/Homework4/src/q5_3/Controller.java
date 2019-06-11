package q5_3;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Class Controller that communicated between models and view
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 3/24/2018
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
		this.view.addListener(new KListener());
	}
	
	/**
	 * Class KListener that extends KeyAdapter to override keyReleased
	 * @author Cameron Anzola
	 * @class COP5339 001
	 * @data 3/24/2018
	 */
	class KListener extends KeyAdapter {
		/**
		*  override keyReleased to notify observers
		*  @precondition key release listener has been added to Textfield
		*  @postcondition Observer has been updated.
		*/
		@Override
		public void keyReleased(KeyEvent arg) {
			Textfield temp = (Textfield) arg.getSource();
			temp.notifyObserver();
            view.repaint();
		}
	}
}
