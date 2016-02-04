package org.ndb.jpyramidgame.pyramidsolver;

import org.jooq.lambda.Seq;

import java.io.StringWriter;
import java.util.List;

public class PyramidHelper {
	static public boolean[] convertToBooleanArray(IPyramid pyr){
		boolean[] bools = new boolean[pyr.size()];
		
		for(int i = 0; i < pyr.size(); ++i){
			bools[i] = pyr.isFilled(i);
		}
		
		return bools;
	}
	
	static public int convertToInt(IPyramid pyr){
		int ret = 0;
		
		for(int i = 0; i < pyr.size(); ++i){
			if(pyr.isFilled(i)){
				ret |= (1 << i);
			}
		}
		
		return ret;
	}
	
	static public IPyramid convertToPyramid(int ret){
		return new Int32Pyramid(ret, null);
	}
	
	static public PyramidDifference getDifferences(List<IPyramid> pyrs, int index){
		PyramidDifference pd = new PyramidDifference();
		
		int red = -1, yellow = -1, green = -1;
		int[] greens = new int[2];
		int bc = 0;
		if (index + 1 >= pyrs.size()) {
			IPyramid current = pyrs.get(index);
			for (int i = 0; i < current.size(); ++i) {
				if (current.isFilled(i)) {
					pd.setRed(i);
					break;
				}
			}
		} else {
			IPyramid current = pyrs.get(index);
			IPyramid next = pyrs.get(index+1);

			for (int i = 0; i < current.size(); ++i) {
				if (!current.isFilled(i) && next.isFilled(i)) {
					// we found the destination
					red = i;
				} else if (current.isFilled(i) && !next.isFilled(i)) {
					// we found the start
					greens[bc] = i;
					bc++;
				}
			}

			if (red < greens[0] && red < greens[1]) {
				if (greens[0] < greens[1]) {
					yellow = greens[0];
					green = greens[1];
				} else {
					yellow = greens[1];
					green = greens[0];
				}
			} else {
				if (greens[0] > greens[1]) {
					yellow = greens[0];
					green = greens[1];
				} else {
					yellow = greens[1];
					green = greens[0];
				}
			}

			pd.setRed(red);
			pd.setGreen(green);
			pd.setYellow(yellow);
		}
		
		return pd;
	}
	
	static public String textSolution(List<IPyramid> pyramids){
		return Seq.seq(pyramids)
                .map(pyr->pyr.toString())
                .toString("\n");
	}
}
