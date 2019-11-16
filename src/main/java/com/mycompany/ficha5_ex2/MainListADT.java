/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex2;

/**
 *
 * @author vitor
 */
public class MainListADT {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException, ElementoNaoExisteException {
        DoubleLinkedList lista1 = new DoubleLinkedList();

        int teste = 19;

        switch (teste) {
            case 0: //teste size com lista vazia
                System.out.println(lista1.size());
                break;

            case 1: //teste size com alguns elementos na lista
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.size());
                break;

            case 2: //teste isEmpty com lista vazia
                System.out.println(lista1.isEmpty());
                break;

            case 3: //teste isEmpty com alguns elementos na lista
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.isEmpty());
                break;

            case 4: //teste removeFist com elementos
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.toString());
                lista1.removeFirst();
                System.out.println(lista1.toString());

                break;

            case 5: //teste removeFist sem elementos
                lista1.removeFirst();
                System.out.println(lista1.toString());

                break;

            case 6: //teste removeFist com 1 elemento
                lista1.add(1);
                lista1.removeFirst();
                System.out.println(lista1.toString());

                break;

            case 7: //teste removeLast sem elementos
                lista1.removeLast();
                System.out.println(lista1.toString());

                break;

            case 8: //teste removeLast com varios elementos elementos
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                lista1.removeLast();
                System.out.println(lista1.toString());

                break;

            case 9: //teste removeLast com um elemento
                lista1.add(1);

                lista1.removeLast();
                System.out.println(lista1.toString());

                break;

            case 10: //teste remove sem ter elementos
                lista1.remove(1);
                System.out.println(lista1.toString());

                break;

            case 11: //teste remove com um elemento
                lista1.add(1);
                lista1.remove(1);
                System.out.println(lista1.toString());

                break;

            case 12: //teste remove o head
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);

                lista1.remove(3);
                System.out.println(lista1.toString());

                break;

            case 13: //teste remove o tail
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);

                lista1.remove(1);
                System.out.println(lista1.toString());

                break;

            case 14: //teste remove a meio
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);

                lista1.remove(2);
                System.out.println(lista1.toString());

                break;

            case 15: //teste remove a meio
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                lista1.add(4);
                lista1.add(5);
                lista1.add(6);

                lista1.remove(3);
                System.out.println(lista1.toString());

                break;

            case 16: //teste contains numa lista vazia

                System.out.println(lista1.contains(1));
                System.out.println(lista1.toString());

                break;

            case 17: //teste contains numa lista o primeiro
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.contains(3));
                System.out.println(lista1.toString());

                break;

            case 18: //teste contains numa lista o ultimo
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.contains(1));
                System.out.println(lista1.toString());

                break;

            case 19: //teste contains numa lista a meio
                lista1.add(1);
                lista1.add(2);
                lista1.add(3);
                System.out.println(lista1.contains(2));
                System.out.println(lista1.toString());

                break;

        }

    }

}
