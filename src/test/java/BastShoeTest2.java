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
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            bast.commandExecuter("4");
        }
        for (int i = 0; i < 9; i++) {
            bast.commandExecuter("5");
        }
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("4"); // abcd ?
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        actual = bast.commandExecuter("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 99; i++) {
            bast.commandExecuter("4");
        }
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
    }
}


