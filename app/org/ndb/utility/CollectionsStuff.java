package org.ndb.utility;

import java.util.Collection;

public class CollectionsStuff {
	public final static <T> boolean containsAny(Collection<? extends T> c, Collection<? extends T> toFind){
		
		for(T t : toFind){
			if(c.contains(t)){
				return true;
			}
		}
		
		return false;
	}
}
