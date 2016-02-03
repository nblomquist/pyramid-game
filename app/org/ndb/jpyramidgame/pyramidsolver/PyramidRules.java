package org.ndb.jpyramidgame.pyramidsolver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PyramidRules<E> {

	Map<Integer, Map<Integer, E>> map = null;

	public PyramidRules(List<E> cboxes) {
		buildMap(cboxes);
	}

	private void buildMap(List<E> cboxes) {
		map = new HashMap<Integer, Map<Integer, E>>();

		final Map<Integer, E> d0 = new HashMap<Integer, E>();
		d0.put(3, cboxes.get(1));
		d0.put(5, cboxes.get(2));
		map.put(0, d0);

		final Map<Integer, E> d1 = new HashMap<Integer, E>();
		d1.put(6, cboxes.get(3));
		d1.put(8, cboxes.get(4));
		map.put(1, d1);

		final Map<Integer, E> d2 = new HashMap<Integer, E>();
		d2.put(9, cboxes.get(5));
		d2.put(7, cboxes.get(4));
		map.put(2, d2);

		final Map<Integer, E> d3 = new HashMap<Integer, E>();
		d3.put(0, cboxes.get(1));
		d3.put(10, cboxes.get(6));
		d3.put(5, cboxes.get(4));
		map.put(3, d3);

		final Map<Integer, E> d4 = new HashMap<Integer, E>();
		d4.put(11, cboxes.get(7));
		d4.put(13, cboxes.get(8));
		map.put(4, d4);

		final Map<Integer, E> d5 = new HashMap<Integer, E>();
		d5.put(3, cboxes.get(4));
		d5.put(0, cboxes.get(2));
		d5.put(14, cboxes.get(9));
		map.put(5, d5);

		final Map<Integer, E> d6 = new HashMap<Integer, E>();
		d6.put(1, cboxes.get(3));
		d6.put(8, cboxes.get(7));
		map.put(6, d6);

		final Map<Integer, E> d7 = new HashMap<Integer, E>();
		d7.put(2, cboxes.get(4));
		d7.put(9, cboxes.get(8));
		map.put(7, d7);

		final Map<Integer, E> d8 = new HashMap<Integer, E>();
		d8.put(1, cboxes.get(4));
		d8.put(6, cboxes.get(7));
		map.put(8, d8);

		final Map<Integer, E> d9 = new HashMap<Integer, E>();
		d9.put(2, cboxes.get(5));
		d9.put(7, cboxes.get(8));
		map.put(9, d9);

		final Map<Integer, E> d10 = new HashMap<Integer, E>();
		d10.put(12, cboxes.get(11));
		d10.put(3, cboxes.get(6));
		map.put(10, d10);

		final Map<Integer, E> d11 = new HashMap<Integer, E>();
		d11.put(13, cboxes.get(12));
		d11.put(4, cboxes.get(7));
		map.put(11, d11);

		final Map<Integer, E> d12 = new HashMap<Integer, E>();
		d12.put(10, cboxes.get(11));
		d12.put(5, cboxes.get(8));
		d12.put(14, cboxes.get(13));
		d12.put(3, cboxes.get(7));

		map.put(12, d12);

		final Map<Integer, E> d13 = new HashMap<Integer, E>();
		d13.put(11, cboxes.get(12));
		d13.put(4, cboxes.get(8));
		map.put(13, d13);

		final Map<Integer, E> d14 = new HashMap<Integer, E>();
		d14.put(5, cboxes.get(9));
		d14.put(12, cboxes.get(13));
		map.put(14, d14);
	}

	public E getJumped(int movingIndex, int destIndex) {

		Map<Integer, E> d = map.get(movingIndex);

		if (d == null)
			return null;

		E c = d.get(destIndex);

		if (c == null)
			return null;

		return c;
	}
}
