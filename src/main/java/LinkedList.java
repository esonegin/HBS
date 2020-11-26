import java.util.*;

//v1
public class LinkedList {

    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
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
        if (node == null) {
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
            if (head.value == _value) {
                head.value = node.next.value;
                node.next = node.next.next;
                break;
            } else if (node.next.value == _value && node.next.next != null) {
                node.next.value = node.next.next.value;
                node.next.next.value = _value;
            } else if (node.next.value == _value && node.next.next == null) {
                this.tail.value = node.value;
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
        // здесь будет ваш код вставки узла после заданного
        if(_nodeAfter != null) {
            _nodeToInsert.next = find(_nodeAfter.value).next;
            find(_nodeAfter.value).next = _nodeToInsert;
        }
        // если _nodeAfter = null ,
        // добавьте новый элемент первым в списке
        else if(_nodeAfter == null){
            _nodeToInsert.next = find(head.value);
            this.head = _nodeToInsert;
        }

    }

}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}