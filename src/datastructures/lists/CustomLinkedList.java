package datastructures.lists;
import datastructures.interfaces.LinkedList;

import java.util.NoSuchElementException;

public class CustomLinkedList<T> implements LinkedList<T>{
    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head, tail;
    private int size = 0;

    @Override
    public void addFirst(T t) {
        if (t == null)
            throw new NullPointerException();

        Node<T> newNode = new Node<>(t);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T t) {
        if (t == null)
            throw new NullPointerException();

        Node<T> newNode = new Node<>(t);

        if(tail == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if(head == null)
            throw new NoSuchElementException();

        T removedData = head.data;

        if(head.next == null) {
            head = null;
            tail = null;
        }
        else {
            head = head.next;
            head.prev = null;
        }

        size--;
        return removedData;
    }

    @Override
    public T removeLast() {
        if(tail == null)
            throw new NoSuchElementException();

        T removedData = tail.data;

        if(tail.prev == null) {
            head = null;
            tail = null;
        }
        else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
        return removedData;
    }

    @Override
    public T getFirst(){
        if(head == null)
            throw new NoSuchElementException();

        return head.data;
    }

    @Override
    public T getLast() {
        if(tail == null)
            throw new NoSuchElementException();

        return tail.data;
    }

    @Override
    public void clear() {
        head = null;
        tail =null;
        size = 0;
    }

    @Override
    public T get(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> current = head;

        for(int i = 0; i < index; i++)
             current = current.next;

        return current.data;
    }

    @Override
    public T set(int index, T element) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();

        if (element == null)
            throw new NullPointerException();

        Node<T> current = head;

        for(int i = 0; i < index; i++)
            current = current.next;

        T replacedData = current.data;

        current.data = element;

        return replacedData;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null)
            throw new NullPointerException();

        Node<T> current = head;

        for(int i = 0; i < size; i++)
        {
            if(current.data.equals(o))
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null)
            throw new NullPointerException();

        Node<T> current = head;

        for(int i = 0; i < size; i++, current = current.next)
        {
            if( ! current.data.equals(o))
                continue;

            if(current == head) {
                head = head.next;
                if(head != null)
                    head.prev = null;
                else
                    tail = null;
            }
            else if(current == tail) {
                tail = tail.prev;
                if(tail != null)
                    tail.next = null;
                else
                    head = null;
            }
            else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            size--;
            return true;
        }
        return false;
    }
}