
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;

public class LinkedListTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void removeMiddleEl() throws Exception {
        LinkedList list = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        list.remove(3);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(3));
    }

    @Test
    public void removeFirstEl() throws Exception {
        LinkedList list = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        Assert.assertNotNull(list.find(1));
        list.remove(1);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(1));
    }

    @Test
    public void removeFinalEl() throws Exception {
        LinkedList list = new LinkedList();
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        list.addInTail(n1);
        list.addInTail(n2);
        list.addInTail(new Node(3));
        list.addInTail(new Node(4));
        Assert.assertNotNull(list.find(4));
        list.remove(4);
        Assert.assertThat(list.head.next.next.next == null, is(true));
        Assert.assertNull(list.find(4));
    }

    @Test
    public void removeEmptyListEl() throws Exception {
        LinkedList list = new LinkedList();
        Assert.assertThat(list.remove(4), is(false));
        Assert.assertNull(list.find(4));
    }

    @Test
    public void removeOneEl() throws Exception {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        Assert.assertNotNull(list.find(1));
        list.remove(1);
        Assert.assertThat(list.head == null, is(true));

        Assert.assertNull(list.find(1));
    }

    @Test
    public void removeThreeEqualsEl() throws Exception {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        list.addInTail(new Node(1));
        Assert.assertNotNull(list.find(1));
        list.remove(1);
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.next.next == null, is(true));
        Assert.assertNotNull(list.find(1));
    }

    @Test
    public void removeBigListEl() throws Exception {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        Assert.assertNotNull(list.find(77));
        list.remove(77);
        Assert.assertNull(list.find(77));
    }

    @Test
    public void removeMultiEl() throws Exception {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 5; i++) {
            list.addInTail(new Node(i));
        }
        list.remove(2);
        list.remove(3);
        Assert.assertNull(list.find(2));
        Assert.assertNull(list.find(3));
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.tail.value == 4, is(true));
    }

    @Test
    public void removeBigListMultiEl() throws Exception {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        for (int i = 2; i < 99; i++) {
            list.remove(i);
        }
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.tail.value == 99, is(true));
    }

    @Test
    public void removAllElBetwen() throws Exception {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(1));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.removeAll(2);
        Assert.assertThat(list.head.value == 1, is(true));
        Assert.assertThat(list.head.next.value == 3, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertNull(list.find(2));
    }

    @Test
    public void removAllElStartPos() throws Exception {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.removeAll(2);
        Assert.assertThat(list.head.value == 3, is(true));
        Assert.assertThat(list.head.next.value == 3, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertNull(list.find(2));
    }

    @Test
    public void removAllElFinishPos() throws Exception {
        LinkedList list = new LinkedList();
        list.addInTail(new Node(3));
        list.addInTail(new Node(3));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.addInTail(new Node(2));
        list.removeAll(2);
        Assert.assertThat(list.head.value == 3, is(true));
        Assert.assertThat(list.head.next.value == 3, is(true));
        Assert.assertThat(list.tail.value == 3, is(true));
        Assert.assertNull(list.find(2));
    }

    @Test
    public void removAllElEmptyList() throws Exception {
        LinkedList list = new LinkedList();
        Assert.assertThat(list.remove(4), is(false));
        Assert.assertNull(list.find(4));
    }

    @Test
    public void clearDefault() throws Exception {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 5; i++) {
            list.addInTail(new Node(i));
        }
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void clearBigList() throws Exception {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 100; i++) {
            list.addInTail(new Node(i));
        }
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void clearEmptyist() throws Exception {
        LinkedList list = new LinkedList();
        list.clear();
        Assert.assertThat(list.head == null, is(true));
        Assert.assertThat(list.tail == null, is(true));
    }

    @Test
    public void findAllBetwen() throws Exception {
        LinkedList act = new LinkedList();
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(2).size() == 3, is(true));
        for(int i = 0; i < 3; i++) {
            Assert.assertThat(act.findAll(2).get(i).value == 2, is(true));
        }
    }
    @Test
    public void findAllStart() throws Exception {
        LinkedList act = new LinkedList();
        act.addInTail(new Node(1));
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(1).size() == 2, is(true));
        for(int i = 0; i < 2; i++) {
            Assert.assertThat(act.findAll(1).get(i).value == 1, is(true));
        }
    }
    @Test
    public void findAllFin() throws Exception {
        LinkedList act = new LinkedList();
        act.addInTail(new Node(1));
        act.addInTail(new Node(1));
        act.addInTail(new Node(2));
        act.addInTail(new Node(2));
        act.addInTail(new Node(3));
        Assert.assertThat(act.findAll(3).size() == 1, is(true));
        for(int i = 0; i < 1; i++) {
            Assert.assertThat(act.findAll(3).get(i).value == 3, is(true));
        }
    }
    @Test
    public void findAllEmpty() throws Exception {
        LinkedList actual = new LinkedList();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(3));
        Assert.assertThat(actual.findAll(7).size() == 0, is(true));
    }

    @Test
    public void count100() throws Exception {
        LinkedList actual = new LinkedList();
        for (int i = 0; i < 100; i++) {
            actual.addInTail(new Node(i));
        }
        Assert.assertThat(actual.count() == 100, is(true));
    }
    @Test
    public void count0() throws Exception {
        LinkedList actual = new LinkedList();
        Assert.assertThat(actual.count() == 0, is(true));
    }
    @Test
    public void insertAfterBetwen() throws Exception {
        LinkedList actual = new LinkedList();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(2), new Node(3));
        Assert.assertThat(actual.find(3).value == 3, is(true));
        Assert.assertThat(actual.find(3).next.value == 4, is(true));
    }
    @Test
    public void insertAfterFirst() throws Exception {
        LinkedList actual = new LinkedList();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(3));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(1), new Node(2));
        Assert.assertThat(actual.find(2).value == 2, is(true));
        Assert.assertThat(actual.find(2).next.value == 3, is(true));
    }
    @Test
    public void insertAfterFinal() throws Exception {
        LinkedList actual = new LinkedList();
        actual.addInTail(new Node(1));
        actual.addInTail(new Node(3));
        actual.addInTail(new Node(4));
        actual.addInTail(new Node(5));
        actual.insertAfter(actual.find(5), new Node(6));
        Assert.assertThat(actual.find(6).value == 6, is(true));
        Assert.assertThat(actual.find(6).next == null, is(true));
    }
    @Test
    public void insertAfterNull() throws Exception {
        LinkedList actual = new LinkedList();
        actual.addInTail(new Node(2));
        actual.addInTail(new Node(3));
        actual.insertAfter(actual.find(5), new Node(1));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).next.value == 2, is(true));
    }
    @Test
    public void inserToEmptyList() throws Exception {
        LinkedList actual = new LinkedList();
        actual.insertAfter(actual.find(1), new Node(1));
        Assert.assertThat(actual.find(1).value == 1, is(true));
        Assert.assertThat(actual.find(1).next == null, is(true));
    }

}