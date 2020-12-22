import java.util.*;

public class Deque<T> {

    QueueThroughStack<T> deque;

    public Deque() {
        deque = new QueueThroughStack<>();
    }

    public void addFront(T item) {
        QueueThroughStack<T> deque2 = new QueueThroughStack<T>();
        deque2.enqueue(item);
        while (deque.stack1.size() > 0) {
            deque2.stack1.push(deque.dequeue());
        }
        deque = deque2;

    }

    public void addTail(T item) {
        deque.enqueue(item);
    }

    public T removeFront() {
        return deque.dequeue();
    }

    public T removeTail() {
        return deque.stack1.pop();
    }

    public int size() {
        return deque.size();
    }
}