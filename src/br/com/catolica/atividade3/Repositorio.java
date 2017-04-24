/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.atividade3;

import java.util.Random;

/**
 *
 * @author FC20120897
 */
public class Repositorio {

    private int[] vetor1;
    private int[] vetor2;
    private int[] vetor3;
    private int quant;
    private boolean gerouVetores = false;
    private boolean resultadoDisponivel = false;

    public synchronized void geraVetores() {
        while (gerouVetores == true) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        quant = new Random().nextInt(10);
        vetor1 = new int[quant];
        vetor2 = new int[quant];
        gerouVetores = true;
        for (int i = 0; i < quant; i++) {
            vetor1[i] = new Random().nextInt(10);
            vetor2[i] = new Random().nextInt(10);
        }
        System.out.println("Vetor1: ");
        for (int i = 0; i < quant; i++) {
            System.out.print("[" + vetor1[i] + "] ");
        }

        System.out.println("\nVetor2: ");
        for (int i = 0; i < quant; i++) {
            System.out.print("[" + vetor2[i] + "] ");
        }
        notifyAll();
    }

    public synchronized void somaVetores() {
        while (gerouVetores == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        vetor3 = new int[quant];
        for (int i = 0; i < quant; i++) {
            vetor3[i] = vetor1[i] + vetor2[i];
        }
        gerouVetores = true;
        resultadoDisponivel = true;
        notifyAll();
    }

    public synchronized void imprimeResultado() {
        while (resultadoDisponivel == false) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("\nImprimindo Resultado:");
        for (int i = 0; i < quant; i++) {
            System.out.print("[" + vetor3[i] + "] ");
        }
        System.out.println("");
    }
}
