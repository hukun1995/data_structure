package data_structure.model;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 基于数组实现的List
 * 已省略扩容等操作，可参考java-ArrayList实现逻辑
 */
public class ArrayStack<E> implements Stack<E>{

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 栈数据
     */
    private Object[] data;

    /**
     * 栈大小
     */
    private int size;

    public ArrayStack(){
        this.data = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    E getData(int index) {
        return (E) this.data[index];
    }

    @Override
    public boolean empty() {
        return this.size != 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void push(E e) {
        this.data[this.size++] = e;
    }

    @Override
    public E pop() {
        E oldValue = getData(this.size - 1);
        this.data[--this.size] = null;
        return oldValue;
    }

    @Override
    public E top() {
        return getData(this.size - 1);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Size: " + stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println(stack.top());
    }
}
