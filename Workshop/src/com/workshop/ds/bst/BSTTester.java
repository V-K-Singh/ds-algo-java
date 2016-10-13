package com.workshop.ds.bst;

import com.workshop.ds.linkedlist.DoublyCircularLinkedList;
import com.workshop.ds.linkedlist.DoublyCircularLinkedListNode;

public class BSTTester {
	public static void main(String[] args) {
		/*
		 *             1
		 *           /   \
		 *          /     \
		 *        -5      10
		 *          \     /\
		 *           \   /  \
		 *            0 6    25
		 *                     \
		 *                      \
		 *                      100
		 *           
		 *          
		 *          
		 *       
		 *      
		 *     
		 *    
		 *   
		 *                   
		 *    Serialized: 1,-5,MIN,0,MIN,MIN,10,6,MIN,MIN,25,MIN,100,MIN,MIN,
		 *               [0, 1, 2 , 3, 4, 5 ,6, 7 , 8 ,9,10 ,11 , 12,13 , 14]     
		 *               
		 */
		BST bst =  new BST();
		bst.insert(1);
		bst.insert(10);
		bst.insert(6);
		bst.insert(-5);
		bst.insert(0);
		bst.insert(25);
		bst.insert(100);
		// To check diameter.
		bst.insert(5);
		bst.insert(4);
		bst.insert(3);
		bst.insert(2);
		bst.insert(200);
		bst.insert(300);
		bst.insert(400);
		
		System.out.print("\nIs BST: "+ bst.isBST());
		System.out.print("\nInorder Traversal: ");
		bst.traverseInorder();
		System.out.print("\nZigzag Level Traversal: ");
		bst.traverseZigzagLevelOrder();
		System.out.print("\nLevel Order Traversal: ");
		bst.traverseLevelOrder();
		System.out.print("\nInorder Traversal: ");
		bst.traverseInorder();
		bst.serialize();
		BST deserializedBst = bst.deserialize();
		System.out.print("\nPrinting deseriallized tree..");
		System.out.print("\nInorder Traversal: ");
		deserializedBst.traverseInorder();
		System.out.print("\nDiameter of tree is: "+bst.diameter());
		BSTNode lca = bst.getLeastCommonAncestor(bst.root.getRight().getLeft(),bst.root.getRight().getRight().getRight());
		System.out.print("\nLeast Common Ancestor of 6 and 100 : "+lca.getData());
		
		/* Convert Binary tree (or BST) to Doubly Circular Linked List */
		DoublyCircularLinkedList dcl = bst.convartToDCL();
		dcl.traverse();
	}
}
