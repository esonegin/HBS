import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue;
    public SimpleTreeNode<T> Parent;
    public List<SimpleTreeNode<T>> Children;

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<>();
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root;

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public List<SimpleTreeNode<T>> allnodes = new ArrayList<>();

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode == Root) {
            Root.Children.add(NewChild);
        } else {
            NewChild.Parent = ParentNode;
            ParentNode.Children.add(NewChild);
        }
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        for (int i = 0; i < NodeToDelete.Children.size(); i++) {
            NodeToDelete.Children.get(i).Parent = NodeToDelete.Parent;
            NodeToDelete.Parent.Children.add(NodeToDelete.Children.get(i));
        }
        for (int i = 0; i < NodeToDelete.Parent.Children.size(); i++) {
            if (NodeToDelete.Parent.Children.get(i) == NodeToDelete) {
                NodeToDelete.Parent.Children.remove(i);
            }
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> result = new ArrayList<>();
        result.add(Root);
        for (int i = 0; i < result.size(); i++) {
            result.addAll(GetChildren(result.get(i)));
        }
        return result;
    }

    public List<SimpleTreeNode<T>> GetChildren(SimpleTreeNode<T> parent) {
        return new ArrayList<>(parent.Children);
    }

    public List<SimpleTreeNode<T>> FindNodesByValue(T val) {
        List<SimpleTreeNode<T>> allnodes = GetAllNodes();
        List<SimpleTreeNode<T>> result = new ArrayList<>();
        for (SimpleTreeNode<T> allnode : allnodes) {
            if (allnode.NodeValue == val) {
                result.add(allnode);
            }
        }
        return result;
    }

    public void MoveNode(SimpleTreeNode<T> OriginalNode, SimpleTreeNode<T> NewParent) {
        for (int i = 0; i < OriginalNode.Parent.Children.size(); i++) {
            if (OriginalNode.Parent.Children.get(i) == OriginalNode) {
                OriginalNode.Parent.Children.remove(i);
            }
        }
        OriginalNode.Parent = NewParent;
        NewParent.Children.add(OriginalNode);

    }

    public int Count() {
        return GetAllNodes().size();
    }

    public int LeafCount() {
        int result = 0;
        List<SimpleTreeNode<T>> allnodes = GetAllNodes();
        for (SimpleTreeNode<T> allnode : allnodes) {
            if (allnode.Children.size() == 0) {
                result++;
            }
        }
        return result;
    }

    public ArrayList<T> EvenTrees() {
        ArrayList<T> result = new ArrayList<>();
        int nodecount = 1;
        int edgecount = 0;
        T parrent = null;
        T child = null;
        for (int i = GetAllNodes().size() - 1; i > 0; ) {
            if (GetAllNodes().get(i).Parent.Parent == null) {
                break;
            }
            if (GetAllNodes().get(i).Parent != null) {
                nodecount += GetAllNodes().get(i).Parent.Children.size();
                edgecount += GetAllNodes().get(i).Parent.Children.size();
                parrent = GetAllNodes().get(i).Parent.Parent.NodeValue;
                child = GetAllNodes().get(i).Parent.NodeValue;
                i -= GetAllNodes().get(i).Parent.Children.size();
            }
            if (nodecount % 2 == 0 & edgecount % 2 != 0) {
                result.add(parrent);
                result.add(child);
                nodecount = 1;
                edgecount = 0;
            }
        }
        return result;
    }
}