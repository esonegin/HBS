import java.util.*;

public class Queue<T> {
    ArrayList<T> array;

    //Реализация очереди на основе ArrayList
    public Queue() {
        array = new ArrayList<>();
    }

    //Вставляет значение в хвост смещая уже имеющиеся
    public void enqueue(Object item) {
        if (array.size() == 0) {
            array.add((T) item);
        } else {
            array.add((T) item);
            int j = array.size();
            for (int i = 1; i < j; i++) {
                array.set(array.size() - i, array.get(array.size() - i - 1));
            }
            array.set(0, (T) item);
        }
    }

    //Удаляет значение из головы
    public T dequeue() {
        T result;
        if (array.size() > 0) {
            result = array.get(array.size() - 1);
            array.remove(array.size() - 1);
        } else {
            result = null;
        }
        return result;
    }

    public int size() {
        return array.size();
    }

}