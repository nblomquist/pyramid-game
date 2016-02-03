/*
 * Created on Nov 4, 2005
 *
 */
package org.ndb.jsquaregame.squaresolver;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SquareSolver {

	public static void main(String[] args) {
		boolean[] bools = new boolean[25];
		for (int i = 0; i < bools.length; ++i) {
			if (i == 2) // set this value to whatever position you want empty
				bools[i] = false;
			else
				bools[i] = true;
		}

		Square s = new Square(bools, null);
		// ArrayList ar = s.movePositions();
		// StringWriter sw = new StringWriter();
		// for(int i = 0; i < ar.size(); ++i){
		// ((Square)ar.get(i)).print(sw);
		// sw.write('\n');
		// }

		Square ss = solve(s);
		ArrayList sqList = new ArrayList();

		while (null != ss) {
			sqList.add(ss);
			ss = ss.parent;
		}

		Collections.reverse(sqList);
		StringWriter sw = new StringWriter();
		for (int i = 0; i < sqList.size(); ++i) {
			((Square) sqList.get(i)).print(sw);
			sw.write("\n");
		}

		System.out.println(sw.toString());
	}

	public static Square solve(Square s) {

		List allReadySeenList = new LinkedList();

		Square temp = null;
		LinkedList ar = new LinkedList();
		ar.add(s);
		
		long count =0;

		while (ar.size() > 0) {
			++count;
			
			Square z = ((Square) ar.removeFirst());
			if (z.isSolved()) {
				System.out.println("# of Squares examined: " + count);
				return z;
			}

			ArrayList tmpList = z.movePositions();
			for (int i = 0; i < tmpList.size(); ++i) {
				Object object = tmpList.get(i);
				if(!allReadySeenList.contains(object)){
					ar.addFirst(object);
					allReadySeenList.add(object);
				}
			}
			temp = z;

		}
		System.out.println("# of Squares examined: " + count);
		return temp;
	}
}
