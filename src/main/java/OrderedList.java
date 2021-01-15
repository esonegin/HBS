import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T val) {
        value = val;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
    }

    public int compare(T v1, T v2) {
        if (v1 == v2) {
            return 0;
        } else if ((Integer) v1 > (Integer) v2) {
            return 1;
        }
        return -1;
        // -1 если v1 < v2
        // 0 если v1 == v2
        // +1 если v1 > v2
    }

    public void add(T value) {
        // автоматическая вставка value
        // в нужную позицию

        Node<T> _nodeToInsert = new Node<>(value);

        //Если список пустой
        if (tail == null && head == null) {
            this.head = _nodeToInsert;
            this.head.next = null;
            this.head.prev = null;
            this.tail = _nodeToInsert;

        }
        // - вставляем в хвост
        else if ((head != null && (compare(_nodeToInsert.value, tail.value) == 0
                || compare(_nodeToInsert.value, tail.value) == -1) && !_ascending) || head != null && (compare(_nodeToInsert.value, tail.value) == 0
                || compare(_nodeToInsert.value, tail.value) == 1) && _ascending) {
            _nodeToInsert.prev = tail;
            tail.next = _nodeToInsert;
            tail = _nodeToInsert;

        }
        // - вставляем в голову
        else if ((head != null && (compare(_nodeToInsert.value, head.value) == 0
                || compare(_nodeToInsert.value, head.value) == 1) && !_ascending) || head != null && (compare(_nodeToInsert.value, head.value) == 0
                || compare(_nodeToInsert.value, head.value) == -1) && _ascending) {
            _nodeToInsert.next = head;
            head.prev = _nodeToInsert;
            head = _nodeToInsert;


        }
        //Если список не пустой и значение больше хвоста, но меньше головы
        else {
            Node<T> node = this.head;
            while (node != null) {
                //Если вставляемый узел меньше текущего и больше следующего или равен текущему и список по возрастанию (false)
                if ((!_ascending && ((compare(_nodeToInsert.value, node.value) == -1
                        && compare(_nodeToInsert.value, node.next.value) == 1))
                        || compare(node.value, _nodeToInsert.value) == 0) || _ascending && ((compare(_nodeToInsert.value, node.value) == 1
                        && compare(_nodeToInsert.value, node.next.value) == -1))
                        || compare(node.value, _nodeToInsert.value) == 0) {
                    node.next.prev = _nodeToInsert;
                    _nodeToInsert.next = node.next;
                    node.next = _nodeToInsert;
                    _nodeToInsert.prev = node;
                    break;
                }
                node = node.next;
            }
        }
    }


    public Node<T> find(T val) {
        Node<T> node = this.head;
        while (node != null) {
            if (compare(val, tail.value) == 1 || compare(val, head.value) == -1) {
                return null;
            }
            if (node.value == val)
                return node;
            node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        Node<T> node = head;
        //Если список пустой
        //Если один элемент
        if (tail.value.equals(val) && tail.next == null && tail.prev == null) {
            this.head = null;
            this.tail = null;
        }
        //Если список из двух значений и удаляется хвост
        else if (tail.value.equals(val) && tail.prev.prev == null) {
            tail = head;
            head.next = null;
            tail.prev = null;

        }
        //Если список из двух значений и удаляется голова
        else if (head.value.equals(val) && head.next.next == null) {
            head = tail;
            head.prev = null;
            tail.next = null;

            //Если спиcок не пустой и больше двух элемента
        } else if (node.next.next != null) {

            while (node != null) {
                if (node.value.equals(val) && node.next != null && node.prev != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.next.prev.prev;
                }
                //Если удаляется голова
                else if (node.value.equals(val) && node.prev == null) {
                    head = node.next;
                    head.prev = null;
                    break;
                }
                //Если удаляется хвост
                else if (node.value.equals(val) && node.next == null) {
                    tail = node.prev;
                    tail.next = null;
                    break;
                }
                node = node.next;
            }
        }
    }

    public void clear(boolean asc) {
        _ascending = asc;
        this.head = null;
        this.tail = null;
    }

    public int count() {
        int count = 0;
        Node<T> node = this.head;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    ArrayList<Node<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> Node = tail;
        while (Node != null) {
            r.add(Node);
            Node = Node.prev;
        }
        return r;
    }
}