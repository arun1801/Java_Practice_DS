package com.accenture.java.practice.linkedList;

public class Node<T> {

    Node next;
    int data;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
