package com.sky.oxcoder;

import java.util.LinkedList;
import java.util.Stack;

public class MirrorBinaryTreeNonRecursion {
    private BinaryTreeNode<Integer> root;

	public MirrorBinaryTreeNonRecursion() {
		root = new BinaryTreeNode<Integer>();
	}

	public MirrorBinaryTreeNonRecursion(int[] values) {
		System.out.print("构造二叉树:");
		for (int i : values) {
			System.out.print(i);
		}
		System.out.println();
		boolean isLeft = true;
		int length = values.length;
		if (length == 0)
			return;
		LinkedList<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		root = new BinaryTreeNode<Integer>(values[0]);
		queue.addLast(root);
		BinaryTreeNode parent = null;
		BinaryTreeNode current = null;
		for (int i = 1; i < length; i++) {
			current = new BinaryTreeNode<Integer>(values[i]);
			queue.addLast(current);
			if (isLeft)
				parent = queue.getFirst();
			else
				parent = queue.removeFirst();
			if (isLeft) {
				parent.setLeftChild(current);
				isLeft = false;
			} else {
				parent.setRightChild(current);
				isLeft = true;
			}
		}
	}

	public void mirrorNonRecursion() {
		System.out.print("二叉树非递归镜像:");
		mirrorNonRecursionExecute(root);
		System.out.println();
	}

	private static void mirrorNonRecursionExecute(BinaryTreeNode node) {
		if (node == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		stack.add(node);
		//No.1
		//开始写代码，非递归方法实现二叉树镜面对称并以先序遍历顺序输出  www.oxcoder.com
		while(!stack.empty())
        {
			BinaryTreeNode node1=stack.pop();
            if(node1.getRightChild()!=null)
            {
                stack.push(node1.getRightChild());
            }
            if(node1.getLeftChild()!=null)
            {
                stack.push(node1.getLeftChild());
            }
        }
		//end_code
	}

	public static void swapChild(BinaryTreeNode node) {
		BinaryTreeNode left = node.getLeftChild();
		node.setLeftChild(node.getRightChild());
		node.setRightChild(left);
	}

	public static void main(String[] args) {
		MirrorBinaryTreeNonRecursion mirrorBinaryTreeNonRecursion = new MirrorBinaryTreeNonRecursion(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
		mirrorBinaryTreeNonRecursion.mirrorNonRecursion();
	}

}

class BinaryTreeNode<value> {
	private value value;
	private BinaryTreeNode<value> leftChild;
	private BinaryTreeNode<value> rightChild;

	public BinaryTreeNode() {
	};

	public BinaryTreeNode(value value) {
		this.value = value;
		leftChild = null;
		rightChild = null;
	}

	public void setLeftChild(BinaryTreeNode<value> leftNode) {
		this.leftChild = leftNode;
	}

	public void setRightChild(BinaryTreeNode<value> rightNode) {
		this.rightChild = rightNode;
	}

	public value getValue() {
		return value;
	}

	public void setValue(value value) {
		this.value = value;
	}

	public BinaryTreeNode<value> getLeftChild() {
		return leftChild;
	}

	public BinaryTreeNode<value> getRightChild() {
		return rightChild;
	}
}