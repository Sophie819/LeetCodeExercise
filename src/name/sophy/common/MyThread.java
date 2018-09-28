package name.sophy.common;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * public class MyRunnable implements Runnable {
	    public void run() {
	        // ...
	    }
	}
	public static void main(String[] args) {
	    MyRunnable instance = new MyRunnable();
	    Thread thread = new Thread(instance);
	    thread.start();
	}
 */

/*
 * public class MyThread extends Thread {
	    public void run() {
	        // ...
	    }
	}
	public static void main(String[] args) {
	    MyThread mt = new MyThread();
	    mt.start();
	}
 */
class RunnableDemo implements Runnable {
	   private Thread t;
	   private String threadName;
	   
	   RunnableDemo( String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // 让线程睡眠一会
	            Thread.sleep(50);
	         }
	      }catch (InterruptedException e) {
	         System.out.println("Thread " +  threadName + " interrupted.");
	      }
	      System.out.println("Thread " +  threadName + " exiting.");
	   }
	   
	   public void start () {
	      System.out.println("Starting " +  threadName );
	      if (t == null) {
	         t = new Thread (this, threadName);
	         t.start ();
	      }
	   }
	}
	 
	public class MyThread {
	 
	   public static void main(String args[]) {ExecutorService eService = Executors.newFixedThreadPool(10);
	      RunnableDemo R1 = new RunnableDemo( "Thread-1");
	      R1.start();
	      
	      RunnableDemo R2 = new RunnableDemo( "Thread-2");
	      R2.start();
	   }   
	}