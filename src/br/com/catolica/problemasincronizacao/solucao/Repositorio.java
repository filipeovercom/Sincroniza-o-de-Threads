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
public class Repositorio {

    private Integer conteudo;
    private boolean disponivel = false;

    public synchronized Integer get() {
        while (disponivel == false) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        disponivel = false;
        notifyAll();
        return conteudo;
    }

    public synchronized void put(Integer conteudo) {
        while (disponivel == true) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        this.conteudo = conteudo;
        disponivel = true;
        notifyAll();
    }
}
