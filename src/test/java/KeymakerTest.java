import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class KeymakerTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void one() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(1);
        Assert.assertThat(keymaker.getKey(), is("1"));
    }

    @Test
    public void two() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(2);
        Assert.assertThat(keymaker.getKey(), is("10"));
    }

    @Test
    public void three() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(3);
        Assert.assertThat(keymaker.getKey(), is("100"));
    }

    @Test
    public void four() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(4);
        Assert.assertThat(keymaker.getKey(), is("1001"));
    }

    @Test
    public void five() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(5);
        Assert.assertThat(keymaker.getKey(), is("10010"));
    }

    @Test
    public void six() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(6);
        Assert.assertThat(keymaker.getKey(), is("100100"));
    }

    @Test
    public void seven() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(7);
        Assert.assertThat(keymaker.getKey(), is("1001000"));
    }

    @Test
    public void eight() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(8);
        Assert.assertThat(keymaker.getKey(), is("10010000"));
    }

    @Test
    public void nine() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(9);
        Assert.assertThat(keymaker.getKey(), is("100100001"));
    }

    @Test
    public void ten() throws Exception {
        //1
        Keymaker keymaker = new Keymaker(10);
        Assert.assertThat(keymaker.getKey(), is("1001000010"));
    }
}
