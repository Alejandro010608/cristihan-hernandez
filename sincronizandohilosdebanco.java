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
public class sincronizandohilosdebanco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        banco b=new banco();
        for(int i=0;i<100;i++){
        transferir r=new transferir (b,i,2000);
        Thread t=new Thread ((Runnable) r);
        t.start();
        
        
        
        }
    }
    
}

class banco {
    public banco(){
    cuentas=new double[100];
    for (int i=0;i<cuentas.length;i++){
        cuentas[i]=2000;
    
    }
    
    }
    public void transferencia(int cuentaorigen,int cuentadestino,double cantidad){
     if(cuentas[cuentaorigen]<cantidad){
     return;
     }
    System.out.println(Thread.currentThread());
    cuentas[cuentaorigen]-=cantidad;//dinero que sale de la cantidad de origen 
    System.out.printf("%10.2f de %d para %d " ,cantidad,cuentaorigen,cuentadestino);
    cuentas[cuentadestino]+=cantidad;
    System.out.printf("saldototal:%10.2f%n",getsaldototal());

    }
    public double getsaldototal(){
       double suma_cuenta=0;
        double suma_cuentas = 0;
       for(double a: cuentas){
       suma_cuentas+=a;
           
       }
       return suma_cuentas;
       
      }
    
    class transferir implements Runnable{
        public transferir(banco b , int de ,double max){
            banco=b;
            delacuenta=de;
            cantidadmax=max;
            
        }

        @Override
        public void run() {
           while(true){
               int paralacuenta=(int)(100*Math.random());
               double cantidad=cantidadmax*Math.random();
               banco.transferencia(delacuenta,paralacuenta,cantidad);
               try {
                   Thread.sleep((int)(Math.random()*10));
               } catch (InterruptedException ex) {
                   Logger.getLogger(banco.class.getName()).log(Level.SEVERE, null, ex);
               }
           
           }
            
          }
        private banco banco;
        private int delacuenta;
        private double cantidadmax;
        
    
    }
    
    
    
 private final double[] cuentas;
}
