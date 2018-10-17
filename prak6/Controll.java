/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package prak6;
class Controll implements Runnable {
   public Thread t;
   private String threadName;
   boolean suspended = false;

   Controll( String name) {
      threadName = name;
      System.out.println("Creating " +  threadName );
   }

   public void run() {
      System.out.println("Running " +  threadName );
      try {
         for(int i = 15; i > 0; i--) {
             if(i%2!=0){
            System.out.print(i+" ");
            // Let the thread sleep for a while.
             }
            Thread.sleep(1000);
            synchronized(this) {
               while(suspended) {
                  wait();
               }
            }
         }
      } catch (InterruptedException e) {
         System.out.println("Thread " +  threadName + " interrupted.");
      }
      System.out.println("Thread " +  threadName + " exiting.");
   }

   public void start () {
      System.out.println("Starting " +  threadName );
     
         t = new Thread (this, threadName);
         t.start ();
     
   }

   void suspend() {
      suspended = true;
   }

   synchronized void resume() {
      suspended = false;
      notify();
   }
}

