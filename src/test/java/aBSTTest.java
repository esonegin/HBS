
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class aBSTTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultAddTest() {
        aBST tree = new aBST(4);

        tree.AddKey(8);
        tree.AddKey(4);
        tree.AddKey(12);
        tree.AddKey(2);
        tree.AddKey(6);
        tree.AddKey(10);
        tree.AddKey(14);
        tree.AddKey(1);
        tree.AddKey(3);
        tree.AddKey(5);
        tree.AddKey(7);
        tree.AddKey(13);
        tree.AddKey(15);
        tree.AddKey(9);
        tree.AddKey(11);

        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.Tree[3], is(2));
        Assert.assertThat(tree.Tree[4], is(6));
        Assert.assertThat(tree.Tree[5], is(10));
        Assert.assertThat(tree.Tree[6], is(14));
        Assert.assertThat(tree.Tree[7], is(1));
        Assert.assertThat(tree.Tree[8], is(3));
        Assert.assertThat(tree.Tree[9], is(5));
        Assert.assertThat(tree.Tree[10], is(7));
        Assert.assertThat(tree.Tree[11], is(9));
        Assert.assertThat(tree.Tree[12], is(11));
        Assert.assertThat(tree.Tree[13], is(13));
        Assert.assertThat(tree.Tree[14], is(15));

        for (int i = 0; i < tree.Tree.length; i++) {
            Assert.assertThat(tree.AddKey(tree.Tree[i]), is(-1));
        }

    }

    @Test
    public void defaultFindTest() {
        aBST tree = new aBST(4);

        tree.AddKey(8);
        tree.AddKey(4);
        tree.AddKey(12);
        tree.AddKey(2);
        tree.AddKey(6);
        tree.AddKey(10);
        tree.AddKey(14);
        tree.AddKey(1);
        tree.AddKey(3);
        tree.AddKey(5);
        tree.AddKey(7);
        tree.AddKey(13);
        tree.AddKey(15);
        tree.AddKey(9);
        tree.AddKey(11);

        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));
        Assert.assertThat(tree.FindKeyIndex(6), is(4));
        Assert.assertThat(tree.FindKeyIndex(10), is(5));
        Assert.assertThat(tree.FindKeyIndex(14), is(6));
        Assert.assertThat(tree.FindKeyIndex(1), is(7));
        Assert.assertThat(tree.FindKeyIndex(3), is(8));
        Assert.assertThat(tree.FindKeyIndex(5), is(9));
        Assert.assertThat(tree.FindKeyIndex(7), is(10));
        Assert.assertThat(tree.FindKeyIndex(9), is(11));
        Assert.assertThat(tree.FindKeyIndex(11), is(12));
        Assert.assertThat(tree.FindKeyIndex(13), is(13));
        Assert.assertThat(tree.FindKeyIndex(15), is(14));
    }

    @Test
    public void nullFindTest() {
        aBST tree = new aBST(4);

        tree.AddKey(8);
        tree.AddKey(4);
        tree.AddKey(12);
        tree.AddKey(2);
        tree.AddKey(6);
        tree.AddKey(10);
        tree.AddKey(14);
        tree.AddKey(1);
        tree.AddKey(3);
        tree.AddKey(5);
        tree.AddKey(7);
        tree.AddKey(13);
        tree.AddKey(15);
        tree.AddKey(9);
        tree.AddKey(11);

        Assert.assertThat(tree.FindKeyIndex(80) == null, is(true));
        Assert.assertThat(tree.FindKeyIndex(0) == null, is(true));
        Assert.assertThat(tree.FindKeyIndex(333) == null, is(true));
        Assert.assertThat(tree.FindKeyIndex(54) == null, is(true));
        Assert.assertThat(tree.FindKeyIndex(65) == null, is(true));
        Assert.assertThat(tree.FindKeyIndex(57) == null, is(true));
    }

    @Test
    public void acceptFindTest() {
        aBST tree = new aBST(3);
        Assert.assertThat(tree.FindKeyIndex(8), is(-0));
        tree.AddKey(8);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(-1));
        tree.AddKey(4);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));

        Assert.assertThat(tree.FindKeyIndex(12), is(-2));
        tree.AddKey(12);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));

        Assert.assertThat(tree.FindKeyIndex(2), is(-3));
        tree.AddKey(2);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.Tree[3], is(2));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));

        Assert.assertThat(tree.FindKeyIndex(6), is(-4));
        tree.AddKey(6);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.Tree[3], is(2));
        Assert.assertThat(tree.Tree[4], is(6));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));
        Assert.assertThat(tree.FindKeyIndex(6), is(4));

        Assert.assertThat(tree.FindKeyIndex(10), is(-5));
        tree.AddKey(10);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.Tree[3], is(2));
        Assert.assertThat(tree.Tree[4], is(6));
        Assert.assertThat(tree.Tree[5], is(10));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));
        Assert.assertThat(tree.FindKeyIndex(6), is(4));
        Assert.assertThat(tree.FindKeyIndex(10), is(5));

        Assert.assertThat(tree.FindKeyIndex(14), is(-6));
        tree.AddKey(14);
        Assert.assertThat(tree.Tree[0], is(8));
        Assert.assertThat(tree.Tree[1], is(4));
        Assert.assertThat(tree.Tree[2], is(12));
        Assert.assertThat(tree.Tree[3], is(2));
        Assert.assertThat(tree.Tree[4], is(6));
        Assert.assertThat(tree.Tree[5], is(10));
        Assert.assertThat(tree.Tree[6], is(14));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));
        Assert.assertThat(tree.FindKeyIndex(6), is(4));
        Assert.assertThat(tree.FindKeyIndex(10), is(5));
        Assert.assertThat(tree.FindKeyIndex(14), is(6));

        Assert.assertThat(tree.FindKeyIndex(1) == null, is(true));
    }
}
