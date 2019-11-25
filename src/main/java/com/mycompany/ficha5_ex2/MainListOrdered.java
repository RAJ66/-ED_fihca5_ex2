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
public class MainListOrdered {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DoubleLinkedOrderedList lista1 = new DoubleLinkedOrderedList();

        int teste = 6;

        switch (teste) {
            case 0: //teste add se nao existir la nada
                lista1.add("C");

                Iterator it3 = lista1.iterator();

                while (it3.hasNext()) {
                    String obj = (String) it3.next();
                    System.out.println(obj);
                }
                break;

            case 1: //teste add se for menor que o head
                lista1.add("C");
                lista1.add("B");

                Iterator it2 = lista1.iterator();

                while (it2.hasNext()) {
                    String obj = (String) it2.next();
                    System.out.println(obj);
                }
                break;

            case 2: //teste add se for maior que o tail
                lista1.add("C");
                lista1.add("B");
                lista1.add("D");

                Iterator it1 = lista1.iterator();

                while (it1.hasNext()) {
                    String obj = (String) it1.next();
                    System.out.println(obj);
                }
                break;

            case 3: //teste add no meio
                lista1.add("A");
                lista1.add("B");
                lista1.add("D");
                lista1.add("E");

                lista1.add("C");

                Iterator it4 = lista1.iterator();

                while (it4.hasNext()) {
                    String obj = (String) it4.next();
                    System.out.println(obj);
                }
                break;

            case 4: //teste add no meio segunda posicao
                lista1.add("A");
                lista1.add("C");
                lista1.add("D");
                lista1.add("E");

                lista1.add("B");

                Iterator it5 = lista1.iterator();

                while (it5.hasNext()) {
                    String obj = (String) it5.next();
                    System.out.println(obj);
                }
                break;

            case 5: //teste add penultima posicao
                lista1.add("A");
                lista1.add("B");
                lista1.add("C");
                lista1.add("E");

                lista1.add("D");

                Iterator it6 = lista1.iterator();

                while (it6.hasNext()) {
                    String obj = (String) it6.next();
                    System.out.println(obj);
                }
                break;

            case 6: //teste add com elemento igual
                lista1.add("A");
                lista1.add("B");
                lista1.add("C");
                lista1.add("D");

                lista1.add("B");

                Iterator it7 = lista1.iterator();

                while (it7.hasNext()) {
                    String obj = (String) it7.next();
                    System.out.println(obj);
                }
                break;
        }
    }
}
