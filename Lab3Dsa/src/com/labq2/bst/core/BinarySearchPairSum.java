package com.labq2.bst.core;

import java.util.HashSet;
import java.util.Set;

class Node{
	int key;
	Node left,right;
	
	public Node(int key) {
		this.key=key;
		left=right=null;
	}
}
public class BinarySearchPairSum {
	Node root;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchPairSum tree= new BinarySearchPairSum();
		//inserting nodes
		tree.root=tree.insert(tree.root,40);
		tree.insert(tree.root,20);
		tree.insert(tree.root,60);
		tree.insert(tree.root,10);
		tree.insert(tree.root,30);
		tree.insert(tree.root,50);
		tree.insert(tree.root,70);
		System.out.println("Inorder Traverse: ");
		tree.inOrderTraverse(tree.root);
		System.out.println();
		
		int sum=130; //as given in the question 
		tree.findPairWithGivenSum(tree.root, sum);
		//tree.findPairWithGivenSum(tree.root, 37); //for this pair doesn't exist 
		
	}
	private void findPairWithGivenSum(Node root, int sum) {
		Set<Integer> set= new HashSet<>();
		if(!findPairUtil(root,sum,set)) {
			System.out.print("pairs doesn't exist" + "\n");
		}
	}
	private boolean findPairUtil(Node node, int sum, Set<Integer> set) {
		if(node==null) {
			return false;
		}
		if(findPairUtil(node.left,sum,set))
			return true;
		int diff=sum-node.key;  //taking difference and checking 
		if(set.contains(diff)) {
			System.out.println("Given pair (" + node.key + "," + diff + ")");
		    return true;
		}else {
			set.add(node.key);
		}
		return findPairUtil(node.right, sum, set);
		    
	}
	
	private void inOrderTraverse(Node node) {
		if(node==null) {
			return;
		}
		inOrderTraverse(node.left);
		System.out.print(node.key + " ");
		inOrderTraverse(node.right);
	}
	
	//insert nodes using utility function
	private Node insert(Node node, int key) {
		//check if the tree is empty ,then return a new node
		if(node==null) {
			node=new Node(key);
			return node;
		}
		//otherwise insert in left and right subtree of tree
		if(key<node.key) {
			node.left=insert(node.left,key);
		}else if(key>node.key) {
			node.right = insert (node.right,key);
		}
		return node;
	}
	

}
