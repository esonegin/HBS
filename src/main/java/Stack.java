
import java.util.*;

//v1
public class Stack<T> {
    public ArrayList<T> array;
    Class clazz;

    public Stack(Class clz) {
        // инициализация внутреннего хранилища стека
        clazz = clz; // нужен для безопасного приведения типов
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
        return result;  // если стек пустой
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
        // ваш код
        if (array.size() > 0) {
            result = array.get(0);
        } else {
            result = null;
        }
        return result; // если стек пустой
    }
}