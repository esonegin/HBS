import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class BastShoeTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void firstDefault() throws Exception {
        //1
        String actual = Level1.BastShoe("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("2 2");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //6
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = Level1.BastShoe("1 *");
        expected = "Привет, Мир!*";
        Assert.assertThat(actual, is(expected));
        //8
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //10
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //11
        actual = Level1.BastShoe("3 6");
        expected = ",";
        Assert.assertThat(actual, is(expected));
        //12
        actual = Level1.BastShoe("2 100");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void secondDefault() throws Exception {

        //1
        String actual = Level1.BastShoe("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = Level1.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //6
        actual = Level1.BastShoe("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = Level1.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //8
        actual = Level1.BastShoe("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = Level1.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //10
        actual = Level1.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //11
        actual = Level1.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //12
        actual = Level1.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //13
        actual = Level1.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //14
        actual = Level1.BastShoe("2 2");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //15
        actual = Level1.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //16
        actual = Level1.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //17
        actual = Level1.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //18
        actual = Level1.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void oneThreeUndo() throws Exception {
        //1
        String actual = Level1.BastShoe("1 П");
        String expected = "П";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //5
        actual = Level1.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //6
        actual = Level1.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //7
        actual = Level1.BastShoe("5");
        expected = "П";
        Assert.assertThat(actual, is(expected));
        //8
        actual = Level1.BastShoe("1 ривет");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("4");
        expected = "П";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tenOnePlusUndo() throws Exception {
        //0
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));
        //1

        for (int i = 0; i < 10; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = Level1.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //11 Исключение
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
        //11
        actual = Level1.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void tenPlusUndo() throws Exception {
        //0
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));
        //1

        for (int i = 0; i < 10; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = Level1.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //11
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
        //11
        actual = Level1.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = Level1.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = Level1.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = Level1.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //14
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 100; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

    }

    @Test
    public void undoUndoPlusOdin() throws Exception {
        //1
        String actual = Level1.BastShoe("4");
        String expected = "";
        Assert.assertThat(actual, is(expected));
        //1
        actual = Level1.BastShoe("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 100; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //3
        actual = Level1.BastShoe("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tudaSuda() throws Exception {
        //1
        String actual = Level1.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = Level1.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //11
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = Level1.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //3
        actual = Level1.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //4
        actual = Level1.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //5
        actual = Level1.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //11
        actual = Level1.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = Level1.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = Level1.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = Level1.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 6; i++) {
            actual = Level1.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        for (int i = 0; i < 5; i++) {
            actual = Level1.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //18
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //19
        actual = Level1.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //20
        actual = Level1.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //20
        actual = Level1.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //6
        actual = Level1.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //7
        actual = Level1.BastShoe("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        //8
        actual = Level1.BastShoe("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        //9
        actual = Level1.BastShoe("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 5; i++) {
            actual = Level1.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //18
        actual = Level1.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //18
        actual = Level1.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //18
        actual = Level1.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //18
        actual = Level1.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //18
        actual = Level1.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

    }
}


