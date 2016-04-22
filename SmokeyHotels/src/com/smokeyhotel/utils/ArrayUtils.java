package com.smokeyhotel.utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.smokeyhotel.people.guest.Guest;


public class ArrayUtils {
	
	public static Object[] removeElements(Object[] input, Object deleteMe) {
	    List result = new LinkedList();

	    for(Object item : input)
	        if(!item.equals(deleteMe))
	            result.add(item);

	    return result.toArray(input);
	}
	
	public static Guest[] removeNullGuest(Guest[] a) {
		   ArrayList<Guest> removed = new ArrayList<Guest>();
		   for (Guest str : a)
		      if (str != null)
		         removed.add(str);
		   return removed.toArray(new Guest[removed.size()]);
	}
	
}
