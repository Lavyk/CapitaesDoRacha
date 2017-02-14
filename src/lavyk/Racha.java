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
public class Racha {

    private int numJogadores = 0;
    private int[] ordemEscolha = new int[3];
    private int intGanhador = -1;
    private String strGanhador = null;
    //private ArrayList<String> jogadores = new ArrayList<String> ();
    private ArrayList<Jogador> arrayJogadores = new ArrayList<Jogador>();
    ArrayList<Time> arrayTimes = new ArrayList<Time>();
    private Map<Integer, String> lista = new HashMap<Integer, String>();
    private String[] arrayParImpar = new String[3];

    //Jogador[] objJogadores = new Jogador[numJogadores];
    Racha() {
        arrayTimes.add(new Time("Time A"));
        arrayTimes.add(new Time("Time B"));
        arrayTimes.add(new Time("Time C"));
    }

    public void addJogador(String nome, int numero) {
        numJogadores++;
        //objJogadores[numJogadores] = new Jogador(nome, numero);
        //jogadores.add(nome);

        if (numJogadores <= 3) {
            arrayJogadores.add(new Jogador(nome, numero, true));
        } else {
            arrayJogadores.add(new Jogador(nome, numero, false));
        }
    }

    public int getNumJogadores() {
        return numJogadores;
    }

    public ArrayList<String> getJogadores() {
        ArrayList<String> jogadores = new ArrayList<String>();
        int cont = numJogadores;
        for (int i = 0; arrayJogadores.size() > i; i++) {
            jogadores.add(arrayJogadores.get(i).getNome());
            cont--;
        }
        return jogadores;
    }

    public String zeroOuUm() {
        ArrayList<String> jogadores = getJogadores();
        String nomeJogador;
        System.out.println("Zero ou Um iniciado!\n");
        if (numJogadores > 3) {
            for (int i = 0; i <= 2; i++) {
                nomeJogador = jogadores.get(i).toString();
                Scanner sc = new Scanner(System.in);
                System.out.print(nomeJogador + " escolhe: ");
                int numJogador = Integer.valueOf(sc.next());
                if (numJogador >= 1) {
                    arrayJogadores.get(i).setZeroOuUm(1);
                    //System.out.println(nomeJogador + " escolheu 1.");
                } else if (numJogador <= 0) {
                    arrayJogadores.get(i).setZeroOuUm(0);
                    //System.out.println(nomeJogador + " escolheu 0.");
                }
            }
            intGanhador = verificarGanhador();
            arrayTimes.get(0).addJogadoresNoTime(arrayJogadores.get(intGanhador));
            strGanhador = arrayJogadores.get(intGanhador).getNome();
            return arrayJogadores.get(intGanhador).getNome();
        } else {
            System.out.println("Numero de jogadores insuficiente.");
        }

        return null;
    }

    public int verificarGanhador() {
        int ganhador = -1;
        int[] num = new int[3];
        for (int i = 0; i < 3; i++) {
            num[i] = arrayJogadores.get(i).getZeroOuUm();
        }

        if (num[0] == 1 && num[1] == 1 && num[2] == 1) {
            System.out.println("Todos os jogadores colocaram numeros iguais, recomeça o Zero ou Um.");
            zeroOuUm();
        } else if (num[0] == 0 && num[1] == 0 && num[2] == 0) {
            System.out.println("Todos os jogadores colocaram numeros iguais, recomeça o Zero ou Um.");
            zeroOuUm();
        } else {

            if (num[0] == num[1]) {
                ganhador = 2;
            } else if (num[0] == num[2]) {
                ganhador = 1;
            } else if (num[1] == num[2]) {
                ganhador = 0;
            }

            String strGanhador = arrayJogadores.get(ganhador).getNome();
            arrayTimes.get(0).setCapitao(strGanhador);
        }

        ordemEscolha[0] = ganhador;
        return ganhador;
    }

    public int imparOuPar() {
        System.out.println("\n[Jogo Impar ou Par iniciado]");
        //Map<Integer, String> lista = new HashMap<Integer, String>();
        lista.put(0, null);
        lista.put(1, null);
        lista.put(2, null);

        
        for (int i = 0; i < arrayParImpar.length; i++) {
            arrayParImpar[i] = arrayJogadores.get(i).getNome();
        }

        arrayParImpar[intGanhador] = null;

        // [ID] [NOME] [PAR/IMPAR] [NUMERO]
        //String[] arrayJogador1 = {null, null, null, null};
        //String[] arrayJogador2 = {null, null, null, null};

        if (strGanhador == null) {
            System.out.println("É necessário que se jogue o Zero ou Um.");
        } else {
            //lista.remove(strGanhador);

            for (int i = 0; i < arrayParImpar.length; i++) {
                if (arrayParImpar[i] != null) {
                    
                    String scan = imparParPerg(i, arrayParImpar);
                    if (scan.equals("par") || scan.equals("impar")) {
                        lista.put(i, scan);
                    } else {
                        System.out.println("O jogador deve escolher entre 'impar' ou 'par'.");
                        imparOuPar();
                    }

                }
                //Scanner sc = new Scanner(System.in);
                //System.out.print(lista + " escolheu: ");
                //lista.put(arrayJogadores.get(i).getNome(), sc.next());
                //System.out.println("Passou: " + i);
            }

            

        }
        return 0;
    }

    public String imparParPerg(int i, String[] array) {
        
        Scanner sc = new Scanner(System.in);
        System.out.print(array[i] + " escolheu: ");
        String scan = sc.next().toLowerCase();
        return scan;
    }
    
    public int ganhadorPI(int a, int b){
        int c = -1;
        
        return c;
    }

}
