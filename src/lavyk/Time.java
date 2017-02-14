/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavyk;

import java.util.ArrayList;

/**
 *
 * @author Super i3
 */
public class Time{
    private String nome;
    private String capitao;
    ArrayList<Jogador> jogadoresNoTime = new ArrayList<Jogador>();
    int numTotalDeJogadores = 0;
    String[] jogadores = new String[11];

    public String[] getJogadoresNoTime() {
        try{
            for(int i = 0; i < jogadoresNoTime.size(); i++){
                jogadores[i] = jogadoresNoTime.get(i).getNome();
            } 
        } catch(Exception e){
            System.out.println("A equipe atingiu o numero maximo de jogadores.");
        }
        
        
        return jogadores;
    }

    public void addJogadoresNoTime(Jogador jogador) {
        jogadoresNoTime.add(jogador);
    }
    
    Time(String nome){
        this.nome = nome;
    }
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapitao() {
        return capitao;
    }

    public void setCapitao(String capitao) {
        this.capitao = capitao;
    }    
}
