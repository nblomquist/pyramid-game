/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class JPyramidGame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2926061027275119870L;
	private JPanel jContentPane = null;
	private JPyramidPanel jPyramidPanel = null;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){

			public void run() {
				JFrame frame = new JPyramidGame();
				frame.pack();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
			}
			
		});

	}

	/**
	 * This is the default constructor
	 */
	public JPyramidGame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		//this.setSize(300, 200);
		this.setResizable(false);
		this.setContentPane(getJContentPane());
		this.setTitle("JPyramid Game (Solver)");
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
			jContentPane.add(getJPyramidPanel(), java.awt.BorderLayout.EAST);
		}
		return jContentPane;
	}

}
