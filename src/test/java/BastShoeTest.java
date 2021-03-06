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
        String actual = BastShoe.BastShoe("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("2 2");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //6
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = BastShoe.BastShoe("1 *");
        expected = "Привет, Мир!*";
        Assert.assertThat(actual, is(expected));
        //8
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //10
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("3 6");
        expected = ",";
        Assert.assertThat(actual, is(expected));
        //12
        actual = BastShoe.BastShoe("2 100");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void secondDefault() throws Exception {

        //1
        String actual = BastShoe.BastShoe("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = BastShoe.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //6
        actual = BastShoe.BastShoe("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = BastShoe.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //8
        actual = BastShoe.BastShoe("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = BastShoe.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //10
        actual = BastShoe.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //12
        actual = BastShoe.BastShoe("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //13
        actual = BastShoe.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //14
        actual = BastShoe.BastShoe("2 2");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //15
        actual = BastShoe.BastShoe("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //16
        actual = BastShoe.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //17
        actual = BastShoe.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //18
        actual = BastShoe.BastShoe("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void oneThreeUndo() throws Exception {
        //1
        String actual = BastShoe.BastShoe("1 П");
        String expected = "П";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //5
        actual = BastShoe.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //6
        actual = BastShoe.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //7
        actual = BastShoe.BastShoe("5");
        expected = "П";
        Assert.assertThat(actual, is(expected));
        //8
        actual = BastShoe.BastShoe("1 ривет");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("4");
        expected = "BastShoe";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tenOnePlusUndo() throws Exception {
        //1
        String actual = BastShoe.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        //2-11
        for (int i = 0; i < 10; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //
        for (int i = 0; i < 9; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //11 Исключение
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void tenPlusUndo() throws Exception {
        //0
        String actual = BastShoe.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));
        //1

        for (int i = 0; i < 10; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //11
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = BastShoe.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = BastShoe.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //15
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 100; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

    }

    @Test
    public void undoUndoPlusOdin() throws Exception {
        //1
        String actual = BastShoe.BastShoe("4");
        String expected = "";
        Assert.assertThat(actual, is(expected));
        //1
        actual = BastShoe.BastShoe("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //3
        actual = BastShoe.BastShoe("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tudaSuda() throws Exception {
        //1
        String actual = BastShoe.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = BastShoe.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //3
        actual = BastShoe.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //4
        actual = BastShoe.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //5
        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //11
        actual = BastShoe.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = BastShoe.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = BastShoe.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 6; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        for (int i = 0; i < 5; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //18
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //19
        actual = BastShoe.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //20
        actual = BastShoe.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //20
        actual = BastShoe.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //6
        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //7
        actual = BastShoe.BastShoe("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        //8
        actual = BastShoe.BastShoe("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        //9
        actual = BastShoe.BastShoe("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 5; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //18
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //18
        actual = BastShoe.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //18
        actual = BastShoe.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //18
        actual = BastShoe.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //18
        actual = BastShoe.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void tudaSuda2() throws Exception {
        //0
        String actual = BastShoe.BastShoe("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for(int i=0; i<100; i++)
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));

        for(int i=0; i<99; i++)
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        //10
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //11
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //Откат вот сюда
        actual = BastShoe.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //1
        actual = BastShoe.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //2
        actual = BastShoe.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //3
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for(int i=0; i<7; i++)
            actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for(int i=0; i<6; i++)
            actual = BastShoe.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

        //97
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //98
        actual = BastShoe.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //99
        actual = BastShoe.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //100
        actual = BastShoe.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        actual = BastShoe.BastShoe("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        //1
        actual = BastShoe.BastShoe("4");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        //2
        actual = BastShoe.BastShoe("4");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        //3
        actual = BastShoe.BastShoe("4");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //4
        actual = BastShoe.BastShoe("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //5
        actual = BastShoe.BastShoe("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //6
        actual = BastShoe.BastShoe("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //7
        actual = BastShoe.BastShoe("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for(int i=0; i<93; i++)
            actual = BastShoe.BastShoe("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for(int i=0; i<92; i++)
            actual = BastShoe.BastShoe("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

        //93
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //94
        actual = BastShoe.BastShoe("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //95
        actual = BastShoe.BastShoe("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //96
        actual = BastShoe.BastShoe("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //97
        actual = BastShoe.BastShoe("5");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //98
        actual = BastShoe.BastShoe("5");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));
        //99
        actual = BastShoe.BastShoe("5");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));
        //100
        actual = BastShoe.BastShoe("5");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

    }
    @Test
    public void vidatZaPredelami() throws Exception {
        //1
        String actual = BastShoe.BastShoe("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));

        //11
        actual = BastShoe.BastShoe("3 6");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void undoPlusOdinUndo() throws Exception {
        //1
        String actual = BastShoe.BastShoe("4");
        String expected = "";
        Assert.assertThat(actual, is(expected));
        //1
        actual = BastShoe.BastShoe("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = BastShoe.BastShoe("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = BastShoe.BastShoe("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = BastShoe.BastShoe("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
    }
}


