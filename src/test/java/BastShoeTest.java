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
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("2 2");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //6
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = bast.commandExecuter("1 *");
        expected = "Привет, Мир!*";
        Assert.assertThat(actual, is(expected));
        //8
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //10
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //11
        actual = bast.commandExecuter("3 6");
        expected = ",";
        Assert.assertThat(actual, is(expected));
        //12
        actual = bast.commandExecuter("2 100");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void secondDefault() throws Exception {
        BastShoe bast = new BastShoe();
        //1
        String actual = bast.commandExecuter("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("1 , Мир!");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("1 ++");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //5
        actual = bast.commandExecuter("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //6
        actual = bast.commandExecuter("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //7
        actual = bast.commandExecuter("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //8
        actual = bast.commandExecuter("5");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //9
        actual = bast.commandExecuter("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //10
        actual = bast.commandExecuter("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //11
        actual = bast.commandExecuter("5");
        expected = "Привет, Мир!++";
        Assert.assertThat(actual, is(expected));
        //12
        actual = bast.commandExecuter("4");
        expected = "Привет, Мир!";
        Assert.assertThat(actual, is(expected));
        //13
        actual = bast.commandExecuter("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //14
        actual = bast.commandExecuter("2 2");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //15
        actual = bast.commandExecuter("4");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //16
        actual = bast.commandExecuter("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //17
        actual = bast.commandExecuter("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));
        //18
        actual = bast.commandExecuter("5");
        expected = "Прив";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void oneThreeUndo() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 П");
        String expected = "П";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //5
        actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //6
        actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //7
        actual = bast.commandExecuter("5");
        expected = "П";
        Assert.assertThat(actual, is(expected));
        //8
        actual = bast.commandExecuter("1 ривет");
        expected = "Привет";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("4");
        expected = "П";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tenOnePlusUndo() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        //2-11
        for (int i = 0; i < 10; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //
        for (int i = 0; i < 9; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //11 Исключение
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
        //11
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void tenPlusUndo() throws Exception {
        //0
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));
        //1

        for (int i = 0; i < 10; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //11
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
        //11
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = bast.commandExecuter("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = bast.commandExecuter("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //15
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 100; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

    }

    @Test
    public void undoUndoPlusOdin() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("4");
        String expected = "";
        Assert.assertThat(actual, is(expected));
        //1
        actual = bast.commandExecuter("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //3
        actual = bast.commandExecuter("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("1 a");
        expected = "aa";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void tudaSuda() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //11
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
        //2
        actual = bast.commandExecuter("1 b");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //3
        actual = bast.commandExecuter("1 c");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //4
        actual = bast.commandExecuter("1 d");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //5
        actual = bast.commandExecuter("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //11
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //12
        actual = bast.commandExecuter("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //13
        actual = bast.commandExecuter("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //14
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 6; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        for (int i = 0; i < 5; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //18
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //19
        actual = bast.commandExecuter("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //20
        actual = bast.commandExecuter("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //20
        actual = bast.commandExecuter("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //6
        actual = bast.commandExecuter("1 e");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //7
        actual = bast.commandExecuter("1 f");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        //8
        actual = bast.commandExecuter("1 g");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        //9
        actual = bast.commandExecuter("1 h");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 5; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }

        //18
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //18
        actual = bast.commandExecuter("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));
        //18
        actual = bast.commandExecuter("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //18
        actual = bast.commandExecuter("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //18
        actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void tudaSuda2() throws Exception {
        //0
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 a");
        String expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 100; i++)
            actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 99; i++)
            actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));
        //10
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //11
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

        //Откат вот сюда
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //1
        actual = bast.commandExecuter("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //2
        actual = bast.commandExecuter("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //3
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 7; i++)
            actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 6; i++)
            actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

        //97
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //98
        actual = bast.commandExecuter("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //99
        actual = bast.commandExecuter("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //100
        actual = bast.commandExecuter("5");
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

        //1
        actual = bast.commandExecuter("4");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));

        //2
        actual = bast.commandExecuter("4");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));

        //3
        actual = bast.commandExecuter("4");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));

        //4
        actual = bast.commandExecuter("4");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));

        //5
        actual = bast.commandExecuter("4");
        expected = "abc";
        Assert.assertThat(actual, is(expected));

        //6
        actual = bast.commandExecuter("4");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //7
        actual = bast.commandExecuter("4");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 93; i++)
            actual = bast.commandExecuter("4");
        expected = "";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 92; i++)
            actual = bast.commandExecuter("5");
        expected = "";
        Assert.assertThat(actual, is(expected));

        //93
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        //94
        actual = bast.commandExecuter("5");
        expected = "ab";
        Assert.assertThat(actual, is(expected));

        //95
        actual = bast.commandExecuter("5");
        expected = "abc";
        Assert.assertThat(actual, is(expected));
        //96
        actual = bast.commandExecuter("5");
        expected = "abcd";
        Assert.assertThat(actual, is(expected));
        //97
        actual = bast.commandExecuter("5");
        expected = "abcde";
        Assert.assertThat(actual, is(expected));
        //98
        actual = bast.commandExecuter("5");
        expected = "abcdef";
        Assert.assertThat(actual, is(expected));
        //99
        actual = bast.commandExecuter("5");
        expected = "abcdefg";
        Assert.assertThat(actual, is(expected));
        //100
        actual = bast.commandExecuter("5");
        expected = "abcdefgh";
        Assert.assertThat(actual, is(expected));

    }

    @Test
    public void vidatZaPredelami() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("1 Привет");
        String expected = "Привет";
        Assert.assertThat(actual, is(expected));

        //11
        actual = bast.commandExecuter("3 6");
        expected = "";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void undoPlusOdinUndo() throws Exception {
        //1
        BastShoe bast = new BastShoe();
        String actual = bast.commandExecuter("4");
        String expected = "";
        Assert.assertThat(actual, is(expected));
        //1
        actual = bast.commandExecuter("1 a");
        expected = "a";
        Assert.assertThat(actual, is(expected));

        for (int i = 0; i < 10; i++) {
            actual = bast.commandExecuter("4");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        for (int i = 0; i < 9; i++) {
            actual = bast.commandExecuter("5");
            expected = "";
            Assert.assertThat(actual, is(expected));
        }
        //10
        actual = bast.commandExecuter("5");
        expected = "a";
        Assert.assertThat(actual, is(expected));
    }
}


