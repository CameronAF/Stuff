package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import model.*;
import view.*;

/**
* Class MembershipControl that acts as controller between MembershipView and models
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class MembershipControl {
	private MembershipView view;
	private static AllMemberships memberships = AllMemberships.getInstance();
	private static final Object[] myMembershipHeader = {"Type","Plan", "Cost","Action"};
	private String[][] list;

	/**
	*  Constructor for class MembershipControl
	*  @param view the JPanel to be controlled
	*  @postcondition a instance of MembershipControl would have been initialized and view will be set to Frame
	*/
	public MembershipControl(MembershipView view) {
		makeList();
		view.fillTable(list, myMembershipHeader);
		view.addButtonsListener(new btn_SavePress());
		this.view = view;
		SingleFrame.getFrame().addView(view);
	}
	
	/**
	*  makeList method makes list that to be used to fill the Table model
	*  @postcondition a list will be made with save buttons
	*/
	private void makeList() {
		LinkedList<String> types = memberships.getTypes();
		LinkedList<String> plans = memberships.getPlans();
		LinkedList<String> cost = memberships.getCost();
		list = new String[types.size()][4];
		for (int i = 0; i < types.size(); i++) {
			list[i][0] = types.get(i);
			list[i][1] = plans.get(i);
			list[i][2] = cost.get(i);
			list[i][3] = "Save";
		}
	}
	
	/**class btn_SavePress that implements ActionListener to be used by Save button
	 * @precondition Button must be initialized be for use 
	 * @postcondition Item in row will be saved */
	class btn_SavePress implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String[] items = view.getBtnItems();
			if (memberships.isItemAtIndex(view.getBtnIndex())) {
				if (!memberships.editMembership(items, view.getBtnIndex())) {
					MessageBox.infoBox("Can not remove initial Manager Employee", "Illigal Remove");
				}
			}
			else {
				memberships.addMembership(new Membership(items[0], items[1], items[2]));
			}
			makeList();
			view.fillTable(list, myMembershipHeader);
			SingleFrame.getFrame().addView(view);
		}	
	}
}
