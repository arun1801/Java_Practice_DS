package com.accenture.java.practice;

import java.util.Stack;

public class QueueAsStack {

    private static Stack<String> stack1 = new Stack<>();
    private static Stack<String> stack2 = new Stack<>();
    private static String front;
    private static String rear;

    QueueAsStack()
    {
        front = null;
        rear = null;
    }

    public void push(String data)
    {
        stack1.add(data);
    }

    public void pop()
    {
        while(!stack1.isEmpty())
        {
            stack2.add(stack1.pop());
        }
        System.out.println("Deleted Node is:- "+ stack2.pop());
        while (!stack2.isEmpty())
        {
            stack1.add(stack2.pop());
        }
    }

    public static void main(String args[])
    {
        QueueAsStack objQueue = new QueueAsStack();
        objQueue.push("Arun");
        objQueue.push("Zia");
        objQueue.push("Ankit");
        objQueue.push("Vaibhav");
        objQueue.push("Arpit");
        objQueue.pop();
        objQueue.pop();
        objQueue.pop();


    }
}
