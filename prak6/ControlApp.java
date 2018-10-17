/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prak6;

/**
 *
 * @author NuH
 */
public class ControlApp {

    public static void main(String args[]) {

        Controll R1 = new Controll("Thread-1");
        R1.start();



        try {
            Thread.sleep(1000);
            R1.suspend();
            System.out.println("Suspending First Thread");
            Thread.sleep(1000);
            R1.resume();
            System.out.println("Resuming First Thread");

        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        try {
            System.out.println("Waiting for threads to finish.");
            R1.t.join();

        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        Control1 R2 = new Control1("Thread-2");
        R2.start();

        try {
            R2.suspend();
            System.out.println("Suspending thread Two");
            Thread.sleep(1000);
            R2.resume();
            System.out.println("Resuming thread Two");
            System.out.println("Main thread exiting.");
            R2.t.join();
        } catch (InterruptedException interruptedException) {
        }
    }
}