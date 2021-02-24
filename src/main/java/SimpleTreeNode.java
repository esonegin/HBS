import java.util.*;

public class SimpleTreeNode<T> {
    public T NodeValue; // значение в узле
    public SimpleTreeNode<T> Parent; // родитель или null для корня
    public List<SimpleTreeNode<T>> Children; // список дочерних узлов или null для листа

    public SimpleTreeNode(T val, SimpleTreeNode<T> parent) {
        NodeValue = val;
        Parent = parent;
        Children = new ArrayList<>();
    }
}

class SimpleTree<T> {
    public SimpleTreeNode<T> Root; // корень, может быть null

    public SimpleTree(SimpleTreeNode<T> root) {
        Root = root;
    }

    public void AddChild(SimpleTreeNode<T> ParentNode, SimpleTreeNode<T> NewChild) {
        if (ParentNode == Root) {
            Root.Children.add(NewChild);
        } else {
            ParentNode.Children.add(NewChild);
        }
    }

    public void DeleteNode(SimpleTreeNode<T> NodeToDelete) {
        for(int i = 0; i < NodeToDelete.Children.size(); i++) {
            NodeToDelete.Children.get(i).Parent = NodeToDelete.Parent;
            NodeToDelete.Parent.Children.add(NodeToDelete.Children.get(i));
        }
        for(int i = 0; i < NodeToDelete.Parent.Children.size(); i++){
            if(NodeToDelete.Parent.Children.get(i) == NodeToDelete){
                NodeToDelete.Parent.Children.remove(i);
            }
        }
    }

    public List<SimpleTreeNode<T>> GetAllNodes() {
        List<SimpleTreeNode<T>> result = new ArrayList<>();
        result.add(Root);
        result.addAll(Root.Children);
        for(int i = 1; i < result.size() - 1; i++){
            result.addAll(result.get(i).Children);
        }

        return result;
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
        //Список узлов OriginalNode
        List<SimpleTreeNode<T>> alloriginalnode = FindNodesByValue(OriginalNode.NodeValue);

        //Проходим по списку с OriginalNode
        for (SimpleTreeNode<T> SimpleTreeNode : alloriginalnode) {

            //Вставить в номер перемещаемого ребенка null
            //Проходим по списку детей родителя перемещаемого узла узла
            for (int j = 0; j < SimpleTreeNode.Parent.Children.size(); j++) {
                if (SimpleTreeNode.Parent.Children.get(j).NodeValue == OriginalNode.NodeValue) {
                    SimpleTreeNode.Parent.Children.remove(j);
                }
            }
            //Присвоить перемещаемым детям нового родителя
            SimpleTreeNode.Parent = NewParent;
            //Присвоить родителю перемещаемых детей
            NewParent.Children.add(SimpleTreeNode);
        }

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
}