import org.junit.*;
import java.util.Arrays;


public class WordSearchTest {

    @BeforeClass
    public static void globalSetUp() { }

    @Before
    public void setUp() { }

    @Test
    public void whenWordSearchIntWithoutProbel() throws Exception {
        int[] actual = WordSearch.WordSearch(3, "12345", "123");
        int[] expected = {1,0};
        Assert.assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void whenWordSearchIntWithOneProbel() throws Exception {
        int[] actual = WordSearch.WordSearch(3, "123 45", "123");
        int[] expected = {1, 0};
        Assert.assertTrue(Arrays.equals(actual, expected));
    }

    @Test
    public void whenWordSearchStringWithManyProbel() throws Exception {
        int[] actual = WordSearch.WordSearch(12, "1) строка разбивается на набор строк через выравнивание по заданной ширине.", "строк");
        int[] expected = {0,0,0,1,0,0,0};
        Assert.assertTrue(Arrays.equals(actual, expected));
    }

}
