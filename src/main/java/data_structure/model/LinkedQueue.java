package data_structure.model;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * 链式结构栈
 * @param <E>
 */
@Slf4j
public class LinkedQueue<E> implements Queue<E>{
    /**
     * 队列尺寸
     */
    private int size;

    /**
     * 队首
     */
    private Node<E> head;

    /**
     * 队尾
     */
    private Node<E> tail;

    public LinkedQueue(){
        this.size = 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public E front() {
        return this.head.item;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void enQueue(E e) {
        Node<E> newData = new Node<>(e);
        // 第一个数据, 直接初始化新队首, 队尾
        if(this.head == null){
            this.head = newData;
            this.tail = newData;
        }

        // 更新队尾
        this.tail.next = newData;
        this.tail = newData;
        this.size ++;
    }

    @Override
    public E deQueue() {
        if(isEmpty()){
            log.info("queue is empty !");
            return null;
        }
        E value = this.head.item;
        this.head = this.head.next;
        this.size --;
        return value;
    }

    @Override
    public void removeAll() {
        this.head = null;
        this.tail =null;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E e) {
            this.item = e;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedQueue<>();
        System.out.println("isEmpty: " + queue.isEmpty());
        IntStream.range(0, 11).forEach(queue::enQueue);
        System.out.println("Size: " + queue.size());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(100);
        queue.enQueue(101);
    }
}
