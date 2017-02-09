/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavyk;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class Racha{
    private int numJogadores = 0;
    //private ArrayList<String> jogadores = new ArrayList<String> ();
    private ArrayList<Jogador> arrayJogadores = new ArrayList<Jogador>();
    
    //Jogador[] objJogadores = new Jogador[numJogadores];
    
    public void addJogador(String nome, int numero){
        numJogadores ++;
        //objJogadores[numJogadores] = new Jogador(nome, numero);
        //jogadores.add(nome);
        
        if(numJogadores <= 3){
            arrayJogadores.add(new Jogador(nome, numero, true));
        } else {
            arrayJogadores.add(new Jogador(nome, numero, false));
        }
        
      
        
        
    }
    
    public int getNumJogadores(){
        return numJogadores;
    }
    
    public ArrayList<String> getJogadores(){
        ArrayList<String> jogadores = new ArrayList<String> ();
        int cont = numJogadores;
        for(int i = 0; arrayJogadores.size() > i; i++){
            jogadores.add(arrayJogadores.get(i).isCapitao()+"");
            cont--;
        }
        return jogadores;
    }
    
    public void zeroOuUm(){
        if(numJogadores < 3){
            System.out.println("Numero de jogadores insuficiente.");
        } else {
            
        }
    }
}
