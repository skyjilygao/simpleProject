package com.sky;

import java.util.Stack;

public class LinkedStack<E> extends Stack<E> {
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