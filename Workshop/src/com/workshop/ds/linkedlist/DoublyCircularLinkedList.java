package com.workshop.ds.linkedlist;

public class DoublyCircularLinkedList {
	DoublyCircularLinkedListNode head;
	DoublyCircularLinkedListNode end;
	
	public void traverse(){
		DoublyCircularLinkedListNode currentNode = head;
		System.out.println(currentNode.getData()+" -> ");
		currentNode = currentNode.getNext();
		while(currentNode != head){
	    	System.out.print(currentNode.getData()+" -> ");
	    	currentNode =  currentNode.getNext();
	    }	
	}
	public synchronized void insert(DoublyCircularLinkedListNode node){
		insertAtEnd(node);
	}
	public synchronized void insertAtEnd(DoublyCircularLinkedListNode node){
		if(head == null){
			head = node;
		}else{
			DoublyCircularLinkedListNode p,q;
			p = q = head;
			for(p=head; p.getNext()!= head; p = p.getNext());
			node.setPrev(p);
			p.setNext(node);
			node.setNext(head);
			head.setPrev(node);
			
		}
		end = node;
	}
}
