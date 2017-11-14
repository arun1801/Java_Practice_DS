package com.accenture.java.practice;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUImplementation extends LinkedHashMap<Integer, String> {

    private int capacity;
    public LRUImplementation(int capacity, float loadfactor)
    {
        super(capacity,loadfactor,true);
        this.capacity=capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest)
    {
        return size() > this.capacity;
    }


    public static void main(String args[])
    {
        LRUImplementation lruObj = new LRUImplementation(6,0.75f);
        lruObj.put(1,"Arun");
        lruObj.put(2,"Zia");
        lruObj.put(3,"Arun");
        System.out.println(lruObj);
        lruObj.put(4,"Arun");
        lruObj.put(5,"Zia");
        lruObj.put(6,"Arun");
        lruObj.put(7,"Arun");
        lruObj.get(7);
        lruObj.put(7,"Zia");
        System.out.println(lruObj);

    }

}
