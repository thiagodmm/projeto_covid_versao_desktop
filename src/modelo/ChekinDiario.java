/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Jaderson Maciel
 */
public class ChekinDiario {
    ArrayList <String> sintomas = new ArrayList<>();
    
    public void adicionar(String ck){
        this.sintomas.add(ck);
    }

    @Override
    public String toString() {
        return "Check-in Diario" + sintomas;
    }
    
    
}
