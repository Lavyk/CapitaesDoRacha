/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavyk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Lavyk
 */
public class Racha{
    private int numJogadores = 0;
    private int[] ordemEscolha = new int[3];
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

    
    public int zeroOuUm(){
    	ArrayList<String> jogadores = getJogadores();
    	String nomeJogador;
    	System.out.println("Zero ou Um iniciado!\n");
    	int ganhador = -1;
        if(numJogadores > 3){
        	for(int i = 0; i <= 2; i++){
        		nomeJogador = jogadores.get(i).toString();
		    	Scanner sc = new Scanner(System.in);
		    	System.out.print(nomeJogador + " escolhe: ");
		    	int numJogador = Integer.valueOf(sc.next());
            	if(numJogador >= 1){
            		arrayJogadores.get(i).setZeroOuUm(1);
            		//System.out.println(nomeJogador + " escolheu 1.");
               	} else if(numJogador <= 0){
            		arrayJogadores.get(i).setZeroOuUm(0);
            		//System.out.println(nomeJogador + " escolheu 0.");
            	}      		
        	}
        	
        	return ganhador = verificarGanhador();
        } else {
            System.out.println("Numero de jogadores insuficiente.");
        }
        
        
        return ganhador;
    }
    
    public int verificarGanhador(){
        int ganhador = -1;
    	int[] num = new int[3];
    	for(int i = 0; i < 3; i++){
    		num[i] = arrayJogadores.get(i).getZeroOuUm();
    	}
        
        if(num[0] == 1 && num[1] == 1 && num[2] == 1){
            System.out.println("Todos os jogadores colocaram numeros iguais, recomeça o Zero ou Um.");
            zeroOuUm();
        } else if(num[0] == 0 && num[1] == 0 && num[2] == 0){
            System.out.println("Todos os jogadores colocaram numeros iguais, recomeça o Zero ou Um.");
            zeroOuUm();
        } else {
            
            if(num[0] == num[1]){
                ganhador = 2;
            } else if(num[0] == num[2]){
                ganhador = 1;
            } else if(num[1] == num[2]){
                ganhador = 0;
            }   
            System.out.println(arrayJogadores.get(ganhador).getNome() + " ganhou o Zero ou Um.");
        }

        ordemEscolha[0] = ganhador;
    	return ganhador;
    }
    
    public int imparOuPar(int ganhadorZU){
        System.out.println("\n[Jogo Impar ou Par iniciado]");
        Map<Integer, String> lista = new HashMap<Integer,String>();
        lista.put(0, null);
        lista.put(1, null);
        lista.put(2, null);
        
        if(ganhadorZU == -1){
            System.out.println("É necessário que se jogue o Zero ou Um.");
        } else {
            lista.remove(ganhadorZU);
            System.out.println(lista);
            for(int i = 0; i < lista.size(); i++){
                	//Scanner sc = new Scanner(System.in);
		    	//System.out.print(arrayJogadores.get(i).getNome() + " bota: ");
		    	//int numJogador = Integer.valueOf(sc.next());
                        System.out.println("Passou: " + i);
            }
        }
        
        return 0;
    }
}