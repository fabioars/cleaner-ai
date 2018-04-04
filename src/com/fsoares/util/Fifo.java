package com.fsoares.util;

import java.util.ArrayList;

public class Fifo<T> {

    private ArrayList<T> list = null;

    private static final int NEXT_POSITION = 0;

    public Fifo (){
        this.list = new ArrayList<>();
    }

    public Fifo<T> add(T item){
        this.list.add(item);

        return this;
    }

    public T next() {
        return list.remove(NEXT_POSITION);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public ArrayList<T> getList() {
        return this.list;
    }

    public int size() {
        return this.list.size();
    }
}
