package com.workshop.ds.linkedlist;

public class LinkedListTester {

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		LinkedListNode node = new LinkedListNode(10);
		linkedList.insert(node);
		node = new LinkedListNode(2);
		linkedList.insert(node);
		node = new LinkedListNode(30);
		linkedList.insert(node);
		node = new LinkedListNode(45);
		linkedList.insert(node);
		node = new LinkedListNode(50);
		linkedList.insert(node);
		node = new LinkedListNode(6);
		linkedList.insert(node);
		node = new LinkedListNode(17);
		linkedList.insert(node);
		node = new LinkedListNode(89);
		linkedList.insert(node);
		node = new LinkedListNode(9);
		linkedList.insert(node);
		
		node.setNext(linkedList.getHead().getNext().getNext().getNext());
		
		System.out.println("\nIs Loop exists: "+linkedList.isLoopExist());
		if(linkedList.isLoopExist()){
			linkedList.removeLoop();
			linkedList.traverse();
			System.out.println(linkedList.isPalindrom());
		}
		/*if(!linkedList.isLoopExist()){
			linkedList.traverse();
			System.out.println(linkedList.isPalindrom());
		}*/
		
		LinkedListNode sortedHead = LinkedList.mergeSort(linkedList.getHead());
		LinkedList sortedLinkList = new LinkedList();
		sortedLinkList.setHead(sortedHead);
		System.out.print("Printing sorted data: ");
		sortedLinkList.traverse();

	}

}
