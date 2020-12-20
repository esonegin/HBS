import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class QueueRotateTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void firstvar() throws Exception {
        //1
        QueueRotate rotate = new QueueRotate();
        Queue<T> queue = new Queue<T>();
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(2);
        queue.enqueue(2);
        Assert.assertThat(queue.size(), is(6));
        rotate.rotate(queue, 3);
        Assert.assertThat(queue.array.get(0), is(1));
        Assert.assertThat(queue.array.get(1), is(1));
        Assert.assertThat(queue.array.get(2), is(1));
        Assert.assertThat(queue.array.get(3), is(2));
        Assert.assertThat(queue.array.get(4), is(2));
        Assert.assertThat(queue.array.get(5), is(2));
        rotate.rotate(queue, 2);
        Assert.assertThat(queue.array.get(0), is(2));
        Assert.assertThat(queue.array.get(1), is(2));
        Assert.assertThat(queue.array.get(2), is(1));
        Assert.assertThat(queue.array.get(3), is(1));
        Assert.assertThat(queue.array.get(4), is(1));
        Assert.assertThat(queue.array.get(5), is(2));
        rotate.rotate(queue, 1);
        Assert.assertThat(queue.array.get(0), is(2));
        Assert.assertThat(queue.array.get(1), is(2));
        Assert.assertThat(queue.array.get(2), is(2));
        Assert.assertThat(queue.array.get(3), is(1));
        Assert.assertThat(queue.array.get(4), is(1));
        Assert.assertThat(queue.array.get(5), is(1));
        rotate.rotate(queue, 0);
        Assert.assertThat(queue.array.get(0), is(2));
        Assert.assertThat(queue.array.get(1), is(2));
        Assert.assertThat(queue.array.get(2), is(2));
        Assert.assertThat(queue.array.get(3), is(1));
        Assert.assertThat(queue.array.get(4), is(1));
        Assert.assertThat(queue.array.get(5), is(1));

    }
}