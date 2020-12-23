
public class QueueThroughStack<T> {

    Stack<T> stack1;
    Stack<T> stack2;

    public QueueThroughStack() {
        // инициализация внутреннего хранилища очереди
        stack1 = new Stack<T>();

    }

    //Добавление элемента в очередь
    public void enqueue(T item) {
        stack1.push(item);
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
