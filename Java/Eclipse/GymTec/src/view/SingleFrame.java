package view;

import java.awt.BorderLayout;
import java.awt.event.WindowListener;
import java.util.LinkedList;
import javax.swing.*;
import model.Observer;

/**
* Singleton pattern Class LoginView that extends JFrame and implements subject for Observer pattern 
* @author Cameron Anzola
* @class COP5339 001
* @data 4/23/2018
*/
public class SingleFrame extends JFrame implements Subject {
	private static SingleFrame frame = null;
	private LinkedList<Observer> recObservers = new LinkedList<Observer>();
	private JPanel menu = null;
	
	/**
	*  Private Constructor for class SingleFrame
	*  @postcondition a instance of SingleFrame would have been initialized
	*/
	private SingleFrame() {
		this.setSize(1000, 700);
		this.setLayout(new BorderLayout()); 
	}
	
	/**Get private static instance of SingleFrame (Singleton pattern)
	*  @return a static instance of SingleFrame will be passes*/
	public static SingleFrame getFrame() {
		if (frame == null)  {
			frame = new SingleFrame();
		}
		return frame;
	}
	
	/**Add Menu to blank Jframe
	*  @postcondition Menu will be added to JFrame*/
	public void addMenuToBlankFrame(Menu p1) {
		clear();
		menu = p1;
		frame.add(menu, BorderLayout.LINE_START );
	}
	
	/**Add a panel to JFrame
	*  @postcondition JFrame will contain one Panel container*/
	public void addViewToBlankFrame(JPanel p1) {
		clear();
		frame.add(p1, BorderLayout.CENTER );
		frame.repaint();
		frame.setVisible(true);
	}
	
	/**Add a panel to JFrame
	*  @precondition Menu has already been added using addMenuToBlankFrame()
	*  @postcondition JFrame will have a menu and another panel */
	public void addView(JPanel p1) {
		clear();
		frame.add(menu, BorderLayout.LINE_START );
		frame.add(p1);
		frame.repaint();
		frame.setVisible(true);
	}
	
	/**Clear content of JFrame
	*  @postcondition JFrame will have no content*/
	private void clear() {
		frame.getContentPane().removeAll();
		frame.repaint();
		frame.setTitle("GymTec");
	}
	
	/**Add a Window Listener
	*  @postcondition Event will Execute when Action occurs */
	public void addListener(WindowListener wl) {
		frame.addWindowListener(wl);
	}

	/**Add observers to a list (Observer pattern)
	*  @postcondition these observers will be notified if Event occurs */
	@Override
	public void addObserver(Observer o) {
		this.recObservers.add(o);
	}

	/**Notify Observers of event (Observer pattern)
	*  @postcondition Observers in list will be notified*/
	@Override
	public void notifyObserver() {
		if (recObservers != null)
			recObservers.forEach(observer -> observer.saveClass());
	}
}