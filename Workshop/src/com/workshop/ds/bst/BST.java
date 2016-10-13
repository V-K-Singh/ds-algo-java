package com.workshop.ds.bst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

import com.workshop.ds.linkedlist.DoublyCircularLinkedList;
import com.workshop.ds.linkedlist.DoublyCircularLinkedListNode;

public class BST {
	BSTNode root;

	public void insert(int data) {
		root = insertRec(root, data);
	}

	private BSTNode insertRec(BSTNode node, int data) {
		if (node == null) {
			node = new BSTNode(data);
			return node;
		} else {
			if (data < node.data) {
				node.left = insertRec(node.left, data);
				node.getLeft().setParent(node);
				
			} else {
				node.right = insertRec(node.right, data);
				node.getRight().setParent(node);
			}
		}
		return node;
	}

	public void traverseInorder() {
		traverseInorderRec(root);
	}

	private void traverseInorderRec(BSTNode root) {
		if (root != null) {
			traverseInorderRec(root.left);
			System.out.print(root.data + " ");
			traverseInorderRec(root.right);
		}
	}

	public void traverseZigzagLevelOrder() {
		if (null == root) {
			System.out.println("Empty tree!!");
			return;
		}

		Stack<BSTNode> printBuffer = new Stack<>();
		Stack<BSTNode> children = new Stack<>();
		printBuffer.push(root);
		int k = -1; // For Reverse level traversal initialize k with 1
		while (!printBuffer.isEmpty()) {
			BSTNode aNode = printBuffer.pop();
			System.out.print(aNode.data + " ");
			if (k == -1) {

				if (aNode.right != null) {
					children.push(aNode.right);
				}
				if (aNode.left != null) {
					children.push(aNode.left);
				}
			} else {
				if (aNode.left != null) {
					children.push(aNode.left);
				}
				if (aNode.right != null) {
					children.push(aNode.right);
				}
			}
			if (printBuffer.isEmpty() && !children.isEmpty()) {
				printBuffer.addAll(children);
				children.clear();
				k = k * -1;
			}
		}
	}

	public boolean isBST() {
		return isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBSTRec(BSTNode node, int minValue, int maxValue) {
		if (node == null) {
			return true;
		}
		if (node.data < minValue || node.data > maxValue) {
			return false;
		}
		// System.out.println("Min: "+minValue+" Data: "+node.data+" Max: "+maxValue);
		return (isBSTRec(node.left, minValue, node.data - 1) && isBSTRec(
				node.right, node.data + 1, maxValue));
	}

	/*
	 * public void serialize() {
	 * 
	 * if (null == root) { System.out.println("Empty tree!!"); return; } try
	 * (PrintWriter writer = new PrintWriter("DormentTree.txt", "UTF-8")) {
	 * Queue<BSTNode> printBuffer = new LinkedList<>(); List<BSTNode> children =
	 * new LinkedList<>(); printBuffer.add(root); while (!printBuffer.isEmpty())
	 * { BSTNode aNode = printBuffer.remove(); writer.print(aNode.data + ",");
	 * if (aNode.left != null) { children.add(aNode.left); }else{
	 * writer.print(Integer.MIN_VALUE+","); } if (aNode.right != null) {
	 * children.add(aNode.right); }else{ writer.print(Integer.MIN_VALUE+","); }
	 * if (printBuffer.isEmpty() && !children.isEmpty()) { for (BSTNode node :
	 * children) { printBuffer.add(node); } children.clear(); } } } catch
	 * (Exception e) { // TODO: handle exception e.printStackTrace(); }
	 * 
	 * }
	 */

	public void serialize() {

		if (null == root) {
			System.out.println("Empty tree!!");
			return;
		}

		try (PrintWriter writer = new PrintWriter("DormentTree.txt", "UTF-8")) {
			traversePreorder(root, writer);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void traversePreorder(BSTNode root, PrintWriter writer) {
		if (root == null) {
			writer.print(Integer.MIN_VALUE + ",");
			return;
		}
		writer.print(root.data + ",");
		traversePreorder(root.left, writer);
		traversePreorder(root.right, writer);
	}

	public void traverseLevelOrder() {
		if (null == root) {
			System.out.println("Empty tree!!");
			return;
		}

		Queue<BSTNode> printBuffer = new LinkedList<>();
		List<BSTNode> children = new LinkedList<>();
		printBuffer.add(root);
		while (!printBuffer.isEmpty()) {
			BSTNode aNode = printBuffer.remove();
			System.out.print(aNode.data + " ");

			if (aNode.left != null) {
				children.add(aNode.left);
			}
			if (aNode.right != null) {
				children.add(aNode.right);
			}
			if (printBuffer.isEmpty() && !children.isEmpty()) {
				for (BSTNode node : children) {
					printBuffer.add(node);
				}
				children.clear();
			}
		}
	}

	public BST deserialize() {
		BufferedReader br = null;
		BST deserializedBst = null;
		try {
			br = new BufferedReader(new FileReader("DormentTree.txt"));
			String treeString = br.readLine();
			String[] treeNodes;
			StringTokenizer st = null;
			if (treeString == null || "".equals(treeString)) {
				System.out.println("Deserialize source not found.");
				return null;
			} else {
				st = new StringTokenizer(treeString, ",");
			}
//			BST deserializedBST = 
			BSTNode root = deserializeRec(st);
			
			deserializedBst = new BST();
			deserializedBst.root = root;
			
		} catch (Exception e) {
		}
		return deserializedBst;
	}

	private BSTNode deserializeRec(StringTokenizer st) {
		if (!st.hasMoreTokens())
	        return null;
	    String val = st.nextToken();
	    if (Integer.parseInt(val) == Integer.MIN_VALUE)
	        return null;
		BSTNode root = new BSTNode(Integer.parseInt(val));
		root.left = deserializeRec(st);
		root.right = deserializeRec(st);
		return root;
	}

	public int diameter() {
		int diameter = diameter(root);
		return diameter;
	}

	private int diameter(BSTNode root) {
		if(null == root){
			return 0;
		}else{
			int leftSubtreeHeight = height(root.left);
			int rightSubtreeHeight = height(root.right);
			
			int leftSubtreeDiameter = diameter(root.left);
			int rightSubtreeDiameter = diameter(root.right);
			return Math.max(leftSubtreeHeight + rightSubtreeHeight + 1, Math.max(leftSubtreeDiameter, rightSubtreeDiameter));
		}
	}

	private int height(BSTNode root) {
		if(null == root){
			return 0;
		}
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public BSTNode getLeastCommonAncestor(BSTNode left, BSTNode right) {
		if(root == null){
			return null;
		}else if(left == root || right  == root){
			return root;
		}else{
			List ancestors = new ArrayList<BSTNode>();
			while (left != null){
				ancestors.add(left);
				left = left.getParent();
			}
			
			while(right != null){
				if(ancestors.contains(right)){
					return right;	
				}
				right = right.getParent();
			}
			return null;
		}
		
	}

	public DoublyCircularLinkedList convartToDCL() {
		if (root == null){
			System.out.println("Tree is null!!");
			return null;
		}
		DoublyCircularLinkedList dcl = new DoublyCircularLinkedList();
		convartToDCLRec(root,dcl);
		return dcl;
	}

	private void convartToDCLRec(BSTNode root, DoublyCircularLinkedList dcl) {
		if(root != null){
			convartToDCLRec(root.left,dcl);
			dcl.insert(new DoublyCircularLinkedListNode(root.data));
			convartToDCLRec(root.right,dcl);
		}
		
	}
}
