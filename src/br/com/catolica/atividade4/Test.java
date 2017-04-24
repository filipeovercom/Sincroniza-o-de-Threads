/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.catolica.atividade4;

/**
 *
 * @author FC20120897
 */
public class Test {

    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        GeradorPrimeiraMetade g1 = new GeradorPrimeiraMetade(repositorio);
        GeradorSegundaMetade g2 = new GeradorSegundaMetade(repositorio);
        Impressor impressor = new Impressor(repositorio);
        
        impressor.start();
        g2.start();
        g1.start();
    }
}
