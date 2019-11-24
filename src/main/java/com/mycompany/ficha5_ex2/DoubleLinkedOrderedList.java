/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex2;

/**
 *
 * @author vitor
 * @param <T>
 */
public class DoubleLinkedOrderedList<T> extends DoubleLinkedList<T> implements OrderedListADT<T> {

    public DoubleLinkedOrderedList() {
        super();
    }

    @Override
    public void add(T element) {
        if (element instanceof Comparable) {
            Comparable<T> x = (Comparable<T>) element;

            DoubleNode<T> newNode = new DoubleNode<>(element);

            if (this.isEmpty()) {
                this.head = newNode;
                this.tail = newNode;
            }

            //menor que o head
            if (x.compareTo(this.head.getElement()) < 0) {
                newNode.setNext(this.head);
                this.head.setPrevious(newNode);
                this.head = newNode;
            }

            //maior que a tail
            if (x.compareTo(this.tail.getElement()) > 0) {
                newNode.setPrevious(this.tail);
                this.tail.setNext(newNode);
                this.tail = newNode;

            }
            this.count++;
            this.modCount++;
        }

    }
}
