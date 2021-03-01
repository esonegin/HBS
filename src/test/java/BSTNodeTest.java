
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;


public class BSTNodeTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddNodeTest() {

        BSTNode root = new BSTNode(1, 0,null);
        BST tree = new BST(root);

        tree.AddKeyValue(2,2);
        tree.AddKeyValue(3,3);
        System.out.println(tree.Root.NodeValue);
        System.out.println(tree.Root.LeftChild.NodeValue);
        System.out.println(tree.Root.RightChild.NodeValue);

    }
    }