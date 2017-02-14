/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lavyk;

/**
 *
 * @author Lavyk
 */
public class Main {
    public static void main(String[] args){

        Racha racha = new Racha();
        
        racha.addJogador("Joao", 15);
        racha.addJogador("Pedro", 17);
        racha.addJogador("Ronaldo", 20);
        racha.addJogador("Fabiano", 20);
        racha.addJogador("Lamark", 20);
        racha.addJogador("Lavyk", 20);
        
        //System.out.println(racha.getJogadores());
        int ganhadorZU = racha.zeroOuUm();
        System.out.println(racha.getJogadores().get(ganhadorZU));
        racha.imparOuPar(ganhadorZU);
    }
}