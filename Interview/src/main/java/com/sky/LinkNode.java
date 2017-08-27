package com.sky;

public class LinkNode<E> {
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