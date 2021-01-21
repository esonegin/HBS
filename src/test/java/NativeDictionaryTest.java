
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class NativeDictionaryTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultPutCycleTest() {
        NativeDictionary dict = new NativeDictionary(5, String.class);

        Assert.assertThat(dict.hashFun("1"), is(0));
        dict.put("1", "first");
        Assert.assertThat(dict.slots[0], is("1"));
        Assert.assertThat(dict.values[0], is("first"));

        Assert.assertThat(dict.hashFun("2"), is(1));
        dict.put("2", "second");
        Assert.assertThat(dict.slots[1], is("2"));
        Assert.assertThat(dict.values[1], is("second"));

        Assert.assertThat(dict.hashFun("3"), is(2));
        dict.put("3", "third");
        Assert.assertThat(dict.slots[2], is("3"));
        Assert.assertThat(dict.values[2], is("third"));

        Assert.assertThat(dict.hashFun("4"), is(3));
        dict.put("4", "fourth");
        Assert.assertThat(dict.slots[3], is("4"));
        Assert.assertThat(dict.values[3], is("fourth"));

        Assert.assertThat(dict.hashFun("5"), is(4));
        dict.put("5", "fifth");
        Assert.assertThat(dict.slots[4], is("5"));
        Assert.assertThat(dict.values[4], is("fifth"));

        Assert.assertThat(dict.hashFun("1"), is(0));
        dict.put("1", "sixth");
        Assert.assertThat(dict.slots[0], is("1"));
        Assert.assertThat(dict.values[0], is("sixth"));

        Assert.assertThat(dict.hashFun("6"), is(0));
        dict.put("6", "seventh");
        Assert.assertThat(dict.slots[0], is("6"));
        Assert.assertThat(dict.values[0], is("seventh"));
    }
    @Test
    public void defaultIsKeyTest() {
        NativeDictionary dict = new NativeDictionary(5, String.class);
        dict.put("1", "first"); //нет
        dict.put("2", "second");
        dict.put("3", "third");
        dict.put("4", "fourth");
        dict.put("5", "fifth");
        dict.put("1", "sixth"); //нет
        dict.put("6", "seventh");
        Assert.assertThat(dict.isKey("1"), is(false));
        Assert.assertThat(dict.isKey("2"), is(true));
        Assert.assertThat(dict.isKey("3"), is(true));
        Assert.assertThat(dict.isKey("4"), is(true));
        Assert.assertThat(dict.isKey("5"), is(true));
        Assert.assertThat(dict.isKey("6"), is(true));

    }
    @Test
    public void defaultIsGetTest() {
        NativeDictionary dict = new NativeDictionary(5, String.class);
        dict.put("1", "first"); //нет
        dict.put("2", "second");
        dict.put("3", "third");
        dict.put("4", "fourth");
        dict.put("5", "fifth");
        dict.put("1", "sixth"); //нет
        dict.put("6", "seventh");
        Assert.assertThat(dict.get("1") == null, is(true));
        Assert.assertThat(dict.get("2"), is("second"));
        Assert.assertThat(dict.get("3"), is("third"));
        Assert.assertThat(dict.get("4"), is("fourth"));
        Assert.assertThat(dict.get("5"), is("fifth"));
        Assert.assertThat(dict.get("6"), is("seventh"));
    }
    @Test
    public void emptyIsGetIsKeyTest() {
        NativeDictionary dict = new NativeDictionary(5, String.class);
        Assert.assertThat(dict.get("1") == null, is(true));
        Assert.assertThat(dict.isKey("1"), is(false));
    }
}