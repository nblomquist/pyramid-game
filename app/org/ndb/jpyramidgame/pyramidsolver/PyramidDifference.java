package org.ndb.jpyramidgame.pyramidsolver;

import java.io.Serializable;

public class PyramidDifference implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int red = -1;
	private int yellow = -1;
	private int green = -1;
	
	public int getRed() {
		return red;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public int getYellow() {
		return yellow;
	}
	public void setYellow(int yellow) {
		this.yellow = yellow;
	}
	public int getGreen() {
		return green;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	
	
}
