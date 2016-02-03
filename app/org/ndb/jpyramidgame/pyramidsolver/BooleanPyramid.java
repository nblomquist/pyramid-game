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
			boolean[] temp1 = null;
			boolean[] temp2 = null;
			
			BooleanPyramid bpTemp = (BooleanPyramid)this;
			temp1 = bpTemp.positions;
			temp2 = new boolean[bpTemp.positions.length];
			
			// use array copy to handle the normal case of the Pyramid being type BooleanPyramid
			System.arraycopy(temp1,0,temp2,0,temp1.length);
			temp2[moveTo] = true;
			temp2[index] = false;
			temp2[jumpOver] = false;
			children.add(new BooleanPyramid(temp2, this));
		}
	}
		
	public int size(){
		return positions.length;
	}
    
	public boolean isFilled(int pos){
		return positions[pos];
	}
}