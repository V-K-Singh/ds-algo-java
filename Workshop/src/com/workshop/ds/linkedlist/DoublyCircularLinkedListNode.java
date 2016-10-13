package com.workshop.ds.linkedlist;

public class DoublyCircularLinkedListNode {
	DoublyCircularLinkedListNode prev;
	int data;
	DoublyCircularLinkedListNode next;
	
	public DoublyCircularLinkedListNode(int data){
		this.prev = this;
		this.data = data;
		this.next = this;
	}
	public DoublyCircularLinkedListNode getPrev() {
		return prev;
	}
	public void setPrev(DoublyCircularLinkedListNode prev) {
		this.prev = prev;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public DoublyCircularLinkedListNode getNext() {
		return next;
	}
	public void setNext(DoublyCircularLinkedListNode next) {
		this.next = next;
	}
	
	
}
