import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class PalindromDequeTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void palindromTest() throws Exception {
        PalindromDeque stroka = new PalindromDeque();

        Assert.assertThat(stroka.PalindromDeque("qweewq"), is(true));
        Assert.assertThat(stroka.PalindromDeque("wweewq"), is(false));
        Assert.assertThat(stroka.PalindromDeque("qqeewq"), is(false));
        Assert.assertThat(stroka.PalindromDeque("qwqewq"), is(false));
        Assert.assertThat(stroka.PalindromDeque("qweqwq"), is(false));
        Assert.assertThat(stroka.PalindromDeque("qweeqq"), is(false));
        Assert.assertThat(stroka.PalindromDeque("qweeww"), is(false));
        Assert.assertThat(stroka.PalindromDeque("11"), is(true));
        Assert.assertThat(stroka.PalindromDeque("12"), is(false));
        Assert.assertThat(stroka.PalindromDeque("21"), is(false));
        Assert.assertThat(stroka.PalindromDeque("212"), is(true));
        Assert.assertThat(stroka.PalindromDeque("312"), is(false));
        Assert.assertThat(stroka.PalindromDeque("213"), is(false));
        Assert.assertThat(stroka.PalindromDeque("A"), is(true));
        Assert.assertThat(stroka.PalindromDeque(""), is(true));
    }
}
