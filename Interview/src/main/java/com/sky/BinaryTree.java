package com.sky;

import java.util.LinkedList;

/**
 * Created by SKYJILYGAO on 2017/8/27.
 * 前序／中序／后序 3种遍历需要在于输出value顺序不同
 */
public class BinaryTree {
    public BinaryNode root;

    /**
     * 生成二叉树
     * @param values
     * @return
     */
    public BinaryNode generateTree(int[] values){
        if(values==null || values.length==0){
            return null;
        }
        root=new BinaryNode(values[0]);
        boolean isLeft=true;
        LinkedList<BinaryNode<Integer>> queue=new LinkedList<BinaryNode<Integer>>();
        queue.addLast(root);
        BinaryNode parent=null;
        BinaryNode current=null;
        for(int i=1;i<values.length;i++){
            current=new BinaryNode(values[i]);
            queue.addLast(current);
            if(isLeft){
                parent=queue.getFirst();
            }else{
                parent=queue.removeFirst();
            }
            if(isLeft) {
                parent.setLeftNode(current);
                isLeft=false;
            }else {
                parent.setRightNode(current);
                isLeft=true;
            }
        }
        return this.root;
    }

    /**
     * 递归：前序遍历
     * 遍历顺序：根左右
     * @param p
     */
    public void preOrder(BinaryNode p){
        if(p != null){
            System.out.println(p.getValue());
            preOrder(p.getLeftNode());
            preOrder(p.getRightNode());
        }
    }

    /**
     * 递归：中序遍历
     * 遍历顺序：左根右
     * @param p
     */
    public void inOrder(BinaryNode p){
        if(p != null){
            inOrder(p.getLeftNode());
            System.out.println(p.getValue());
            inOrder(p.getRightNode());
        }
    }

    /**
     * 递归：后序遍历
     * 遍历顺序：左右根
     * @param p
     */
    public void postOrder(BinaryNode p){
        if(p != null){
            postOrder(p.getLeftNode());
            postOrder(p.getRightNode());
            System.out.println(p.getValue());
        }
    }

    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        BinaryNode b=tree.generateTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        System.out.println(b.toString());
        //递归遍历
        System.out.println("递归-前序遍历：");
        tree.preOrder(b);
        System.out.println("递归-中序遍历：");
        tree.inOrder(b);
        System.out.println("递归-后序遍历：");
        tree.postOrder(b);
    }
}

/**
 * 定义二叉树结构
 * @param <T>
 */
class BinaryNode<T>{
    private T value;
    private BinaryNode leftNode;
    private BinaryNode rightNode;

    public BinaryNode(T value){
        this.value=value;
        leftNode=null;
        rightNode=null;

    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public String toString() {
        return "BinaryNode{" +
                "value=" + value +
                ", leftNode=" + leftNode +
                ", rightNode=" + rightNode +
                '}';
    }
}