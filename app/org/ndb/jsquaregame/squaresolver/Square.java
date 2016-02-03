/*
 * Created on Nov 4, 2005
 *
 */
package org.ndb.jsquaregame.squaresolver;


import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import org.ndb.utility.BooleanStuff;



public class Square {
	public boolean[] positions;
	public Square parent;
	public int depth = -1;
	
	int vj;
	int vd;
	
	int row_length;
	
	public Square(boolean[] pos, Square parent){
		positions = pos;
		
		this.parent = parent;
		if(parent == null)
			depth = 0;
		else
			depth = parent.depth + 1;
		
//		I am expecting a square nothing else
		vj = (int)Math.sqrt(positions.length);
		vd = vj*2;
		
		row_length = vj;
	}
	
	
	public void print(Writer out){
		int count = 0;
		PrintWriter pw = new PrintWriter(out);
		for(int i = 0; i < positions.length; ++i){
			char c = BooleanStuff.zeroOrOne(positions[i]);
			pw.print(c + " ");
			
			++count;
			if(count == vj){
				pw.println();
				count = 0;
			}
		}
	}
	
	//private ArrayList squares = new ArrayList();
	public ArrayList movePositions(){
		ArrayList squares = new ArrayList();
		squares.clear();
		int dest = -1, jumped = -1;
		if(depth < (positions.length - 1)){
			for(int i = 0; i < positions.length; ++i){
				
				if(positions[i] == true){ // short circuit it, make sure there is a peg before attempting to move it
					dest = i + vd;
					jumped = i + vj;
					
					move(squares, dest, jumped, i, false);
					
					
					dest = i - vd;
					jumped = i - vj;
					
					move(squares, dest, jumped, i, false);
					
					dest = i + 2;
					jumped = i + 1;
					
					move(squares, dest, jumped, i, true);
					
					dest = i - 2;
					jumped = i - 1;
					
					move(squares, dest, jumped, i, true);
				}
				
			}
		}
		
		return squares;
	}
	
	
	/**
	 * @param squares
	 * @param dest
	 * @param jumped
	 * @param mover
	 */
	private void move(ArrayList squares, int dest, int jumped, int mover, boolean horizontal) {
		if(dest >= 0 && dest < positions.length){
			
			// find the row this index is on
			int row = mover / row_length;
			
			int max_index = (row+1)*row_length - 1;
			if(dest > max_index && horizontal) return;
			
			int min_index = row*row_length;
			if(dest < min_index && horizontal) return;
			
			if (positions[dest] == false && positions[jumped] == true)
			{
				boolean[] bools = copy();
				
				bools[dest] = true;
				bools[mover] = false;
				bools[jumped] = false;
				squares.add(new Square(bools, this));
			}
			
		}
	}
	
	boolean[] copy(){
		boolean[] bools = new boolean[positions.length];
		System.arraycopy(positions,0,bools,0,bools.length);
		return bools;
	}
	
	public boolean isSolved()
	{
		int count = 0;
		for(int i = 0; i < positions.length; ++i)
		{
			if(positions[i] == true)
			{
				if(count >= 1)
					return false;
				
				++count;
			}
		}
		
		if(count > 1)
			return false;
		
		return true;
	}
	
	public boolean equals(Object obj){
		if(this == obj) return true;
		
		if(!(obj instanceof Square)) return false;
		
		Square s = (Square)obj;
		
		for(int i = 0; i < positions.length; ++i){
			if(positions[i] != s.positions[i])
				return false;
		}
		
		return true;
	}
	
	public int hashCode() {
		int h = 47;
		for(int i = 0; i < positions.length; ++i){
			h += i * (positions[i]?1:0) + i;
		}
		
		return super.hashCode() * h;
	}
}
