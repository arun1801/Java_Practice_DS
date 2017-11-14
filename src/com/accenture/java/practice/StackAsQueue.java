package com.accenture.java.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackAsQueue {

    private static Queue<String> queue1 = new LinkedList<>();
    private static Queue<String> queue2 = new LinkedList<>();
    private static String top;

    public void push(String data)
    {
        queue1.add(data);
        top = data;
    }
    public void pop()
    {
        while (queue1.size()>1)
        {
            top = queue1.poll();
            queue2.add(top);
        }
        System.out.println(queue1.poll());
        Queue<String> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

    }
    public void getTop()
    {
        System.out.println("Element on TOP is: - "+top);
    }
    public static void main(String args[])
    {
        StackAsQueue obj = new StackAsQueue();
        obj.push("Arun");
        obj.push("Zia");
        obj.push("Vaibhav");
        obj.push("Ankit");
        obj.getTop();
        obj.pop();
        obj.getTop();
        obj.pop();
        obj.getTop();
        obj.pop();
        obj.getTop();
    }
}
