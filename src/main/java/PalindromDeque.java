

public class PalindromDeque<T> {

    Deque<T> deque;

    public Boolean PalindromDeque(String stroka) {
        deque = new Deque<T>();
        for (int i = 0; i < stroka.length(); i++) {
            deque.addFront((T) stroka.substring(i, i + 1));
        }
        for (int i = 0; i < stroka.length() / 2; i++) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                return false;
            }
        }
        return true;
    }

}
