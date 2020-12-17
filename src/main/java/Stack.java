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

    public Boolean brackets(String stroka) {
        array.clear();
        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == '(') {
                array.add((T) "(");
                continue;
            } else if (array.size() == 0) {
                return false;
            } else {
                array.remove(array.size() - 1);
            }
        }
        if (array.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public Integer postfix(Stack<T> arrayList1) {
        Stack<T> arrayList2 = new Stack<T>();
        for (int i = 0; arrayList1.size() > 0; i++) {
            if (arrayList1.peek() instanceof Integer) {
                arrayList2.push(arrayList1.pop());
            } else if (arrayList1.peek() == "+") {
                arrayList2.push((Integer) arrayList2.pop() + (Integer) arrayList2.pop());
                arrayList1.pop();
            } else if (arrayList1.peek() == "-") {
                arrayList2.push((Integer) arrayList2.pop() - (Integer) arrayList2.pop());
                arrayList1.pop();
            } else if (arrayList1.peek() == "*") {
                arrayList2.push((Integer) arrayList2.pop() * (Integer) arrayList2.pop());
                arrayList1.pop();
            } else if (arrayList1.peek() == "/") {
                arrayList2.push((Integer) arrayList2.pop() / (Integer) arrayList2.pop());
                arrayList1.pop();
            } else if (arrayList1.peek() == "=") {
                break;
            }
        }
        return (Integer) arrayList2.peek();
    }
}