/*
 * Created on Oct 30, 2005
 *
 */
package org.ndb.jpyramidgame.pyramidsolver;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.google.common.primitives.Ints;

public class PyramidSolver {
	LinkedList<IPyramid> pyramids = new LinkedList<>();
	Collection<Integer> alreadySeen = new HashSet<>();
	public PyramidSolver(IPyramid start)
	{
		pyramids.add(start);
	}

	protected IPyramid solveInternal()
	{
		long pyramidsExamined = 0;
		long branchesPruned = 0; 
		IPyramid temp = null;
		while(pyramids.size() > 0)
		{
			IPyramid z = pyramids.removeFirst();
			++pyramidsExamined;
            if (z.isSolved())
            {
            	System.out.println("Pyramids examined: " + pyramidsExamined + ", Branches Pruned: " + branchesPruned);
                return z;
            }
            
            Collection<IPyramid> children = z.getChildren();
			
			// don't insert into the working list if it has all ready been seen.
			branchesPruned += children.stream().mapToInt(pyramid->{

                Collection<Integer> hashes = Ints.asList(
                        pyramid.hashCode(),
                        pyramid.getYReflection().hashCode(),
                        pyramid.getYXReflection().hashCode(),
                        pyramid.getXYReflection().hashCode()
                );

				if(!alreadySeen.stream().anyMatch(hashes::contains)){
					// ok, we haven't seen the original or its reflections,
					// store it
					pyramids.addFirst(pyramid);
					alreadySeen.addAll(hashes);
				}else{
					return 1;
				}
				return 0;
			}).sum();
			
			temp = z;
		}
		System.out.println("Pyramids examined: " + pyramidsExamined);
		return temp;
	}
	
	public List<IPyramid> solve(){
		IPyramid p = solveInternal();
		if (p != null && p.isSolved()) {
			List<IPyramid> pyramids = new LinkedList<>();
			while (null != p) {
				pyramids.add(0, p);
				p = p.getParent();
			}
			return pyramids;
		}
		return Collections.emptyList();
	}
}
