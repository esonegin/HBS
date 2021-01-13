
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class OrderedListTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void findTestTrue() {

        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertThat(list.find(3).value, is(3));
        Assert.assertThat(list.find(5) == null, is(true));
        Assert.assertThat(list.find(0) == null, is(true));
        Assert.assertThat(list.find(1) == null, is(false));
        Assert.assertThat(list.find(2) == null, is(false));
        Assert.assertThat(list.find(3) == null, is(false));
        Assert.assertThat(list.find(4) == null, is(false));

        Assert.assertThat(list.find(1).value, is(1));
        Assert.assertThat(list.find(2).value, is(2));
        Assert.assertThat(list.find(3).value, is(3));
        Assert.assertThat(list.find(4).value, is(4));

        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(4));
        Assert.assertThat(list.tail.next.value, is(3));

    }

    @Test
    public void addPoKrayamTestTrue() {

        OrderedList list = new OrderedList(true);
        list.add(1);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.find(1).value, is(1));
        Assert.assertThat(list.count(), is(1));


        list.add(0);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.find(1).value, is(1));
        Assert.assertThat(list.find(0).value, is(0));
        Assert.assertThat(list.count(), is(2));


        list.add(2);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(0));
        Assert.assertThat(list.count(), is(3));

        list.add(3);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(0));
        Assert.assertThat(list.count(), is(4));

    }

    @Test
    public void addPoKrayamMultiTestTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(0);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.find(1).value, is(1));
        Assert.assertThat(list.find(0).value, is(0));
        Assert.assertThat(list.count(), is(2));

        //Добавление в хвост 2
        list.add(1);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(0));
        Assert.assertThat(list.count(), is(3));

        //Добавление в хвост 3
        list.add(1);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(0));
        Assert.assertThat(list.count(), is(4));

        //Добавление в голову 2
        list.add(0);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(0));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(1));

        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(0));
        Assert.assertThat(list.tail.next.next.next.next.value, is(0));
        Assert.assertThat(list.count(), is(5));
    }

    @Test
    public void addBetweenTestTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(3);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.find(1).value, is(1));
        Assert.assertThat(list.find(3).value, is(3));
        Assert.assertThat(list.count(), is(2));

        list.add(2);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(3));

        list.add(5);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        ;
        Assert.assertThat(list.tail.next.value, is(3));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(4));

        list.add(4);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.value, is(4));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.next.value, is(4));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(5));

        list.add(0);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(4));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        ;
        Assert.assertThat(list.tail.next.value, is(4));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.next.next.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(6));

        list.add(2);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.value, is(4));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        ;
        Assert.assertThat(list.tail.next.value, is(4));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.next.next.next.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.count(), is(7));
    }

    @Test
    public void addBetweenMultiTestTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(0);
        list.add(2);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(0));

        list.add(1);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(0));

        list.add(1);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.next.value, is(0));

        list.add(1);
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(1));
        Assert.assertThat(list.tail.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.next.next.next.next.next.value, is(0));

    }

    @Test
    public void addPoKrayamTestFalse() {

        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(3);
        list.add(2);

        Assert.assertThat(list.head.value, is(3));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.count(), is(3));
    }

    @Test
    public void delOneElTestTrue() {

        OrderedList list = new OrderedList(true);
        list.add(1);
        Assert.assertThat(list.count(), is(1));
        list.delete(1);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }


    @Test
    public void delHeadTrue() {

        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(0);
        Assert.assertThat(list.count(), is(2));
        list.delete(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
    }

    @Test
    public void delTailTrue() {

        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(0);
        Assert.assertThat(list.count(), is(2));
        list.delete(1);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
    }

    @Test
    public void delHeadFalse() {

        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(0);
        Assert.assertThat(list.count(), is(2));
        list.delete(1);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
    }

    @Test
    public void delTailFalse() {

        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(0);
        Assert.assertThat(list.count(), is(2));
        list.delete(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev == null, is(true));
    }

    @Test
    public void delBetweenThreeFalse() {
        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(0);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        list.delete(1);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.prev.value, is(0));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.prev == null, is(true));
        //Удаляем хвост
        list.delete(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev == null, is(true));
        list.delete(2);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void delBetweenFourFalse() {
        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertThat(list.count(), is(4));
        list.delete(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(4));
        Assert.assertThat(list.head.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(3));
        Assert.assertThat(list.tail.next.next.value, is(4));
        list.add(2);
        list.delete(3);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(4));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(4));

    }

    @Test
    public void delBetweenThreeTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(0);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        list.delete(1);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(0));
        Assert.assertThat(list.tail.prev == null, is(true));
        //Удаляем голову
        list.delete(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev == null, is(true));
        list.delete(2);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void multiAddFalse() {
        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(3);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(3));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(3));

        list.add(2);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(3));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(3));

        list.add(5);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.head.value, is(5));
        Assert.assertThat(list.head.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.next.value, is(5));

        list.add(4);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.head.value, is(5));
        Assert.assertThat(list.head.prev.value, is(4));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.next.value, is(4));
        Assert.assertThat(list.tail.next.next.next.next.next.value, is(5));

    }

    @Test
    public void ultraAddFalse() {
        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(1000);
        Assert.assertThat(list.head.value, is(1000));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.count(), is(2));
        for (int i = 999; i > 1; i--) {
            list.add(i);
        }
        Assert.assertThat(list.count(), is(1000));
        Assert.assertThat(list.head.value, is(1000));
        Assert.assertThat(list.head.prev.value, is(999));
        Assert.assertThat(list.head.prev.prev.value, is(998));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(3));
    }

    @Test
    public void ultraDeleteFalse() {
        OrderedList list = new OrderedList(false);
        list.add(1);
        list.add(1000);
        Assert.assertThat(list.head.value, is(1000));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.count(), is(2));
        for (int i = 999; i > 1; i--) {
            list.add(i);
        }
        Assert.assertThat(list.count(), is(1000));
        list.delete(1000);
        Assert.assertThat(list.count(), is(999));
        Assert.assertThat(list.head.value, is(999));
        Assert.assertThat(list.head.prev.value, is(998));
        Assert.assertThat(list.head.prev.prev.value, is(997));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.value, is(4));

        list.delete(1);
        Assert.assertThat(list.count(), is(998));
        Assert.assertThat(list.head.value, is(999));
        Assert.assertThat(list.head.prev.value, is(998));
        Assert.assertThat(list.head.prev.prev.value, is(997));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.next.value, is(3));
        Assert.assertThat(list.tail.next.next.value, is(4));
        Assert.assertThat(list.tail.next.next.next.value, is(5));
        for(int i = 3; i < 999; i++){
            list.delete(i);
        }
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.head.value, is(999));
        list.delete(2);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.head.value, is(999));
        list.delete(999);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void multiAddTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(3);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(1));

        list.add(2);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.next.value, is(2));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(1));

        list.add(5);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.next.value, is(3));
        Assert.assertThat(list.tail.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.value, is(1));

        list.add(4);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.prev.prev.value, is(4));
        Assert.assertThat(list.head.prev.prev.prev.prev.prev.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.next.value, is(4));
        Assert.assertThat(list.tail.next.next.value, is(3));
        Assert.assertThat(list.tail.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next.next.next.next.next.value, is(1));
    }

    @Test
    public void ultraAddTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(1000);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.tail.value, is(1000));
        Assert.assertThat(list.count(), is(2));
        for (int i = 999; i > 1; i--) {
            list.add(i);
        }
        Assert.assertThat(list.count(), is(1000));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(1000));
        Assert.assertThat(list.tail.next.value, is(999));
        Assert.assertThat(list.tail.next.next.value, is(998));
    }

    @Test
    public void ultraDeleteTrue() {
        OrderedList list = new OrderedList(true);
        list.add(1);
        list.add(1000);
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.tail.value, is(1000));
        Assert.assertThat(list.count(), is(2));
        for (int i = 999; i > 1; i--) {
            list.add(i);
        }
        Assert.assertThat(list.count(), is(1000));
        list.delete(1000);
        Assert.assertThat(list.count(), is(999));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.prev.value, is(2));
        Assert.assertThat(list.head.prev.prev.value, is(3));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.tail.next.value, is(998));
        Assert.assertThat(list.tail.next.next.value, is(997));
        Assert.assertThat(list.tail.next.next.next.value, is(996));

        list.delete(1);
        Assert.assertThat(list.count(), is(998));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.prev.value, is(3));
        Assert.assertThat(list.head.prev.prev.value, is(4));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.tail.next.value, is(998));
        Assert.assertThat(list.tail.next.next.value, is(997));
        Assert.assertThat(list.tail.next.next.next.value, is(996));
        for(int i = 3; i < 999; i++){
            list.delete(i);
        }
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.head.value, is(2));
        list.delete(999);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        list.delete(2);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void clear() {
        OrderedList list = new OrderedList(false);
        list.add(3);
        list.add(2);
        list.add(1);
        Assert.assertThat(list.count(), is(3));
        list.clear(false);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }
    @Test
    public void getAll() {
        OrderedList list = new OrderedList(false);
        list.add(3);
        list.add(2);
        list.add(1);
        System.out.println(list.getAll());
    }
}
