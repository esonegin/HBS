
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

   /* @Test
    public <T> void postfix3() {
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("*");
        arrayList1.push(3);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(1);
        PostFix postfix = new PostFix(arrayList1);
        Assert.assertThat(postfix.postfixCheck(), is(9));
    }

    @Test
    public <T> void postfix2() {
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(9);
        arrayList1.push("*");
        arrayList1.push(5);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(8);
        PostFix postfix = new PostFix(arrayList1);
        Assert.assertThat(postfix.postfixCheck(), is(59));
    }

    @Test
    public <T> void postfixUmnDel() {
        Stack<T> arrayList1 = new Stack<>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(3);
        arrayList1.push("*");
        arrayList1.push(2);
        arrayList1.push("/");
        arrayList1.push(8);
        arrayList1.push(2);
        PostFix postfix = new PostFix(arrayList1);
        Assert.assertThat(postfix.postfixCheck(), is(11));
    }

    @Test
    public <T> void postNescChisel() {
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
        PostFix postfix = new PostFix(arrayList1);
        Assert.assertThat(postfix.postfixCheck(), is(5));
    }*/
}
