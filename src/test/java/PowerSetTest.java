
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class PowerSetTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultPutCycleTest() {
        PowerSet powerset = new PowerSet();
        for(int i = 0; i < powerset.size; i++){
            powerset.put("value:" + i);
        }
        powerset.put("value:" + 20000);

        Assert.assertThat(powerset.slots[0], is("value:20000"));
        for(int i = 1; i < powerset.size; i++){
            Assert.assertThat(powerset.slots[i], is("value:" + i));
        }
    }

    @Test
    public void defaultPutDoubleTest() {
        PowerSet powerset = new PowerSet();

        for (int i = 0; i < powerset.slots.length; i++) {
            powerset.put("value: " + i);
        }
        for (int i = 0; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.slots[i], is("value: " + i));
        }

        for (int i = 0; i < powerset.slots.length; i++) {
            powerset.put("value: " + i);
        }
        for (int i = 0; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.slots[i], is("value: " + i));
        }
    }

    @Test
    public void defaultRePutTest() {
        PowerSet powerset = new PowerSet();

        for (int i = 0; i < powerset.slots.length; i++) {
            powerset.put("value: " + i);
        }
        for (int i = 0; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.slots[i], is("value: " + i));
        }

        for (int i = 0, k = 20000; i < powerset.slots.length; i++) {
            powerset.put("value: " + k);
            k++;
        }
        for (int i = 0, k = 20000; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.slots[i], is("value: " + k));
            k++;
        }
    }

    @Test
    public void defaultGetTest() {
        PowerSet powerset = new PowerSet();
        //Assert.assertThat(powerset.get("value:0"), is(false));
        for (int i = 0; i < powerset.slots.length; i++) {
            powerset.put("value:" + i);
        }
        Assert.assertThat(powerset.get("value:0"), is(true));
        Assert.assertThat(powerset.get("value:19999"), is(true));
        Assert.assertThat(powerset.get("value:20000"), is(false));
    }

    @Test
    public void defaultRemoveTest() {
        PowerSet powerset = new PowerSet();
        //Assert.assertThat(powerset.get("value:0"), is(false));
        for (int i = 0; i < powerset.slots.length; i++) {
            powerset.put("value:" + i);
        }
        Assert.assertThat(powerset.get("value:0"), is(true));
        Assert.assertThat(powerset.get("value:19999"), is(true));

        //Удаляем края
        powerset.remove("value:0");
        Assert.assertThat(powerset.get("value:0"), is(false));
        powerset.remove("value:19999");
        Assert.assertThat(powerset.get("value:19999"), is(false));
        Assert.assertThat(powerset.slots[0] == null, is(true));
        Assert.assertThat(powerset.slots[19999] == null, is(true));

        //Возвращаем края
        powerset.put("value:0");
        powerset.put("value:19999");
        Assert.assertThat(powerset.get("value:19999"), is(true));
        Assert.assertThat(powerset.get("value:0"), is(true));
        Assert.assertThat(powerset.slots[0], is("value:0"));
        Assert.assertThat(powerset.slots[19999], is("value:19999"));

        //Удаляем центр
        Assert.assertThat(powerset.get("value:357"), is(true));
        powerset.remove("value:357");
        Assert.assertThat(powerset.get("value:357"), is(false));
        Assert.assertThat(powerset.slots[357] == null, is(true));
        powerset.put("value:357");
        Assert.assertThat(powerset.get("value:357"), is(true));
        Assert.assertThat(powerset.slots[357] == null, is(true));
        Assert.assertThat(powerset.slots[0], is("value:357"));

        //Удаляем все
        for (int i = 1; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.get("value:" + i), is(true));
        }
        for (int i = 1; i < powerset.slots.length; i++) {
            powerset.remove("value:" + i);
        }
        for (int i = 1; i < powerset.slots.length; i++) {
            Assert.assertThat(powerset.get("value:" + i), is(false));
        }

    }

    @Test
    public void defaultIntersectionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();
        powerset1.put("4");
        powerset1.put("5");

        powerset2.put("1");
        powerset2.put("4");
        powerset2.put("2");
        powerset2.put("5");
        powerset2.put("3");

        PowerSet powerset3 = powerset1.intersection(powerset2);
        Assert.assertThat(powerset3.get("4"), is(true));
        Assert.assertThat(powerset3.get("5"), is(true));
        Assert.assertThat(powerset3.get("1"), is(false));
        Assert.assertThat(powerset3.get("2"), is(false));
        Assert.assertThat(powerset3.get("3"), is(false));

    }

    @Test
    public void defaultIntersection2Test() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("4");
        powerset1.put("2");
        powerset1.put("5");
        powerset1.put("3");

        powerset2.put("4");
        powerset2.put("5");

        PowerSet powerset3 = powerset1.intersection(powerset2);
        Assert.assertThat(powerset3.get("4"), is(true));
        Assert.assertThat(powerset3.get("5"), is(true));
        Assert.assertThat(powerset3.get("1"), is(false));
        Assert.assertThat(powerset3.get("2"), is(false));
        Assert.assertThat(powerset3.get("3"), is(false));
    }

    @Test
    public void defaultIntersectionBigDataTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        for (int i = 0; i < powerset1.slots.length; i++) {
            powerset1.put("value:" + i);
        }

        for (int i = 0; i < powerset2.slots.length - 1; i++) {
            powerset2.put("value: null");
        }
        powerset2.put("value:3");

        PowerSet powerset3 = powerset1.intersection(powerset2);
        Assert.assertThat(powerset3.get("value:3"), is(true));
        Assert.assertThat(powerset3.slots[0], is("value:3"));

    }

    @Test
    public void emptyIntersectionBigDataTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("4");
        powerset1.put("2");
        powerset1.put("5");
        powerset1.put("3");

        powerset2.put("6");
        powerset2.put("7");

        PowerSet powerset3 = powerset1.intersection(powerset2);

        for(int i = 0; i < powerset3.slots.length; i++){
            Assert.assertThat(powerset3.slots[i] == null, is(true));
        }
    }

    @Test
    public void defaultUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");
        powerset1.put("3");

        powerset2.put("4");
        powerset2.put("5");

        PowerSet powerset3 = powerset1.union(powerset2);
        Assert.assertThat(powerset3.get("1"), is(true));
        Assert.assertThat(powerset3.get("2"), is(true));
        Assert.assertThat(powerset3.get("3"), is(true));
        Assert.assertThat(powerset3.get("4"), is(true));
        Assert.assertThat(powerset3.get("5"), is(true));
    }

    @Test
    public void defaultUnion2Test() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");

        powerset2.put("3");
        powerset2.put("4");
        powerset2.put("5");

        PowerSet powerset3 = powerset1.union(powerset2);
        Assert.assertThat(powerset3.get("1"), is(true));
        Assert.assertThat(powerset3.get("2"), is(true));
        Assert.assertThat(powerset3.get("3"), is(true));
        Assert.assertThat(powerset3.get("4"), is(true));
        Assert.assertThat(powerset3.get("5"), is(true));
    }

    @Test
    public void bigDataUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        for (int i = 0; i < powerset1.size; i++) {
            powerset1.put("value:" + i);
        }
        for (int i = 20000; i < powerset2.size * 2; i++) {
            powerset2.put("value:" + i);
        }

        Assert.assertThat(powerset1.slots[0], is("value:0"));
        Assert.assertThat(powerset1.slots[19999], is("value:19999"));
        Assert.assertThat(powerset2.slots[0], is("value:20000"));
        Assert.assertThat(powerset2.slots[19999], is("value:39999"));

        PowerSet powerset3 = powerset1.union(powerset2);
        for (int i = 0; i < powerset3.size - 1; i++) {
            Assert.assertThat(powerset3.get("value:" + i), is(true));
        }
    }

    @Test
    public void firstEmptyUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        for (int i = 0; i < powerset2.size; i++) {
            powerset2.put("value:" + i);
        }

        PowerSet powerset3 = powerset1.union(powerset2);
        for (int i = 0; i < powerset2.size; i++) {
            Assert.assertThat(powerset3.get("value:" + i), is(true));
        }
        for (int i = powerset2.size; i < powerset3.size - 1; i++) {
            Assert.assertThat(powerset3.slots[i] == null, is(true));
        }

    }

    @Test
    public void secondEmptyUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        for (int i = 0; i < powerset1.size; i++) {
            powerset1.put("value:" + i);
        }

        PowerSet powerset3 = powerset1.union(powerset2);
        for (int i = 0; i < powerset2.size; i++) {
            Assert.assertThat(powerset3.get("value:" + i), is(true));
        }
        for (int i = powerset2.size; i < powerset3.size - 1; i++) {
            Assert.assertThat(powerset3.slots[i] == null, is(true));
        }
    }

    @Test
    public void doubleAllEmptyUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");
        powerset1.put("3");

        powerset2.put("1");
        powerset2.put("2");
        powerset2.put("3");

        PowerSet powerset3 = powerset1.union(powerset2);
        Assert.assertThat(powerset3.get("1"), is(true));
        Assert.assertThat(powerset3.get("2"), is(true));
        Assert.assertThat(powerset3.get("3"), is(true));
        Assert.assertThat(powerset3.slots[0], is("1"));
        Assert.assertThat(powerset3.slots[1], is("2"));
        Assert.assertThat(powerset3.slots[2], is("3"));
        Assert.assertThat(powerset3.slots[3] == null, is(true));
    }

    @Test
    public void doubleNotAllEmptyUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");
        powerset1.put("3");

        powerset2.put("1");
        powerset2.put("2");
        powerset2.put("3");
        powerset2.put("657");
        powerset2.put("342");

        PowerSet powerset3 = powerset1.union(powerset2);
        Assert.assertThat(powerset3.get("1"), is(true));
        Assert.assertThat(powerset3.get("2"), is(true));
        Assert.assertThat(powerset3.get("3"), is(true));
        Assert.assertThat(powerset3.get("657"), is(true));
        Assert.assertThat(powerset3.get("342"), is(true));
        Assert.assertThat(powerset3.slots[0], is("1"));
        Assert.assertThat(powerset3.slots[1], is("2"));
        Assert.assertThat(powerset3.slots[2], is("3"));
        Assert.assertThat(powerset3.slots[3], is("657"));
        Assert.assertThat(powerset3.slots[4], is("342"));
        Assert.assertThat(powerset3.slots[5] == null, is(true));
    }
    @Test
    public void notDoubleAllEmptyUnionTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("345");
        powerset1.put("67");
        powerset1.put("89");

        powerset2.put("12");
        powerset2.put("23");
        powerset2.put("34");
        powerset2.put("45");
        powerset2.put("56");

        PowerSet powerset3 = powerset1.union(powerset2);
        Assert.assertThat(powerset3.get("345"), is(true));
        Assert.assertThat(powerset3.get("67"), is(true));
        Assert.assertThat(powerset3.get("89"), is(true));
        Assert.assertThat(powerset3.get("12"), is(true));
        Assert.assertThat(powerset3.get("23"), is(true));
        Assert.assertThat(powerset3.get("34"), is(true));
        Assert.assertThat(powerset3.get("45"), is(true));
        Assert.assertThat(powerset3.get("56"), is(true));
        Assert.assertThat(powerset3.slots[0], is("12"));
        Assert.assertThat(powerset3.slots[1], is("23"));
        Assert.assertThat(powerset3.slots[2], is("34"));
        Assert.assertThat(powerset3.slots[3], is("45"));
        Assert.assertThat(powerset3.slots[4], is("56"));
        Assert.assertThat(powerset3.slots[5], is("345"));
        Assert.assertThat(powerset3.slots[6], is("67"));
        Assert.assertThat(powerset3.slots[7], is("89"));
    }

        @Test
    public void defaultDifferenceTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");

        powerset2.put("3");
        powerset2.put("2");
        powerset2.put("5");

        PowerSet powerset3 = powerset1.difference(powerset2);
        PowerSet powerset4 = powerset2.difference(powerset1);

        Assert.assertThat(powerset3.slots[0], is("1"));
        Assert.assertThat(powerset3.get("1"), is(true));
        Assert.assertThat(powerset3.get("2"), is(false));
        Assert.assertThat(powerset3.get("3"), is(false));
        Assert.assertThat(powerset3.get("5"), is(false));

        Assert.assertThat(powerset4.slots[0], is("3"));
        Assert.assertThat(powerset4.slots[1], is("5"));
        Assert.assertThat(powerset4.get("3"), is(true));
        Assert.assertThat(powerset4.get("5"), is(true));
        Assert.assertThat(powerset4.get("2"), is(false));
    }

    @Test
    public void bigDataDifferenceTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();

        for (int i = 0; i < powerset1.size; i++) {
            powerset1.put("value:" + i);
        }
        for (int i = 20000; i < powerset2.size * 2; i++) {
            powerset2.put("value:" + i);
        }

        PowerSet powerset3 = powerset1.difference(powerset2);
        PowerSet powerset4 = powerset2.difference(powerset1);

        for (int i = 0; i < powerset3.size - 1; i++) {
            Assert.assertThat(powerset3.get("value:" + i), is(true));
        }

        for (int i = 0, k = 20000; i < powerset4.size - 1; i++) {
            Assert.assertThat(powerset4.get("value:" + k), is(true));
            k++;
        }
    }

    @Test
    public void isSubsetDefaultTest() {
        PowerSet powerset1 = new PowerSet();
        PowerSet powerset2 = new PowerSet();
        PowerSet powerset3 = new PowerSet();
        PowerSet powerset4 = new PowerSet();

        powerset1.put("1");
        powerset1.put("2");
        powerset1.put("3");
        powerset1.put("4");

        powerset2.put("2");
        powerset2.put("3");

        powerset3.put("2");
        powerset3.put("3");
        powerset3.put("5");

        powerset4.put("1");
        powerset4.put("2");
        powerset4.put("3");
        powerset4.put("4");
        powerset4.put("5");

        Assert.assertThat(powerset1.isSubset(powerset2), is(true));
        Assert.assertThat(powerset1.isSubset(powerset3), is(false));
        Assert.assertThat(powerset1.isSubset(powerset4), is(false));
    }
}