package com.accenture.java.practice.linkedList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class CustomLinkedList {

    public Node head;
    public Node last;

    public Node addToList(Node node) {
        if (head == null) {
            head = node;
            head.next = null;
            last = head;
        } else {
            last.next = node;
            last = last.next;
        }
        return head;
    }

    public void populateList() {
        for (int i = 0; i < 8; i++) {
            addToList(new Node(i));
        }
    }

    public int size() {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public int sizeByRecursion(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + sizeByRecursion(node.next);
        }
    }

    public void printList(Node node) {
        Node curr = node;
        while (curr != null) {
            System.out.print(curr.data + " --> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public boolean deleteKey(int key) {
        Node prev = null;
        Node curr = head;
        if (head == null) {
            System.out.println("Linked List is Empty. Nothing to delete.");
            return false;
        }
        while (curr != null) {
            if (curr.data == key) {
                prev.next = curr.next;
                curr = null;
                return true;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return false;
    }

    public boolean deleteByPosition(int indexValue) {
        Node prev = null;
        Node curr = head;
        int index = 0;
        int size = size();
        if (indexValue > size) {
            System.out.println("\nIndex value is outside Linked list Size, Terminating !!!!");
            return false;
        }
        while (curr != null) {
            if (index == indexValue) {
                prev.next = curr.next;
                curr = null;
                return true;
            } else {
                prev = curr;
                curr = curr.next;
                index++;
            }
        }
        return false;
    }

    public boolean searchByIteration(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                return true;
            } else {
                curr = curr.next;
            }
        }
        return false;
    }

    public boolean searchByRecursion(Node node, int key) {

        if (node == null) {
            return false;
        }
        if (node.data == key) {
            return true;
        }
        return searchByRecursion(node.next, key);
    }

    public void swapNodes(int x, int y)
    {
        Node prevX = null;
        Node prevY = null;
        Node currX = head;
        Node currY = head;
        if(x == y)
        {
            return;
        }
        while (currX!=null && currX.data!=x)
        {
            prevX = currX;
            currX = currX.next;
        }
        while (currY!=null && currY.data!=y)
        {
            prevY = currY;
            currY = currY.next;
        }
        if(currX == null || currY == null)
        {
            return;
        }
        if(prevX!=null)
        {
            prevX.next = currY;
        } else {
            head = currY;
        }
        if(prevY!=null)
        {
            prevY.next = currX;
        } else {
            head = currX;
        }
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }

    public Node printMiddleByTraversal()
    {
        Node curr = head;
        int size = size();
        int middleIndex = size/2;
        int index=0;
        Node temp = null;
        if(head == null)
        {
            System.out.println("Linked List is empty.Please insert some elements them try again.");
        } else
        {
        while (curr!=null) {
            if (size % 2 == 0) {
                if (index+1 == middleIndex) {
                    temp = curr;
                    break;
                } else {
                    curr = curr.next;
                    index++;
                }
            } else
            {
                if (index == middleIndex) {
                    temp = curr;
                    break;
                } else {
                    curr = curr.next;
                    index++;
                }
            }

        }
        }
        return temp;
    }

    public Node middleElementbyFastMethod()
    {
        Node slow = head;
        Node fast = head.next;
        if(head == null)
        {
            System.out.println("Linked List is empty.Please insert some elements them try again.");
        }
        while (fast!=null && fast.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public Node nthNodeFromEnd(int n)
    {
        Node slow = head;
        Node fast = head;
        if(head == null || n>size())
        {
            System.out.println("Either linked list is empty or provided index is out of Size limit.");
        } else {
            while (n > 1) {
                fast = fast.next;
                n--;
            }
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return slow;
    }

    public Node reverseLinkedList() {
        Node prev = null;
        Node curr = head;
        Node next = null;
        if (curr == null) {
            System.out.println("There is no element in Linked List.");
        } else {

            while (curr!=null)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
        }
        return prev;
    }

    public boolean detectLoop()
    {
        Map<Node,String> tempMap = new HashMap<>();
        Node curr = head;
        while (curr!= null)
        {
            if(tempMap.containsKey(curr))
            {
                return true;
            } else
            {
                tempMap.put(curr,null);
                curr = curr.next;
            }
        }
        return false;
    }

    public boolean detectLoopbyTwoPointers()
    {
        Node slow = head;
        Node fast = head;
        while (slow!=null && fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
            {
                return true;
            }
        }
        return false;
    }

    public void lastnthElementMovement(int value,Node node)
    {
       Node slow = node;
       Node fast = node;
       while (value > 0) {
           fast = fast.next;
           value -- ;
       }
       while(fast!=null)
       {
           slow = slow.next;
           fast  = fast.next;
           if(fast.next == null)
           {
               Node temp = slow.next;
               fast.next = node;
               slow.next = null;
               head = temp;
               break;
           }
       }

    }

    public void createLoop()
    {
        if(head !=null)
        {
            head.next.next.next.next=head;
        }else {
            return;
        }
    }

    public boolean checkPalindrome(Node node)
    {
        Stack<Node> stack1 = new Stack<>();
        Node curr = node;
        while (curr!=null)
        {
            stack1.add(curr);
            curr = curr.next;
        }
        while (stack1.size()>0)
        {
            if(node.data!=stack1.pop().data)
            {
                return false;
            }
            node = node.next;
        }
        return true;
    }

    public static void main(String[] args) {

        CustomLinkedList linkedObj = new CustomLinkedList();
        //linkedObj.populateList();
        linkedObj.addToList(new Node(6));
        linkedObj.addToList(new Node(1));
        linkedObj.addToList(new Node(2));
        linkedObj.addToList(new Node(3));
        linkedObj.addToList(new Node(2));
        linkedObj.addToList(new Node(1));
        linkedObj.printList(linkedObj.head);
      /*  linkedObj.deleteByPosition(3);
        linkedObj.printList();*/
        int size = linkedObj.sizeByRecursion(linkedObj.head);
        int size2 = linkedObj.size();
        System.out.println("Size of LL by recursion is:- " + size);
        System.out.println("Size of LL by iteration is:- " + size2);
        boolean searchResult = linkedObj.searchByIteration(3443);
        System.out.println("Search Result:- " + searchResult);
        boolean searchResultByRecursion = linkedObj.searchByRecursion(linkedObj.head, 6);
        System.out.println("Search Result by recursion:- " + searchResultByRecursion);
        linkedObj.swapNodes(0,90904);
        linkedObj.printList(linkedObj.head);
        Node middleElement = linkedObj.middleElementbyFastMethod();
        System.out.println("Middle element of Linked list is:- "+middleElement.data);
        Node nthElement = linkedObj.nthNodeFromEnd(5);
        System.out.println("nth Element from End:- "+nthElement.data);
       /* Node newNode = linkedObj.reverseLinkedList();
        linkedObj.printList(newNode);*/
    /*    linkedObj.lastnthElementMovement(5,head);
        linkedObj.printList(head);*/
        System.out.println("Loop present in Linked List :- "+linkedObj.detectLoop());
        System.out.println("Loop present in Linked List :- "+linkedObj.detectLoopbyTwoPointers());
        linkedObj.printList(linkedObj.head);
        System.out.println("String is palindrome:- "+linkedObj.checkPalindrome(linkedObj.head));
        linkedObj.createLoop();
        System.out.println("Loop present in Linked List :- "+linkedObj.detectLoop());
        System.out.println("Loop present in Linked List :- "+linkedObj.detectLoopbyTwoPointers());
       // linkedObj.printList(head);



    }
}
