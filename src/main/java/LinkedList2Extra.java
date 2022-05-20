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