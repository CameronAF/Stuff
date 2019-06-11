package view;

import model.Observer;

/**
* interface Subject used for Observer Pattern
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public interface Subject {
	public void addObserver(Observer o);
	public void notifyObserver();
}
