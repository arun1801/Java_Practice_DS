package com.accenture.java.practice;

import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Node root;
    static int maxlevel;
    BinaryTree()
    {
        root = null;
    }

    void insert(int data)
    {
       root = insertNode(root,data);
    }

    Node insertNode(Node root,int data)
    {
        Node tempNode = new Node(data);
        if(root == null)
        {
            root = tempNode;
            return root;
        }
        if(root.data== data)
        {
            return root;
        } else
        if(root.data>data)
        {
            root.left = insertNode(root.left,data);
        } else
        {
            root.right = insertNode(root.right,data);
        }
        return root;

    }
    void display(Node root)
    {
        if(root == null)
        {
            return;
        }
        display(root.left);
        System.out.print(root.data+" ");
        display(root.right);
    }
    void getLeftView(Node root)
    {
        leftView(root,1);
        maxlevel = 0;
    }

    void leftView(Node root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(maxlevel<level)
        {
            System.out.print(root.data+" ");
            maxlevel = level;
        }
        leftView(root.left,level+1);
        leftView(root.right,level+1);
    }

    void getRightView(Node root)
    {
        rightView(root,1);
        maxlevel = 0;
    }

    void rightView(Node root, int level)
    {
        if(root == null)
        {
            return;
        }
        if(maxlevel<level)
        {
            System.out.print(root.data+" ");
            maxlevel = level;
        }
        rightView(root.right,level+1);
        rightView(root.left,level+1);
    }
    void levelOrderTraversal(Node root)
    {
        Queue<Node> tempQueue = new LinkedList<>();
        if(root == null)
        {
            return;
        }
        tempQueue.add(root);
        while (tempQueue.size()!=0)
        {
            Node removedNode = tempQueue.poll();
            System.out.print(removedNode.data+" ");
            if(removedNode.left!=null) {
                tempQueue.add(removedNode.left);
            }
            if(removedNode.right!=null)
            {
                tempQueue.add(removedNode.right);
            }
        }
    }

    void getTopView(Node root)
    {
        Queue<Node> tempQueue =  new LinkedList<>();
        Stack<Node> tempStack = new Stack<>();
        if(root == null)
        {
            return;
        }
        tempQueue.add(root);
        tempStack.add(root);
        while(tempQueue.size()!=0 || tempStack.size()!=0)
        {
            Node removednode1 = tempQueue.poll();
         try
         {
             Node removednode2 = tempStack.pop();

            if(removednode1.data == removednode2.data)
            {
                System.out.print(removednode1.data + " ");
            } else
            {
                System.out.print(removednode1.data+" "+removednode2.data);
            }
            if(removednode1.left!=null)
            {
                tempQueue.add(removednode1.left);
            } else if(removednode1.right!=null)
            {
                tempStack.add(removednode1.right);
            }
            if(removednode2.left!=null)
            {
                tempQueue.add(removednode2.left);
            } else if(removednode2.right!=null)
            {
                tempStack.add(removednode2.right);
            }}catch (EmptyStackException  e)
         {

         }
        }



    }


    public static void main(String args[])
    {
        BinaryTree obj = new BinaryTree();
        obj.insert(30);
        obj.insert(10);
        obj.insert(25);
        obj.insert(25);
        obj.insert(25);
        obj.insert(5);
        obj.insert(35);
        System.out.println("Tree Elements:- ");
        obj.display(obj.root);
        System.out.println("\nLeft View:- ");
        obj.getLeftView(obj.root);
        System.out.println("\nRight View:- ");
        obj.getRightView(obj.root);
        System.out.println("\nLevel order traversal:- ");
        obj.levelOrderTraversal(obj.root);
        System.out.println("\nTop View:- ");
        obj.getTopView(obj.root);
    }

}

