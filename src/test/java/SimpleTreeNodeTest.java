
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

//v5
public class    SimpleTreeNodeTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddNodeTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        Assert.assertThat(tree.Root.NodeValue, is(1));
        Assert.assertThat(tree.Root.Parent == null, is(true));
        Assert.assertThat(tree.Root.Children.size(), is(0));

        //Добавляем значение к корню
        tree.AddChild(tree.Root, new SimpleTreeNode<Integer>(2, tree.FindNodesByValue(1).get(0)));

        //Добавляем значение к корню
        tree.AddChild(tree.Root, new SimpleTreeNode<Integer>(3, tree.FindNodesByValue(1).get(0)));

        //Добавляем первое значение к ветви 2
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode<Integer>(4, tree.FindNodesByValue(2).get(0)));
        //Добавляем первое значение к ветви 3
        tree.AddChild(tree.FindNodesByValue(3).get(0), new SimpleTreeNode<Integer>(5, tree.FindNodesByValue(3).get(0)));


        Assert.assertThat(tree.Root.Children.size(), is(2));
        Assert.assertThat((tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat((tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat((tree.Root.Children.get(0)).Parent.NodeValue, is(1));
        Assert.assertThat((tree.Root.Children.get(1)).Parent.NodeValue, is(1));
        Assert.assertThat((tree.Root.Children.get(0)).Children.size() == 1, is(true));
        Assert.assertThat((tree.Root.Children.get(1)).Children.size() == 1, is(true));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(0)).Children.get(0)).NodeValue, is(4));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(1)).Children.get(0)).NodeValue, is(5));


        //Добавляем второе значение к ветви 2
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode<>(6, tree.FindNodesByValue(2).get(0)));
        //Добавляем второе значение к ветви 3
        tree.AddChild(tree.FindNodesByValue(3).get(0), new SimpleTreeNode<Integer>(7, tree.FindNodesByValue(3).get(0)));

        Assert.assertThat(tree.Root.Children.size(), is(2));
        Assert.assertThat((tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat((tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat((tree.Root.Children.get(0)).Parent.NodeValue, is(1));
        Assert.assertThat((tree.Root.Children.get(1)).Parent.NodeValue, is(1));
        Assert.assertThat((tree.Root.Children.get(0)).Children.size() == 2, is(true));
        Assert.assertThat((tree.Root.Children.get(1)).Children.size() == 2, is(true));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(0)).Children.get(0)).NodeValue, is(4));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(1)).Children.get(0)).NodeValue, is(5));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(0)).Children.get(1)).NodeValue, is(6));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(1)).Children.get(1)).NodeValue, is(7));
    }

   @Test
    public void defaultDelNodeTest() {
       SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
       SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild((tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, ((tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild((tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, ((tree.Root.Children.get(0)).Children.get(0))));

        //Удаляем НЕ лист
        tree.DeleteNode(tree.Root.Children.get(0));
        Assert.assertThat(tree.Root.Children.size(), is(3));
        Assert.assertThat((tree.Root.Children.get(0)).NodeValue, is(3));
        Assert.assertThat((tree.Root.Children.get(1)).NodeValue, is(4));
        Assert.assertThat((tree.Root.Children.get(2)).NodeValue, is(6));

        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(1)).Children.get(0)).NodeValue, is(8));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(1)).Children.get(1)).NodeValue, is(10));

        //Удаляем лист
        tree.DeleteNode((SimpleTreeNode) ( tree.Root.Children.get(0)).Children.get(0));
        Assert.assertThat((tree.Root.Children.get(0)).NodeValue, is(3));
        Assert.assertThat((tree.Root.Children.get(1)).NodeValue, is(4));
        Assert.assertThat((tree.Root.Children.get(2)).NodeValue, is(6));
        Assert.assertThat(((SimpleTreeNode) (tree.Root.Children.get(0)).Children.get(0)).NodeValue, is(7));
        Assert.assertThat((tree.Root.Children.get(0)).Children.size(), is(1));
    }

    
    @Test
    public void defaultGetAllNodesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild((tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, ((tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        List<SimpleTreeNode<Integer>> allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.get(0).NodeValue, is(1));
        Assert.assertThat(allnode.get(1).NodeValue, is(2));
        Assert.assertThat(allnode.get(2).NodeValue, is(3));
        Assert.assertThat(allnode.get(3).NodeValue, is(4));
        Assert.assertThat(allnode.get(4).NodeValue, is(6));
        Assert.assertThat(allnode.get(5).NodeValue, is(5));
        Assert.assertThat(allnode.get(6).NodeValue, is(7));
        Assert.assertThat(allnode.get(7).NodeValue, is(8));
        Assert.assertThat(allnode.get(8).NodeValue, is(10));

    }

    @Test
    public void defaultFindNodesByValueTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(3, (( tree.Root.Children.get(0)).Children.get(0))));

        List<SimpleTreeNode<Integer>> findnode = tree.FindNodesByValue(3);
        Assert.assertThat(findnode.size(), is(2));
        Assert.assertThat(findnode.get(0).NodeValue, is(3));
        Assert.assertThat(findnode.get(0).Parent.NodeValue, is(1));
        Assert.assertThat((findnode.get(0).Children.get(0)).NodeValue, is(5));
        Assert.assertThat((findnode.get(0).Children.get(1)).NodeValue, is(7));
        Assert.assertThat(findnode.get(1).NodeValue, is(3));
        Assert.assertThat(findnode.get(1).Parent.NodeValue, is(4));
        Assert.assertThat(findnode.get(1).Children.size(), is(0));
    }

    @Test
    public void defaultMoveNodeTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.MoveNode(tree.Root.Children.get(0), tree.Root.Children.get(1));
        Assert.assertThat(tree.Root.Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(3));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(5));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).NodeValue, is(7));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).NodeValue, is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.size(), is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(0).NodeValue, is(4));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(1).NodeValue, is(6));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(0).Children.get(0).NodeValue, is(8));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(0).Children.get(1).NodeValue, is(10));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(1).NodeValue, is(6));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(2).Children.get(1).Children.size(), is(0));
    }

    @Test
    public void defaultCountTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        Assert.assertThat(tree.Count(), is(9));
    }

    @Test
    public void defaultLeafCountTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        Assert.assertThat(tree.LeafCount(), is(5));
    }

    @Test
    public void onLeafMoveNodeTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.MoveNode(tree.Root.Children.get(0), (SimpleTreeNode) ( tree.Root.Children.get(1)).Children.get(0));

        Assert.assertThat(tree.Root.Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(5));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).NodeValue, is(7));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.size(), is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(0).NodeValue, is(4));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(1).NodeValue, is(6));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(0).Children.get(0).NodeValue, is(8));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(0).Children.get(1).NodeValue, is(10));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(0).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.get(0).Children.get(0).Children.get(1).Children.size(), is(0));
    }

    @Test
    public void onRootMoveNodeTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(4, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(5, tree.Root.Children.get(1)));
        tree.AddChild(tree.Root.Children.get(0), new SimpleTreeNode(6, tree.Root.Children.get(0)));
        tree.AddChild(tree.Root.Children.get(1), new SimpleTreeNode(7, tree.Root.Children.get(1)));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(8, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.AddChild(( tree.Root.Children.get(0)).Children.get(0),
                new SimpleTreeNode(10, (( tree.Root.Children.get(0)).Children.get(0))));

        tree.MoveNode(( tree.Root.Children.get(0)).Children.get(0), ( tree.Root));


        Assert.assertThat(tree.Root.Children.size(), is(3));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(6));

        Assert.assertThat(( tree.Root.Children.get(1)).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(0).NodeValue, is(5));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(1).NodeValue, is(7));

        Assert.assertThat(( tree.Root.Children.get(2)).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(2)).NodeValue, is(4));
        Assert.assertThat(( tree.Root.Children.get(2)).Children.get(0).NodeValue, is(8));
        Assert.assertThat(( tree.Root.Children.get(2)).Children.get(1).NodeValue, is(10));

        tree.MoveNode(( tree.Root.Children.get(2)), ( tree.Root.Children.get(0)));

        Assert.assertThat(tree.Root.Children.size(), is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(6));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).NodeValue, is(4));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(0).NodeValue, is(8));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(1).NodeValue, is(10));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(1).Children.size(), is(0));

        //10 - 5
        tree.MoveNode((( tree.Root.Children.get(0)).Children.get(1).Children.get(1)),
                (( tree.Root.Children.get(1)).Children.get(0)));

        Assert.assertThat(tree.Root.Children.size(), is(2));

        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(6));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).NodeValue, is(4));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(0).NodeValue, is(8));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(1).Children.get(0).Children.size(), is(0));

        Assert.assertThat(( tree.Root.Children.get(1)).Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(0).NodeValue, is(5));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(1).NodeValue, is(7));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(1).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(0).Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(0).Children.get(0).NodeValue, is(10));

        List<SimpleTreeNode<Integer>> allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(9));
        Assert.assertThat(allnode.get(0).NodeValue, is(1));
        Assert.assertThat(allnode.get(1).NodeValue, is(2));
        Assert.assertThat(allnode.get(2).NodeValue, is(3));
        Assert.assertThat(allnode.get(3).NodeValue, is(6));
        Assert.assertThat(allnode.get(4).NodeValue, is(4));
        Assert.assertThat(allnode.get(5).NodeValue, is(5));
        Assert.assertThat(allnode.get(6).NodeValue, is(7));
        Assert.assertThat(allnode.get(7).NodeValue, is(8));
        Assert.assertThat(allnode.get(8).NodeValue, is(10));

    }

    @Test
    public void odinakovieTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);
        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.Root));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.Root));

        tree.MoveNode(( tree.Root.Children.get(0)), ( tree.Root.Children.get(2)));

        Assert.assertThat(tree.Root.Children.size(), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.size(), is(1));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.get(0).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat((( tree.Root.Children.get(1)).Children.get(0)).NodeValue, is(2));

        tree.MoveNode((( tree.Root.Children.get(1)).Children.get(0)), ( tree.Root));
        Assert.assertThat((tree.Root.Children.size()), is(3));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(1)).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(2)).Children.size(), is(0));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat(( tree.Root.Children.get(2)).NodeValue, is(2));

        tree.MoveNode(( tree.Root.Children.get(2)), ( tree.Root.Children.get(0)));
        Assert.assertThat((tree.Root.Children.size()), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(2));

        tree.MoveNode(( tree.Root.Children.get(0)), (( tree.Root.Children.get(0)).Children.get(0)));
        Assert.assertThat((tree.Root.Children.size()), is(2));
        Assert.assertThat(( tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat(( tree.Root.Children.get(1)).NodeValue, is(3));
        Assert.assertThat(( tree.Root.Children.get(0)).Children.get(0).NodeValue, is(2));

        List<SimpleTreeNode<Integer>> allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.get(0).NodeValue, is(1));
        Assert.assertThat(allnode.get(1).NodeValue, is(2));
        Assert.assertThat(allnode.get(2).NodeValue, is(3));
        Assert.assertThat(allnode.get(3).NodeValue, is(2));


    }

    @Test
    public void errorTest() {
        SimpleTreeNode<Integer> root = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(root);

        SimpleTreeNode<Integer> n1 = new SimpleTreeNode<Integer>(1, root);
        tree.AddChild(root, n1);
        SimpleTreeNode<Integer> n2 = new SimpleTreeNode<Integer>(2, root);
        tree.AddChild(root, n2);
        SimpleTreeNode<Integer> n3 = new SimpleTreeNode<Integer>(3, root);
        tree.AddChild(root, n3);

        SimpleTreeNode<Integer> n12 = new SimpleTreeNode<Integer>(2, null);
        tree.AddChild(n1, n12);

        SimpleTreeNode<Integer> n13 = new SimpleTreeNode<Integer>(3, null);
        tree.AddChild(n1, n13);

        SimpleTreeNode<Integer> n21 = new SimpleTreeNode<Integer>(4, null);
        tree.AddChild(n2, n21);

        List<SimpleTreeNode<Integer>> allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(7));

        tree.DeleteNode(n21);
        allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(6));
        Assert.assertThat(tree.FindNodesByValue(4).size(), is(0));


    }

    @Test
    public void allNodesErrorTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        List<SimpleTreeNode<Integer>> allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(1));
        Assert.assertThat(allnode.get(0).NodeValue, is(0));

        tree.AddChild(tree.Root, new SimpleTreeNode<>(1, tree.Root));
        allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(2));
        Assert.assertThat(allnode.get(0).NodeValue, is(0));
        Assert.assertThat(allnode.get(1).NodeValue, is(1));

        tree.DeleteNode(tree.Root.Children.get(0));
        allnode = tree.GetAllNodes();
        Assert.assertThat(allnode.size(), is(1));
        Assert.assertThat(allnode.get(0).NodeValue, is(0));

    }

    @Test
    public void defaultEvenTreesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(1, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);

        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.FindNodesByValue(1).get(0)));
        tree.AddChild(tree.Root, new SimpleTreeNode(3, tree.FindNodesByValue(1).get(0)));
        tree.AddChild(tree.Root, new SimpleTreeNode(6, tree.FindNodesByValue(1).get(0)));
        //Добавляем первое значение к ветви 2
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode(5, tree.FindNodesByValue(2).get(0)));
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode(7, tree.FindNodesByValue(2).get(0)));
        //Добавляем первое значение к ветви 3
        tree.AddChild(tree.FindNodesByValue(3).get(0), new SimpleTreeNode(4, tree.FindNodesByValue(3).get(0)));
        //Добавляем первое значение к ветви 6
        tree.AddChild(tree.FindNodesByValue(6).get(0), new SimpleTreeNode(8, tree.FindNodesByValue(6).get(0)));
        //Добавляем первое значение к ветви 8
        tree.AddChild(tree.FindNodesByValue(8).get(0), new SimpleTreeNode(9, tree.FindNodesByValue(8).get(0)));
        tree.AddChild(tree.FindNodesByValue(8).get(0), new SimpleTreeNode(10, tree.FindNodesByValue(8).get(0)));

        Assert.assertThat((tree.Root.Children.get(0)).NodeValue, is(2));
        Assert.assertThat((tree.Root.Children.get(1)).NodeValue, is(3));

        ArrayList expected = new ArrayList<>();
        expected.add(1);
        expected.add(6);
        expected.add(1);
        expected.add(3);
        Assert.assertThat(tree.EvenTrees(), is(expected));
    }

    @Test
    public void nullEvenTreesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);
        tree.AddChild(tree.Root, new SimpleTreeNode<Integer>(1, tree.FindNodesByValue(0).get(0)));
        tree.AddChild(tree.Root, new SimpleTreeNode<Integer>(2, tree.FindNodesByValue(0).get(0)));
        //Добавляем первое значение к ветви 1
        tree.AddChild(tree.FindNodesByValue(1).get(0), new SimpleTreeNode<Integer>(3, tree.FindNodesByValue(1).get(0)));
        tree.AddChild(tree.FindNodesByValue(1).get(0), new SimpleTreeNode<Integer>(4, tree.FindNodesByValue(1).get(0)));
        //Добавляем первое значение к ветви 2
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode<Integer>(5, tree.FindNodesByValue(2).get(0)));
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode<Integer>(6, tree.FindNodesByValue(2).get(0)));
        Assert.assertThat(tree.EvenTrees().size(), is(0));
        //Добавляем первое значение к ветви 4
        tree.AddChild(tree.FindNodesByValue(3).get(0), new SimpleTreeNode<Integer>(7, tree.FindNodesByValue(3).get(0)));
        tree.AddChild(tree.FindNodesByValue(3).get(0), new SimpleTreeNode<Integer>(8, tree.FindNodesByValue(3).get(0)));
        //Добавляем первое значение к ветви 4
        tree.AddChild(tree.FindNodesByValue(4).get(0), new SimpleTreeNode<Integer>(9, tree.FindNodesByValue(4).get(0)));
        tree.AddChild(tree.FindNodesByValue(4).get(0), new SimpleTreeNode<Integer>(10, tree.FindNodesByValue(4).get(0)));
        //Добавляем первое значение к ветви 5
        tree.AddChild(tree.FindNodesByValue(5).get(0), new SimpleTreeNode<Integer>(11, tree.FindNodesByValue(5).get(0)));
        tree.AddChild(tree.FindNodesByValue(5).get(0), new SimpleTreeNode<Integer>(12, tree.FindNodesByValue(5).get(0)));
        //Добавляем первое значение к ветви 6
        tree.AddChild(tree.FindNodesByValue(6).get(0), new SimpleTreeNode<Integer>(13, tree.FindNodesByValue(6).get(0)));
        tree.AddChild(tree.FindNodesByValue(6).get(0), new SimpleTreeNode<Integer>(14, tree.FindNodesByValue(6).get(0)));
        Assert.assertThat(tree.EvenTrees().size(), is(0));
    }

    @Test
    public void rootInEvenTreesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);
        tree.AddChild(tree.Root, new SimpleTreeNode(1, tree.FindNodesByValue(0).get(0)));
        tree.AddChild(tree.Root, new SimpleTreeNode(2, tree.FindNodesByValue(0).get(0)));
        //Добавляем первое значение к ветви 1
        tree.AddChild(tree.FindNodesByValue(1).get(0), new SimpleTreeNode(3, tree.FindNodesByValue(1).get(0)));

        //Добавляем первое значение к ветви 2
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode(4, tree.FindNodesByValue(2).get(0)));
        tree.AddChild(tree.FindNodesByValue(2).get(0), new SimpleTreeNode(5, tree.FindNodesByValue(2).get(0)));
        Assert.assertThat(tree.EvenTrees().size(), is(2));

        ArrayList expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        Assert.assertThat(tree.EvenTrees(), is(expected));
    }

    @Test
    public void oneEdgeInEvenTreesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);
        tree.AddChild(tree.Root, new SimpleTreeNode(1, tree.FindNodesByValue(0).get(0)));
        //Добавляем первое значение к ветви 1
        tree.AddChild(tree.FindNodesByValue(1).get(0), new SimpleTreeNode(2, tree.FindNodesByValue(1).get(0)));
        ArrayList expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        Assert.assertThat(tree.EvenTrees(), is(expected));
    }

    @Test
    public void onlyRootEvenTreesTest() {
        SimpleTreeNode<Integer> node = new SimpleTreeNode<>(0, null);
        SimpleTree<Integer> tree = new SimpleTree<>(node);
        Assert.assertThat(tree.EvenTrees().size(), is(0));
    }
}