package JavaConcurrency.ch5;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

/*
 * No iterator is thread-safe. If the underlying collection is changed middle of iteration, a ConcurrentModificationException is thrown.
Even iterators of synchronized collections are not thread-safe like Vector is also not- you have to synchronize manually.
One exception is the CopyOnWriteArrayList, which holds a snapshot during iteration.So if the underlying collection is modified then
it will not throw CME.
 */
public class CopyOnWriteArrayListTest {
	
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		list.add("suman");
		list.add("Ban");
		
		ListIterator<String> itr = list.listIterator();
		while(itr.hasNext())
		{
			String res = itr.next();
			System.out.println("elememt from list " + res);
			//list.add("CMECaused"); // CME will come when we use iterator and ListIterator both , can be resolved by CopyOnWriteArrayList.
			
		}
		
		ListIterator<String> newitr = list.listIterator();
		while(newitr.hasNext())
		{
			String res = newitr.next();
			System.out.println("after changing list " + res);			
		}
		
		List<String> copyOnWriteArrList = new CopyOnWriteArrayList<String>();
		copyOnWriteArrList.add("sban");
		copyOnWriteArrList.add("ban");
		
		Iterator<String> myitr = copyOnWriteArrList.iterator();
		while(myitr.hasNext())
			{
				String res = myitr.next();
				System.out.println("Before adding element in copyOnwriteArrList " + res );
				copyOnWriteArrList.add("newElemt"); // this will not change the current copyOnWriteArrList it will add into the new snapshot
			}
		Iterator<String> myNewitr = copyOnWriteArrList.iterator();
		while(myNewitr.hasNext())
		{
			String res = myNewitr.next();
			System.out.println("After adding element in copyOnwriteArrList " + res );			
		}
	}

}
