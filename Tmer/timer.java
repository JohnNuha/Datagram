/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NuH
 */
import jade.core.Agent;
import jade.core.behaviours.TickerBehaviour;

public class timer extends TickerBehaviour {

    int timer;

    public timer(Agent a, int timer) {
        super(a, 1000);
        this.timer = timer;
    }

    @Override
    protected void onTick() {
        if (timer == 0) {
            System.out.println(timer);
            timer--;
        } else {
            System.out.println("Waktu Habis");
            myAgent.doDelete();
        }
    }
}