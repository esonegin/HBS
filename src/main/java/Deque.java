import java.util.*;

public class Deque<T> {

    ArrayList<T> deque;

    public Deque() {
        deque = new ArrayList<>();
    }

    public void addFront(T item) {
        //Создаем второй список
        deque.add(item);
    }

    public void addTail(T item) {
        deque.add(item);
        for (int i = 1; i < deque.size(); i++) {
            deque.set(deque.size() - i, deque.get(deque.size() - (i + 1)));
        }
        deque.set(0, item);

    }


    public T removeFront() {
        if(deque.size() == 0){
            return null;
        }
        return deque.remove(deque.size() - 1);
    }

    public T removeTail() {
        if(deque.size() == 0){
            return null;
        }
        return deque.remove(0);
    }

    public int size() {
        return deque.size();
    }
}
