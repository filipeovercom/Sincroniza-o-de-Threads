/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica;

/**
 *
 * @author FC20120897
 */
public class ThreadEx1 extends Thread {

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadEx1());
        Thread t2 = new Thread(new ThreadEx1());
        Thread t3 = new Thread(new ThreadEx1());
        
        t1.start();
        t2.start();
        t3.start();
    }

    @Override
    public void run() {
        System.out.println("Rodando a thread " + getId() + "!");
        System.out.println("Parando a thread " + getId() + "!");
        System.exit(0);
    }
}
