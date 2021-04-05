
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
        aBST tree = new aBST(3);

        Assert.assertThat(tree.FindKeyIndex(8), is(0));
        Assert.assertThat(tree.AddKey(8), is(0));
        Assert.assertThat(tree.FindKeyIndex(8), is(0));

        Assert.assertThat(tree.FindKeyIndex(4), is(-1));
        Assert.assertThat(tree.AddKey(4), is(1));
        Assert.assertThat(tree.FindKeyIndex(4), is(1));

        Assert.assertThat(tree.FindKeyIndex(12), is(-2));
        Assert.assertThat(tree.AddKey(12), is(2));
        Assert.assertThat(tree.FindKeyIndex(12), is(2));

        Assert.assertThat(tree.FindKeyIndex(2), is(-3));
        Assert.assertThat(tree.AddKey(2), is(3));
        Assert.assertThat(tree.FindKeyIndex(2), is(3));

        Assert.assertThat(tree.FindKeyIndex(6), is(-4));
        Assert.assertThat(tree.AddKey(6), is(4));
        Assert.assertThat(tree.FindKeyIndex(6), is(4));

        Assert.assertThat(tree.FindKeyIndex(10), is(-5));
        Assert.assertThat(tree.AddKey(10), is(5));
        Assert.assertThat(tree.FindKeyIndex(10), is(5));

        Assert.assertThat(tree.FindKeyIndex(14), is(-6));
        Assert.assertThat(tree.AddKey(14), is(6));
        Assert.assertThat(tree.FindKeyIndex(14), is(6));

        Assert.assertThat(tree.FindKeyIndex(1), is(-7));
        Assert.assertThat(tree.AddKey(1), is(7));
        Assert.assertThat(tree.FindKeyIndex(1), is(7));

        Assert.assertThat(tree.FindKeyIndex(3), is(-8));
        Assert.assertThat(tree.AddKey(3), is(8));
        Assert.assertThat(tree.FindKeyIndex(3), is(8));

        Assert.assertThat(tree.FindKeyIndex(5), is(-9));
        Assert.assertThat(tree.AddKey(5), is(9));
        Assert.assertThat(tree.FindKeyIndex(5), is(9));

        Assert.assertThat(tree.FindKeyIndex(7), is(-10));
        Assert.assertThat(tree.AddKey(7), is(10));
        Assert.assertThat(tree.FindKeyIndex(7), is(10));

        Assert.assertThat(tree.FindKeyIndex(13), is(-13));
        Assert.assertThat(tree.AddKey(13), is(13));
        Assert.assertThat(tree.FindKeyIndex(13), is(13));

        Assert.assertThat(tree.FindKeyIndex(15), is(-14));
        Assert.assertThat(tree.AddKey(15), is(14));
        Assert.assertThat(tree.FindKeyIndex(15), is(14));

        Assert.assertThat(tree.FindKeyIndex(9), is(-11));
        Assert.assertThat(tree.AddKey(9), is(11));
        Assert.assertThat(tree.FindKeyIndex(9), is(11));

        Assert.assertThat(tree.FindKeyIndex(11), is(-12));
        Assert.assertThat(tree.AddKey(11), is(12));
        Assert.assertThat(tree.FindKeyIndex(11), is(12));

        Assert.assertThat(tree.FindKeyIndex(16) == null, is(true));

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
            Assert.assertThat(tree.AddKey(tree.Tree[i]), is(i));
        }

    }

    @Test
    public void defaultFindTest() {
        aBST tree = new aBST(3);

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
        aBST tree = new aBST(3);

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
        aBST tree = new aBST(2);
        Assert.assertThat(tree.FindKeyIndex(8), is(0));
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



        for(int i = 0; i < 1000; i++){
            Assert.assertThat(tree.FindKeyIndex(1) == null, is(true));
        }
        Assert.assertThat(tree.AddKey(1), is(-1));
        for(int i = 0; i < 1000; i++){
            Assert.assertThat(tree.AddKey(1), is(-1));
        }
    }

    @Test
    public void depthTest() {
        aBST tree0 = new aBST(0);
        Assert.assertThat(tree0.Tree.length, is(1));

        aBST tree1 = new aBST(1);
        Assert.assertThat(tree1.Tree.length, is(3));

        aBST tree2 = new aBST(2);
        Assert.assertThat(tree2.Tree.length, is(7));

        aBST tree3 = new aBST(3);
        Assert.assertThat(tree3.Tree.length, is(15));
    }

    @Test
    public void errorTest() {
        aBST tree = new aBST(3);
        Assert.assertThat(tree.Tree.length, is(15));

        Assert.assertThat(tree.FindKeyIndex(50), is(0));
        Assert.assertThat(tree.AddKey(50), is(0));
        Assert.assertThat(tree.AddKey(50), is(0));
        Assert.assertThat(tree.FindKeyIndex(50), is(0));

        Assert.assertThat(tree.FindKeyIndex(25), is(-1));
        Assert.assertThat(tree.AddKey(25), is(1));
        Assert.assertThat(tree.AddKey(25), is(1));
        Assert.assertThat(tree.FindKeyIndex(25), is(1));

        Assert.assertThat(tree.FindKeyIndex(75), is(-2));
        Assert.assertThat(tree.AddKey(75), is(2));
        Assert.assertThat(tree.AddKey(75), is(2));
        Assert.assertThat(tree.FindKeyIndex(75), is(2));

        for(int i = 0; i < 1000; i++){
            Assert.assertThat(tree.FindKeyIndex(37), is(-3));
        }
        for(int i = 0; i < 1000; i++){
            Assert.assertThat(tree.AddKey(37), is(3));
        }
        for(int i = 0; i < 1000; i++){
            Assert.assertThat(tree.FindKeyIndex(37), is(3));
        }

        Assert.assertThat(tree.Tree[0], is(50));
        Assert.assertThat(tree.Tree[1], is(25));
        Assert.assertThat(tree.Tree[2], is(75));
        Assert.assertThat(tree.Tree[3], is(37));
        Assert.assertThat(tree.Tree[4] == null, is(true));
        Assert.assertThat(tree.Tree[5] == null, is(true));
        Assert.assertThat(tree.Tree[6] == null, is(true));

    }
    @Test
    public void error2Test() {
        aBST tree = new aBST(3);
        Assert.assertThat(tree.Tree.length, is(15));

        Assert.assertThat(tree.AddKey(50), is(0));
        Assert.assertThat(tree.AddKey(25), is(1));
        Assert.assertThat(tree.AddKey(75), is(2));
        Assert.assertThat(tree.AddKey(37), is(3));
    }
}
