/*
 * Created on Jun 24, 2006
 *
 */
package org.ndb.jpyramidgame.pyramidsolver;

import java.util.List;

import junit.framework.TestCase;

public class PyramidTestCase extends TestCase {
	
	public void testIsSolvedTrue(){
		boolean[] bools = new boolean[15];
		bools[0] = true;
		
		IPyramid p = new BooleanPyramid(bools,null);
		
		assertTrue(p.isSolved());		
	}
	
	public void testIsSolvedFalse(){
		boolean[] bools = new boolean[15];
		bools[0] = true;
		bools[14]=true; // this test will fail
		
		IPyramid p = new BooleanPyramid(bools,null);
		assertFalse(p.isSolved());
	}
	
	public void testSolvingDefaultPyramid(){
		boolean[] bools = {false,true,true,true,true,true,true,true,true,true,true,true,true,true,true};
		
		IPyramid p = new Int32Pyramid(bools, null);
		
		PyramidSolver solver = new PyramidSolver(p);
		List<IPyramid> pyramids = solver.solve();
		
		assertNotNull(pyramids);
		assertFalse(pyramids.isEmpty());
		assertTrue(pyramids.get(pyramids.size()-1).isSolved());
	}
	
	public void testSolvingPyramid(){
		boolean[] bools = {false,true,true,true,true,false,true,true,true,true,true,true,false,true,true};
		
		IPyramid p = new BooleanPyramid(bools, null);
		
		PyramidSolver solver = new PyramidSolver(p);
		List<IPyramid> pyramids = solver.solve();
		
		assertNotNull(pyramids);
		assertFalse(pyramids.isEmpty());
		assertTrue(pyramids.get(pyramids.size()-1).isSolved());
	}
}
