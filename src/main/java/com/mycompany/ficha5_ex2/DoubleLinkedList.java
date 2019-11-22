/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha5_ex2;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author vitor
 */
public class DoubleLinkedList<T> implements ListADT<T> {

    protected int count;
    protected int modCount;
    protected DoubleNode<T> head;
    protected DoubleNode<T> tail;

    public DoubleLinkedList() {
        this.count = 0;
        this.modCount = 0;
        this.head = null;
        this.tail = null;
    }

    public void add(T novo) {
        DoubleNode<T> newNode = new DoubleNode<>(novo);

        if (this.count == 0) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.head.setPrevious(newNode);
            newNode.setNext(this.head);
            this.head = newNode;
        }

        this.count++;
        this.modCount++;
    }

    @Override
    public T removeFirst() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista vazia");
        }

        DoubleNode<T> tmp = this.head;

        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.getNext();
            tmp.setNext(null);
            this.head.setPrevious(null);
        }

        this.count--;
        this.modCount++;

        return tmp.getElement();

    }

    @Override
    public T removeLast() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista vazia");
        }
        DoubleNode<T> tmp = this.tail;
        if (this.size() == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.tail = this.tail.getPrevious();
            tmp.setPrevious(null);
            this.tail.setNext(null);
        }

        this.count--;
        this.modCount++;

        return tmp.getElement();
    }

    @Override
    public T remove(T element) throws EmptyCollectionException, ElementoNaoExisteException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista vazia");
        }

        T tmp;

        if (element.equals(this.head.getElement())) {
            tmp = this.removeFirst();
        } else if (element.equals(this.tail.getElement())) {
            tmp = this.removeLast();
        } else {

            DoubleNode<T> current = this.head.getNext();

            boolean found = false;

            while (!found && current != null) {
                if (element.equals(current.getElement())) {
                    found = true;
                } else {
                    current = current.getNext();
                }

            }

            if (!found) {
                throw new ElementoNaoExisteException("Ñao existe na lista");
            }

            (current.getPrevious()).setNext(current.getNext());
            (current.getNext()).setPrevious(current.getPrevious());

            current.setNext(null);
            current.setPrevious(null);

            tmp = current.getElement();
            this.count--;
            this.modCount++;

        }

        return tmp;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.head.getElement();
    }

    @Override

    public T last() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.tail.getElement();
    }

    @Override
    public boolean contains(T target) throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }

        DoubleNode<T> current = this.head;

        boolean found = false;

        while (!found && current != null) {
            if (target.equals(current.getElement())) {
                found = true;
            } else {
                current = current.getNext();
            }

        }

        if (!found) {
            throw new EmptyCollectionException("Ñao existe na lista");
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public String toString() {
        String str = "";

        DoubleNode<T> current = this.head;

        while (current != null) {
            str += current.getElement().toString();
            str += "\n";
            current = current.getNext();
        }

        str += "Count=" + this.count;
        return str;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyItr();
    }

    private class MyItr implements Iterator<T> {

        int expectedModCount;
        boolean okToRemove;
        DoubleNode<T> current;
        DoubleNode<T> previous;

        /**
         * Creates an Iterator.
         *
         */
        MyItr() {
            //proxima coisa a fazer neste projecto e colocar o modcount
            this.expectedModCount = modCount;
            okToRemove = false;
            this.current = head;
        }

        @Override
        public boolean hasNext() {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException("Lista imcompativel!");
            }
            return this.current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            this.okToRemove = true;
            
             previous = this.current;
            
            this.current = this.current.getNext();
            return previous.getElement();
        }

        @Override
        public void remove() {
            if (this.expectedModCount != modCount) {
                throw new ConcurrentModificationException("modCount incompativel");
            }
            if (!okToRemove) {
                throw new NoSuchElementException("impossivel remover");
            }
            try {
                DoubleLinkedList.this.remove(this.previous.getElement());

                this.expectedModCount = modCount;
                this.okToRemove = false;
            } catch (EmptyCollectionException | ElementoNaoExisteException ex) {
                throw new ConcurrentModificationException();
            }
            
        }
    }

}
