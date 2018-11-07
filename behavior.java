/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NuH
 */
import jade.core.Agent;

public class behavior extends Agent{

        int timer=10;
       

        public void setup(){
            addBehaviour(new timer(this, timer));
        }


}
