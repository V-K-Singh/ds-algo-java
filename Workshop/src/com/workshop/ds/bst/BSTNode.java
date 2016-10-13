package com.workshop.ds.bst;

public class BSTNode {
	BSTNode left;
	int data;
	BSTNode right;
	private BSTNode parent;
	public BSTNode(int data){
		this.left = null;
		this.data = data;
		this.right = null;
		this.setParent(null);
	}
	public BSTNode getLeft() {
		return left;
	}
	public void setLeft(BSTNode left) {
		this.left = left;
	}
	public Object getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BSTNode getRight() {
		return right;
	}
	public void setRight(BSTNode right) {
		this.right = right;
	}
	public BSTNode getParent() {
		return parent;
	}
	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	
}
