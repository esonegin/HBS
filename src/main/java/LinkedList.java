import java.util.*;

//v3
public class LinkedList {

    public Node0 head;
    public Node0 tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node0 item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node0 find(int value) {
        Node0 Node0 = this.head;
        while (Node0 != null) {
            if (Node0.value == value)
                return Node0;
            Node0 = Node0.next;
        }
        return null;
    }

    public ArrayList<Node0> findAll(int _value) {
        ArrayList<Node0> Node0s = new ArrayList<>();
        Node0 Node0 = this.head;
        while (Node0 != null) {
            if (Node0.value == _value)
                Node0s.add(Node0);
            Node0 = Node0.next;
        }
        return Node0s;
    }

    public boolean remove(int _value) {
        Node0 Node0 = this.head;
        //Если список пустой
        if (Node0 == null) {
            return false;
        }
        //Если один элемент
        if (Node0.value == _value && Node0.next == null) {
            Node0 = null;
            this.head = null;
            this.tail = null;
        }
        //Если спиcок не пустой
        while (Node0 != null) {
            if (head.value == _value) {
                head.value = Node0.next.value;
                Node0.next = Node0.next.next;
                break;
            } else if (Node0.next.value == _value && Node0.next.next != null) {
                Node0.next.value = Node0.next.next.value;
                Node0.next.next.value = _value;
            } else if (Node0.next.value == _value && Node0.next.next == null) {
                this.tail.value = Node0.value;
                Node0.next = null;
            }
            Node0 = Node0.next;
        }
        return true;
    }

    public void removeAll(int _value) {
        while (find(_value) != null) {
            remove(_value);
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int count = 0;
        Node0 Node0 = this.head;
        while (Node0 != null) {
            count++;
            Node0 = Node0.next;
        }
        return count;
    }

    public void insertAfter(Node0 _Node0After, Node0 _Node0ToInsert) {
        if (_Node0After != null) {
            _Node0ToInsert.next = find(_Node0After.value).next;
            find(_Node0After.value).next = _Node0ToInsert;
            if (tail.next != null) {
                tail = tail.next;
            }
        }
        // если _Node0After = null ,
        // добавьте новый элемент первым в списке
        else if (_Node0After == null && head != null) {
            _Node0ToInsert.next = find(head.value);
            this.head = _Node0ToInsert;
        } else if (_Node0After == null && head == null) {
            this.head = _Node0ToInsert;
            this.tail = _Node0ToInsert;
        }
    }
}

class Node01 {
    public int value;
    public Node01 next;

    public Node01(int _value) {
        value = _value;
        next = null;
    }

    class LinkedListExtra {

        public ArrayList<Integer> listsElSum(LinkedList list1, LinkedList list2) {
            ArrayList<Integer> result = new ArrayList<>();
            if (list1.count() == list2.count()) {
                Node0 Node01 = list1.head;
                Node0 Node02 = list2.head;
                while (Node01 != null) {
                    result.add(Node01.value + Node02.value);
                    Node01 = Node01.next;
                }
            } else {
                return null;
            }
            return result;
        }
    }
}