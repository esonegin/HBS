
import org.junit.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class DynArrayTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void onlyAppend() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < dynArray.capacity; i++) {
            dynArray.append(i);
        }
        dynArray.append(16);
        Assert.assertThat(dynArray.capacity, is(32));
        for (int i = 17; i < dynArray.capacity; i++) {
            dynArray.append(i);
            Assert.assertThat(dynArray.capacity, is(32));
        }
        dynArray.append(32);
        Assert.assertThat(dynArray.capacity, is(64));
        for (int i = 33; i < dynArray.capacity; i++) {
            dynArray.append(i);
            Assert.assertThat(dynArray.capacity, is(64));
        }
    }

    @Test
    public void insertDefaultTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.insert(1, 0);
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.getItem(0), is(1));
        dynArray.insert(2, 1);
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.getItem(0), is(1));
        dynArray.insert(0, 0);
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.getItem(0), is(0));
        Assert.assertThat(dynArray.getItem(1), is(1));
        Assert.assertThat(dynArray.getItem(2), is(2));
        dynArray.insert(3, 3);
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.getItem(0), is(0));
        Assert.assertThat(dynArray.getItem(1), is(1));
        Assert.assertThat(dynArray.getItem(2), is(2));
        Assert.assertThat(dynArray.getItem(3), is(3));
        dynArray.insert(8, 0);
        dynArray.insert(8, 2);
        dynArray.insert(8, 4);
        dynArray.insert(8, 6);
        dynArray.insert(8, 8);
        Assert.assertThat(dynArray.getItem(0), is(8));
        Assert.assertThat(dynArray.getItem(1), is(0));
        Assert.assertThat(dynArray.getItem(2), is(8));
        Assert.assertThat(dynArray.getItem(3), is(1));
        Assert.assertThat(dynArray.getItem(4), is(8));
        Assert.assertThat(dynArray.getItem(5), is(2));
        Assert.assertThat(dynArray.getItem(6), is(8));
        Assert.assertThat(dynArray.getItem(7), is(3));
        Assert.assertThat(dynArray.getItem(8), is(8));
    }

    @Test
    public void insertOverTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        for (int i = 16; i < 32; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(32));
        }
        for (int i = 32; i < 64; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(64));
        }
        for (int i = 64; i < 128; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(128));
        }

    }

    @Test
    public void removeDefaultTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(0);
        dynArray.append(1);
        dynArray.append(2);
        dynArray.remove(0);
        Assert.assertThat(dynArray.getItem(0), is(1));
        Assert.assertThat(dynArray.getItem(1), is(2));
        dynArray.remove(0);
        Assert.assertThat(dynArray.getItem(0), is(2));

        dynArray.remove(0);
        Assert.assertThat(dynArray.count, is(0));
        Assert.assertThat(dynArray.capacity, is(16));
        for (int i = 0; i < dynArray.count; i++) {
            Assert.assertThat(dynArray.getItem(i), is((Class<Object>) null));
        }
        for (int i = 0; i < dynArray.count; i++) {
            System.out.println(dynArray.getItem(i));
        }
    }

    @Test
    public void removeSzhatieTestUdalenieSKonca() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            dynArray.insert(i, i);
        }
        Assert.assertThat(dynArray.capacity, is(32));
        Assert.assertThat(dynArray.getItem(16), is(16));
        dynArray.remove(16);
        Assert.assertThat(dynArray.capacity, is(32));
        dynArray.remove(15);
        Assert.assertThat(dynArray.capacity, is(21));
        for (int i = 14; i > 9; i--) {
            dynArray.remove(i);
            Assert.assertThat(dynArray.capacity, is(21));
        }
        for (int i = 9; i > 0; i--) {
            dynArray.remove(i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(16));
    }

    @Test()
    public void insertExcceptionTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(0);
        dynArray.append(1);
        dynArray.append(2);
        dynArray.insert(3, 3);
        try {
            dynArray.insert(6, 6);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Данный индекс вне массива", thrown.getMessage());
        }
        try {
            dynArray.insert(4, -1);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Данный индекс вне массива", thrown.getMessage());
        }
    }


    @Test
    public void removeExcceptionTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        dynArray.append(0);
        dynArray.append(1);
        dynArray.append(2);
        try {
            dynArray.remove(4);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Данный индекс вне массива", thrown.getMessage());
        }
        try {
            dynArray.remove(-1);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("Данный индекс вне массива", thrown.getMessage());
        }
    }

    @Test
    public void globTest() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        try {
            dynArray.getItem(0);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        Assert.assertThat(dynArray.capacity, is(16));
        dynArray.append(0);
        Assert.assertThat(dynArray.getItem(0), is(0));
        dynArray.remove(0);
        try {
            dynArray.getItem(0);
            Assert.fail("Expected IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        for (int i = 0; i < 16; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        dynArray.insert(16, 16);
        Assert.assertThat(dynArray.capacity, is(32));
        dynArray.remove(16);
        dynArray.remove(15);
        Assert.assertThat(dynArray.capacity, is(21));
        dynArray.insert(16, 15);
        for (int i = 16; i < 21; i++) {
            dynArray.append(i);
            Assert.assertThat(dynArray.capacity, is(21));
        }
        dynArray.append(21);
        Assert.assertThat(dynArray.capacity, is(42));
    }

    @Test
    public void insertRashir() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < dynArray.capacity; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        for (int i = 0; i < 16; i++) {
            dynArray.insert(0, i + 10);
            Assert.assertThat(dynArray.capacity, is(32));
        }
        dynArray.insert(0, 1);
        Assert.assertThat(dynArray.capacity, is(64));
    }

    @Test
    public void removeWithoutSuzh16_0() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        dynArray.remove(15);
        try {
            dynArray.getItem(15);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        Assert.assertThat(dynArray.getItem(14), is(14));
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.count, is(15));
        for (int i = 14; i > 0; i--) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(16));
            Assert.assertThat(dynArray.count, is(i));
            try {
                dynArray.getItem(i);
                Assert.fail("Ожидается IndexOutOfBoundsException");
            } catch (IndexOutOfBoundsException thrown) {
                Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
            }
        }
        Assert.assertThat(dynArray.count, is(1));
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(16));
        Assert.assertThat(dynArray.count, is(0));
        try {
            dynArray.getItem(0);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
    }

    @Test
    public void removeWithoutSuzh32_16() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 16; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(16));
        }
        for (int i = 16; i < 32; i++) {
            dynArray.insert(i, i);
            Assert.assertThat(dynArray.capacity, is(32));
        }
        dynArray.remove(31);
        try {
            dynArray.getItem(31);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        Assert.assertThat(dynArray.getItem(30), is(30));
        Assert.assertThat(dynArray.capacity, is(32));
        Assert.assertThat(dynArray.count, is(31));

        for (int i = 0; i < dynArray.capacity / 2 - 1; i++) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(32));
        }
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(21));

        dynArray.remove(14);
        try {
            dynArray.getItem(14);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        Assert.assertThat(dynArray.getItem(13), is(29));
        Assert.assertThat(dynArray.capacity, is(21));
        Assert.assertThat(dynArray.count, is(14));
        for (int i = 14; dynArray.count > 10; i--) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(21));
        }
        for (int i = 9; dynArray.count > 0; i--) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(16));
        }

    }

    @Test
    public void removeSzhatieTestUdalenieSNachala() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 17; i++) {
            dynArray.insert(i, i);
        }
        Assert.assertThat(dynArray.capacity, is(32));
        Assert.assertThat(dynArray.getItem(16), is(16));
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(32));
        try {
            dynArray.getItem(16);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(21));
        try {
            dynArray.getItem(15);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException thrown) {
            Assert.assertEquals("По данному индексу нет значения", thrown.getMessage());
        }
        for (int i = 14; i > 9; i--) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(21));
        }
        for (int i = 9; i > 0; i--) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(16));
        }
    }

    @Test
    public void removeWithoutSuzh2048() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 2048; i++) {
            dynArray.insert(i, i);
        }
        Assert.assertThat(dynArray.capacity, is(2048));
        for (int i = 0; i < 1024; i++) {
            dynArray.remove(0);
            Assert.assertThat(dynArray.capacity, is(2048));
        }
        dynArray.remove(0);
        Assert.assertThat(dynArray.capacity, is(1365));
        for (int i = 1022; i >= 682; i--) {
            dynArray.remove(i);
            Assert.assertThat(dynArray.capacity, is(1365));
        }
        dynArray.remove(681);
        Assert.assertThat(dynArray.capacity, is(910));
    }

    @Test
    public void appendWithoutRashir2048() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 2048; i++) {
            dynArray.insert(i, i);
        }
        Assert.assertThat(dynArray.capacity, is(2048));
        Assert.assertThat(dynArray.getItem(2047), is(2047));
        dynArray.append(2048);
        Assert.assertThat(dynArray.getItem(2048), is(2048));
        Assert.assertThat(dynArray.capacity, is(4096));
        for (int i = 2049; i < 4096; i++) {
            dynArray.append(i);
            Assert.assertThat(dynArray.capacity, is(4096));
        }
        dynArray.append(4096);
        Assert.assertThat(dynArray.getItem(4096), is(4096));
        Assert.assertThat(dynArray.capacity, is(8192));

    }

    @Test
    public void removeInsertDebug() throws Exception {
        DynArray<Integer> dynArray = new DynArray<Integer>(Integer.class);
        for (int i = 0; i < 2048; i++) {
            dynArray.insert(i, i);
        }
        for (int i = 0; i < 1000; i++) {
            dynArray.remove(0);
        }
        Assert.assertThat(dynArray.capacity, is(2048));
        Assert.assertThat(dynArray.count, is(1048));

        try {
            dynArray.insert(1050, 1050);
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Данный индекс вне массива");
        }
        dynArray.remove(1047);
        Assert.assertThat(dynArray.capacity, is(2048));
        Assert.assertThat(dynArray.count, is(1047));
        try {
            dynArray.remove(1047);
            Assert.fail("Ожидается IndexOutOfBoundsException");
        }
        catch (IndexOutOfBoundsException thrown){
            System.out.println("Данный индекс вне массива");
        }
        Assert.assertThat(dynArray.capacity, is(2048));
        Assert.assertThat(dynArray.count, is(1047));
    }
}