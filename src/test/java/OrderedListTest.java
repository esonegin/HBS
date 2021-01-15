
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

        OrderedList<Integer> list = new OrderedList(true);
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
        Assert.assertThat(list.tail.value, is(4));


    }

    @Test
    public void addPoKrayamTestTrue() {

        OrderedList<Integer> list = new OrderedList(true);
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
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(0));

        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(0));


        list.add(3);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(0));

    }



    @Test
    public void addBetweenTestTrue() {
        OrderedList<Integer> list = new OrderedList(true);
        list.add(1);
        list.add(3);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev.value, is(1));

        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));

        list.add(5);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));

        list.add(4);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.value, is(4));
        Assert.assertThat(list.head.next.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));

        list.add(0);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.next.value, is(4));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(0));

        list.add(2);
        Assert.assertThat(list.count(), is(7));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(4));
        Assert.assertThat(list.head.next.next.next.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.prev.value, is(0));
    }

    @Test
    public void delOneElTestTrue() {

        OrderedList<Integer> list = new OrderedList(true);
        list.add(1);
        Assert.assertThat(list.count(), is(1));
        list.delete(1);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }


    @Test
    public void delTailFalse() {

        OrderedList<Integer> list = new OrderedList(false);
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

        OrderedList<Integer> list = new OrderedList(true);
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
    public void delHeadTrue() {

        OrderedList<Integer> list = new OrderedList(true);
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

        OrderedList<Integer> list = new OrderedList(false);
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
        OrderedList<Integer> list = new OrderedList(false);
        list.add(1);
        list.add(0);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        list.delete(1);

        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(0));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(2));
        //Удаляем хвост
        list.delete(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        list.delete(2);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void delBetweenFourFalse() {
        OrderedList<Integer> list = new OrderedList(false);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Assert.assertThat(list.count(), is(4));

        list.delete(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(4));
        Assert.assertThat(list.head.next.value, is(3));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.value, is(4));

        list.add(2);
        list.delete(3);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(4));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(4));

    }

    @Test
    public void delBetweenThreeTrue() {
        OrderedList<Integer> list = new OrderedList(true);
        list.add(1);
        list.add(0);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        list.delete(1);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(0));

        //Удаляем голову
        list.delete(0);
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.tail.value, is(2));

        list.delete(2);
        Assert.assertThat(list.count(), is(0));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void multiAddFalse() {
        OrderedList<Integer> list = new OrderedList(false);
        list.add(1);
        list.add(3);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(3));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(3));

        list.add(2);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(3));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(3));

        list.add(5);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.head.value, is(5));
        Assert.assertThat(list.head.next.value, is(3));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(5));

        list.add(4);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.head.value, is(5));
        Assert.assertThat(list.head.next.value, is(4));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(1));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(5));

    }

    @Test
    public void ultraAddFalse() {
        OrderedList<Integer> list = new OrderedList(false);
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
        Assert.assertThat(list.head.next.value, is(999));
        Assert.assertThat(list.head.next.next.value, is(998));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
    }

    @Test
    public void ultraDeleteFalse() {
        OrderedList<Integer> list = new OrderedList(false);
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
        Assert.assertThat(list.head.next.value, is(998));
        Assert.assertThat(list.head.next.next.value, is(997));
        Assert.assertThat(list.tail.value, is(1));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(4));

        list.delete(1);
        Assert.assertThat(list.count(), is(998));
        Assert.assertThat(list.head.value, is(999));
        Assert.assertThat(list.head.next.value, is(998));
        Assert.assertThat(list.head.next.next.value, is(997));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(5));
        for (int i = 3; i < 999; i++) {
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
        OrderedList<Integer> list = new OrderedList(true);
        list.add(1);
        list.add(3);
        list.add(2);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));

        list.add(2);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(3));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));

        list.add(5);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));

        list.add(4);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.head.value, is(1));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.value, is(3));
        Assert.assertThat(list.head.next.next.next.next.value, is(4));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(5));
        Assert.assertThat(list.tail.value, is(5));
        Assert.assertThat(list.tail.prev.value, is(4));
        Assert.assertThat(list.tail.prev.prev.value, is(3));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(1));
    }

    @Test
    public void ultraAddTrue() {
        OrderedList<Integer> list = new OrderedList(true);
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
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(1000));
        Assert.assertThat(list.tail.prev.value, is(999));
        Assert.assertThat(list.tail.prev.prev.value, is(998));
    }

    @Test
    public void ultraDeleteTrue() {
        OrderedList<Integer> list = new OrderedList(true);
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
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(3));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.tail.prev.value, is(998));
        Assert.assertThat(list.tail.prev.prev.value, is(997));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(996));

        list.delete(1);
        Assert.assertThat(list.count(), is(998));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(3));
        Assert.assertThat(list.head.next.next.value, is(4));
        Assert.assertThat(list.tail.value, is(999));
        Assert.assertThat(list.tail.prev.value, is(998));
        Assert.assertThat(list.tail.prev.prev.value, is(997));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(996));
        for (int i = 3; i < 999; i++) {
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
        OrderedList<Integer> list = new OrderedList(false);
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
        OrderedList<Integer> list = new OrderedList(false);
        list.add(3);
        list.add(2);
        list.add(1);
        Assert.assertThat(list.getAll().size(), is(3));
    }

    @Test
    public void NewTestFalse() {
        OrderedList<Integer> list = new OrderedList(false);

        list.add(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(2);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.head.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(2);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(0);
        Assert.assertThat(list.count(), is(7));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(0));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.prev.value, is(2));
        Assert.assertThat(list.head.value, is(2));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(0));
        Assert.assertThat(list.head.next.next.next.next.next.next.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
    }

    @Test
    public void NewTestTrue() {
        OrderedList<Integer> list = new OrderedList(true);

        list.add(0);
        Assert.assertThat(list.count(), is(1));
        Assert.assertThat(list.tail.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(2);
        Assert.assertThat(list.count(), is(2));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.tail.prev.value, is(0));
        Assert.assertThat(list.head.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(3));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(4));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(2);
        Assert.assertThat(list.count(), is(5));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(1);
        Assert.assertThat(list.count(), is(6));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(1));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

        list.add(0);
        Assert.assertThat(list.count(), is(7));
        Assert.assertThat(list.tail.value, is(2));
        Assert.assertThat(list.tail.prev.value, is(2));
        Assert.assertThat(list.tail.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.value, is(1));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.value, is(0));
        Assert.assertThat(list.tail.prev.prev.prev.prev.prev.prev.value, is(0));
        Assert.assertThat(list.head.value, is(0));
        Assert.assertThat(list.head.next.value, is(0));
        Assert.assertThat(list.head.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.value, is(1));
        Assert.assertThat(list.head.next.next.next.next.next.value, is(2));
        Assert.assertThat(list.head.next.next.next.next.next.next.value, is(2));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.head.prev == null, is(true));

    }
}
