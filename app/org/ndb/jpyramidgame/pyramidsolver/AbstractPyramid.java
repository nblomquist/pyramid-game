/**
 * 
 */
package org.ndb.jpyramidgame.pyramidsolver;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.ndb.utility.BooleanStuff;

/**
 * @author nathan
 * 
 */
public abstract class AbstractPyramid implements IPyramid {

	private IPyramid parent;
	private int depth = -1;
	
	private Collection<IPyramid> children;

	public boolean isSolved() {
		int count = 0;
		for (int i = 0; i < this.size(); ++i) {
			if (this.isFilled(i)) {
				++count;
				if (count > 1)
					return false;
			}
		}
		return true;
	}

	protected void setParent(IPyramid parent) {
		this.parent = parent;
		if (parent == null)
			depth = 0;
		else
			depth = parent.getDepth() + 1;
	}

	public int getDepth() {
		return depth;
	}

	public IPyramid getParent() {
		return parent;
	}
	
	public Collection<IPyramid> getChildren() {
		if(children == null){
			children = new ArrayList<IPyramid>();
		}
		
		children.clear();
		for(int index = 0; index < size(); ++index){
			movePosition(index);
		}
		
		return Collections.unmodifiableCollection(children);
	}

	public void movePosition(int index)
	{
		if(isFilled(index))
		{
			switch(index)
			{
				case 0:
                    move(index, 3, 1);
                    move(index, 5, 2);
					break;
				case 1:
                    move(index, 6, 3);
                    move(index, 8, 4);
					break;
				case 2:
                    move(index, 7, 4);
                    move(index, 9, 5);
					break;
				case 3:
                    move(index, 0, 1);
                    move(index, 5, 4);
                    move(index, 10, 6);
                    move(index, 12, 7);
					break;
				case 4:
                    move(index, 11, 7);
                    move(index, 13, 8);
					break;
				case 5:
                    move(index, 0, 2);
                    move(index, 3, 4);
                    move(index, 12, 8);
                    move(index, 14, 9);
					break;
				case 6:
                    move(index, 1, 3);
                    move(index, 8, 7);
					break;
				case 7:
                    move(index, 2, 4);
                    move(index, 9, 8);
					break;
				case 8:
                    move(index, 1, 4);
                    move(index, 6, 7);
					break;
				case 9:
                    move(index, 7, 8);
                    move(index, 2, 5);
					break;
				case 10:
                    move(index, 3, 6);
                    move(index, 12, 11);
					break;
				case 11:
                    move(index, 4, 7);
                    move(index, 13, 12);
					break;
				case 12:
                    move(index, 3, 7);
                    move(index, 5, 8);
                    move(index, 10, 11);
                    move(index, 14, 13);
					break;
				case 13:
                    move(index, 4, 8);
                    move(index, 11, 12);
					break;
				case 14:
                    move(index, 12, 13);
                    move(index, 5, 9);
					break;
			}
		}
	}
	
	public void print(StringWriter sw)
    {
    	sw.write(toString());
    }

    protected void addChild(IPyramid pyramid){
        this.children.add(pyramid);
    }

    @Override
	public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("    " + tf(isFilled(0))+ "    \n");
        sb.append("   "+tf(isFilled(1)) + " " + tf(isFilled(2))+"   \n");
        sb.append("  "+ tf(isFilled(3))+" "+ tf(isFilled(4))+ " "+ tf(isFilled(5))+"  \n");
        sb.append(" "+ tf(isFilled(6))+" "+ tf(isFilled(7))+" "+ tf(isFilled(8))+" "+ tf(isFilled(9))+" \n");
        sb.append(tf(isFilled(10))+" "+tf(isFilled(11))+" "+ tf(isFilled(12))+" "+ tf(isFilled(13))+" "+ tf(isFilled(14))+'\n');
        return sb.toString();
    }
	
	@Override
	public int hashCode() {
		int h = 0;
		for(int i = 0; i < size(); ++i){
			h |= (isFilled(i)?1:0);
			h <<= 1;
		}
		 
		return h;
	}
	
    @Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(!(obj instanceof IPyramid)) return false;
		
		IPyramid p = (IPyramid) obj;
		
		for(int i = 0; i < size(); ++i){
			if(isFilled(i) != p.isFilled(i)) return false;
		}
		
		return true;
	}
    
    
	
	public IPyramid getYReflection() {
		boolean[] positions = PyramidHelper.convertToBooleanArray(this);
		boolean[] newPositions = new boolean[positions.length];
		
		newPositions[0] = positions[0];
		
		swap(positions, newPositions, 1, 2);
		
		newPositions[4] = positions[4];
		
		swap(positions, newPositions, 3, 5);
		swap(positions, newPositions, 6, 9);
		swap(positions, newPositions, 7, 8);
		swap(positions, newPositions, 10, 14);
		swap(positions, newPositions, 11, 13);
		
		newPositions[12] = positions[12];
		
		return PyramidFactory.newPyramid(newPositions, this.parent);
	}
	
	public IPyramid getYXReflection() {
		boolean[] positions = PyramidHelper.convertToBooleanArray(this);
		boolean[] newPositions = new boolean[positions.length];
		
		newPositions[14] = positions[14];
		
		swap(positions, newPositions, 9, 13);
		
		newPositions[8] = positions[8];
		
		swap(positions, newPositions, 5, 12);
		swap(positions, newPositions, 2, 11);
		swap(positions, newPositions, 4, 7);
		swap(positions, newPositions, 0, 10);
		swap(positions, newPositions, 1, 6);
		
		newPositions[3] = positions[3];
		
		return PyramidFactory.newPyramid(newPositions, this.parent);
	}
	
	public IPyramid getXYReflection() {
		boolean[] positions = PyramidHelper.convertToBooleanArray(this);
		boolean[] newPositions = new boolean[positions.length];
		
		newPositions[10] = positions[10];
		
		swap(positions, newPositions, 6, 11);
		
		newPositions[7] = positions[7];
		
		swap(positions, newPositions, 3, 12);
		swap(positions, newPositions, 1, 13);
		swap(positions, newPositions, 4, 8);
		swap(positions, newPositions, 0, 14);
		swap(positions, newPositions, 2, 9);
		
		newPositions[5] = positions[5];
		
		return PyramidFactory.newPyramid(newPositions, this.parent);
	}
	
	protected void swap(boolean[] src, boolean[] dest, int srcIndex1, int srcIndex2){
		dest[srcIndex1] = src[srcIndex2];
		dest[srcIndex2] = src[srcIndex1];
	}

	protected static char tf(boolean b)
	{
		return BooleanStuff.zeroOrOne(b);
	}
	
	protected abstract void move(int index, int moveTo, int jumpOver);

}
