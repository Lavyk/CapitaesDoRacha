/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Lavyk
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
            jogadores.add(arrayJogadores.get(i).getNome());
            cont--;
        }
        return jogadores;
    }

    
    public void zeroOuUm(){
    	ArrayList<String> jogadores = getJogadores();
    	String nomeJogador;
    	System.out.println("Zero ou Um iniciado!\n");
    	
        if(numJogadores > 3){
        	for(int i = 0; i <= 2; i++){
        		nomeJogador = jogadores.get(i).toString();
		    	Scanner sc = new Scanner(System.in);
		    	System.out.print(nomeJogador + " escolhe: ");
		    	int numJogador = Integer.valueOf(sc.next());
            	if(numJogador >= 1){
            		arrayJogadores.get(i).setZeroOuUm(1);
            		System.out.println(nomeJogador + " escolheu 1.");
               	} else if(numJogador <= 0){
            		arrayJogadores.get(i).setZeroOuUm(0);
            		System.out.println(nomeJogador + " escolheu 0.");
            	}      		
        	}
        	
        	verificarGanhador();
        } else {
            System.out.println("Numero de jogadores insuficiente.");
        }
        
    }
    
    public int verificarGanhador(){
    	int numJogador1, numJogador2, numJogador3;
    	int[] num = new int[3];
    	for(int i = 0; i < 2; i++){
    		num[i] = arrayJogadores.get(i).getZeroOuUm();
    	}
    	System.out.println(num[0]);
    	System.out.println(num[1]);
    	System.out.println(num[2]);
    	return 0;
    }
}