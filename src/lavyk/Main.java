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
public class Main extends Racha{
    public void mostra(){
        System.out.println(super.getNumJogadores());
    }
    public static void main(String[] args){

        Racha racha = new Racha();
        
        racha.addJogador("João", 15);
        racha.addJogador("Pedro", 17);
        racha.addJogador("Ronaldo", 20);
        racha.addJogador("Fabiano", 20);
        racha.addJogador("Lamark", 20);
        racha.addJogador("Lavyk", 20);
        
        System.out.println(racha.getJogadores());
        racha.zeroOuUm();
    }
}