import java.util.ArrayList;

//v1
public class LinkedListExtra {
    public static void main(String[] args) {
        LinkedList first = new LinkedList();
        first.addInTail(new Node(0));
        first.addInTail(new Node(1));
        first.addInTail(new Node(2));
        LinkedList second = new LinkedList();
        second.addInTail(new Node(1));
        second.addInTail(new Node(1));
        //second.addInTail(new Node(1));
        System.out.println(listsElSum(first, second));
    }

    public static ArrayList<Integer> listsElSum(LinkedList list1, LinkedList list2) {
        ArrayList<Integer> result = new ArrayList<>();
        if (list1.count() == list2.count()) {
            Node node1 = list1.head;
            Node node2 = list2.head;
            while (node1 != null) {
                result.add(node1.value + node2.value);
                node1 = node1.next;
            }
        }
        else{return null;}
        return result;
    }
}
