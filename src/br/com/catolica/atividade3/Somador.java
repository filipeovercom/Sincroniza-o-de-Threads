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
public class Somador extends Thread{

    private final Repositorio repositorio;

    public Somador(Repositorio repositorio) {
        this.repositorio = repositorio;
    }
    
    @Override
    public void run() {
        repositorio.somaVetores();
    }
}
