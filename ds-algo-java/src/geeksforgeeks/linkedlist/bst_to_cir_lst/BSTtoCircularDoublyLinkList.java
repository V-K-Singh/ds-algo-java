package geeksforgeeks.linkedlist.bst_to_cir_lst;

import java.util.Scanner;
import java.util.TreeSet;

public class BSTtoCircularDoublyLinkList {

	public static void main(String[] args) {

		Scanner sc =new Scanner(System.in);
		
		BinaryTreeNode root=new BinaryTreeNode();
		BinaryTreeNode left;
		BinaryTreeNode right;
		
		root.setData(Integer.parseInt(sc.next()));
		
		while(sc.hasNext()){
			
			left=new BinaryTreeNode();
			left.setData(Integer.parseInt(sc.next()));
			
			right=new BinaryTreeNode();
			right.setData(Integer.parseInt(sc.next()));
			
			
			
		}
	}

}
