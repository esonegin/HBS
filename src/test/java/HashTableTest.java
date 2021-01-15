
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class HashTableTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void hashFunTest() {
        HashTable hashtable = new HashTable(5, 3);
        hashtable.size = 5;
        hashtable.put("1");
        hashtable.put("2");
        hashtable.put("3");
        hashtable.put("4");
        hashtable.put("5");
        Assert.assertThat(hashtable.hashFun("1"), is(0));
        Assert.assertThat(hashtable.hashFun("2"), is(3));
        Assert.assertThat(hashtable.hashFun("3"), is(1));
        Assert.assertThat(hashtable.hashFun("4"), is(4));
        Assert.assertThat(hashtable.hashFun("5"), is(2));

    }

    @Test
    public void seekSlotTest() {
        HashTable hashtable = new HashTable(7, 3);
        hashtable.size = 5;
        hashtable.put("1");
        Assert.assertThat(hashtable.seekSlot("2"), is(3));
        hashtable.put("2");
        Assert.assertThat(hashtable.seekSlot("3"), is(6));
        hashtable.put("3");
        Assert.assertThat(hashtable.seekSlot("4"), is(2));

    }

    @Test
    public void putTest() {

        HashTable hashtable = new HashTable(5, 3);
        hashtable.size = 5;
        hashtable.put("1");
        hashtable.put("2");
        hashtable.put("3");
        hashtable.put("4");
        hashtable.put("5");

        Assert.assertThat(hashtable.slots[0], is("1"));
        Assert.assertThat(hashtable.slots[3], is("2"));
        Assert.assertThat(hashtable.slots[1], is("3"));
        Assert.assertThat(hashtable.slots[4], is("4"));
        Assert.assertThat(hashtable.slots[2], is("5"));
        for (int i = 0; i < hashtable.slots.length; i++) {
            System.out.println(hashtable.slots[i]);
        }
        Assert.assertThat(hashtable.put("5"), is(-1));

    }

    @Test
    public void findTest() {

        HashTable hashtable = new HashTable(5, 3);
        hashtable.size = 5;
        hashtable.put("1");
        hashtable.put("2");
        hashtable.put("3");
        hashtable.put("4");
        hashtable.put("5");
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(1));
        Assert.assertThat(hashtable.find("4"), is(4));
        Assert.assertThat(hashtable.find("5"), is(2));
    }

    @Test
    public void seekSecTest() {

        HashTable hashtable = new HashTable(10, 5);
        hashtable.size = 5;
        hashtable.put("1");
        System.out.println(hashtable.seekSlot("2"));
        hashtable.put("2");



    }
}