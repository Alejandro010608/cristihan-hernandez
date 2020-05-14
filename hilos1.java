/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packdehilo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lenovo
 */
public class hilos1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       hilosvarios hilo1= new hilosvarios();
    hilo1.start();
    System.out.print("primer hilo terminado");
        try {
            hilo1.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(hilos1.class.getName()).log(Level.SEVERE, null, ex);
        }
    hilosvarios hilo2= new hilosvarios();
    hilo2.start();
    System.out.print("segundo hilo terminado");
        try {
            hilo2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(hilos1.class.getName()).log(Level.SEVERE, null, ex);
        }
    hilosvarios hilo3= new hilosvarios();
    hilo3.start();
    System.out.print("tercer hilo terminado");
    
        try {
            hilo3.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(hilos1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class hilosvarios extends Thread{
    public void run(){
    for(int i=0;i<15;i++){
        System.out.println("Ejecutando hilo "+getName());
        try {
            Thread.sleep(700);
        } catch (InterruptedException ex) {
            Logger.getLogger(hilosvarios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }
}
