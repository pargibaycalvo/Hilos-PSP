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
        
        int m = rnd.nextInt(200) + 300; 
        
        try {
            Thread.sleep(segundos * 300);
            
            try {
                if (num < 5){ 
                    f = new fios(""+num);
                    num++;
                }
                System.out.println("Padre " +f.getName()+ "->" +m+ "ms");
                
                for(int i=0; i<5; i++){ 
                    Thread.sleep(segundos * 300); 
                    System.out.println("Hijo de " +f.getName()+ "->" +m+ "ms"); 
                }
                if(f != null){ 
                    f.start();
                    f.join(); 
                    System.out.println("");
                    Thread.sleep(segundos * 300);
                    System.out.println("-Me desconecto- " +f.getName()+ "->" +m+ "ms");
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(fios.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(fios.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    }
    

