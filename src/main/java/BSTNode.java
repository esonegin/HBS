import java.util.ArrayList;
import java.util.List;

class BSTNode<T> {
    public int NodeKey;
    public T NodeValue;
    public BSTNode<T> Parent;
    public BSTNode<T> LeftChild;
    public BSTNode<T> RightChild;


    public BSTNode(int key, T val, BSTNode<T> parent) {
        NodeKey = key;
        NodeValue = val;
        Parent = parent;
        LeftChild = null;
        RightChild = null;
    }
}

class BSTFind<T> {
    public BSTNode<T> Node;
    public boolean NodeHasKey;
    public boolean ToLeft;
    public BSTFind() {
        Node = null;
    }
}

class BST<T> {
    BSTNode<T> Root;

    public BST(BSTNode<T> node) {
        Root = node;
    }

    public BSTFind<T> FindNodeByKey(int key) {
        BSTFind<T> teknod = new BSTFind<>();
        teknod.Node = Root;
        while (teknod.Node != null) {
            if(teknod.Node.NodeKey == key){
                break;
            }
            else if(teknod.Node.LeftChild != null &&teknod.Node.LeftChild.NodeKey == key){
                teknod.Node = teknod.Node.LeftChild;
                break;
            }
            else if(teknod.Node.RightChild != null && teknod.Node.RightChild.NodeKey == key){
                teknod.Node = teknod.Node.RightChild;
                break;
            }
            else if(teknod.Node.LeftChild == null && teknod.Node.RightChild == null){
                break;
            }
            else if(teknod.Node.LeftChild == null){
                break;
            }
            else if(teknod.Node.RightChild == null){
                break;
            }
            else if(key < teknod.Node.NodeKey){
                teknod.Node = teknod.Node.LeftChild;
            }
            else {
                teknod.Node = teknod.Node.RightChild;
            }

        }

            assert teknod.Node != null;
            if (teknod.Node.NodeKey == key
                    || (teknod.Node.LeftChild != null && teknod.Node.LeftChild.NodeKey == key)
                    || (teknod.Node.RightChild != null && teknod.Node.RightChild.NodeKey == key)) {
                teknod.NodeHasKey = true;
            } else if (teknod.Node.LeftChild == null) {
                teknod.NodeHasKey = false;
                teknod.ToLeft = true;
            } else {
                teknod.NodeHasKey = false;
                teknod.ToLeft = false;
            }

            return teknod;
    }

    public boolean AddKeyValue(int key, T val) {
        BSTNode node = new BSTNode(key, val, null);
        BSTFind<T> predfind = FindNodeByKey(key);

        if (predfind.ToLeft && !predfind.NodeHasKey) {
            predfind.Node.LeftChild = node;
            node.Parent = predfind.Node;
            return true;
        } else if (!predfind.ToLeft && !predfind.NodeHasKey && predfind.Node.LeftChild.NodeKey < key) {
            predfind.Node.RightChild = node;
            node.Parent = predfind.Node;
            return true;
        }else if (!predfind.ToLeft && !predfind.NodeHasKey && predfind.Node.LeftChild.NodeKey > key) {
            predfind.Node.RightChild = predfind.Node.LeftChild;
            predfind.Node.LeftChild = node;
            node.Parent = predfind.Node;
            return true;
        }
        return false;
    }

    public BSTNode<T> FinMinMax(BSTNode<T> FromNode, boolean FindMax) {
        if(!FindMax) {
            while (FromNode.LeftChild != null) {
                FromNode = FromNode.LeftChild;
            }
            return FromNode;
        }
        else{
            while (FromNode.RightChild != null) {
                FromNode = FromNode.RightChild;
            }
            return FromNode;
        }
    }

    public boolean DeleteNodeByKey(int key) {
        BSTFind<T> delnode = FindNodeByKey(key);
        if(delnode.NodeHasKey){
        if(delnode.Node.LeftChild == null && delnode.Node.RightChild == null
                && delnode.Node.Parent.LeftChild != null && delnode.Node.Parent.LeftChild.NodeKey == delnode.Node.NodeKey){
            FindNodeByKey(delnode.Node.Parent.NodeKey).Node.LeftChild = null;
            delnode.Node = null;
        }

        else if(delnode.Node.LeftChild == null && delnode.Node.RightChild == null
                && delnode.Node.Parent.RightChild != null && delnode.Node.Parent.RightChild.NodeKey == delnode.Node.NodeKey){
            FindNodeByKey(delnode.Node.Parent.NodeKey).Node.RightChild = null;
            delnode.Node = null;
        }

        else if(delnode.Node.RightChild == null){
            delnode.Node = delnode.Node.LeftChild;
            assert delnode.Node != null;
            delnode.Node.LeftChild = null;
        }

        else {
            BSTNode<T> changenode = delnode.Node.RightChild;

            while (changenode.LeftChild != null) {
                changenode = changenode.LeftChild;
            }

            if (changenode.Parent.RightChild == changenode) {
                delnode.Node.RightChild = null;
                changenode.Parent = delnode.Node.Parent;
                changenode.LeftChild = delnode.Node.LeftChild;
                changenode.RightChild = delnode.Node.RightChild;
                delnode.Node = changenode;

            }
            else if (changenode.Parent.LeftChild == changenode) {
                changenode.Parent.LeftChild = null;
                changenode.Parent = delnode.Node.Parent;
                changenode.LeftChild = delnode.Node.LeftChild;
                changenode.RightChild = delnode.Node.RightChild;
                delnode.Node = changenode;

            }
        }

        if(delnode.Node == null){
            return true;
        }

        else if (FindNodeByKey(delnode.Node.Parent.NodeKey).Node.LeftChild.NodeKey  == key){
            FindNodeByKey(delnode.Node.Parent.NodeKey).Node.LeftChild = delnode.Node;
        }
        else if(FindNodeByKey(delnode.Node.Parent.NodeKey).Node.RightChild.NodeKey  == key){
            FindNodeByKey(delnode.Node.Parent.NodeKey).Node.RightChild = delnode.Node;
        }

            return true;
        }
        return false;
    }

    public int Count() {
        List<BSTNode<T>> result = new ArrayList<>();
        result.add(Root);
        for (int i = 0; i < result.size(); i++) {
            result.addAll(GetChildren(result.get(i)));
        }
        return result.size();
    }

    public List<BSTNode<T>> GetChildren(BSTNode<T> parent) {

        List<BSTNode<T>> rootchildren = new ArrayList<>();
        if(parent.LeftChild != null){
            rootchildren.add(parent.LeftChild);
        }
        if(parent.RightChild != null){
            rootchildren.add(parent.RightChild);
        }
        return rootchildren;
    }

}