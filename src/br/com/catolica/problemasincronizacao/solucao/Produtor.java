/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.problemasincronizacao.solucao;

/**
 *
 * @author FC20120897
 */
public class Produtor extends Thread {

    private final Repositorio repositorio;

    public Produtor(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            repositorio.put(i);
            System.out.println("Produtor #"+getId()+" armazenou: " + i);
            try {
                sleep((int) (Math.random() * 100));
            } catch (InterruptedException e) {
            }
        }
    }
}
