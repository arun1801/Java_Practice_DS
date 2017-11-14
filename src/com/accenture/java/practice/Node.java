package com.accenture.java.practice;

public class Node<T> {

    Node left;
    Node right;
    int data;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
