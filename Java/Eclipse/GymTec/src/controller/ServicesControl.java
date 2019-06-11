package controller;

import view.ServicesView;
import view.SingleFrame;

/**
* Class ServicesControl that acts as controller between ServicesView and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class ServicesControl {

	/**
	*  Constructor for class ServicesControl
	*  @param view the JPanel to be controlled
	*  @postcondition a instance of ServicesControl would have been initialized and view will be set to Frame
	*/
	public ServicesControl(ServicesView view) {
		// TODO Auto-generated constructor stub
		SingleFrame.getFrame().addView(view);
	}

}
