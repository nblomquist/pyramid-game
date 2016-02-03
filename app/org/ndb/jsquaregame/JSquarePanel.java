/*
 * Created on Nov 16, 2005
 *
 */
package org.ndb.jsquaregame;

import java.awt.GridLayout;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class JSquarePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527699619436752613L;

	int size;
	
	JCheckBox[] checks;
	
	/**
	 * This is the default constructor
	 */
	public JSquarePanel() {
		this(5);
	}
	
	public JSquarePanel(int size){
		super();
		this.size = size;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		JPanel p = new JPanel();
		
		GridLayout g = new GridLayout(size,size);
		p.setLayout(g);
		int max = size * size;
		checks = new JCheckBox[max];
		for(int i = 0; i < max; ++i){
			checks[i] = new JCheckBox();
			p.add(checks[i]);
		}
		
		add(p);
	}
	
	public void setValues(boolean[] bools){
		for(int i = 0; i < bools.length; ++i){
			checks[i].setSelected(bools[i]);
		}
		
		this.repaint();
	}
	
	public boolean[] getValues(){
		boolean[] bools = new boolean[size*size];
		for(int i = 0; i < checks.length; ++i){
			bools[i] = checks[i].isSelected();
		}
		
		return bools;
	}

}
