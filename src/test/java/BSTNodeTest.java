
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class BSTNodeTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddAndFindNodeTest() {

        //Создаем узел корень
        BSTNode root = new BSTNode(8, 8, null);
        //Создаем дерево с корнем
        BST tree = new BST(root);
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));

        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild == null, is(true));


        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(false));
        Assert.assertThat(tree.FindNodeByKey(1).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(1).ToLeft, is(true));


        tree.AddKeyValue(1, 1);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(1));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild == null, is(true));


        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(1, 2), is(false));

        tree.AddKeyValue(2, 2);
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(1));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(2));

        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(2).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(1, 2), is(false));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));

    }

    @Test
    public void addLeftChildTest() {

        //Создаем узел корень
        BSTNode root = new BSTNode(8, 8, null);
        //Создаем дерево с корнем
        BST tree = new BST(root);

        tree.AddKeyValue(2, 2);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(2));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild == null, is(true));


        Assert.assertThat(tree.FindNodeByKey(2).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));

        tree.AddKeyValue(1, 1);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(1));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(2));

        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(2).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(1, 2), is(false));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));

        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(4, 4);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(1));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(2));
        Assert.assertThat(tree.FindNodeByKey(1).Node.LeftChild.NodeValue, is(3));
        Assert.assertThat(tree.FindNodeByKey(1).Node.RightChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild == null, is(true));
    }

    @Test
    public void addPoPoryadkuTest() {

        //Создаем узел корень
        BSTNode root = new BSTNode(8, 8, null);
        //Создаем дерево с корнем
        BST tree = new BST(root);

        Assert.assertThat(tree.AddKeyValue(8, 8), is(false));


        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(12, 12);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(12));

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(4, 4), is(false));
        Assert.assertThat(tree.AddKeyValue(12, 12), is(false));

        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(6, 6);

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeKey, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeKey, is(12));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild.NodeKey, is(6));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild == null, is(true));

        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);
        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeKey, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeKey, is(12));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild.NodeKey, is(6));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));

    }

    @Test
    public void addVraznoboyTest() {

        //Создаем узел корень
        BSTNode root = new BSTNode(8, 8, null);
        //Создаем дерево с корнем
        BST tree = new BST(root);

        Assert.assertThat(tree.AddKeyValue(8, 8), is(false));

        tree.AddKeyValue(12, 12);

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild == null, is(true));

        tree.AddKeyValue(4, 4);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(12));

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(4, 4), is(false));
        Assert.assertThat(tree.AddKeyValue(12, 12), is(false));

        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(2, 2);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(12));

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild.NodeKey, is(6));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild == null, is(true));
        Assert.assertThat(tree.AddKeyValue(4, 4), is(false));
        Assert.assertThat(tree.AddKeyValue(12, 12), is(false));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));
        Assert.assertThat(tree.AddKeyValue(6, 6), is(false));

        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(12));

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild.NodeKey, is(6));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));
        Assert.assertThat(tree.AddKeyValue(4, 4), is(false));
        Assert.assertThat(tree.AddKeyValue(12, 12), is(false));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));
        Assert.assertThat(tree.AddKeyValue(6, 6), is(false));
        Assert.assertThat(tree.AddKeyValue(10, 10), is(false));
        Assert.assertThat(tree.AddKeyValue(14, 14), is(false));

        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);

        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeKey, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).Node.NodeValue, is(8));
        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.Parent == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeValue, is(4));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeValue, is(12));

        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(4).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(4).Node.RightChild.NodeKey, is(6));

        Assert.assertThat(tree.FindNodeByKey(2).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild.NodeKey, is(1));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild.NodeKey, is(3));

        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(1).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(3).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(3).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(3).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(6).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(6).Node.LeftChild.NodeKey, is(5));
        Assert.assertThat(tree.FindNodeByKey(6).Node.RightChild.NodeKey, is(7));

        Assert.assertThat(tree.FindNodeByKey(5).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(5).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(5).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(7).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(7).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(7).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.AddKeyValue(4, 4), is(false));
        Assert.assertThat(tree.AddKeyValue(12, 12), is(false));
        Assert.assertThat(tree.AddKeyValue(2, 2), is(false));
        Assert.assertThat(tree.AddKeyValue(6, 6), is(false));
        Assert.assertThat(tree.AddKeyValue(10, 10), is(false));
        Assert.assertThat(tree.AddKeyValue(14, 14), is(false));
        Assert.assertThat(tree.AddKeyValue(1, 1), is(false));
        Assert.assertThat(tree.AddKeyValue(3, 3), is(false));
        Assert.assertThat(tree.AddKeyValue(5, 5), is(false));
        Assert.assertThat(tree.AddKeyValue(7, 7), is(false));

        tree.AddKeyValue(15, 15);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(9, 9);


        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.FindNodeByKey(10).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(10).Node.LeftChild.NodeKey, is(9));
        Assert.assertThat(tree.FindNodeByKey(10).Node.RightChild.NodeKey, is(11));

        Assert.assertThat(tree.FindNodeByKey(14).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.LeftChild.NodeKey, is(13));
        Assert.assertThat(tree.FindNodeByKey(14).Node.RightChild.NodeKey, is(15));

        Assert.assertThat(tree.FindNodeByKey(13).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.RightChild == null, is(true));

        Assert.assertThat(tree.AddKeyValue(15, 15), is(false));
        Assert.assertThat(tree.AddKeyValue(13, 13), is(false));
        Assert.assertThat(tree.AddKeyValue(11, 11), is(false));
        Assert.assertThat(tree.AddKeyValue(9, 9), is(false));


    }

    @Test
    public void findMaxRootTest() {

        BSTNode root = new BSTNode(8, 8, null);
        BST tree = new BST(root);


        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(15, 15);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(9, 9);

        Assert.assertThat(tree.FinMinMax(tree.Root, false).NodeKey, is(1));
        Assert.assertThat(tree.FinMinMax(tree.Root, true).NodeKey, is(15));

    }

    @Test
    public void findMaxSecondStageTest() {

        BSTNode root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(15, 15);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(9, 9);

        Assert.assertThat(tree.FinMinMax(tree.Root.LeftChild, false).NodeKey, is(1));
        Assert.assertThat(tree.FinMinMax(tree.Root.LeftChild, true).NodeKey, is(7));
        Assert.assertThat(tree.FinMinMax(tree.Root.RightChild, false).NodeKey, is(9));
        Assert.assertThat(tree.FinMinMax(tree.Root.RightChild, true).NodeKey, is(15));

        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(2).Node, false).NodeKey, is(1));
        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(2).Node, true).NodeKey, is(3));

        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(1).Node, false).NodeKey, is(1));
        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(1).Node, true).NodeKey, is(1));

        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(15).Node, false).NodeKey, is(15));
        Assert.assertThat(tree.FinMinMax(tree.FindNodeByKey(15).Node, true).NodeKey, is(15));

    }

    @Test
    public void deleteOneLevelTest() {

        BSTNode root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(15, 15);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(9, 9);

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.FindNodeByKey(10).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(10).Node.LeftChild.NodeKey, is(9));
        Assert.assertThat(tree.FindNodeByKey(10).Node.RightChild.NodeKey, is(11));

        Assert.assertThat(tree.FindNodeByKey(14).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.LeftChild.NodeKey, is(13));
        Assert.assertThat(tree.FindNodeByKey(14).Node.RightChild.NodeKey, is(15));

        Assert.assertThat(tree.FindNodeByKey(13).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.RightChild == null, is(true));

        Assert.assertThat(tree.DeleteNodeByKey(10), is(true));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(12).Node.LeftChild.NodeKey, is(11));
        Assert.assertThat(tree.FindNodeByKey(12).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.FindNodeByKey(11).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(11).Node.LeftChild.NodeKey, is(9));
        Assert.assertThat(tree.FindNodeByKey(11).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(14).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.LeftChild.NodeKey, is(13));
        Assert.assertThat(tree.FindNodeByKey(14).Node.RightChild.NodeKey, is(15));

        Assert.assertThat(tree.FindNodeByKey(13).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.RightChild == null, is(true));

    }

    @Test
    public void deleteTwoLevelTest() {

        BSTNode root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        tree.AddKeyValue(12, 12);
        tree.AddKeyValue(4, 4);
        tree.AddKeyValue(6, 6);
        tree.AddKeyValue(2, 2);
        tree.AddKeyValue(14, 14);
        tree.AddKeyValue(10, 10);
        tree.AddKeyValue(1, 1);
        tree.AddKeyValue(3, 3);
        tree.AddKeyValue(5, 5);
        tree.AddKeyValue(7, 7);
        tree.AddKeyValue(15, 15);
        tree.AddKeyValue(13, 13);
        tree.AddKeyValue(11, 11);
        tree.AddKeyValue(9, 9);

        Assert.assertThat(tree.DeleteNodeByKey(12), is(true));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(false));


        Assert.assertThat(tree.FindNodeByKey(13).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(13).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.FindNodeByKey(14).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.RightChild.NodeKey, is(15));

    }

    @Test
    public void deleteOneRightTest() {

        BSTNode root = new BSTNode(8, 8, null);
        BST tree = new BST(root);

        Assert.assertThat(tree.Count(), is(1));

        tree.AddKeyValue(12, 12);
        Assert.assertThat(tree.Count(), is(2));
        tree.AddKeyValue(4, 4);
        Assert.assertThat(tree.Count(), is(3));
        tree.AddKeyValue(6, 6);
        Assert.assertThat(tree.Count(), is(4));
        tree.AddKeyValue(2, 2);
        Assert.assertThat(tree.Count(), is(5));
        tree.AddKeyValue(14, 14);
        Assert.assertThat(tree.Count(), is(6));
        tree.AddKeyValue(10, 10);
        Assert.assertThat(tree.Count(), is(7));
        tree.AddKeyValue(1, 1);
        Assert.assertThat(tree.Count(), is(8));
        tree.AddKeyValue(3, 3);
        Assert.assertThat(tree.Count(), is(9));
        tree.AddKeyValue(5, 5);
        Assert.assertThat(tree.Count(), is(10));
        tree.AddKeyValue(7, 7);
        Assert.assertThat(tree.Count(), is(11));
        tree.AddKeyValue(15, 15);
        Assert.assertThat(tree.Count(), is(12));
        tree.AddKeyValue(13, 13);
        Assert.assertThat(tree.Count(), is(13));
        tree.AddKeyValue(11, 11);
        Assert.assertThat(tree.Count(), is(14));
        tree.AddKeyValue(9, 9);
        Assert.assertThat(tree.Count(), is(15));

        Assert.assertThat(tree.DeleteNodeByKey(12), is(true));
        Assert.assertThat(tree.Count(), is(14));
        Assert.assertThat(tree.DeleteNodeByKey(12), is(false));
        Assert.assertThat(tree.Count(), is(14));
        Assert.assertThat(tree.DeleteNodeByKey(15), is(true));
        Assert.assertThat(tree.Count(), is(13));
        Assert.assertThat(tree.DeleteNodeByKey(1), is(true));
        Assert.assertThat(tree.Count(), is(12));
        Assert.assertThat(tree.DeleteNodeByKey(4), is(true));
        Assert.assertThat(tree.Count(), is(11));

        Assert.assertThat(tree.FindNodeByKey(12).NodeHasKey, is(false));
        Assert.assertThat(tree.FindNodeByKey(15).NodeHasKey, is(false));
        Assert.assertThat(tree.FindNodeByKey(1).NodeHasKey, is(false));
        Assert.assertThat(tree.FindNodeByKey(4).NodeHasKey, is(false));

        Assert.assertThat(tree.FindNodeByKey(13).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(13).Node.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.FindNodeByKey(13).Node.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.FindNodeByKey(14).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(14).Node.RightChild == null, is(true));

        Assert.assertThat(tree.FindNodeByKey(2).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(2).Node.RightChild.NodeKey, is(3));

        Assert.assertThat(tree.FindNodeByKey(5).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(5).Node.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.FindNodeByKey(5).Node.RightChild.NodeKey, is(6));

        Assert.assertThat(tree.FindNodeByKey(6).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(6).Node.LeftChild == null, is(true));
        Assert.assertThat(tree.FindNodeByKey(6).Node.RightChild.NodeKey, is(7));

        Assert.assertThat(tree.FindNodeByKey(8).NodeHasKey, is(true));
        Assert.assertThat(tree.FindNodeByKey(8).Node.LeftChild.NodeKey, is(5));
        Assert.assertThat(tree.FindNodeByKey(8).Node.RightChild.NodeKey, is(13));

        Assert.assertThat(tree.Count(), is(11));

    }
}