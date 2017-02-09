/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavyk;

/**
 *
 * @author usuario
 */
public class Jogador{
    private String nome;
    private int numero;
    private boolean capitao;
    
    Jogador(String nome, int numero, boolean capitao){
        this.nome = nome;
        this.numero = numero;
        this.capitao = capitao;
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
