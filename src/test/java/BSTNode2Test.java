
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class BSTNode2Test {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {
        int[] array = {12, 8, 4, 6, 2, 14, 10};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(array);


        Assert.assertThat(tree.Root.NodeKey, is(8));
        Assert.assertThat(tree.Root.LeftChild.NodeKey, is(4));
        Assert.assertThat(tree.Root.RightChild.NodeKey, is(12));
        Assert.assertThat(tree.Root.LeftChild.LeftChild.NodeKey, is(2));
        Assert.assertThat(tree.Root.LeftChild.RightChild.NodeKey, is(6));
        Assert.assertThat(tree.Root.RightChild.LeftChild.NodeKey, is(10));
        Assert.assertThat(tree.Root.RightChild.RightChild.NodeKey, is(14));

        Assert.assertThat(tree.Root.Level, is(1));
        Assert.assertThat(tree.Root.LeftChild.Level, is(2));
        Assert.assertThat(tree.Root.RightChild.Level, is(2));
        Assert.assertThat(tree.Root.LeftChild.LeftChild.Level, is(3));
        Assert.assertThat(tree.Root.LeftChild.RightChild.Level, is(3));
        Assert.assertThat(tree.Root.RightChild.LeftChild.Level, is(3));
        Assert.assertThat(tree.Root.RightChild.RightChild.Level, is(3));

        Assert.assertThat(tree.IsBalanced(tree.Root), is(true));

    }

    @Test
    public void defaultPrevAddTest() {
        int[] array = {50, 25, 75, 37, 62, 84, 31, 43, 55, 92};
        BalancedBST tree = new BalancedBST();
        tree.GenerateTree(array);

        Assert.assertThat(tree.Root.NodeKey, is(50));
        Assert.assertThat(tree.IsBalanced(tree.Root), is(true));


    }
}
