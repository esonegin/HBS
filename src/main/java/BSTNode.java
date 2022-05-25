import java.util.*;

//v1
class BSTNode {
    public int NodeKey; // ключ узла
    public BSTNode Parent; // родитель или null для корня
    public BSTNode LeftChild; // левый потомок
    public BSTNode RightChild; // правый потомок	
    public int Level; // глубина узла

    public BSTNode(int key, BSTNode parent) {
        NodeKey = key;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BalancedBST {

    public BSTNode Root; // корень дерева
    public int teklevel;

    public BalancedBST() {
        Root = null;
        teklevel = 1;
    }

    public void GenerateTree(int[] a) {
        BalancedBST tree = new BalancedBST();
        Arrays.sort(a);
        int n = a.length;
        Root = tree.sortedArrayToBST(a, 0, n - 1);
        InstallLevel(Root);
    }

    BSTNode sortedArrayToBST(int arr[], int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BSTNode node = new BSTNode(arr[mid], null);
        node.LeftChild = sortedArrayToBST(arr, start, mid - 1);
        node.RightChild = sortedArrayToBST(arr, mid + 1, end);
        return node;

    }

    int getLevel(BSTNode node, int data) {
        return getLevelUtil(node, data, 0);
    }

    int getLevelUtil(BSTNode node, int data, int level) {
        if (node == null) {
            return 0;
        }
        if (node.NodeKey == data) {
            return level;
        }
        int downlevel = getLevelUtil(node.LeftChild, data, level + 1);
        if (downlevel != 0) {
            return downlevel;
        }
        downlevel = getLevelUtil(node.RightChild, data, level + 1);

        return downlevel;

    }

    public void InstallLevel(BSTNode teknode) {
        if (teknode == null) return;
        InstallLevel(teknode.LeftChild);
        teknode.Level = getLevel(Root, teknode.NodeKey);
        InstallLevel(teknode.RightChild);
    }


    public boolean IsBalanced(BSTNode root_node) {
        int lh;
        int rh;
        if (root_node == null) {
            return true;
        }
        lh = height(root_node.LeftChild);
        rh = height(root_node.RightChild);
        if ((lh - rh) * -1 <= 1 && IsBalanced(root_node.LeftChild) && IsBalanced(root_node.RightChild)) {
            return true;
        }
        return false;
    }

    int height(BSTNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(height(node.LeftChild), height(node.RightChild));
    }
}  