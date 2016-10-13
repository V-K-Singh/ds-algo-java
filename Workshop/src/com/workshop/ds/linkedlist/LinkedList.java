package com.workshop.ds.linkedlist;

public class LinkedList {
	private int size;
	private LinkedListNode head;
	private LinkedListNode left;
	public LinkedList(){
		size = 0;
	}
	
	public int size(){
		return size;
	}
	public LinkedListNode getHead(){
		return head;
	}
	public void setHead(LinkedListNode head){
		this.head = head;
	}
	public void traverse(){
		LinkedListNode currentNode = head;
	    while(currentNode != null){
	    	System.out.print(currentNode.getData()+" -> ");
	    	currentNode =  currentNode.getNext();
	    }	
	}
	
	public synchronized void insertAtBegining(LinkedListNode node){
		node.setNext(head);
		head = node;
		size++;
	}
	
	public synchronized void insertAtEnd(LinkedListNode node){
		if(head == null){
			head = node;
		}else{
			LinkedListNode p,q;
			p = head;
			q = null;
			for(p=head; ((q=p.getNext()) != null); p=q);
			p.setNext(node);
		}
		size++;
	}
	
	public synchronized void insertAt(LinkedListNode node, int loc){
		if(loc > size){
			System.out.println("");
		}
	}
	public synchronized void insert(LinkedListNode node){
		insertAtEnd(node);
	}
	
	private boolean isPalindromUtil(LinkedListNode right){
		left = head;
		if(right == null)
			return true;
		
		boolean isPalindrom = isPalindromUtil(right.next);	
		
		if (!isPalindrom){
			return false;
		}
		boolean isPalindrom1 = (right.data == left.data);
		left = left.next;
		return isPalindrom1;
	} 
	
	public boolean isPalindrom(){
		return isPalindromUtil(head);
	}

	public boolean isLoopExist() {
		LinkedListNode slow, fast;
		slow = fast = head;
		while(slow != null && fast != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

	public void removeLoop() {
		LinkedListNode slow, fast, prev;
		prev =slow = fast = head;
		while(slow != null && fast != null && fast.next.next != null){
			prev = fast;
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				prev = prev.next;
				break;
			}
		}
		prev.next = null;
	}

	public static LinkedListNode mergeSort(LinkedListNode head) {
		
		if(head == null || head.next == null){
			return head;
		}
		LinkedListNode fast, slow;
		fast = slow = head;
		
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		LinkedListNode middleNode, nextOfMiddleNode;
		middleNode = slow;
		nextOfMiddleNode = slow.next;
		middleNode.next = null;
		LinkedListNode firstList = mergeSort(head);
		LinkedListNode secondList = mergeSort(nextOfMiddleNode);
		LinkedListNode headOfsortedList = mergeTwoListRecursive(firstList, secondList);
		return headOfsortedList;
	}

	private static LinkedListNode mergeTwoListRecursive(LinkedListNode firstList,
			LinkedListNode secondList) {
		if(firstList == null){
			return secondList;
		}else if(secondList == null){
			return firstList;
		}
		LinkedListNode result;
		if(firstList.data <= secondList.data){
			result = firstList;
			result.next = mergeTwoListRecursive(firstList.next, secondList);
		}else{
			result = secondList;
			result.next = mergeTwoListRecursive(firstList, secondList.next);
		}
		return result;
	} 
}
