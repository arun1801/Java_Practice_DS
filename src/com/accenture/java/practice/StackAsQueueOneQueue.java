package com.accenture.java.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackAsQueueOneQueue {

    public static Queue<String> queue = new LinkedList<>();
    public static String top;

    public void push(String data)
    {
        queue.add(data);
        top = data;
        int size = queue.size();
        while(size>1)
        {
            queue.add(queue.remove());
            size -- ;
        }

    }

    public void pop()
    {
        System.out.println("Removed data is:- "+queue.remove());
        if(!queue.isEmpty())
        {
            top = queue.peek();
        }
    }

    public void getTopView()
    {
        System.out.println("TOP View is:- "+top);
    }

    public static void main(String args[])
    {
        StackAsQueueOneQueue obj = new StackAsQueueOneQueue();
        obj.push("Arun");
        obj.push("Ankit");
        obj.push("Zia");
        obj.push("Vaibhav");
        obj.getTopView();
        obj.pop();
        obj.getTopView();
        obj.pop();
        obj.getTopView();
        obj.pop();
        obj.getTopView();
    }

}
