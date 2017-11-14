package com.accenture.java.practice.linkedList;

import java.util.LinkedList;

public class LinkedListMerging {

    public CustomLinkedList mergeList(CustomLinkedList list1, CustomLinkedList list2)
    {
        CustomLinkedList finalLinkedList = new CustomLinkedList();
        Node curr1 = list1.head;
        Node curr2 = list2.head;
        while (curr1!= null && curr2!=null)
        {
            if(curr1.data<curr2.data)
            {
                finalLinkedList.addToList(new Node(curr1.data) );
                curr1 = curr1.next;
            } else {
                finalLinkedList.addToList(new Node(curr2.data));
                curr2 = curr2.next;
            }
        }
        if(curr1!=null)
        {
            finalLinkedList.last.next = curr1;
        } else if(curr2!=null)
        {
            finalLinkedList.last.next = curr2;
        }

        return finalLinkedList;
    }
    public static void main(String[] args) {

        CustomLinkedList ll1 = new CustomLinkedList();
        CustomLinkedList ll2 = new CustomLinkedList();
        Node head1 = ll1.addToList(new Node(2));
        head1 = ll1.addToList(new Node(10));
        head1 = ll1.addToList(new Node(30));
        Node head2 = ll2.addToList(new Node(5));
        head2 = ll2.addToList(new Node(12));
        head2 = ll2.addToList(new Node(15));
        ll1.printList(head1);
        ll2.printList(head2);
        CustomLinkedList llFinal = new LinkedListMerging().mergeList(ll1,ll2);
        llFinal.printList(llFinal.head);





    }
}
