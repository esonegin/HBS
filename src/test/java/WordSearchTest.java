import org.junit.*;

import java.util.Arrays;
import java.util.TreeSet;


public class WordSearchTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void whenWordSearchIntWithoutProbel() throws Exception {
        Stack actual = WordSearch.WordSearch(3, "12345", "123");
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 1);
    }

    @Test
    public void whenWordSearchIntWithOneProbel() throws Exception {
        Stack actual = WordSearch.WordSearch(3, "123 45", "123");
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
    }

    @Test
    public void whenWordSearchStringWithManyProbel() throws Exception {
        Stack actual = WordSearch.WordSearch(12, "1) строка разбивается на набор строк через выравнивание по заданной ширине.", "строк");
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 1);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
        Assert.assertEquals(actual.pop(), 0);
    }
}
