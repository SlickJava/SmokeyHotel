package com.smokeyhotel.utils;

import java.util.LinkedList;
import java.util.List;

public class ArrayUtils {
	
	public static Object[] removeElements(Object[] input, Object deleteMe) {
	    List result = new LinkedList();

	    for(Object item : input)
	        if(!deleteMe.equals(item))
	            result.add(item);

	    return result.toArray(input);
	}
	
}
