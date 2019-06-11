package controller;

import view.MembersView;
import view.SingleFrame;

/**
* Class MembersControl that acts as controller between MembersView and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MembersControl {

	/**
	*  Constructor for class MembersControl
	*  @param view the JPanel to be controlled
	*  @postcondition a instance of MembersControl would have been initialized and view will be set to Frame
	*/
	public MembersControl(MembersView view) {
		// TODO Auto-generated constructor stub
		SingleFrame.getFrame().addView(view);
	}

}
