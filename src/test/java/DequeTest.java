
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;


public class DequeTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }

    @Test
    public void firstAddTail() throws IOException {
        Deque<Integer> deque = new Deque<>();
        //Добавление в голову первое
        deque.addFront(1);
        Assert.assertThat(deque.size(), is(1));
        Assert.assertThat(deque.deque.get(0), is(1));

        //Добавление в голову второе
        deque.addFront(0);
        Assert.assertThat(deque.size(), is(2));
        Assert.assertThat(deque.deque.get(0), is(1));
        Assert.assertThat(deque.deque.get(1), is(0));

        //Добавление в хвост первое
        deque.addTail(2);
        Assert.assertThat(deque.size(), is(3));
        Assert.assertThat(deque.deque.get(0), is(2));
        Assert.assertThat(deque.deque.get(1), is(1));
        Assert.assertThat(deque.deque.get(2), is(0));


        //Добавление в хвост второе
        deque.addTail(3);
        Assert.assertThat(deque.size(), is(4));
        Assert.assertThat(deque.deque.get(0), is(3));
        Assert.assertThat(deque.deque.get(1), is(2));
        Assert.assertThat(deque.deque.get(2), is(1));
        Assert.assertThat(deque.deque.get(3), is(0));


        //Удаление с хвоста первое
        deque.removeTail();
        Assert.assertThat(deque.size(), is(3));
        Assert.assertThat(deque.deque.get(0), is(2));
        Assert.assertThat(deque.deque.get(1), is(1));
        Assert.assertThat(deque.deque.get(2), is(0));


        //Удаление с головы первое
        deque.removeFront();
        Assert.assertThat(deque.size(), is(2));
        Assert.assertThat(deque.deque.get(0), is(2));
        Assert.assertThat(deque.deque.get(1), is(1));


        //Удаление с хвоста второе
        deque.removeTail();
        Assert.assertThat(deque.size(), is(1));
        Assert.assertThat(deque.deque.get(0), is(1));


        //Удаление с головы второе
        deque.removeFront();
        Assert.assertThat(deque.size(), is(0));

        //Удаление с хвоста пустого
        Assert.assertThat(deque.removeTail() == null, is(true));
        Assert.assertThat(deque.size(), is(0));

        //Удаление с головы пустого
        Assert.assertThat(deque.removeFront() == null, is(true));
        Assert.assertThat(deque.size(), is(0));

    }

    @Test
    public void firstAddFront() {

        //1
        Deque<Integer> deque = new Deque<>();

        //Добавление в хвост первое
        deque.addTail(1);
        Assert.assertThat(deque.size(), is(1));
        Assert.assertThat(deque.deque.get(0), is(1));

        //Удаление с хвоста первое
        deque.removeTail();
        Assert.assertThat(deque.size(), is(0));

        //Добавление в голову первое
        deque.addFront(1);
        Assert.assertThat(deque.size(), is(1));
        Assert.assertThat(deque.deque.get(0), is(1));

        //Удаление с хвоста первое
        deque.removeFront();
        Assert.assertThat(deque.size(), is(0));
    }

    @Test
    public void manyValueAddFront() {

        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10000; i++) {
            deque.addFront(i);
        }

        for (int i = 0; i < 10000; i++) {
            Assert.assertThat(deque.deque.get(i), is(i));
        }
        Assert.assertThat(deque.size(), is(10000));
    }

    @Test
    public void manyValueAddTail() {

        Deque<Integer> deque = new Deque<>();
        for (int i = 0; i < 10000; i++) {
            deque.addTail(i);
        }
        for (int i = 1000; i > 10000; i--) {
            Assert.assertThat(deque.deque.get(i), is(i));
        }
        Assert.assertThat(deque.size(), is(10000));
    }


    @Test
    public void removeEmptyDeque() {
        Deque<Integer> deque = new Deque<>();

        //Удаление с хвоста первое
        for (int i = 0; i < 100; i++) {
            //Удаление с хвоста пустой очереди
            Assert.assertThat(deque.removeTail() == null, is(true));
            Assert.assertThat(deque.removeTail() == null, is(true));
            Assert.assertThat(deque.size(), is(0));
        }

        for (int i = 0; i < 100; i++) {
            //Удаление с головы пустой очереди
            Assert.assertThat(deque.removeFront() == null, is(true));
            Assert.assertThat(deque.removeFront() == null, is(true));
            Assert.assertThat(deque.size(), is(0));
        }

    }

    @Test
    public void easyRemoveFront() {
        Deque<Integer> qu = new Deque<>();
        qu.removeFront();
    }
    @Test
    public void easyRemoveTail() {
        Deque<Integer> qu = new Deque<>();
        qu.removeTail();
    }

    @Test
    public void addFr() {
        Deque<Integer> deque = new Deque<>();
        deque.addFront(0);
        Assert.assertThat(deque.deque.get(0), is(0));

        deque.addFront(1);
        Assert.assertThat(deque.deque.get(0), is(0));
        Assert.assertThat(deque.deque.get(1), is(1));

        deque.addFront(2);
        Assert.assertThat(deque.deque.get(0), is(0));
        Assert.assertThat(deque.deque.get(1), is(1));
        Assert.assertThat(deque.deque.get(2), is(2));
    }
}



