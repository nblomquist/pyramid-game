package org.ndb.jpyramidgame.pyramidsolver;

import java.io.StringWriter;
import java.util.Collection;

public interface IPyramid {

	public void movePosition(int index);

	public boolean isSolved();

	public void print(StringWriter sw);
	
	public IPyramid getParent();
	
	public int size();
	
	public boolean isFilled(int pos);
	
	public int getDepth();
	
	public IPyramid getYReflection();
	public IPyramid getYXReflection();
	public IPyramid getXYReflection();

	public Collection<IPyramid> getChildren();
}