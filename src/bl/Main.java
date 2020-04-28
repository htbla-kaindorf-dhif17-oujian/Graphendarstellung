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

/**
 *
 * @author Gottl
 */
public class Main {
    
    private char[] knotenListe;
    private int[][] matrix;
    
    public void ladeDaten() throws IOException{
        
        BufferedReader br = new BufferedReader(new FileReader(Paths.get(System.getProperty("user.dir"), "src","res","daten.csv").toFile()));
        
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
    
    public static void main(String[] args) {
        
    }
}
