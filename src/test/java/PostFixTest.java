
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class PostFixTest {
    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    /*@Test
    public <T> void postfix3()  {
        PostFix postfix = new PostFix();
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push((T) "=");
        arrayList1.push((T) "*");
        arrayList1.push(3);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(1);
        Assert.assertThat(postfix.postfixCheck(arrayList1), is(9));
    }
    @Test
    public <T> void postfix2() {
        PostFix postfix = new PostFix();
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(9);
        arrayList1.push("*");
        arrayList1.push(5);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(8);
        Assert.assertThat(postfix.postfixCheck(arrayList1), is(59));
    }
    @Test
    public <T> void postfixUmnDel()  {
        PostFix postfix = new PostFix();
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(3);
        arrayList1.push("*");
        arrayList1.push(2);
        arrayList1.push("/");
        arrayList1.push(8);
        arrayList1.push(2);
        Assert.assertThat(postfix.postfixCheck(arrayList1), is(11));
    }
    @Test
    public <T> void postNescChisel() {
        PostFix postfix = new PostFix();
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(3);
        arrayList1.push("*");
        arrayList1.push(2);
        arrayList1.push("/");
        arrayList1.push(8);
        arrayList1.push(2);
        arrayList1.push(2);
        Assert.assertThat(postfix.postfixCheck(arrayList1), is(5));
    }*/
}
