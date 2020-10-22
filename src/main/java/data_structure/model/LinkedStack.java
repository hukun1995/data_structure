package data_structure.model;


/**
 * 链式结构栈
 * @param <E>
 */
public class LinkedStack<E> implements Stack<E>{

    /**
     * 堆栈尺寸
     */
    private int size;

    /**
     * 栈顶
     */
    private Node<E> top;

    public LinkedStack(){
        this.size = 0;
    }

    @Override
    public boolean isEmpty(){
        return this.top == null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void push(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = this.top;
        this.top = newNode;
        this.size++;
    }

    @Override
    public E pop() {
        E element = this.top.item;
        this.top = this.top.next;
        this.size--;
        return element;
    }

    @Override
    public E top() {
        return this.top.item;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        public Node(E e) {
            this.item = e;
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new LinkedStack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Size: " + stack.size());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println("Size: " + stack.size());
        System.out.println(stack.top());
    }
}
