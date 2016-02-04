/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame.pyramidsolver;




public class BooleanPyramid extends AbstractPyramid
{
	private boolean[] positions;
	
	public BooleanPyramid(boolean[] pos, IPyramid parent)
	{
		positions = pos;	
		setParent(parent);
	}

	@Override
	protected void move(int index, int moveTo, int jumpOver)
	{
		if (this.isFilled(moveTo) == false && this.isFilled(jumpOver) == true)
		{
			boolean[] oldPositions = this.positions;
			boolean[] newPositions = new boolean[this.positions.length];
			// use array copy to handle the normal case of the Pyramid being type BooleanPyramid
			System.arraycopy(oldPositions,0,newPositions,0,oldPositions.length);
			newPositions[moveTo] = true;
			newPositions[index] = false;
			newPositions[jumpOver] = false;
			addChild(new BooleanPyramid(newPositions, this));
		}
	}
		
	public int size(){
		return positions.length;
	}
    
	public boolean isFilled(int pos){
		return positions[pos];
	}
}