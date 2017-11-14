package com.accenture.java.practice;

import java.util.LinkedList;
import java.util.Queue;

public class StackAsQueueMethod2 {

    private static Queue<String> queue1 = new LinkedList<>();
    private static Queue<String> queue2 = new LinkedList<>();
    private static String top;
    public void push(String data)
    {
        queue2.add(data);
        top = data;
        while (queue1.size()!=0)
        {
            queue2.add(queue1.poll());
        }
        Queue<String> tempQueue = queue1;
        queue1 = queue2;
        queue2 = tempQueue;

    }

    public void pop()
    {
        System.out.println(queue1.remove());
        if(!queue1.isEmpty())
        {
            top = queue1.peek();
        }
    }

    public void getTop()
    {
        System.out.println("Top Element is:- "+top);
    }

    public static void main(String args[])
    {
        StackAsQueueMethod2 obj = new StackAsQueueMethod2();
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
