package org.ndb.jpyramidgame.pyramidsolver;

public class PyramidFactory {

	public static IPyramid generateRandom(){
		boolean[] bools = new boolean[15];
		int count = 0;
		for(int i = 0; i < bools.length; ++i){
			double d = Math.random();
			if(d > .5){
				bools[i] = true;
				++count;
			}else{
				bools[i] = false;
			}
			
			if(count >= 14) break;
		}
		
		return new BooleanPyramid(bools,null);
	}
	
	public static IPyramid newPyramid(boolean[] pos, IPyramid parent){
		//return new BooleanPyramid(pos, parent);
		return new Int32Pyramid(pos, parent);
	}
}
