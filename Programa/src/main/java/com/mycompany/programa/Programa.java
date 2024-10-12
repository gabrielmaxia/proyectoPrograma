/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.programa;

import java.util.Scanner;

/**
 *
 * @author alexa
 */
public class Programa {

    public static void main(String[] args) {
        
        Scanner GESTION = new Scanner (System.in);
        
        System.out.println("Ingresa la opcion que deseas realizar ");
        System.out.println("1) Gestion de productos ");
        System.out.println("2) Control de existencias  ");
        System.out.println("3) Pedidos de compra ");
        System.out.println("4) Informes y estadisticas ");
        
        int gest = GESTION.nextInt(); 
        
        if (gest == 1) {
            
            // collocar la clase gestion de productos
            
            gestionDeProductos pr = new gestionDeProductos();
            pr.mostraropcionesdegestion();
        }
        
        if(gest == 2) {
            // coloca la clase control de existencias
            
            controlExistencia ce = new controlExistencia();
            ce.prueba2();
        }
        if(gest == 3){
            // colocar la clase pedidos de compra 
            
            pedidoDeCompra pdc = new pedidoDeCompra();
            pdc.prueba3();
        }
        
        
        if (gest == 4) {
            
            informesEstadisticas ie = new informesEstadisticas ();
            ie.prueba4();
            
            // colocar clase estadisticas
        }
       
    }
}
