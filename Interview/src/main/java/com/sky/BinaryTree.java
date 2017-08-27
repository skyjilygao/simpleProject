package com.sky;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by SKYJILYGAO on 2017/8/27.
 * 先序／中序／后序 3种遍历需要在于输出value顺序不同
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
     * 递归：先序遍历
     * 遍历顺序：根左右
     * @param p
     */
    public void preOrderByRecursion(BinaryNode p){
        if(p != null){
            System.out.println(p.getValue());
            preOrderByRecursion(p.getLeftNode());
            preOrderByRecursion(p.getRightNode());
        }
    }

    /**
     * 递归：中序遍历
     * 遍历顺序：左根右
     * @param p
     */
    public void inOrderByRecursion(BinaryNode p){
        if(p != null){
            inOrderByRecursion(p.getLeftNode());
            System.out.println(p.getValue());
            inOrderByRecursion(p.getRightNode());
        }
    }

    /**
     * 递归：后序遍历
     * 遍历顺序：左右根
     * @param p
     */
    public void postOrderByRecursion(BinaryNode p){
        if(p != null){
            postOrderByRecursion(p.getLeftNode());
            postOrderByRecursion(p.getRightNode());
            System.out.println(p.getValue());
        }
    }

    /**
     * 非递归：前序遍历
     * 遍历顺序：根左右
     * @param p1
     */
    public void preOrderByNonRecursion(BinaryNode p1){
        LinkedStack<BinaryNode> stack = new LinkedStack<BinaryNode>();
        BinaryNode p = this.root;
        while(p!=null||!stack.isEmpty()){
            if(p!=null){
                System.out.print(p.getValue());
                stack.push(p);
                p = p.getLeftNode();
            }else{
                System.out.print("^ ");
                p = stack.pop();//返回当前栈顶的值。逐级向上返回根节点信息
                p = p.getRightNode();
            }
        }
    }

    /**
     * 非递归：中序遍历
     * 遍历顺序：左根右
     */
    public void inOrderByNonRecursion(){
        LinkedStack<BinaryNode> stack=new LinkedStack<BinaryNode>();
        BinaryNode p=this.root;
        while (p != null || !stack.isEmpty()){
//            if(p != null){
//                System.out.println(p.getValue());
//            }
            if(p != null){
                System.out.print("^ ");
                stack.push(p);
                p=p.getLeftNode();
            }else{
                p=stack.pop();
                System.out.print(p.getValue());
                p=p.getRightNode();
            }
        }
    }

    /**
     * 非递归：后序遍历
     * 遍历顺序：左右根
     */
    public void postOrderByNonRecuresion(){
        LinkedStack<BinaryNode> stack=new LinkedStack<BinaryNode>();
        LinkedStack<BinaryNode> output=new LinkedStack<BinaryNode>();
        BinaryNode p=this.root;
        while (p != null || !stack.isEmpty()){
            if(p != null){
                stack.push(p);
                output.push(p);//保存到待操作栈
                p=p.getRightNode();
            }else{
                output.push(new BinaryNode(null));//将null入待操作栈
                p=stack.pop();
                p=p.getLeftNode();
            }
        }

        //依次出栈
        while (!output.isEmpty()){
            BinaryNode node=output.pop();
            if(node.getValue()==null){
                System.out.print("^");
            }else{
                System.out.print(node.getValue());
            }
        }
    }

    /**
     * mian，主函数，程序入口。
     * @param args
     */
    public static void main(String[] args){
        BinaryTree tree=new BinaryTree();
        BinaryNode b=tree.generateTree(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 });
        System.out.println(b.toString());
        //递归遍历
//        System.out.println("递归-前序遍历：");
//        tree.preOrderByRecursion(b);
//        System.out.println("递归-中序遍历：");
//        tree.inOrderByRecursion(b);
//        System.out.println("递归-后序遍历：");
//        tree.postOrderByRecursion(b);
        System.out.println("非递归-先序遍历：");
        tree.preOrderByNonRecursion(b);
        System.out.println("\n非递归-中序遍历：");
        tree.inOrderByNonRecursion();
        System.out.println("\n非递归-后序遍历：");
        tree.postOrderByNonRecuresion();
//        tree.postorderTraverse();
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

/**
 * 保存二叉树中的数据
 * @param <E>
 */
class LinkNode<E> {
    /**
     * 表示存储在节点中的数据项
     */
    private E data;

    private LinkNode<E> next;

    public LinkNode(E data) {
        this.data = data;
        this.next = null;
    }

    public LinkNode(E data, LinkNode next) {
        this.data = data;
        this.next = next;

    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public LinkNode<E> getNext() {
        return next;
    }

    public void setNext(LinkNode<E> next) {
        this.next = next;
    }

}

/**
 * 链表栈
 * 存储二叉树值
 * @param <E>
 */
class LinkedStack<E> extends Stack<E> {
    // 表示链表的头结点
    private LinkNode<E> top;

    // 表示链表中当前的元素个数
    private int size;

    public LinkedStack() {
        this.top = null;
        size = 0;

    }

    public boolean isEmpty() {
        return top == null;
    }

    public E pop() {
        if (isEmpty()) {

            throw new RuntimeException("链表为空!!");
        }
        // 将栈顶元素的值保存起来
        E tempData = top.getData();
        // 然后出栈，次栈顶元素成为新的栈顶元素
        top = top.getNext();
        // 栈中元素个数减少一
        size--;
        return tempData;
    }

    public E push(E target) {
        if(target==null){
            throw new RuntimeException("不能往栈中加入null元素");

        }
        LinkNode<E> newNode = new LinkNode<E>(target);
        if (isEmpty()) {
            top = newNode;
        } else {
            //新加入的节点放入栈中,并指向原来的top节点
            newNode.setNext(top);
            // 新加入的元素成为了新的栈顶
            top = newNode;
        }
        size++;
        return target;
    }

    public int size() {
        return size;
    }

    public E top() {
        if (isEmpty()) {

            throw new RuntimeException("链表为空!!");
        }
        return top.getData();
    }

}