package Interfaz;

import Gestores.GestorPersonas;
import Modelo.*;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Angel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//        GestorPersonas gestor = new GestorPersonas();
//        ArrayList<EstadoCivil> listaEC = gestor.obtenerEstadosCiviles();
//        
//        for (EstadoCivil estadoCivil : listaEC) {
//            System.out.println(estadoCivil);
//        }
//        
//        ArrayList<Persona> listaPer = gestor.obtenerPersonas();
//        
//        for (Persona persona : listaPer) {
//            System.out.println(persona);
//        }
        
        frmAltaPersonas alta = new frmAltaPersonas();
        alta.setLocationRelativeTo(null);
        alta.setVisible(true);
    }
    
}
