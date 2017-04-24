package br.com.catolica.problemasincronizacao.solucao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FC20120897
 */
public class Test {
    public static void main(String[] args) {
        Repositorio repositorio = new Repositorio();
        Produtor p1 = new Produtor(repositorio);
        Consumidor c1 = new Consumidor(repositorio);
        
        p1.start();
        c1.start();
    }
}
