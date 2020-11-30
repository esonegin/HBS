import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    public LinkedList2() {
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
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

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<Node>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                nodes.add(node);
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        //Если список пустой
        if (node == null || find(_value) == null) {
            return false;
        }
        //Если один элемент
        if (node.value == _value && node.next == null) {
            node = null;
            this.head = null;
            this.tail = null;
        }
        //Если спиcок не пустой
        while (node != null) {
            if(head.next.next == null && head.value == _value){
                head.value = node.next.value;
                node.next.prev = null;
                node.next = node.next.next;
                tail.value = head.value;
                tail.prev = null;
                break;
            }
            if (head.value == _value) {
                head.value = node.next.value;
                node.next.prev = null;
                node.next = node.next.next;
                break;
            } else if (node.next.value == _value && node.next.next != null) {
                node.next.value = node.next.next.value;
                node.next.next.value = _value;
            } else if (node.next.value == _value && node.next.next == null) {
                this.tail.value = node.value;
                this.tail.prev = node.prev;
                node.next = null;
            }
            node = node.next;
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
        Node node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter != null) {
            _nodeToInsert.next = find(_nodeAfter.value).next;
            _nodeToInsert.prev = find(_nodeAfter.value);
            find(_nodeAfter.value).next = _nodeToInsert;
            if(find(_nodeAfter.value).next.next != null) {
                find(_nodeAfter.value).next.next.prev = _nodeToInsert;
            }
            if (tail.next != null) {
                tail = tail.next;
            }
        }
        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
        else if (_nodeAfter == null && head != null) {
            _nodeToInsert.next = find(head.value);
            this.head = _nodeToInsert;
            find(head.next.value).prev = head;
        } else if (_nodeAfter == null && head == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}