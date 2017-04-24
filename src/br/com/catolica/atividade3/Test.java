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
public class Test {

    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Gerador gerador = new Gerador(repositorio);
        Somador somador = new Somador(repositorio);
        Impressor impressor = new Impressor(repositorio);

        gerador.start();
        somador.start();
        impressor.start();
    }
}
