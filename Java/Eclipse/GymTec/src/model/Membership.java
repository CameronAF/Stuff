package model;

import java.io.Serializable;

/**
 * Class Membership that is Serializable
 * @author Cameron Anzola
 * @class COP5339 001
 * @data 4/23/2018
 */
public class Membership implements Serializable {
	private String type;
	private String plan;
	private String cost;

	/**
	 * Constructor for class Membership
	 * @param t type value
	 * @param p plan value
	 * @param c cost value
	 * @postcondition a instance of Membership would have been initialized
	 */
	public Membership (String t, String p, String c) {
		this.type = t;
		this.plan = p;
		this.cost = c;
	}
	
	/**Get Type from Membership
	 * @return Type value of String type  */
	public String getType() { return type; }
	/**Get plan from Membership
	 * @return plan value of String type  */
	public String getPlan() { return plan; }
	/**Get cost from Membership
	 * @return cost value of String type  */
	public String getCost() { return cost; }
}
