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

    Stack1<T> stack1;
    Stack1<T> stack2;

    public QueueThroughStack1() {
        // инициализация внутреннего хранилища очереди
        stack1 = new Stack1<T>();

    }

    //Добавление элемента в очередь
    public void enqueue(Object item) {
        stack1.push((T) item);
    }

    //Удаление элемента из очереди
    public T dequeue() {
        stack2 = new Stack1<T>();
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

class Stack1<T> {

    ArrayList<T> array;

    public Stack1() {
        array = new ArrayList<>();
    }

    public int size() {
        return array.size();
    }

    public T pop() {
        T result;
        if (array.size() > 0) {
            result = array.get(0);
            array.remove(result);
        } else {
            result = null;
        }
        return result;
    }

    public void push(Object val) {
        //
        if (array.size() == 0) {
            array.add((T) val);
        } else {
            array.add((T) val);
            int j = array.size();
            for (int i = 1; i < j; i++) {
                array.set(array.size() - i, array.get(array.size() - i - 1));
            }
            array.set(0, (T) val);
        }
    }

    public T peek() {
        T result;
        if (array.size() > 0) {
            result = array.get(0);
        } else {
            result = null;
        }
        return result;
    }
}