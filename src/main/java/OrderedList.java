import java.util.*;

class Node0<T> extends LinkedList2 {
    public T value;
    public Node0<T> next, prev;

    public Node0(T val) {
        value = val;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node0<T> head, tail;
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

        Node0<T> _nodeToInsert = new Node0<>(value);

        //Если список пустой
        if (tail == null && head == null) {
            this.head = _nodeToInsert;
            this.head.next = null;
            this.head.prev = null;
            this.tail = _nodeToInsert;

        } //Если значение не найдено, список не пустой, значение равно хвосту или больше и список по убыванию (true)
        // - вставляем в хвост
        else if (head != null && (compare(_nodeToInsert.value, tail.value) == 0
                || compare(_nodeToInsert.value, tail.value) == 1) && _ascending) {
            this.tail.prev = _nodeToInsert;
            _nodeToInsert.next = tail;
            this.tail = _nodeToInsert;

        }//Если значение не найдено, список не пустой, значение равно голове или больше и список по возрастанию (false)
        // - вставляем в голову
        else if (head != null && (compare(_nodeToInsert.value, head.value) == 0
                || compare(_nodeToInsert.value, head.value) == 1) && !_ascending) {
            this.head.next = _nodeToInsert;
            _nodeToInsert.prev = head;
            this.head = _nodeToInsert;


        }//Если значение не найдено, список не пустой, значение равно голове или меньше и список по убыванию (true)
        // - вставляем в голову
        else if (head != null && (compare(_nodeToInsert.value, head.value) == 0
                || compare(_nodeToInsert.value, head.value) == -1) && _ascending) {
            this.head.next = _nodeToInsert;
            this.head.next.prev = this.head;
            this.head = _nodeToInsert;

        }//Если значение не найдено, список не пустой, значение равно хвосту или меньше и список по возрастанию (false)
        // - вставляем в хвост
        else if (head != null && (compare(_nodeToInsert.value, head.value) == 0
                || compare(_nodeToInsert.value, tail.value) == -1) && !_ascending) {
            this.tail.prev = _nodeToInsert;
            _nodeToInsert.next = tail;
            this.tail = _nodeToInsert;

        }//Если список не пустой и значение меньше хвоста, но больше головы
        else {
            Node0<T> node = this.tail;
            //Проходим по списку и ищем узлы больше-меньше
            while (node != null) {
                //Если вставляемый узел больше текущего и меньше следующего или равен текущему и список по возрастанию (false)
                if (!_ascending && ((compare(node.value, _nodeToInsert.value) == -1
                        && compare(node.next.value, _nodeToInsert.value) == 1))
                        || compare(node.value, _nodeToInsert.value) == 0) {
                    node.next.prev = _nodeToInsert;
                    _nodeToInsert.next = node.next;
                    node.next = _nodeToInsert;
                    _nodeToInsert.prev = node;
                    break;

                    //Если вставляемый узел больше текущего и меньше следующего или равен текущему и список по возрастанию (false)
                } else if (_ascending && ((compare(_nodeToInsert.value, node.value) == -1
                        && compare(node.next.value, _nodeToInsert.value) == -1))
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


    public Node0<T> find(T val) {
        Node0 node = this.head;
        while (node != null) {
            if (compare(val, tail.value) == 1 || compare(val, head.value) == -1) {
                return null;
            }
            if (node.value == val)
                return node;
            node = node.prev;
        }
        return null;
    }

    public void delete(T val) {
        Node0 node = tail;
        //Если список пустой
        //Если один элемент
        if (tail.value.equals(val) && tail.next == null && tail.prev == null) {
            this.head = null;
            this.tail = null;
        }
        //Если список из двух значений и удаляется хвост
        else if (tail.value.equals(val) && tail.prev == null && tail.next.next == null) {
            this.tail = this.head;
            this.head.prev = null;
            this.tail.next = null;

        }
        //Если список из двух значений и удаляется голова
        else if (head.value.equals(val) && head.next == null && head.prev.prev == null) {
            this.head = this.tail;
            this.head.prev = null;
            this.tail.next = null;

            //Если спиcок не пустой и больше двух элемента
        } else if (node.next.next != null) {

            while (node != null) {
                if (node.value.equals(val) && node.next != null && node.prev != null) {
                    node.prev.next = node.next;
                    node.next.prev = node.next.prev.prev;
                }
                //Если удаляется голова
                else if (node.value.equals(val) && node.next == null) {
                    this.head = node.prev;
                    this.head.next = null;
                    break;
                }
                //Если удаляется хвост
                else if (node.value.equals(val) && node.prev == null) {
                    this.tail = node.next;
                    this.tail.prev = null;
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
        Node0 node = this.tail;
        while (node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    ArrayList<Node0<T>> getAll() // выдать все элементы упорядоченного
    // списка в виде стандартного списка
    {
        ArrayList<Node0<T>> r = new ArrayList<Node0<T>>();
        Node0<T> Node0 = head;
        while (Node0 != null) {
            r.add(Node0);
            Node0 = Node0.prev;
        }
        return r;
    }
}