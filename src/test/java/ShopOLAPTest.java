import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class ShopOLAPTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void defoltnieZnacheniyaFirst() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(5, new String[]{"платье1 5", "сумка32 2", "платье1 1", "сумка23 2", "сумка128 4"});
        String[] expected = {"платье1 6", "сумка128 4", "сумка23 2", "сумка32 2"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void bezDubley() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(4, new String[]{"сумка32 2", "сумка23 2", "сумка128 4", "платье1 5"});
        String[] expected = {"платье1 5", "сумка128 4", "сумка23 2", "сумка32 2"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void dvaDublyaVNachale() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(6, new String[]{"сумка32 2", "сумка23 2", "сумка128 4", "платье1 5", "лоло3 6", "лоло3 4"});
        String[] expected = {"лоло3 10", "платье1 5", "сумка128 4", "сумка23 2", "сумка32 2"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void dvaDublyaVKonce() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(6, new String[]{"сумка23 2", "сумка23 2", "сумка128 700", "платье1 5", "лоло3 6", "лоло3 4"});
        String[] expected = {"сумка128 700", "лоло3 10", "платье1 5", "сумка23 4"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void first() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(5, new String[]{"dress1 5", "handbug32 3", "dress2 1", "handbug23 2", "handbug128 4"});
        String[] expected = {"dress1 5", "handbug128 4", "handbug32 3", "handbug23 2", "dress2 1"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void cifri() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(8, new String[]{"123 5", "32 3", "124 5", "128 1", "32 2", "23 4", "128 4", "128 1"});
        String[] expected = {"128 6", "123 5", "124 5", "32 5", "23 4"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void cifriIbikvi() throws Exception {
        String[] actual = ShopOLAP.ShopOLAP(5, new String[]{"dress1 5", "handbug32 2", "dress1 1", "handbug23 2", "handbug128 4"});
        String[] expected = {"dress1 6", "handbug128 4", "handbug23 2", "handbug32 2"};
        Assert.assertThat(actual, is(expected));
    }

}