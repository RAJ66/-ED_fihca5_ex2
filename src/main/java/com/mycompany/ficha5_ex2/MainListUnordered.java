/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex2;

import java.util.Iterator;

/**
 *
 * @author vitor
 */
public class MainListUnordered {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         DoubleLinkedUnorderedList lista1 = new DoubleLinkedUnorderedList();

        int teste = 0;

        switch (teste) {
            case 0: //teste addToFront
                lista1.addToFront("D");
                lista1.addToFront("B");
                lista1.addToFront("A");
                lista1.addToFront("C");

                Iterator it3 = lista1.iterator();

                while (it3.hasNext()) {
                    String obj = (String) it3.next();
                    System.out.println(obj);
                }
                break;

            
        }
    }
    
}
