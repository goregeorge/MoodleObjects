/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendarizador;

/**
 *
 * @author Jorge
 */
public class Proceso {
    private String name;
    private int burstTime;
    private int waitTime;
    
    public Proceso(String name, int burst){
        this.name = name;
        this.burstTime = burst;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the burstTime
     */
    public int getBurstTime() {
        return burstTime;
    }

    /**
     * @param burstTime the burstTime to set
     */
    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    /**
     * @return the waitTime
     */
    public int getWaitTime() {
        return waitTime;
    }

    /**
     * @param waitTime the waitTime to set
     */
    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}
