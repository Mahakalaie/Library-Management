package datastructures.queues;

import datastructures.interfaces.Queue;
import datastructures.lists.CustomLinkedList;

import java.util.NoSuchElementException;

public class CustomQueue<T> implements Queue<T> {
    private CustomLinkedList<T> list;

    private int capacity;

    public CustomQueue() {
        list = new CustomLinkedList<>();
        capacity = 100;
    }

    public CustomQueue(int capacity) {
        list = new CustomLinkedList<>();
        this.capacity = capacity;
    }

    @Override
    public boolean add(T t) {
        if (t == null)
            throw new NullPointerException();
        if(list.size() >= capacity)
            throw new IllegalStateException();
        list.addLast(t);
        return true;
    }

    @Override
    public boolean offer(T t) {
        if (t == null)
            throw new NullPointerException();
        if(list.size() >= capacity)
            return false;
        list.addLast(t);
        return true;
    }

    @Override
    public T remove() {
        if(list.isEmpty())
            throw new NoSuchElementException();
        return list.removeFirst();
    }

    @Override
    public T poll() {
        if(list.isEmpty())
            return null;
        return list.removeFirst();
    }

    @Override
    public T element() {
        if(list.isEmpty())
            throw new NoSuchElementException();
        return list.getFirst();
    }

    @Override
    public T peek() {
        if(list.isEmpty())
            return null;
        return list.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

}