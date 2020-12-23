
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class QueueThroughStackTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public <T> void firstvar() throws Exception {
        //1
        QueueThroughStack<Integer> queue = new QueueThroughStack<>();
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.stack1.array.get(0), is(1));
        queue.enqueue(2);
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.stack1.array.get(0), is(2));
        Assert.assertThat(queue.stack1.array.get(1), is(1));
        queue.enqueue(3);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.stack1.array.get(0), is(3));
        Assert.assertThat(queue.stack1.array.get(1), is(2));
        Assert.assertThat(queue.stack1.array.get(2), is(1));
        queue.enqueue(4);
        Assert.assertThat(queue.size(), is(4));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        Assert.assertThat(queue.stack1.array.get(1), is(3));
        Assert.assertThat(queue.stack1.array.get(2), is(2));
        Assert.assertThat(queue.stack1.array.get(3), is(1));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        Assert.assertThat(queue.stack1.array.get(1), is(3));
        Assert.assertThat(queue.stack1.array.get(2), is(2));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        Assert.assertThat(queue.stack1.array.get(1), is(3));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        queue.dequeue();
        Assert.assertThat(queue.size(), is(0));

    }

    @Test
    public <T> void threeValue() throws Exception {
        QueueThroughStack<Integer> queue = new QueueThroughStack<>();
        queue.enqueue(1);
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.stack1.array.get(0), is(1));
        queue.enqueue(2);
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.stack1.array.get(0), is(2));
        Assert.assertThat(queue.stack1.array.get(1), is(1));
        queue.enqueue(3);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.stack1.array.get(0), is(3));
        Assert.assertThat(queue.stack1.array.get(1), is(2));
        Assert.assertThat(queue.stack1.array.get(2), is(1));

        //Первое удаление
        Assert.assertThat(queue.dequeue(), is(1));
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.stack1.array.get(0), is(3));
        Assert.assertThat(queue.stack1.array.get(1), is(2));

        //Добавление после удаления
        queue.enqueue(4);
        Assert.assertThat(queue.size(), is(3));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        Assert.assertThat(queue.stack1.array.get(1), is(3));
        Assert.assertThat(queue.stack1.array.get(2), is(2));

        //Второе удаление
        Assert.assertThat(queue.dequeue(), is(2));
        Assert.assertThat(queue.size(), is(2));
        Assert.assertThat(queue.stack1.array.get(0), is(4));
        Assert.assertThat(queue.stack1.array.get(1), is(3));

        //Третье удаление
        Assert.assertThat(queue.dequeue(), is(3));
        Assert.assertThat(queue.size(), is(1));
        Assert.assertThat(queue.stack1.array.get(0), is(4));

        //Четвертое удаление
        Assert.assertThat(queue.dequeue(), is(4));
        Assert.assertThat(queue.size(), is(0));

    }
}
