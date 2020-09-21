import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BastShoeTest2 {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void first() throws Exception {
        //1
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            Level1.BastShoe("4");
        }
        for (int i = 0; i < 9; i++) {
            Level1.BastShoe("5");
        }
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        actual =  Level1.BastShoe("4"); // abcd ?
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        actual = Level1.BastShoe("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 99; i++) {
            Level1.BastShoe("4");
        }

        actual = Level1.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
    }
}


