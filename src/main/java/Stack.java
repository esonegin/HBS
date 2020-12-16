import java.util.*;

//v3
public class Stack<T> {

    ArrayList<T> array;

    public Stack() {
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

    public Boolean brackets(String stroka, Stack<T> arrayList) {
        Boolean result = true;
        int count = 0;

        for (int i = 0; i < stroka.length(); i++) {
            array.add((T) stroka.split("")[i]);
        }

        while (arrayList.size() > 0) {
            if (count == -1) {
                break;
            } else if (arrayList.peek().equals("(")) {
                count += 1;

            } else if (arrayList.peek().equals(")")) {
                count -= 1;
            }
            arrayList.pop();
        }
        if (count != 0 || count < 0) {
            result = false;
        }
        return result;
    }
}