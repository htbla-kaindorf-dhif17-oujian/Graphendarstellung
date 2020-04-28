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
        int index1 = getIndex(startKnoten);
        int index2 = getIndex(endKnoten);
        if(matrix[index1][index2] == 1){
            return true;
        }
        return false;
    }
    
    public char[] getAlleNachbarn(char knoten){
        int knotenIndex = getIndex(knoten);
        List<Character> nachbarn = new ArrayList<>();
        for(int i = 0; i< matrix[knotenIndex].length; i++){
            if(matrix[knotenIndex][i] == 1){
                nachbarn.add(knotenListe[i]);
            }
        }
        char[] nachbarnFeld = new char[nachbarn.size()];
        for(int i = 0; i< nachbarn.size(); i++){
            nachbarnFeld[i] = nachbarn.get(i);
        }
        return nachbarnFeld;
    }
    
    public int getIndex(char knoten){
        
        for(int j = 0; j < knotenListe.length; j++){
            if(knotenListe[j]==knoten){
                return j;
            }
        }
        throw new RuntimeException("Knoten "+ knoten + " existiert nicht");
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
            System.out.println(main.existiertKnoten('B'));
            System.out.println(main.existiertKante('B', 'C'));
            System.out.println(main.existiertKante('D', 'C'));
            System.out.println(main.getAlleNachbarn('C'));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
