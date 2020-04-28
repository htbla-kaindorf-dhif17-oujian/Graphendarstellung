/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gottl
 */
public class Main {
    
    private char[] knotenListe;
    private int[][] matrix;
    
    public void ladeDaten() throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(Paths.get(System.getProperty("user.dir"), "src","res","daten.csv").toFile()));
        String line = br.readLine();
        String[] lineParts = line.split(",");
        knotenListe = new char[lineParts.length - 1];
        for(int i = 1; i<lineParts.length; i++){
            knotenListe[i-1] = lineParts[i].charAt(0);
        }
        matrix = new int[knotenListe.length][knotenListe.length];
        
        for(int i = 0;i < knotenListe.length; i++){
            line = br.readLine();
            lineParts = line.split(",");
            for(int j = 1; j < lineParts.length;j++){
                matrix[i][j-1] = Integer.parseInt(lineParts[j]);
            }
        }
        
    }
    
    public boolean existiertKante(char startKnoten, char endKnoten){
        return false;
    }
    
    public char[] getAlleNachbarn(char knoten){
        return null;
    }
    
    public boolean existiertKnoten(char knoten){
        for (char c : knotenListe) {
            if(knoten == c){
                return true;
            }
        }
        return false;
    }
    
    public String toString(){
        String output = "  ";
        for (char c : knotenListe) {
            output += c + " ";
        }
        output += "\n-----------\n";
        for(int i = 0; i<knotenListe.length; i++){
            output += knotenListe[i] + " ";
            for(int j = 0; j< matrix[i].length;j++){
                output += matrix[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }
    
    public static void main(String[] args) {
        try {
            Main main = new Main();
            main.ladeDaten();
            System.out.println(main.toString());
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
