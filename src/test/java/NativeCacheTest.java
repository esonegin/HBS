
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class NativeCacheTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultPutCycleTest() {
        NativeCache cache = new NativeCache(3, String.class);

        cache.put("1", "first");
        cache.put("2", "second");
        cache.put("3", "third");

        cache.isKey("1");
        cache.isKey("2");
        cache.isKey("2");


        Assert.assertThat(cache.slots[0], is("1"));
        Assert.assertThat(cache.slots[1], is("2"));
        Assert.assertThat(cache.slots[2], is("3"));

        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(1));

        cache.put("4", "four");
        Assert.assertThat(cache.slots[0], is("1"));
        Assert.assertThat(cache.slots[1], is("2"));
        Assert.assertThat(cache.slots[2], is("4"));
        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(1));

        cache.put("5", "five");
        Assert.assertThat(cache.slots[0], is("1"));
        Assert.assertThat(cache.slots[1], is("2"));
        Assert.assertThat(cache.slots[2], is("5"));

        cache.isKey("5");
        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(2));

        cache.isKey("5");
        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(3));

        cache.isKey("5");
        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.put("6", "six");
        Assert.assertThat(cache.slots[0], is("6"));
        Assert.assertThat(cache.slots[1], is("2"));
        Assert.assertThat(cache.slots[2], is("5"));
        Assert.assertThat(cache.hits[0], is(1));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.put("6", "six");
        Assert.assertThat(cache.slots[0], is("6"));
        Assert.assertThat(cache.slots[1], is("2"));
        Assert.assertThat(cache.slots[2], is("5"));
        Assert.assertThat(cache.hits[0], is(1));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.get("6");
        Assert.assertThat(cache.hits[0], is(2));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.get("6");
        Assert.assertThat(cache.hits[0], is(3));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.get("6");
        Assert.assertThat(cache.hits[0], is(4));
        Assert.assertThat(cache.hits[1], is(3));
        Assert.assertThat(cache.hits[2], is(4));

        cache.put("7", "seven");
        Assert.assertThat(cache.hits[0], is(4));
        Assert.assertThat(cache.hits[1], is(1));
        Assert.assertThat(cache.hits[2], is(4));
        Assert.assertThat(cache.slots[0], is("6"));
        Assert.assertThat(cache.slots[1], is("7"));
        Assert.assertThat(cache.slots[2], is("5"));

    }
}