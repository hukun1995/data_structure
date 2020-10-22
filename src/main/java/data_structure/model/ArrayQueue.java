package data_structure.model;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.IntStream;

/**
 * 基于数组实现的循环顺序队列
 * 不考虑扩容，队列满则不允许数据进队列
 */
@Slf4j
public class ArrayQueue<E> implements Queue<E>{
    /**
     * Default initial capacity.
     */
    private static final int MAX_SIZE = 10;

    /**
     * 栈数据
     */
    private Object[] data;

    /**
     * 队首
     */
    private int head;

    /**
     * 队尾
     */
    private int tail;

    public ArrayQueue(){
        this.data = new Object[MAX_SIZE];
        this.head = 0;
        this.tail = 0;
    }

    @SuppressWarnings("unchecked")
    E getData(int index) {
        return (E) this.data[index];
    }

    @Override
    public boolean isEmpty() {
        return this.head == this.tail;
    }

    /**
     * 判断是否满列
     */
    public boolean isFull(){
        return (this.tail + 1) % MAX_SIZE == this.head;
    }


    @Override
    public E front() {
        return getData(this.head);
    }

    @Override
    public int size() {
        return (this.tail - this.head + MAX_SIZE) % MAX_SIZE;
    }

    @Override
    public void enQueue(E e) {
        if (isFull()){
            log.info("queue is full");
            return;
        }

        this.data[this.tail] = e;
        this.tail = (this.tail + 1) % MAX_SIZE;
    }

    @Override
    public E deQueue() {
        E oldValue = getData(this.head);
        this.data[this.head] = null;
        this.head = (this.head + 1) % MAX_SIZE;
        return oldValue;
    }

    @Override
    public void removeAll() {
        while (!isEmpty()){
            deQueue();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayQueue<>();
        System.out.println("isEmpty: " + queue.isEmpty());
        IntStream.range(0, 11).forEach(queue::enQueue);
        System.out.println("Size: " + queue.size());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(100);
        queue.enQueue(101);
    }
}
