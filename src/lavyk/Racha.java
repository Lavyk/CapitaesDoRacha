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
    private ArrayList<Jogador> arrayJogadores = new ArrayList<Jogador>();
    ArrayList<Time> arrayTimes = new ArrayList<Time>();
    private Map<Integer, String> lista = new HashMap<Integer, String>();
    private String[] arrayParImpar = new String[3];

    private int jogadorA = -1;
    private int jogadorB = -1;

    Racha() {
        arrayTimes.add(new Time("Time A"));
        arrayTimes.add(new Time("Time B"));
        arrayTimes.add(new Time("Time C"));
    }

    public void addJogador(String nome, int numero) {
        numJogadores++;

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
                } else if (numJogador <= 0) {
                    arrayJogadores.get(i).setZeroOuUm(0);
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
        lista.put(0, null);
        lista.put(1, null);
        lista.put(2, null);

        for (int i = 0; i < arrayParImpar.length; i++) {
            arrayParImpar[i] = arrayJogadores.get(i).getNome();
        }

        arrayParImpar[intGanhador] = null;
        if (strGanhador == null) {
            System.out.println("É necessário que se jogue o Zero ou Um.");
        } else {

            String result = verificarIP();
            System.out.println("O Impar ou Par deu " + result);
        }
        return 0;
    }

    public String verificarIP() {
        for (int i = 0; i < arrayParImpar.length; i++) {
            if (arrayParImpar[i] != null) {
                imparParPerg(i, arrayParImpar);
            }
            //return a;
        }

        String result = verificarIP2();

        return result;
    }

    public String verificarIP2() {
        for (int i = 0; i < arrayParImpar.length; i++) {
            if (jogadorA == -1 || jogadorB == -1) {
                if (lista.get(i) != null) {
                    resultadoIP(i, arrayParImpar);
                }
            }
        }
        String result = finalIP(jogadorA, jogadorB);
        return result;
    }

    public String imparParPerg(int i, String[] array) {
        if (!array[i].equals(null)) {
            Scanner sc = new Scanner(System.in);
            System.out.print(array[i] + " escolheu: ");
            String scan = sc.next().toLowerCase();
            if (scan.equals("par") || scan.equals("impar")) {
                lista.put(i, scan);
            } else {
                System.out.println("O jogador deve escolher entre 'impar' ou 'par'.");
                imparParPerg(i, array);
            }
            return scan;
        } else {
            return array[i];
        }

    }

    public void resultadoIP(int i, String[] array) {

        String finalIP = null;
        int ganhadorIP, num1;

        System.out.println("\nEscolha um número de 0 a 10.");

        Scanner scan1 = new Scanner(System.in);
        System.out.print(array[i] + " escolheu o número: ");
        num1 = Integer.valueOf(scan1.next());

        if (num1 > 10 || num1 < 0) {
            verificarIP2();
        } else if (jogadorA == -1) {
            jogadorA = num1;
        } else {
            jogadorB = num1;
        }
    }

    public String finalIP(int a, int b) {
        int result = (a + b) % 2;
        String finalIP;
        if (result == 0) {
            finalIP = "par";
        } else {
            finalIP = "impar";
        }

        return finalIP;
    }

}
