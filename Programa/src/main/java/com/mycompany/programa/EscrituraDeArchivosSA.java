/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.programa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alexa
 */
public class EscrituraDeArchivosSA {
    
    File fechaHora = new File("fechaHoraVenta.txt");
    File proveedores = new File("proveedores.txt");
    int cantidad;
    String producto;
   String hora;
    String fecha;
    String limite ="Y";
    String codigo;
    int contador = 1;
    
    public void fechaHora(){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("ingresa la fecha de la venta '01/01/2024'");
        String fecha = scan.next();
        
        Scanner scann = new Scanner(System.in);
        System.out.println("ingresa la hora de la venta '15:30'");
        hora = scann.next();
        
        Scanner scannn = new Scanner(System.in);
        System.out.println("ingresa el nombre del producto 'sofa'");
        producto = scannn.next();
        
        Scanner scane = new Scanner(System.in);
        System.out.println("ingresa la caantidad de la venta '150'");
        cantidad = scane.nextInt();
        try{ 
           FileWriter escribir = new FileWriter(fechaHora, true);
           BufferedWriter bw = new BufferedWriter(escribir);
           
           bw.write(fecha + "|" + hora +"|" + producto +"|"+ cantidad +"|" +"\r");
           bw.flush();
           bw.close();
           System.out.println("el producto se agreco correctamente");
       }
       catch(IOException exception){ 
           exception.printStackTrace(System.out);
         System.out.println("la venta de a realizado exitosamente ")  ;
       }
      
        
    }
    
    public void historial(){
         try{
            FileReader fr = new FileReader(fechaHora);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
    }
    
    public void pedidos(){
        
        while (limite.equalsIgnoreCase("Y")) {
        Scanner sl = new Scanner(System.in);
        System.out.println(" ingresa el proveedor");
        String pedido = sl.next();
        
        
        Scanner slt = new Scanner(System.in);
        System.out.println("ingresa los productos a ");
        String prod = slt.next();
        
        Scanner sls = new Scanner(System.in);
        System.out.println("ingresa la cantidad de productos a comprar");
        int cantpedido = sls.nextInt();
        
                
                Scanner scann = new Scanner(System.in);
                System.out.println("estas seguro de pedir este producto 'Y/N'");
                String caso = scann.next();
                
                if (caso.equalsIgnoreCase("Y")) {
                    
                    try{ 
           FileWriter escribir = new FileWriter(proveedores, true);
           BufferedWriter bw = new BufferedWriter(escribir);
           
           bw.write(codigo + "|"+pedido +"|" + prod + "|" + cantpedido +"|" +"\r"); 
           bw.flush();
           bw.close();
           System.out.println("el producto se agreco correctamente");
       }
       catch(IOException exception){ 
           exception.printStackTrace(System.out);
           
       }
                 codigo = String.format("%06d", contador);
       contador++;
       
       Scanner scan = new Scanner(System.in);
        System.out.println("¿Deseas agregar otro producto? (Y/N): ");
                    limite = scan.next();
                }
                
                System.out.println("se an agregado correctamente");
                    
                }
        
        
    }
    
    
    public void hcompras(){
        
        try{
            FileReader fr = new FileReader(proveedores);
                        BufferedReader br = new BufferedReader(fr);
                        String linea = "";
                        while((linea = br.readLine()) != null) {
                            System.out.println(linea);
                        } 
                        br.close();
                    } 
            
                        catch (FileNotFoundException ex) {
                        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                    Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
    }
    
    
    public void gestcsv(){
        
            try {
         FileReader fras = new FileReader(fechaHora);
        BufferedReader bras = new BufferedReader(fras);
        String lineafg;
        String[][] datos = new String[50][4]; // Almacenar los datos temporalmente
        int contadorc = 0;

        // Leer el archivo línea por línea
        while ((lineafg = bras.readLine()) != null) {
            System.out.println(lineafg); // Mostramos los datos en consola
            String[] campos = lineafg.split("\\|"); // Dividimos cada línea en los campos
            datos[contadorc] = campos; // Guardamos los datos en el array
            contadorc++;
        }

        // Cerrar los archivos de lectura
        bras.close();
        fras.close();

        // Ahora generamos el archivo CSV
        try {
            String archivoCSV = "informe_movimiento_stock.csv";
            FileWriter fwes = new FileWriter(archivoCSV);
            BufferedWriter bwes = new BufferedWriter(fwes);

            // Escribir la cabecera del archivo CSV
            bwes.write("Codigo,Nombre,Descripcion,Caracteristicas,Precio,Stock Inicial\n");

            // Recorrer los datos y escribir cada fila en el archivo CSV
            for (int i = 0; i < datos.length; i++) {
                if (datos[i][0] != null) { // Verificar que la fila no esté vacía
                    bwes.write(datos[i][0] + "," +   // fecha
                             datos[i][1] + "," +   // hora
                             datos[i][2] + "," +   // producto
                             datos[i][3] + "\n");  // cantidad
                }
            }

            // Cerrar el archivo
            bwes.close(); 
            System.out.println("Informe de movimiento de stock exportado exitosamente a " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
        
            }
        catch (FileNotFoundException ex) {
        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
     public void gventa(){
        
            try {
         FileReader fras = new FileReader(proveedores);
        BufferedReader bras = new BufferedReader(fras);
        String lineafg;
        String[][] datos = new String[50][4]; // Almacenar los datos temporalmente
        int contadorc = 0;

        // Leer el archivo línea por línea
        while ((lineafg = bras.readLine()) != null) {
            System.out.println(lineafg); // Mostramos los datos en consola
            String[] campos = lineafg.split("\\|"); // Dividimos cada línea en los campos
            datos[contadorc] = campos; // Guardamos los datos en el array
            contadorc++;
        }

        // Cerrar los archivos de lectura
        bras.close();
        fras.close();

        // Ahora generamos el archivo CSV
        try {
            String archivoCSV = "informe_compras";
            FileWriter fwes = new FileWriter(archivoCSV);
            BufferedWriter bwes = new BufferedWriter(fwes);

            // Escribir la cabecera del archivo CSV
            bwes.write("Codigo,Nombre,Descripcion,Caracteristicas,Precio,Stock Inicial\n");

            // Recorrer los datos y escribir cada fila en el archivo CSV
            for (int i = 0; i < datos.length; i++) {
                if (datos[i][0] != null) { // Verificar que la fila no esté vacía
                    bwes.write(datos[i][0] + "," +   // fecha
                             datos[i][1] + "," +   // hora
                             datos[i][2] + "\n");  // cantidad
                }
            }

            // Cerrar el archivo
            bwes.close(); 
            System.out.println("Informe de movimiento de stock exportado exitosamente a " + archivoCSV);
        } catch (IOException e) {
            System.out.println("Error al exportar el archivo CSV: " + e.getMessage());
        }
        
            }
        catch (FileNotFoundException ex) {
        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
    
    
    
}
    
       
    
    
    

    

