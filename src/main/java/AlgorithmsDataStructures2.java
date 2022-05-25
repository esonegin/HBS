import java.util.*;

public class AlgorithmsDataStructures2 {

    public static int[] generateBBSTArray(int[] a) {
        Arrays.sort(a);

        BinaryTree tree = new BinaryTree();
        int n = a.length;
        Node root = tree.sortedArrayToBST(a, 0, n - 1);
        ArrayList<Node> allnodes = new ArrayList<>();
        allnodes.add(root);
        for (int i = 0; i < allnodes.size(); i++) {
            allnodes.addAll(getChildren(allnodes.get(i)));
        }
        int[] res = new int[allnodes.size()];
        for (int i = 0; i < allnodes.size(); i++) {
            res[i] = allnodes.get(i).data;
        }

        return res;
    }

    public static List<Node> getChildren(Node parent) {

        List<Node> rootchildren = new ArrayList<>();
        if (parent.left != null) {
            rootchildren.add(parent.left);
        }
        if (parent.right != null) {
            rootchildren.add(parent.right);
        }
        return rootchildren;
    }

    static class Node {

        int data;
        Node left, right;

        Node(int d) {
            data = d;
            left = right = null;
        }
    }

    static class BinaryTree {

        //static Node root;

        Node sortedArrayToBST(int[] arr, int start, int end) {
            if (start > end) {
                return null;
            }
            int mid = (start + end) / 2;
            Node node = new Node(arr[mid]);
            node.left = sortedArrayToBST(arr, start, mid - 1);
            node.right = sortedArrayToBST(arr, mid + 1, end);


            return node;
        }
    }
}
