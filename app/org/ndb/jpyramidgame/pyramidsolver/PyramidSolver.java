/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame.pyramidsolver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.ndb.utility.CollectionsStuff;

public class PyramidSolver {
	LinkedList<IPyramid> ar = new LinkedList<IPyramid>();
	Collection<Integer> allReadySeenList = new HashSet<Integer>();
	public PyramidSolver(IPyramid start)
	{
		ar.add(start);
	}

	protected IPyramid solveInternal()
	{
		long pyramidsExamined = 0;
		long branchesPruned = 0; 
		IPyramid temp = null;
		Collection<Integer> hashes = new ArrayList<Integer>(4);
		while(ar.size() > 0)
		{
			IPyramid z = ar.removeFirst();
			++pyramidsExamined;
            if (z.isSolved())
            {
            	System.out.println("Pyramids examined: " + pyramidsExamined + ", Branches Pruned: " + branchesPruned);
                return z;
            }
            
            Collection<IPyramid> children = z.getChildren();
			
			// don't insert into the working list if it has all ready been seen.
			for(IPyramid pyramid : children){
				hashes.clear();
				int hashCode = pyramid.hashCode();
				hashes.add(hashCode);
				hashes.add(pyramid.getYReflection().hashCode());
				hashes.add(pyramid.getYXReflection().hashCode());
				hashes.add(pyramid.getXYReflection().hashCode());
				
				if(!CollectionsStuff.containsAny(allReadySeenList, hashes)){
					// ok, we haven't seen the original or its reflections,
					// store it
					ar.addFirst(pyramid);
					allReadySeenList.addAll(hashes);
				}else{
					++branchesPruned;
				}
			}
			
			temp = z;
		}
		System.out.println("Pyramids examined: " + pyramidsExamined);
		return temp;
	}
	
	public List<IPyramid> solve(){
		IPyramid p = solveInternal();
		if (p != null && p.isSolved()) {
			List<IPyramid> pyramids = new LinkedList<IPyramid>();
			while (null != p) {
				pyramids.add(0, p);
				p = p.getParent();
			}
			return pyramids;
		}
		return Collections.emptyList();
	}
}
