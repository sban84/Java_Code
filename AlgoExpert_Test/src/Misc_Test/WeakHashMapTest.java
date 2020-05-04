package Misc_Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/*
 * allows value object to be Garbage collected if the corresponding key object is longer used. This is not the case in hashMap as we need to call remove() on hashmap to remove the value Object.
 */
public class WeakHashMapTest {
	
	public static void main(String args[])
	{
		Map hashMap= new HashMap();
	    Map weakHashMap = new WeakHashMap();

	    String keyHashMap = new String("keyHashMap");
	    String keyWeakHashMap = new String("keyWeakHashMap");

	    hashMap.put(keyHashMap, "helloHash");
	    weakHashMap.put(keyWeakHashMap, "helloWeakHash");
	    System.out.println("Before: hash map value:"+hashMap.get("keyHashMap")+" and weak hash map value:"+weakHashMap.get("keyWeakHashMap"));

	    keyHashMap = null;
	    keyWeakHashMap = null;

	    System.gc();  

	    System.out.println("After: hash map value:"+hashMap.get("keyHashMap") + " and hashMap.size" + hashMap.size() + " and weak hash map value:"+weakHashMap.get("keyWeakHashMap") + " and weakHashMap.size " + weakHashMap.size() );
	}

}
