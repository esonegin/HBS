import java.util.*;

public class AlgorithmsDataStructures2 {
    private static ArrayList<Integer> result;

    public static int[] GenerateBBSTArray(int[] a) {
        result = new ArrayList(a.length);
        Arrays.sort(a);
        BinaryTree tree = new BinaryTree();
        int n = a.length;
        Node root = tree.sortedArrayToBST(a, 0, n - 1);
        tree.preOrder(root);
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
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

        void preOrder(Node node) {
            if (node == null) {
                return;
            }
            result.add(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }
}