
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class QueueTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void firstvar() throws Exception {
        //1
        Queue<T> queue = new Queue<T>();
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(1));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(2);
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(2));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(3);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(2));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(3));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(0));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(0));
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(1));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(2);
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(2));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(3);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(2));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(3));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(3));
    }

    @Test
    public <T> void secondvar() throws Exception {
        //1
        Queue<T> queue = new Queue<T>();
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(1));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue("2");
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is("2"));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(3.14);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));

        queue.dequeue();
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is("2"));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(3.14));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(0));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(0));
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(1));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue("2");
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is("2"));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.enqueue(3.14);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(1));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is("2"));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.array.get(0), is(3.14));
        Assert.assertThat(queue.array.get(queue.array.size() - 1), is(3.14));


    }
}
