/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JPanel;

import org.ndb.jpyramidgame.pyramidsolver.IPyramid;

public class CheckPyramidPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 374198678183775922L;
	private JCheckBox jcb0 = null;
	private JCheckBox jcb1 = null;
	private JCheckBox jcb2 = null;
	private JCheckBox jcb3 = null;
	private JCheckBox jcb4 = null;
	private JCheckBox jcb5 = null;
	private JCheckBox jcb6 = null;
	private JCheckBox jcb7 = null;
	private JCheckBox jcb8 = null;
	private JCheckBox jcb9 = null;
	private JCheckBox jcb10 = null;
	private JCheckBox jcb11 = null;
	private JCheckBox jcb12 = null;
	private JCheckBox jcb13 = null;
	private JCheckBox jcb14 = null;
	
	private List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
	
	private Color old_color;

	/**
	 * This is the default constructor
	 */
	public CheckPyramidPanel() {
		super();
		initialize();
		
		checkboxes.add(jcb0);
		checkboxes.add(jcb1);
		checkboxes.add(jcb2);
		checkboxes.add(jcb3);
		checkboxes.add(jcb4);
		checkboxes.add(jcb5);
		checkboxes.add(jcb6);
		checkboxes.add(jcb7);
		checkboxes.add(jcb8);
		checkboxes.add(jcb9);
		checkboxes.add(jcb10);
		checkboxes.add(jcb11);
		checkboxes.add(jcb12);
		checkboxes.add(jcb13);
		checkboxes.add(jcb14);
		
		for(int i = 0; i < checkboxes.size(); ++i){
			JCheckBox jcb = checkboxes.get(i);
			jcb.setSelected(true);
			jcb.setToolTipText(String.valueOf(i));
		}
		
		old_color = jcb14.getBackground();
		
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
		gridBagConstraints14.gridx = 23;
		gridBagConstraints14.gridy = 4;
		GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
		gridBagConstraints13.gridx = 8;
		gridBagConstraints13.gridy = 4;
		GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
		gridBagConstraints12.gridx = 5;
		gridBagConstraints12.gridy = 4;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.gridx = 3;
		gridBagConstraints11.gridy = 4;
		GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
		gridBagConstraints10.gridx = 0;
		gridBagConstraints10.gridy = 4;
		GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
		gridBagConstraints9.gridx = 19;
		gridBagConstraints9.gridy = 3;
		GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
		gridBagConstraints8.gridx = 6;
		gridBagConstraints8.gridy = 3;
		GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
		gridBagConstraints7.gridx = 4;
		gridBagConstraints7.gridy = 3;
		GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
		gridBagConstraints6.gridx = 2;
		gridBagConstraints6.gridy = 3;
		GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
		gridBagConstraints5.gridx = 8;
		gridBagConstraints5.gridy = 2;
		GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
		gridBagConstraints4.gridx = 5;
		gridBagConstraints4.gridy = 2;
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 3;
		gridBagConstraints3.gridy = 2;
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.gridx = 6;
		gridBagConstraints2.gridy = 1;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 4;
		gridBagConstraints1.gridy = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 5;
		gridBagConstraints.gridy = 0;
		this.setLayout(new GridBagLayout());
		this.setSize(300, 200);
		this.add(getJcb0(), gridBagConstraints);
		this.add(getJcb1(), gridBagConstraints1);
		this.add(getJcb2(), gridBagConstraints2);
		this.add(getJcb3(), gridBagConstraints3);
		this.add(getJcb4(), gridBagConstraints4);
		this.add(getJcb5(), gridBagConstraints5);
		this.add(getJcb6(), gridBagConstraints6);
		this.add(getJcb7(), gridBagConstraints7);
		this.add(getJcb8(), gridBagConstraints8);
		this.add(getJcb9(), gridBagConstraints9);
		this.add(getJcb10(), gridBagConstraints10);
		this.add(getJcb11(), gridBagConstraints11);
		this.add(getJcb12(), gridBagConstraints12);
		this.add(getJcb13(), gridBagConstraints13);
		this.add(getJcb14(), gridBagConstraints14);
	}

	/**
	 * This method initializes jcb0	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb0() {
		if (jcb0 == null) {
			jcb0 = new JCheckBox();
		}
		return jcb0;
	}

	/**
	 * This method initializes jcb1	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb1() {
		if (jcb1 == null) {
			jcb1 = new JCheckBox();
		}
		return jcb1;
	}

	/**
	 * This method initializes jcb2	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb2() {
		if (jcb2 == null) {
			jcb2 = new JCheckBox();
		}
		return jcb2;
	}

	/**
	 * This method initializes jcb3	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb3() {
		if (jcb3 == null) {
			jcb3 = new JCheckBox();
		}
		return jcb3;
	}

	/**
	 * This method initializes jcb4	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb4() {
		if (jcb4 == null) {
			jcb4 = new JCheckBox();
		}
		return jcb4;
	}

	/**
	 * This method initializes jcb5	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb5() {
		if (jcb5 == null) {
			jcb5 = new JCheckBox();
		}
		return jcb5;
	}

	/**
	 * This method initializes jcb6	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb6() {
		if (jcb6 == null) {
			jcb6 = new JCheckBox();
		}
		return jcb6;
	}

	/**
	 * This method initializes jcb7	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb7() {
		if (jcb7 == null) {
			jcb7 = new JCheckBox();
		}
		return jcb7;
	}

	/**
	 * This method initializes jcb8	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb8() {
		if (jcb8 == null) {
			jcb8 = new JCheckBox();
		}
		return jcb8;
	}

	/**
	 * This method initializes jcb9	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb9() {
		if (jcb9 == null) {
			jcb9 = new JCheckBox();
		}
		return jcb9;
	}

	/**
	 * This method initializes jcb10	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb10() {
		if (jcb10 == null) {
			jcb10 = new JCheckBox();
		}
		return jcb10;
	}

	/**
	 * This method initializes jcb11	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb11() {
		if (jcb11 == null) {
			jcb11 = new JCheckBox();
		}
		return jcb11;
	}

	/**
	 * This method initializes jcb12	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb12() {
		if (jcb12 == null) {
			jcb12 = new JCheckBox();
		}
		return jcb12;
	}

	/**
	 * This method initializes jcb13	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb13() {
		if (jcb13 == null) {
			jcb13 = new JCheckBox();
		}
		return jcb13;
	}

	/**
	 * This method initializes jcb14	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJcb14() {
		if (jcb14 == null) {
			jcb14 = new JCheckBox();
		}
		return jcb14;
	}
	
	protected boolean[] bools = null;
	
	public boolean[] getBooleans(){
		if(bools == null){
			bools = new boolean[15];
		}
		
		for(int i = 0; i < checkboxes.size(); ++i){
			bools[i] = ((JCheckBox)checkboxes.get(i)).isSelected();
		}
		
		return bools;
	}
	
	public void setPyramid(IPyramid pyr){
		if(bools == null){
			bools = new boolean[15];
		}
		
		for(int i = 0; i < pyr.size(); ++i){
			bools[i] = pyr.isFilled(i);
			((JCheckBox)checkboxes.get(i)).setSelected(bools[i]);
		}
	}
	
	
	public void setColor(int i, Color c){
		if(i >= 0){
			((JCheckBox)checkboxes.get(i)).setBackground(c);
			((JCheckBox)checkboxes.get(i)).repaint();
		}
	}
	
	public void resetColor(int i){
		setColor(i,old_color);
	}
	
	public void resetAllColor(){
		for(int i = 0; i < 15; ++i)
			resetColor(i);
	}

	public void reset() {
		for(JCheckBox jc : checkboxes){
			jc.setSelected(true);
		}
		resetAllColor();
	}
}
