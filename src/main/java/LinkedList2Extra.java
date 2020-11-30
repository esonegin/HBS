public class LinkedList2Extra {
    private NodeExtra head;
    private NodeExtra tail;

    public LinkedList2Extra() {
        setHead(null);
        setTail(null);

    }


    public void addNode(int value) {
        if (getHead() == null) {
            setHead(new NodeExtra(value));
            setTail(new NodeExtra(value));
            getHead().next = null;
            getHead().prev = null;
            getTail().next = null;
            getTail().prev = null;
        }
        else if(getHead() != null){
            NodeExtra add = new NodeExtra(value);
            add.prev = getHead();
            add.next = null;
            setTail(add);
            getHead().next = getTail();
        }
    }

    public NodeExtra find(int _value) {
        NodeExtra node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    /*public ArrayList<Node> findAll(int _value) {
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
}*/

    static class NodeExtra {
        public int value;
        public NodeExtra next;
        public NodeExtra prev;

        public NodeExtra(int val) {
            value = val;
            next = null;
            prev = null;
        }
    }

    public NodeExtra getHead() {
        return head;
    }

    public NodeExtra getTail() {
        return tail;
    }

    public void setHead(NodeExtra head) {
        this.head = head;
    }

    public void setTail(NodeExtra tail) {
        this.tail = tail;
    }
}