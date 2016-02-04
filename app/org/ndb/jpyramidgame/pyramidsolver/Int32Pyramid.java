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
				int newPositions =  this.positions;
				newPositions |= (1 << moveTo);     //[moveTo] = true;
				newPositions &= ~(1 << index); //[index] = false;
				newPositions &= ~(1 << jumpOver);//[jumpOver] = false;
				addChild(new Int32Pyramid(newPositions, this));
		}

	}

	public boolean isFilled(int pos) {
		return (positions & (1 << pos)) != 0;
	}

	public int size() {
		
		return SIZE;
	}

}
