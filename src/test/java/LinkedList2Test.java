
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class LinkedList2Test {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void searchEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        Assert.assertThat(list.find(1).value == 1, is(true));
        Assert.assertThat(list.find(1).next.value == 2, is(true));
        Assert.assertThat(list.find(1).prev == null, is(true));
        Assert.assertThat(list.find(2).value == 2, is(true));
        Assert.assertThat(list.find(2).next.value == 3, is(true));
        Assert.assertThat(list.find(2).prev.value == 1, is(true));
        Assert.assertThat(list.find(3).value == 3, is(true));
        Assert.assertThat(list.find(3).next == null, is(true));
        Assert.assertThat(list.find(3).prev.value == 2, is(true));
    }

    @Test
    public void searchInEmptyList() throws Exception {
        LinkedList2 list = new LinkedList2();
        Assert.assertThat(list.find(1) == null, is(true));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void findAllBetwen() throws Exception {
        LinkedList2 act = new LinkedList2();
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(2).size() == 3, is(true));
        for (int i = 0; i < 3; i++) {
            Assert.assertThat(act.findAll(2).get(i).value == 2, is(true));
        }
        Assert.assertThat(act.findAll(2).get(0).value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(0).prev.value == 1, is(true));
        Assert.assertThat(act.findAll(2).get(0).next.value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(1).value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(1).prev.value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(1).next.value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(2).value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(2).prev.value == 2, is(true));
        Assert.assertThat(act.findAll(2).get(2).next.value == 3, is(true));
    }

    @Test
    public void findAllStart() throws Exception {
        LinkedList2 act = new LinkedList2();
        act.addInTail(new Node(1));
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(1).get(0).value == 1, is(true));
        Assert.assertThat(act.findAll(1).get(0).prev == null, is(true));
        Assert.assertThat(act.findAll(1).get(0).next.value == 1, is(true));
        Assert.assertThat(act.findAll(1).get(1).value == 1, is(true));
        Assert.assertThat(act.findAll(1).get(1).prev.value == 1, is(true));
        Assert.assertThat(act.findAll(1).get(1).next.value == 2, is(true));

    }

    @Test
    public void findAllFin() throws Exception {
        LinkedList2 act = new LinkedList2();
        act.addInTail(new Node(1));
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(3).size() == 1, is(true));
        Assert.assertThat(act.findAll(3).get(0).value == 3, is(true));
        Assert.assertThat(act.findAll(3).get(0).prev.value == 2, is(true));
        Assert.assertThat(act.findAll(3).get(0).next == null, is(true));

    }

    @Test
    public void findAllEmpty() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(3));
        Assert.assertThat(actual.findAll(7).size() == 0, is(true));
    }

    @Test
    public void removeMiddleEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.remove(3);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(3));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.find(2).next.value == 4, is(true));
        Assert.assertThat(list.find(4).next == null, is(true));
        Assert.assertThat(list.find(4).prev.value == 2, is(true));
    }
    @Test
    public void removeFirstEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.remove(1);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(1));
        Assert.assertThat(list.find(2).next.value == 3, is(true));
        Assert.assertThat(list.find(2).prev == null, is(true));
        Assert.assertThat(list.head.value == 2, is(true));
        Assert.assertThat(list.tail.value == 4, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
    }
    @Test
    public void removeFinalEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        Assert.assertNotNull(list.find(4));
        list.remove(4);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(4));
        Assert.assertThat(list.find(3).next == null, is(true));
        Assert.assertThat(list.find(3).prev.value == 2, is(true));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
    }
    @Test
    public void removeEmptyListEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        Assert.assertThat(list.remove(4), is(false));
        Assert.assertNull(list.find(4));
    }
    @Test
    public void removeOneEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        Assert.assertNotNull(list.find(1));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.head.next == null, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
        list.remove(1);
        Assert.assertNull(list.find(1));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));

    }
    @Test
    public void removeThreeEqualsEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        Assert.assertNotNull(list.find(1));
        list.remove(1);
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.head.next.value == 1, is(true));
        Assert.assertThat(list.head.next.next == null, is(true));
        Assert.assertNotNull(list.find(1));
    }
    @Test
    public void removeBigListEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        Assert.assertNotNull(list.find(77));
        list.remove(77);
        Assert.assertNull(list.find(77));
        Assert.assertThat(list.find(76).prev.value == 75, is(true));
        Assert.assertThat(list.find(76).next.value == 78, is(true));
        Assert.assertThat(list.find(78).prev.value == 76, is(true));
        Assert.assertThat(list.find(78).next.value == 79, is(true));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.tail.value == 99, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
    }
    @Test
    public void removeMultiEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        for (int i = 1; i < 6; i++) {
            list.addInTail(new Node(i));
        }
        list.remove(2);
        list.remove(3);
        Assert.assertNull(list.find(2));
        Assert.assertNull(list.find(3));
        Assert.assertThat(list.find(4).prev.value == 1, is(true));
        Assert.assertThat(list.find(4).next.value == 5, is(true));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.head.next.value == 4, is(true));
        Assert.assertThat(list.tail.value == 5, is(true));
        Assert.assertThat(list.tail.prev.value == 4, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
    }
    @Test
    public void removeBigListMultiEl() throws Exception {
        LinkedList2 list = new LinkedList2();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        for (int i = 2; i < 99; i++) {
            list.remove(i);
        }
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.tail.value == 99, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.tail.prev.value == 1, is(true));
    }
    @Test
    public void removAllElBetwen() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.removeAll(2);
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.tail.prev.value == 3, is(true));
        Assert.assertThat(list.find(3).prev.value == 1, is(true));
        Assert.assertThat(list.find(3).next.value == 3, is(true));
    }
    @Test
    public void removAllElStartPos() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.removeAll(2);
        Assert.assertThat(list.head.value == 3, is(true));
        Assert.assertThat(list.head.prev == null, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertThat(list.tail.next == null, is(true));
        Assert.assertThat(list.tail.prev.value == 3, is(true));
        Assert.assertThat(list.find(3).prev == null, is(true));
        Assert.assertThat(list.find(3).next.value == 3, is(true));
    }
    @Test
    public void removAllElEmptyList() throws Exception {
        LinkedList2 list = new LinkedList2();
        Assert.assertThat(list.remove(4), is(false));
        Assert.assertNull(list.find(4));
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }
    @Test
    public void clearDefault() throws Exception {
        LinkedList2 list = new LinkedList2();
        for (int i = 1; i < 5; i++) {
            list.addInTail(new Node(i));
        }
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }
    @Test
    public void clearBigList() throws Exception {
        LinkedList2 list = new LinkedList2();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void clearEmptyist() throws Exception {
        LinkedList2 list = new LinkedList2();
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void count100() throws Exception {
        LinkedList2 actual = new LinkedList2();
        for (int i = 0; i < 100; i++) {
            actual.addInTail(new Node(i));
        }
        Assert.assertThat(actual.count() == 100, is(true));
    }
    @Test
    public void count0() throws Exception {
        LinkedList2 actual = new LinkedList2();
        Assert.assertThat(actual.count() == 0, is(true));
    }

    @Test
    public void insertAfterBetwen() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(2), new Node(3));
        Assert.assertThat(actual.find(3).value == 3, is(true));
        Assert.assertThat(actual.find(3).next.value == 4, is(true));
        Assert.assertThat(actual.find(3).prev.value == 2, is(true));
        Assert.assertThat(actual.find(4).prev.value == 3, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.tail.value == 5, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
        Assert.assertThat(actual.tail.prev.value == 4, is(true));
    }
    @Test
    public void insertAfterFirst() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(3));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(1), new Node(2));
        Assert.assertThat(actual.find(2).value == 2, is(true));
        Assert.assertThat(actual.find(2).next.value == 3, is(true));
        Assert.assertThat(actual.find(2).prev.value == 1, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.tail.value == 5, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
        Assert.assertThat(actual.tail.value == 5, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
        Assert.assertThat(actual.tail.prev.value == 4, is(true));
    }
    @Test
    public void insertAfterFinal() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(3));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(5), new Node(6));
        Assert.assertThat(actual.find(6).value == 6, is(true));
        Assert.assertThat(actual.find(6).next == null, is(true));
        Assert.assertThat(actual.find(6).prev.value == 5, is(true));
        Assert.assertThat(actual.find(5).next.value == 6, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.head.prev == null, is(true));
        Assert.assertThat(actual.tail.value == 6, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
        Assert.assertThat(actual.tail.prev.value == 5, is(true));
    }
    @Test
    public void insertAfterNull() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(3));
        actual.insertAfter(actual.find(5), new Node(1));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).next.value == 2, is(true));
        Assert.assertThat(actual.find(1).prev == null, is(true));
        Assert.assertThat(actual.find(2).prev.value == 1, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.tail.value == 3, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
    }
    @Test
    public void inserToEmptyList() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.insertAfter(actual.find(1), new Node(1));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).next == null, is(true));
        Assert.assertThat(actual.find(1).prev == null, is(true));
        actual.insertAfter(actual.find(1), new Node(2));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).next.value == 2, is(true));
        Assert.assertThat(actual.find(2).prev.value == 1, is(true));
        Assert.assertThat(actual.find(1).next.next == null, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.tail.value == 2, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
    }
    @Test
    public void insertMulti() throws Exception {
        LinkedList2 actual = new LinkedList2();
        actual.addInTail(new Node(1));
        actual.insertAfter(actual.find(1), new Node(2));
        actual.insertAfter(actual.find(2), new Node(3));
        actual.insertAfter(actual.find(3), new Node(4));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).prev == null, is(true));
        Assert.assertThat(actual.find(1).next.value == 2, is(true));
        Assert.assertThat(actual.find(2).value == 2, is(true));
        Assert.assertThat(actual.find(2).prev.value == 1, is(true));
        Assert.assertThat(actual.find(2).next.value == 3, is(true));
        Assert.assertThat(actual.find(3).value == 3, is(true));
        Assert.assertThat(actual.find(3).prev.value == 2, is(true));
        Assert.assertThat(actual.find(3).next.value == 4, is(true));
        Assert.assertThat(actual.find(4).value == 4, is(true));
        Assert.assertThat(actual.find(4).prev.value == 3, is(true));
        Assert.assertThat(actual.find(4).next == null, is(true));
        Assert.assertThat(actual.head.value == 1, is(true));
        Assert.assertThat(actual.head.next.value == 2, is(true));
        Assert.assertThat(actual.tail.value == 4, is(true));
        Assert.assertThat(actual.tail.next == null, is(true));
    }

}
