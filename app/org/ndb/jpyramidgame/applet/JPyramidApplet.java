/*
 * Created on Nov 1, 2005
 *
 */
package org.ndb.jpyramidgame.applet;

import java.awt.BorderLayout;

import javax.swing.JApplet;
import javax.swing.JPanel;

import org.ndb.jpyramidgame.JPyramidPanel;

public class JPyramidApplet extends JApplet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8563433690612452378L;
	private JPanel jContentPane = null;
	private JPyramidPanel jPyramidPanel = null;

	/**
	 * This is the default constructor
	 */
	public JPyramidApplet() {
		super();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	public void init() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPyramidPanel(), java.awt.BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPyramidPanel	
	 * 	
	 * @return org.ndb.jpyramidgame.JPyramidPanel	
	 */
	private JPyramidPanel getJPyramidPanel() {
		if (jPyramidPanel == null) {
			jPyramidPanel = new JPyramidPanel();
		}
		return jPyramidPanel;
	}

}
