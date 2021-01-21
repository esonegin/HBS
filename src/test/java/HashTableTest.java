
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
    public void hashFunLength4Step2Test() {
        HashTable hashtable = new HashTable(4, 2);


        Assert.assertThat(hashtable.hashFun("1"), is(0));
        Assert.assertThat(hashtable.put("1"), is(0));
        Assert.assertThat(hashtable.hashFun("2"), is(2));
        Assert.assertThat(hashtable.put("2"), is(2));

        Assert.assertThat(hashtable.hashFun("3"), is(0));
        Assert.assertThat(hashtable.seekSlot("3"), is(1));
        Assert.assertThat(hashtable.put("3"), is(1));

        Assert.assertThat(hashtable.hashFun("4"), is(3));
        Assert.assertThat(hashtable.put("4"), is(3));

        Assert.assertThat(hashtable.hashFun("5"), is(1));
        Assert.assertThat(hashtable.seekSlot("5"), is(-1));
        Assert.assertThat(hashtable.put("5"), is(-1));

    }
    @Test
    public void hashFunLength5Step2Test() {
        HashTable hashtable = new HashTable(5, 2);

        Assert.assertThat(hashtable.hashFun("1"), is(0));
        Assert.assertThat(hashtable.put("1"), is(0));
        Assert.assertThat(hashtable.hashFun("2"), is(2));
        Assert.assertThat(hashtable.put("2"), is(2));
        Assert.assertThat(hashtable.hashFun("3"), is(4));
        Assert.assertThat(hashtable.put("3"), is(4));
        Assert.assertThat(hashtable.hashFun("4"), is(1));
        Assert.assertThat(hashtable.put("4"), is(1));
        Assert.assertThat(hashtable.hashFun("5"), is(3));
        Assert.assertThat(hashtable.put("5"), is(3));

        Assert.assertThat(hashtable.hashFun("6"), is(0));
        Assert.assertThat(hashtable.seekSlot("6"), is(-1));
        Assert.assertThat(hashtable.put("6"), is(-1));
    }

    @Test
    public void hashFunLength5Step1Test() {
        HashTable hashtable = new HashTable(5, 1);

        Assert.assertThat(hashtable.hashFun("1"), is(0));
        Assert.assertThat(hashtable.put("1"), is(0));
        Assert.assertThat(hashtable.hashFun("2"), is(1));
        Assert.assertThat(hashtable.put("2"), is(1));
        Assert.assertThat(hashtable.hashFun("3"), is(2));
        Assert.assertThat(hashtable.put("3"), is(2));
        Assert.assertThat(hashtable.hashFun("4"), is(3));
        Assert.assertThat(hashtable.put("4"), is(3));
        Assert.assertThat(hashtable.hashFun("5"), is(4));
        Assert.assertThat(hashtable.put("5"), is(4));

        Assert.assertThat(hashtable.hashFun("6"), is(0));
        Assert.assertThat(hashtable.seekSlot("6"), is(-1));
        Assert.assertThat(hashtable.put("6"), is(-1));
        Assert.assertThat(hashtable.hashFun("7"), is(0));
        Assert.assertThat(hashtable.seekSlot("7"), is(-1));
        Assert.assertThat(hashtable.put("7"), is(-1));
    }

    @Test
    public void hashFunLength17Step3Test() {
        HashTable hashtable = new HashTable(17, 3);

        Assert.assertThat(hashtable.hashFun("1"), is(0));
        Assert.assertThat(hashtable.put("1"), is(0));
        Assert.assertThat(hashtable.find("1"), is(0));

        Assert.assertThat(hashtable.hashFun("2"), is(3));
        Assert.assertThat(hashtable.put("2"), is(3));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));

        Assert.assertThat(hashtable.hashFun("3"), is(6));
        Assert.assertThat(hashtable.put("3"), is(6));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));

        Assert.assertThat(hashtable.hashFun("4"), is(9));
        Assert.assertThat(hashtable.put("4"), is(9));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));
        Assert.assertThat(hashtable.find("4"), is(9));


        Assert.assertThat(hashtable.hashFun("5"), is(12));
        Assert.assertThat(hashtable.put("5"), is(12));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));
        Assert.assertThat(hashtable.find("4"), is(9));
        Assert.assertThat(hashtable.find("5"), is(12));

        Assert.assertThat(hashtable.hashFun("6"), is(15));
        Assert.assertThat(hashtable.put("6"), is(15));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));
        Assert.assertThat(hashtable.find("4"), is(9));
        Assert.assertThat(hashtable.find("5"), is(12));
        Assert.assertThat(hashtable.find("6"), is(15));

        Assert.assertThat(hashtable.hashFun("7"), is(1));
        Assert.assertThat(hashtable.put("7"), is(1));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));
        Assert.assertThat(hashtable.find("4"), is(9));
        Assert.assertThat(hashtable.find("5"), is(12));
        Assert.assertThat(hashtable.find("6"), is(15));
        Assert.assertThat(hashtable.find("7"), is(1));

        Assert.assertThat(hashtable.hashFun("8"), is(4));
        Assert.assertThat(hashtable.put("8"), is(4));

        Assert.assertThat(hashtable.hashFun("9"), is(7));
        Assert.assertThat(hashtable.put("9"), is(7));

        Assert.assertThat(hashtable.hashFun("10"), is(10));
        Assert.assertThat(hashtable.put("10"), is(10));

        Assert.assertThat(hashtable.hashFun("11"), is(13));
        Assert.assertThat(hashtable.put("11"), is(13));

        Assert.assertThat(hashtable.hashFun("12"), is(16));
        Assert.assertThat(hashtable.put("12"), is(16));

        Assert.assertThat(hashtable.hashFun("13"), is(2));
        Assert.assertThat(hashtable.put("13"), is(2));

        Assert.assertThat(hashtable.hashFun("14"), is(5));
        Assert.assertThat(hashtable.put("14"), is(5));

        Assert.assertThat(hashtable.hashFun("15"), is(8));
        Assert.assertThat(hashtable.put("15"), is(8));

        Assert.assertThat(hashtable.hashFun("16"), is(11));
        Assert.assertThat(hashtable.put("16"), is(11));

        Assert.assertThat(hashtable.hashFun("17"), is(14));
        Assert.assertThat(hashtable.put("17"), is(14));

        Assert.assertThat(hashtable.hashFun("18"), is(0));
        Assert.assertThat(hashtable.seekSlot("18"), is(-1));
        Assert.assertThat(hashtable.put("18"), is(-1));
        Assert.assertThat(hashtable.find("1"), is(0));
        Assert.assertThat(hashtable.find("2"), is(3));
        Assert.assertThat(hashtable.find("3"), is(6));
        Assert.assertThat(hashtable.find("4"), is(9));
        Assert.assertThat(hashtable.find("5"), is(12));
        Assert.assertThat(hashtable.find("6"), is(15));
        Assert.assertThat(hashtable.find("7"), is(1));
        Assert.assertThat(hashtable.find("18"), is(-1));




    }
}