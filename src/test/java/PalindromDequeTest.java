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
        Assert.assertThat(stroka.isPalindrom("qweewq"), is(true));
        Assert.assertThat(stroka.isPalindrom("wweewq"), is(false));
        Assert.assertThat(stroka.isPalindrom("qqeewq"), is(false));
        Assert.assertThat(stroka.isPalindrom("qwqewq"), is(false));
        Assert.assertThat(stroka.isPalindrom("qweqwq"), is(false));
        Assert.assertThat(stroka.isPalindrom("qweeqq"), is(false));
        Assert.assertThat(stroka.isPalindrom("qweeww"), is(false));
        Assert.assertThat(stroka.isPalindrom("11"), is(true));
        Assert.assertThat(stroka.isPalindrom("12"), is(false));
        Assert.assertThat(stroka.isPalindrom("21"), is(false));
        Assert.assertThat(stroka.isPalindrom("212"), is(true));
        Assert.assertThat(stroka.isPalindrom("312"), is(false));
        Assert.assertThat(stroka.isPalindrom("213"), is(false));
        Assert.assertThat(stroka.isPalindrom("A"), is(true));
        Assert.assertThat(stroka.isPalindrom(""), is(true));
    }
}
