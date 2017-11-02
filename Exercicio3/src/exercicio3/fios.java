/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ped90
 */
public class fios extends Thread{
    
    static int num = 0;
    public fios f = null;
    Random rnd = new Random();
    int segundos = 2;

     public fios (String str){
        super(str);
    }
 
    @Override
    public void run(){
        
        int m = rnd.nextInt(200) + 300; //random para meter unos valores por cada ejecucion
        
        try {
            Thread.sleep(segundos * 300); //tiempo de espera para la siguiente ejecucion
            
            try {
                if (num < 5){ //crea 5 hilos en este caso será el Padre, cuando este llegue a 5 creados finaliza
                    f = new fios(""+num);
                    num++;
                }
                System.out.println("Padre " +f.getName()+ "->" +m+ "ms"); //mensaje de que los hilos creados son el Padre con sus milisegundos
                
                for(int i=0; i<5; i++){ //crea 5 hijos por cada padre 
                    Thread.sleep(segundos * 300); //tiempo de espera para la creacion de cada hijo
                    System.out.println("Hijo de " +f.getName()+ "->" +m+ "ms"); //mensaje de que cada hijo creado con sus milisegundos
                }
                if(f != null){ //cuando los padres y hijos terminan este termina de crear más
                    f.start(); //inicia 
                    f.join(); //espera a que termine 
                    System.out.println(""); //espacio en blanco
                    Thread.sleep(segundos * 300); //tiempo de espera para terminar la ejecucion de cada padre
                    System.out.println("-Me desconecto- " +f.getName()+ "->" +m+ "ms"); // mensaje que se van desconectando los padres
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(fios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(fios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    

