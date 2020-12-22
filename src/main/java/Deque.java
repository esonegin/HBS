import java.util.*;

public class Deque<T> {

    QueueThroughStack1<T> deque;

    public Deque() {
        deque = new QueueThroughStack1<>();
    }

    public void addFront(T item) {
        QueueThroughStack1<T> deque2 = new QueueThroughStack1<T>();
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

class QueueThroughStack1<T> {

    Stack<T> stack1;
    Stack<T> stack2;

    public QueueThroughStack1() {
        // инициализация внутреннего хранилища очереди
        stack1 = new Stack<T>();

    }

    //Добавление элемента в очередь
    public void enqueue(Object item) {
        stack1.push((T) item);
    }

    //Удаление элемента из очереди
    public T dequeue() {
        stack2 = new Stack<T>();
        while (stack1.size() > 1) {
            if (stack2.size() == 0) {
                stack2.push(stack1.pop());
            } else if (stack2.size() > 0) {
                T k = stack2.pop();
                stack2.push(stack1.pop());
                stack2.push(k);
            }
        }
        T j = stack1.pop();
        stack1 = stack2;
        return j;
    }

    public int size() {
        // размер очереди
        return stack1.size();
    }
}