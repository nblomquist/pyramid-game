package org.ndb.jpyramidgame.pyramidsolver;


public class Int32Pyramid extends AbstractPyramid implements IPyramid {

	private static final int SIZE = 15; 
	
	private int positions = 0;
	
	public Int32Pyramid(int positions, IPyramid parent){
		this.positions = positions;
		setParent(parent);
	}
	
	Int32Pyramid(boolean[] positions, IPyramid parent){
		for(int i = 0; i < positions.length; ++i){
			if(positions[i]){
				this.positions |= (1 << i);
			}
		}
	}
	
	@Override
	protected void move(int index, int moveTo, int jumpOver) {
		if (this.isFilled(moveTo) == false && this.isFilled(jumpOver) == true){
				Int32Pyramid ipyr = (Int32Pyramid)this;
				
				int temp2 =  ipyr.positions;
				
				temp2 |= (1 << moveTo);     //[moveTo] = true;
				temp2 &= ~(1 << index); //[index] = false;
				temp2 &= ~(1 << jumpOver);//[jumpOver] = false;
				children.add(new Int32Pyramid(temp2, this));	
		}

	}

	public boolean isFilled(int pos) {
		return (positions & (1 << pos)) != 0;
	}

	public int size() {
		
		return SIZE;
	}

}
