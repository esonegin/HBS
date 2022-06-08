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

        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.addKey(8), is(0));
        Assert.assertThat(tree.findKeyIndex(8), is(0));

        Assert.assertThat(tree.findKeyIndex(4), is(-1));
        Assert.assertThat(tree.addKey(4), is(1));
        Assert.assertThat(tree.findKeyIndex(4), is(1));

        Assert.assertThat(tree.findKeyIndex(12), is(-2));
        Assert.assertThat(tree.addKey(12), is(2));
        Assert.assertThat(tree.findKeyIndex(12), is(2));

        Assert.assertThat(tree.findKeyIndex(2), is(-3));
        Assert.assertThat(tree.addKey(2), is(3));
        Assert.assertThat(tree.findKeyIndex(2), is(3));

        Assert.assertThat(tree.findKeyIndex(6), is(-4));
        Assert.assertThat(tree.addKey(6), is(4));
        Assert.assertThat(tree.findKeyIndex(6), is(4));

        Assert.assertThat(tree.findKeyIndex(10), is(-5));
        Assert.assertThat(tree.addKey(10), is(5));
        Assert.assertThat(tree.findKeyIndex(10), is(5));

        Assert.assertThat(tree.findKeyIndex(14), is(-6));
        Assert.assertThat(tree.addKey(14), is(6));
        Assert.assertThat(tree.findKeyIndex(14), is(6));

        Assert.assertThat(tree.findKeyIndex(1), is(-7));
        Assert.assertThat(tree.addKey(1), is(7));
        Assert.assertThat(tree.findKeyIndex(1), is(7));

        Assert.assertThat(tree.findKeyIndex(3), is(-8));
        Assert.assertThat(tree.addKey(3), is(8));
        Assert.assertThat(tree.findKeyIndex(3), is(8));

        Assert.assertThat(tree.findKeyIndex(5), is(-9));
        Assert.assertThat(tree.addKey(5), is(9));
        Assert.assertThat(tree.findKeyIndex(5), is(9));

        Assert.assertThat(tree.findKeyIndex(7), is(-10));
        Assert.assertThat(tree.addKey(7), is(10));
        Assert.assertThat(tree.findKeyIndex(7), is(10));

        Assert.assertThat(tree.findKeyIndex(13), is(-13));
        Assert.assertThat(tree.addKey(13), is(13));
        Assert.assertThat(tree.findKeyIndex(13), is(13));

        Assert.assertThat(tree.findKeyIndex(15), is(-14));
        Assert.assertThat(tree.addKey(15), is(14));
        Assert.assertThat(tree.findKeyIndex(15), is(14));

        Assert.assertThat(tree.findKeyIndex(9), is(-11));
        Assert.assertThat(tree.addKey(9), is(11));
        Assert.assertThat(tree.findKeyIndex(9), is(11));

        Assert.assertThat(tree.findKeyIndex(11), is(-12));
        Assert.assertThat(tree.addKey(11), is(12));
        Assert.assertThat(tree.findKeyIndex(11), is(12));

        Assert.assertThat(tree.findKeyIndex(16) == null, is(true));

        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.getTree()[3], is(2));
        Assert.assertThat(tree.getTree()[4], is(6));
        Assert.assertThat(tree.getTree()[5], is(10));
        Assert.assertThat(tree.getTree()[6], is(14));
        Assert.assertThat(tree.getTree()[7], is(1));
        Assert.assertThat(tree.getTree()[8], is(3));
        Assert.assertThat(tree.getTree()[9], is(5));
        Assert.assertThat(tree.getTree()[10], is(7));
        Assert.assertThat(tree.getTree()[11], is(9));
        Assert.assertThat(tree.getTree()[12], is(11));
        Assert.assertThat(tree.getTree()[13], is(13));
        Assert.assertThat(tree.getTree()[14], is(15));

        for (int i = 0; i < tree.getTree().length; i++) {
            Assert.assertThat(tree.addKey(tree.getTree()[i]), is(i));
        }

    }

    @Test
    public void defaultFindTest() {
        aBST tree = new aBST(3);

        tree.addKey(8);
        tree.addKey(4);
        tree.addKey(12);
        tree.addKey(2);
        tree.addKey(6);
        tree.addKey(10);
        tree.addKey(14);
        tree.addKey(1);
        tree.addKey(3);
        tree.addKey(5);
        tree.addKey(7);
        tree.addKey(13);
        tree.addKey(15);
        tree.addKey(9);
        tree.addKey(11);

        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));
        Assert.assertThat(tree.findKeyIndex(2), is(3));
        Assert.assertThat(tree.findKeyIndex(6), is(4));
        Assert.assertThat(tree.findKeyIndex(10), is(5));
        Assert.assertThat(tree.findKeyIndex(14), is(6));
        Assert.assertThat(tree.findKeyIndex(1), is(7));
        Assert.assertThat(tree.findKeyIndex(3), is(8));
        Assert.assertThat(tree.findKeyIndex(5), is(9));
        Assert.assertThat(tree.findKeyIndex(7), is(10));
        Assert.assertThat(tree.findKeyIndex(9), is(11));
        Assert.assertThat(tree.findKeyIndex(11), is(12));
        Assert.assertThat(tree.findKeyIndex(13), is(13));
        Assert.assertThat(tree.findKeyIndex(15), is(14));
    }

    @Test
    public void nullFindTest() {
        aBST tree = new aBST(3);

        tree.addKey(8);
        tree.addKey(4);
        tree.addKey(12);
        tree.addKey(2);
        tree.addKey(6);
        tree.addKey(10);
        tree.addKey(14);
        tree.addKey(1);
        tree.addKey(3);
        tree.addKey(5);
        tree.addKey(7);
        tree.addKey(13);
        tree.addKey(15);
        tree.addKey(9);
        tree.addKey(11);

        Assert.assertThat(tree.findKeyIndex(80) == null, is(true));
        Assert.assertThat(tree.findKeyIndex(0) == null, is(true));
        Assert.assertThat(tree.findKeyIndex(333) == null, is(true));
        Assert.assertThat(tree.findKeyIndex(54) == null, is(true));
        Assert.assertThat(tree.findKeyIndex(65) == null, is(true));
        Assert.assertThat(tree.findKeyIndex(57) == null, is(true));
    }

    @Test
    public void acceptFindTest() {
        aBST tree = new aBST(2);
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        tree.addKey(8);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(-1));
        tree.addKey(4);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));

        Assert.assertThat(tree.findKeyIndex(12), is(-2));
        tree.addKey(12);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));

        Assert.assertThat(tree.findKeyIndex(2), is(-3));
        tree.addKey(2);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.getTree()[3], is(2));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));
        Assert.assertThat(tree.findKeyIndex(2), is(3));

        Assert.assertThat(tree.findKeyIndex(6), is(-4));
        tree.addKey(6);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.getTree()[3], is(2));
        Assert.assertThat(tree.getTree()[4], is(6));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));
        Assert.assertThat(tree.findKeyIndex(2), is(3));
        Assert.assertThat(tree.findKeyIndex(6), is(4));

        Assert.assertThat(tree.findKeyIndex(10), is(-5));
        tree.addKey(10);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.getTree()[3], is(2));
        Assert.assertThat(tree.getTree()[4], is(6));
        Assert.assertThat(tree.getTree()[5], is(10));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));
        Assert.assertThat(tree.findKeyIndex(2), is(3));
        Assert.assertThat(tree.findKeyIndex(6), is(4));
        Assert.assertThat(tree.findKeyIndex(10), is(5));

        Assert.assertThat(tree.findKeyIndex(14), is(-6));
        tree.addKey(14);
        Assert.assertThat(tree.getTree()[0], is(8));
        Assert.assertThat(tree.getTree()[1], is(4));
        Assert.assertThat(tree.getTree()[2], is(12));
        Assert.assertThat(tree.getTree()[3], is(2));
        Assert.assertThat(tree.getTree()[4], is(6));
        Assert.assertThat(tree.getTree()[5], is(10));
        Assert.assertThat(tree.getTree()[6], is(14));
        Assert.assertThat(tree.findKeyIndex(8), is(0));
        Assert.assertThat(tree.findKeyIndex(4), is(1));
        Assert.assertThat(tree.findKeyIndex(12), is(2));
        Assert.assertThat(tree.findKeyIndex(2), is(3));
        Assert.assertThat(tree.findKeyIndex(6), is(4));
        Assert.assertThat(tree.findKeyIndex(10), is(5));
        Assert.assertThat(tree.findKeyIndex(14), is(6));


        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(tree.findKeyIndex(1) == null, is(true));
        }
        Assert.assertThat(tree.addKey(1), is(-1));
        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(tree.addKey(1), is(-1));
        }
    }

    @Test
    public void depthTest() {
        aBST tree0 = new aBST(0);
        Assert.assertThat(tree0.getTree().length, is(1));

        aBST tree1 = new aBST(1);
        Assert.assertThat(tree1.getTree().length, is(3));

        aBST tree2 = new aBST(2);
        Assert.assertThat(tree2.getTree().length, is(7));

        aBST tree3 = new aBST(3);
        Assert.assertThat(tree3.getTree().length, is(15));
    }

    @Test
    public void errorTest() {
        aBST tree = new aBST(3);
        Assert.assertThat(tree.getTree().length, is(15));

        Assert.assertThat(tree.findKeyIndex(50), is(0));
        Assert.assertThat(tree.addKey(50), is(0));
        Assert.assertThat(tree.addKey(50), is(0));
        Assert.assertThat(tree.findKeyIndex(50), is(0));

        Assert.assertThat(tree.findKeyIndex(25), is(-1));
        Assert.assertThat(tree.addKey(25), is(1));
        Assert.assertThat(tree.addKey(25), is(1));
        Assert.assertThat(tree.findKeyIndex(25), is(1));

        Assert.assertThat(tree.findKeyIndex(75), is(-2));
        Assert.assertThat(tree.addKey(75), is(2));
        Assert.assertThat(tree.addKey(75), is(2));
        Assert.assertThat(tree.findKeyIndex(75), is(2));

        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(tree.findKeyIndex(37), is(-4));
        }
        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(tree.addKey(37), is(4));
        }
        for (int i = 0; i < 1000; i++) {
            Assert.assertThat(tree.findKeyIndex(37), is(4));
        }

        Assert.assertThat(tree.getTree()[0], is(50));
        Assert.assertThat(tree.getTree()[1], is(25));
        Assert.assertThat(tree.getTree()[2], is(75));
        Assert.assertThat(tree.getTree()[4], is(37));
        Assert.assertThat(tree.getTree()[3] == null, is(true));
        Assert.assertThat(tree.getTree()[5] == null, is(true));
        Assert.assertThat(tree.getTree()[6] == null, is(true));

    }

    @Test
    public void error2Test() {
        aBST tree = new aBST(3);
        Assert.assertThat(tree.getTree().length, is(15));

        Assert.assertThat(tree.findKeyIndex(50), is(0));
        Assert.assertThat(tree.addKey(50), is(0));
        Assert.assertThat(tree.findKeyIndex(50), is(0));

        Assert.assertThat(tree.findKeyIndex(25), is(-1));
        Assert.assertThat(tree.addKey(25), is(1));
        Assert.assertThat(tree.findKeyIndex(25), is(1));

        Assert.assertThat(tree.findKeyIndex(75), is(-2));
        Assert.assertThat(tree.addKey(75), is(2));
        Assert.assertThat(tree.findKeyIndex(75), is(2));

        Assert.assertThat(tree.findKeyIndex(37), is(-4));
        Assert.assertThat(tree.addKey(37), is(4));
        Assert.assertThat(tree.findKeyIndex(37), is(4));

        Assert.assertThat(tree.findKeyIndex(31), is(-9));
        Assert.assertThat(tree.addKey(31), is(9));
        Assert.assertThat(tree.findKeyIndex(31), is(9));

        Assert.assertThat(tree.findKeyIndex(62), is(-5));
        Assert.assertThat(tree.addKey(62), is(5));
        Assert.assertThat(tree.findKeyIndex(62), is(5));

        Assert.assertThat(tree.findKeyIndex(84), is(-6));
        Assert.assertThat(tree.addKey(84), is(6));
        Assert.assertThat(tree.findKeyIndex(84), is(6));

        Assert.assertThat(tree.findKeyIndex(43), is(-10));
        Assert.assertThat(tree.addKey(43), is(10));
        Assert.assertThat(tree.findKeyIndex(43), is(10));

        Assert.assertThat(tree.findKeyIndex(55), is(-11));
        Assert.assertThat(tree.addKey(55), is(11));
        Assert.assertThat(tree.findKeyIndex(55), is(11));

        Assert.assertThat(tree.findKeyIndex(92), is(-14));
        Assert.assertThat(tree.addKey(92), is(14));
        Assert.assertThat(tree.findKeyIndex(92), is(14));

        Assert.assertThat(tree.findKeyIndex(26) == null, is(true));
        Assert.assertThat(tree.addKey(26), is(-1));

        Assert.assertThat(tree.findKeyIndex(41) == null, is(true));
        Assert.assertThat(tree.addKey(41), is(-1));

        Assert.assertThat(tree.findKeyIndex(13), is(-3));
        Assert.assertThat(tree.addKey(13), is(3));
        Assert.assertThat(tree.findKeyIndex(13), is(3));

        Assert.assertThat(tree.findKeyIndex(65), is(-12));
        Assert.assertThat(tree.addKey(65), is(12));
        Assert.assertThat(tree.findKeyIndex(65), is(12));

    }
}
