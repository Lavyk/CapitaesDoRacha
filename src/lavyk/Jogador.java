/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

/**
 *
 * @author Lavyk
 */
public class Jogador{
    private String nome;
    private int numero;
    private boolean capitao;
    private int zeroOuUm;
    
    Jogador(String nome, int numero, boolean capitao){
        this.nome = nome;
        this.numero = numero;
        this.capitao = capitao;
    }
    
    public int getZeroOuUm() {
        return zeroOuUm;
    }

    public void setZeroOuUm(int zeroOuUm) {
        this.zeroOuUm = zeroOuUm;
    }
    
    public boolean isCapitao() {
        return capitao;
    }

    public void setCapitao(boolean capitao) {
        this.capitao = capitao;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
        
    }
       
}