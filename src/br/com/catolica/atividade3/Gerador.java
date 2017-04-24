/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.atividade3;

/**
 *
 * @author FC20120897
 */
public class Gerador extends Thread {

    private final Repositorio repositorio;

    public Gerador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public void run() {
        repositorio.geraVetores();
        try {
            sleep((int) (Math.random() * 100));
        } catch (InterruptedException ex) {
        }
    }
}
