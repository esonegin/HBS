
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        Stack<T> arrayList = new Stack<T>();
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
        Stack<T> arrayList = new Stack<T>();
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
        Stack<T> arrayList = new Stack<T>();
        Assert.assertThat(arrayList.pop() == null, is(true));
        Assert.assertThat(arrayList.peek() == null, is(true));
    }

    @Test
    public <T> void dvaPop() throws Exception {
        Stack<T> arrayList = new Stack<T>();
        arrayList.push((T) "1");
        arrayList.push(2);
        arrayList.push(3.14);
        while (arrayList.size() > 0) {
            arrayList.pop();
            arrayList.pop();
        }
        Assert.assertThat(arrayList.size(), is(0));

    }

    @Test
    public <T> void defult() throws Exception {
        Stack<T> arrayList = new Stack<T>();
        arrayList.push(1);
        arrayList.push((T) "2");
    }

    @Test
    public <T> void brackets() throws Exception {
        Stack<T> arrayList = new Stack<T>();
        Assert.assertThat(arrayList.brackets(")"), is(false));
        Assert.assertThat(arrayList.brackets("("), is(false));
        Assert.assertThat(arrayList.brackets(")("), is(false));
        Assert.assertThat(arrayList.brackets("()"), is(true));
        Assert.assertThat(arrayList.brackets("((()))"), is(true));
        Assert.assertThat(arrayList.brackets("()((())())"), is(true));
        Assert.assertThat(arrayList.brackets("(()())()()"), is(true));
        Assert.assertThat(arrayList.brackets("((()(())))"), is(true));
        Assert.assertThat(arrayList.brackets("())("), is(false));
        Assert.assertThat(arrayList.brackets("))(("), is(false));
        Assert.assertThat(arrayList.brackets("((())"), is(false));
    }

    @Test
    public <T> void postfix3() throws Exception {
        Stack<T> arrayList1 = new Stack<T>();
        arrayList1.push("=");
        arrayList1.push("*");
        arrayList1.push(3);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(1);
        Assert.assertThat(arrayList1.postfix(arrayList1), is(9));
    }
    @Test
    public <T> void postfix2() throws Exception {
        Stack<T> arrayList1 = new Stack<T>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(9);
        arrayList1.push("*");
        arrayList1.push(5);
        arrayList1.push("+");
        arrayList1.push(2);
        arrayList1.push(8);
        Assert.assertThat(arrayList1.postfix(arrayList1), is(59));
    }
    @Test
    public <T> void postfixUmn() throws Exception {
        Stack<T> arrayList1 = new Stack<T>();
        arrayList1.push("=");
        arrayList1.push("+");
        arrayList1.push(3);
        arrayList1.push("*");
        arrayList1.push(2);
        arrayList1.push("/");
        arrayList1.push(8);
        arrayList1.push(2);
        Assert.assertThat(arrayList1.postfix(arrayList1), is(11));
    }
}
