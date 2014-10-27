/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Calendarizador;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class PlanificacionDeProcesos {
    public ArrayList<Proceso> fifo(ArrayList<Proceso> processList){
        processList.get(0).setFinishTime(processList.get(0).getArrivalTime() + processList.get(0).getBurstTime());
        int p = processList.get(0).getFinishTime();
        int i = 1;
        int idle = 0;
        while (i < processList.size()) {
            if (processList.get(i).getArrivalTime() <= p){
                processList.get(i).setFinishTime(processList.get(i).getBurstTime() + processList.get(i-1).getFinishTime() + idle);
                idle = 0;
                p = processList.get(i).getFinishTime();
                i++;
            }
            else{
                idle++;
                p++;
            }
        }
        ArrayList<Proceso> completeProcessList = calculateTotalAndWait(processList);
        return completeProcessList;
    }
    
    public ArrayList<Proceso> shortJobFirst(ArrayList<Proceso> processList) {
        int i, Tt = 0, temp, j;
        int B[] = new int[10];
        char S[] = new char[10];
        float temp1, t;
        Twt = 0;
        w = 0;
        for (i = 1; i <= n; i++) {
            B[i] = Bu[i];
            S[i] = 'T';
            Tt = Tt + B[i];
            A[i] = Integer.parseInt(JOptionPane.showInputDialog("Enter The Arrival Time for Process p" + i + ""));
        }

        for (i = n; i >= 1; i--) {
            for (j = 3; j <= n; j++) {
                if (B[j - 1] > B[j]) {
                    temp = B[j - 1];
                    temp1 = A[j - 1];
                    B[j - 1] = B[j];
                    A[j - 1] = A[j];
                    B[j] = temp;
                    A[j] = temp1;
                }
            }
        }
//For the 1st process
        Wt[1] = 0;
        w = w + B[1];
        t = w;
        S[1] = 'F';

        while (w < Tt) {
            i = 2;
            while (i <= n) {
                if (S[i] == 'T' && A[i] <= t) {
                    Wt[i] = w;
                    S[i] = 'F';
                    w = w + B[i];
                    t = w;
                    i = 2;
                } else {
                    i++;
                }
            }
        }

        for (i = 1; i <= n; i++) {
            for (i = 1; i <= n; i++) {
                Twt = Twt + (Wt[i] - A[i]);
            }
        }
        Awt = Twt / n;
        System.out.println("Total Waiting Time:" + Twt);
        System.out.println("Average Waiting Time:" + Awt);

        ArrayList<Proceso> completeProcessList = calculateTotalAndWait(processList);
        return completeProcessList;
    }
    
    public ArrayList<Proceso> roundRobin(ArrayList<Proceso> processList){
        int su = 0;int s = 1;int u = 0;
        int c = 0;
        int x = 0;int y = 0;int b = 0;int a = 0;
        c = processList.get(0).getArrivalTime();
        int[] cpu2 = new int[processList.size() + 1];
        for (int k = 0; k < processList.size(); k++) {
            cpu2[k] = processList.get(k).getBurstTime();
        }
        while (s <= processList.size()) {
            for (int j = 0; j < processList.size(); j++) {
                if (cpu2[j] != 0){
                    c++;
                    cpu2[j] -= 1;
                    if (cpu2[j] == 0){
                        processList.get(j).setFinishTime(c);
                        s++;
                        if (processList.get(j+1).getArrivalTime() > c){
                            a = j;
                            su = 1;
                            u = processList.get(j+1).getArrivalTime();
                        }
                    }
                    if (processList.get(j+1).getArrivalTime() > c){
                        x = 0;
                        for (int i = 0; i < a; i++) {
                            if (cpu2[i] != 0){
                                x++;
                                b = i;
                            }
                        }
                        if (x != 1) {
                            break;
                        }
                        c += cpu2[b];
                        processList.get(b).setFinishTime(c);
                        cpu2[b] = 0;
                        x = 0;
                        s++;
                        break;
                    }
                }
                else if (su == 1){
                    c += u - c;
                    su = 0;
                    x = a = 0;
                }
            }
        }
        ArrayList<Proceso> completeProcessList = calculateTotalAndWait(processList);
        return completeProcessList;
    }
    
    public ArrayList<Proceso> calculateTotalAndWait(ArrayList<Proceso> processList){
        for (int i = 0; i < processList.size(); i++){
            processList.get(i).setTotalTime(processList.get(i).getFinishTime() - processList.get(i).getArrivalTime());
            processList.get(i).setWaitTime(processList.get(i).getTotalTime() - processList.get(i).getBurstTime());
            System.out.println(processList.get(i).getTotalTime());
        }
        return processList;
    }
}
