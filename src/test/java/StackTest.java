import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;


public class StackTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void firstvar() throws Exception {
        //1
        Stack<T> arrayList = new Stack<T>(Integer.class);
        arrayList.push((T) "1");
        arrayList.push(2);
        arrayList.push(3.14);
        Assert.assertThat(arrayList.size(), is(3));
        Assert.assertThat(arrayList.pop(), is(3.14));
        Assert.assertThat(arrayList.size(), is(2));
        Assert.assertThat(arrayList.pop(), is(2));
        Assert.assertThat(arrayList.size(), is(1));
        Assert.assertThat(arrayList.pop(), is("1"));
        Assert.assertThat(arrayList.size(), is(0));

    }
    @Test
    public <T> void popPeekTest() throws Exception {
        //1
        Stack<T> arrayList = new Stack<T>(Integer.class);
        arrayList.push((T) "1");
        arrayList.push(2);
        arrayList.push(3.14);
        Assert.assertThat(arrayList.peek(), is(3.14));
        Assert.assertThat(arrayList.size(), is(3));
        Assert.assertThat(arrayList.pop(), is(3.14));
        Assert.assertThat(arrayList.size(), is(2));
        Assert.assertThat(arrayList.pop(), is(2));
        Assert.assertThat(arrayList.size(), is(1));
        Assert.assertThat(arrayList.pop(), is("1"));
        Assert.assertThat(arrayList.size(), is(0));
    }
    @Test
    public <T> void popPeekEmptyTest() throws Exception {
        //1
        Stack<T> arrayList = new Stack<T>(Integer.class);
        Assert.assertThat(arrayList.pop() == null, is(true));
        Assert.assertThat(arrayList.peek() == null, is(true));
    }
    @Test
    public <T> void dvaPop() throws Exception {
        Stack<T> arrayList = new Stack<T>(Integer.class);
        arrayList.push((T) "1");
        arrayList.push(2);
        arrayList.push(3.14);
        while(arrayList.size() > 0) {
            arrayList.pop();
            arrayList.pop();
        }
        Assert.assertThat(arrayList.size(), is(0));

    }
}
