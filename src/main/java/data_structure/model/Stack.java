package data_structure.model;

import java.util.LinkedList;

/**
 * stack接口
 */
public interface Stack<E> {
    // 判断是否为空
    boolean isEmpty();

    // 取size
    int size();

    // 入栈
    void push(E e);

    // 出栈
    E pop();

    // 取栈顶
    E top();
}
