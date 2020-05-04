package Threading;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void main(String args[])
	{
		Thread[] th_arr = new Thread[3];
		CyclicBarrier barrier = new CyclicBarrier(3);
		for(int i=0;i<3;i++)
		{
			Thread t = new Thread(new Parties(barrier));
			th_arr[i] = t;
			th_arr[i].start();
		}
		System.out.println("Main Thread ends");
		
	}
}

//task class
class Parties implements Runnable
{
	CyclicBarrier barrier = null;
	Parties(CyclicBarrier barrier)
	{
		this.barrier = barrier;
	}
	public void run()
	{
		System.out.println("entered into the run method "+Thread.currentThread().getName());
		try{
			// no thread will start executing task untill all ( i.e. 3 child thread here ) come .
			barrier.await();
			//do the job basically... anything the child thread supposed to do etc.			
			System.out.println("has crossed the barrier " + Thread.currentThread().getName());
			System.out.println("all child thread reached so executing the task");
		}
		
		catch(InterruptedException e)
		{
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}