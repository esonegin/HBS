

public class PalindromDeque<T> {

    Deque<T> deque;

    public Boolean PalindromDeque(String str) {
        deque = new Deque<T>();
        //Кладем строку в очередь
        for (int i = 0; i < str.length(); i++) {
            deque.addFront((T) str.substring(i, i + 1));
        }

        //
        for (int i = 0; i < str.length() / 2; i++) {
            if (!deque.removeFront().equals(deque.removeTail())) {
                return false;
            }
        }
        return true;
    }

}
