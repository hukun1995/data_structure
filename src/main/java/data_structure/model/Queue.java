package data_structure.model;

/**
 * queue接口
 */
public interface Queue<E> {
    // 判断是否为空
    boolean isEmpty();

    // 获取队列第一个数据
    E front();

    // 队列的长度
    int size();

    // 数据进队列
    void enQueue(E e);

    // 数据出队列
    E deQueue();

    // 清空队列内的所有数据
    void removeAll();
}
