/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.atividade4;

import java.util.Random;

/**
 *
 * @author FC20120897
 */
public class Repositorio {

    private final int[] vetor = new int[20];
    private boolean gerouPrimeiraMetade = false;
    private boolean gerouSegundaMetade = false;

    public synchronized void geraPrimeiraMetade() {
        while (gerouPrimeiraMetade == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        for (int i = 0; i < 10; i++) {
            vetor[i] = new Random().nextInt(100);
        }
        gerouPrimeiraMetade = true;
        gerouSegundaMetade = false;
        System.out.println("\nPrimeira Metade do array:");
        for (int i = 0; i < 10; i++) {
            System.out.print("[" + vetor[i] + "] ");
        }
        System.out.println("");
        notifyAll();
    }
    
    public synchronized void geraSegundaMetade() {
         while (gerouPrimeiraMetade == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        for (int i = 10; i < 20; i++) {
            vetor[i] = new Random().nextInt(100);
        }
        gerouSegundaMetade = true;
        gerouPrimeiraMetade = true;
        System.out.println("\nSegunda Metade do array:");
        for (int i = 10; i < 20; i++) {
            System.out.print("[" + vetor[i] + "] ");
        }
        notifyAll();
    }

    public synchronized void exibeValores() {
        while (gerouSegundaMetade == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("\nImprimindo Resultado:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("[" + vetor[i] + "] ");
        }
        System.out.println("");
    }
}
