
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LinkedList2ExtraTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void stanford() throws Exception {
        LinkedList2Extra list = new LinkedList2Extra();
        list.addNode(1);
        list.addNode(2);
        list.addNode(3);
        Assert.assertThat(list.getHead().value == 1, is(true));
        Assert.assertThat(list.getHead().prev == null, is(true));
        Assert.assertThat(list.getHead().next.value == 2, is(true));
        Assert.assertThat(list.getTail().value == 3, is(true));
        Assert.assertThat(list.getTail().prev.value == 2, is(true));
        Assert.assertThat(list.getTail().next == null, is(true));

        Assert.assertThat(list.find(1).value == 1, is(true));
        Assert.assertThat(list.find(2).value == 2, is(true));
        Assert.assertThat(list.find(3).value == 3, is(true));

        //Assert.assertThat(list.find(1).value == 1, is(true));
    }
}