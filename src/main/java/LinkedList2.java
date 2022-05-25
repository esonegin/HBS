import java.util.*;

public class LinkedList2 {
    public Node0 head;
    public Node0 tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node0 _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
    }

    public Node0 find(int _value) {
        Node0 Node0 = this.head;
        while (Node0 != null) {
            if (Node0.value == _value)
                return Node0;
            Node0 = Node0.next;
        }
        return null;
    }

    public ArrayList<Node0> findAll(int _value) {
        ArrayList<Node0> Node0s = new ArrayList<Node0>();
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
        if (Node0 == null || find(_value) == null) {
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
            if (head.next.next == null && head.value == _value) {
                head.value = Node0.next.value;
                Node0.next.prev = null;
                Node0.next = Node0.next.next;
                tail.value = head.value;
                tail.prev = null;
                break;
            }
            if (head.value == _value) {
                head.value = Node0.next.value;
                Node0.next.prev = null;
                Node0.next = Node0.next.next;
                break;
            } else if (Node0.next.value == _value && Node0.next.next != null) {
                Node0.next.value = Node0.next.next.value;
                Node0.next.next.value = _value;
            } else if (Node0.next.value == _value && Node0.next.next == null) {
                this.tail.value = Node0.value;
                this.tail.prev = Node0.prev;
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
            _Node0ToInsert.prev = find(_Node0After.value);
            find(_Node0After.value).next = _Node0ToInsert;
            if (find(_Node0After.value).next.next != null) {
                find(_Node0After.value).next.next.prev = _Node0ToInsert;
            }
            if (tail.next != null) {
                tail = tail.next;
            }
        }
        // если _Node0After = null ,
        // добавьте новый элемент первым в списке
        else if (_Node0After == null && head != null) {
            _Node0ToInsert.next = find(head.value);
            this.head = _Node0ToInsert;
            find(head.next.value).prev = head;
        } else if (_Node0After == null && head == null) {
            this.head = _Node0ToInsert;
            this.tail = _Node0ToInsert;
        }
    }
}

class Node0 {
    public int value;
    public Node0 next;
    public Node0 prev;

    public Node0(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}