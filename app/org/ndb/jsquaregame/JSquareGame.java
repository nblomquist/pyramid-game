/*
 * Created on Nov 5, 2005
 *
 */
package org.ndb.jsquaregame;

import java.awt.BorderLayout;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.ndb.jsquaregame.squaresolver.Square;
import org.ndb.jsquaregame.squaresolver.SquareSolver;


public class JSquareGame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5900102181269191316L;
	private JPanel jContentPane = null;
	
	private JPanel panel = null;
	private JButton jButtonSolve = null;
	private JSquarePanel jSquarePanel = null;
	private JButton jButtonPrev = null;
	private JButton jButtonNext = null;
	/**
	 * This method initializes panel	
	 * 	
	 * @return java.awt.JPanel	
	 */
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getJButtonPrev(), null);
			panel.add(getJButtonSolve(), null);
			panel.add(getJButtonNext(), null);
		}
		return panel;
	}
	
	/**
	 * This method initializes jButtonSolve	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonSolve() {
		if (jButtonSolve == null) {
			jButtonSolve = new JButton();
			jButtonSolve.setText("Solve");
			jButtonSolve.setMnemonic(java.awt.event.KeyEvent.VK_S);
			jButtonSolve.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onSolve();
				}
			});
		}
		return jButtonSolve;
	}
	ArrayList sqList = new ArrayList();
	protected void onSolve() {
		index = 0;
		
		boolean[] bools = jSquarePanel.getValues();
		Square s = new Square(bools,null);

		
		Square ss = SquareSolver.solve(s);
		 sqList.clear();
		
		while(null != ss){
			sqList.add(ss);
			ss = ss.parent;
		}
		
		Collections.reverse(sqList);
		StringWriter sw = new StringWriter();
		for(int i = 0; i < sqList.size(); ++i){
			((Square)sqList.get(i)).print(sw);
			sw.write("\n");
		}
		String str = sw.toString();
		System.out.println(str);
		jSquarePanel.setValues(((Square)sqList.get(0)).positions);
		
	}
	
	/**
	 * This method initializes jSquarePanel	
	 * 	
	 * @return org.ndb.jsquaregame.JSquarePanel	
	 */
	private JSquarePanel getJSquarePanel() {
		if (jSquarePanel == null) {
			jSquarePanel = new JSquarePanel();
			boolean[] bools = new boolean[25];
			for(int i = 0; i < bools.length; ++i){
				if(i == 2) // set this value to whatever position you want empty
					bools[i] = false;
				else
					bools[i] = true;
			}
			jSquarePanel.setValues(bools);
		}
		return jSquarePanel;
	}

	/**
	 * This method initializes jButtonPrev	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonPrev() {
		if (jButtonPrev == null) {
			jButtonPrev = new JButton();
			jButtonPrev.setText("<--");
			jButtonPrev.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onPrevious();
				}
			});
		}
		return jButtonPrev;
	}

	int index = 0;
	protected void onPrevious() {
		index--;
		if(index <= 0)
			jButtonPrev.setEnabled(false);
		
		if(index < sqList.size()-1)
			jButtonNext.setEnabled(true);
		
		jSquarePanel.setValues(((Square)sqList.get(index)).positions);
		
	}
	
	protected void onNext() {
		index++;
		if(index >=  sqList.size()-1)
			jButtonNext.setEnabled(false);
		
		if(index > 0)
			jButtonPrev.setEnabled(true);
		
		jSquarePanel.setValues(((Square)sqList.get(index)).positions);
		
	}

	/**
	 * This method initializes jButtonNext	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButtonNext() {
		if (jButtonNext == null) {
			jButtonNext = new JButton();
			jButtonNext.setText("-->");
			jButtonNext.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					onNext();
				}
			});
		}
		return jButtonNext;
	}

	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final JFrame frame = new JSquareGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		SwingUtilities.invokeLater(new Runnable(){
			
			public void run() {
				frame.setVisible(true);
				
			}
			
		});
		
	}
	
	/**
	 * This is the default constructor
	 */
	public JSquareGame() {
		super();
		initialize();
	}
	
	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(314, 312);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
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
			//jContentPane.add(getJScrollPane(), java.awt.BorderLayout.CENTER);
			jContentPane.add(getPanel(), java.awt.BorderLayout.SOUTH);
			jContentPane.add(getJSquarePanel(), java.awt.BorderLayout.WEST);
		}
		return jContentPane;
	}
	
}  //  @jve:decl-index=0:visual-constraint="10,10"
