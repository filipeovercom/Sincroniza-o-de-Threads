/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.atividade2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author FC20120897
 */
public class Atividade2 extends Thread {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        System.out.print("Informe a quantidade de threads que deseja criar: ");
        Integer quant = ler.nextInt();
        Thread[] threads = new Thread[quant];
        for (int i = 0; i < quant; i++) {
            threads[i] = new Atividade2();
        }

        System.out.println("Threads criadas: ");
        for (int i = 0; i < quant; i++) {
            System.out.println("Thread #" + threads[i].getId());
        }
        
        System.out.println("\nExecutando as Threads de forma Assíncrona!");
        System.out.println("==================================================================");
        for (int i = 0; i < quant; i++) {
            threads[i].start();
        }
    }

    @Override
    public void run() {
        System.out.println("Thread #" + getId() + " | valor: " + new Random().nextInt(50));
    }
}
