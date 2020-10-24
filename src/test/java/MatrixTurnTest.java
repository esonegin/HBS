import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MatrixTurnTest {

    @BeforeClass
    public static void globalSetUp() {

    }

    @Before
    public void setUp() {

    }
    @Test
    public void ishodnoe() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"123456", "234567", "345678", "456789"}, 4, 6, 1);
        String[] actual = Level1.Matrix;
        String[] expected = {"212345", "343456", "456767", "567898"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void ishodnoeShag1() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"1234", "5678", "9123", "4567"}, 4, 4, 1);
        String[] actual = Level1.Matrix;
        String[] expected = {"5123", "9164", "4278", "5673"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void ishodnoeShag2() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"1234", "5678", "9123", "4567"}, 4, 4, 2);
        String[] actual = Level1.Matrix;
        String[] expected = {"9512", "4213", "5764", "6738"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void ishodnoeShag3() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"1234", "5678", "9123", "4567"}, 4, 4, 3);
        String[] actual = Level1.Matrix;
        String[] expected = {"4951", "5722", "6613", "7384"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void ishodnoeShag4() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"1234", "5678", "9123", "4567"}, 4, 4, 4);
        String[] actual = Level1.Matrix;
        String[] expected = {"5495", "6671", "7122", "3843"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void ishodnoeShag5() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"1234", "5678", "9123", "4567"}, 4, 4, 5);
        String[] actual = Level1.Matrix;
        String[] expected = {"6549", "7165", "3271", "8432"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light1() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 1);
        String[] actual = Level1.Matrix;
        String[] expected = {"31", "42"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light2() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 2);
        String[] actual = Level1.Matrix;
        String[] expected = {"43", "21"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light3() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 3);
        String[] actual = Level1.Matrix;
        String[] expected = {"24", "13"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light4() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 4);
        String[] actual = Level1.Matrix;
        String[] expected = {"12", "34"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light5() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 5);
        String[] actual = Level1.Matrix;
        String[] expected = {"31", "42"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light6() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 6);
        String[] actual = Level1.Matrix;
        String[] expected = {"43", "21"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void light7() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34"}, 2, 2, 7);
        String[] actual = Level1.Matrix;
        String[] expected = {"24", "13"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void dvanatri() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"123", "456"}, 2, 3, 1);
        String[] actual = Level1.Matrix;
        String[] expected = {"412", "563"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva1() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 1);
        String[] actual = Level1.Matrix;
        String[] expected = {"31", "52", "64"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void trinadva2() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 2);
        String[] actual = Level1.Matrix;
        String[] expected = {"53", "61", "42"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva3() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 3);
        String[] actual = Level1.Matrix;
        String[] expected = {"65", "43", "21"};
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void trinadva4() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 4);
        String[] actual = Level1.Matrix;
        String[] expected = {"46", "25", "13"};
        Assert.assertThat(actual, is(expected));
    }


    @Test
    public void trinadva5() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 5);
        String[] actual = Level1.Matrix;
        String[] expected = {"24", "16", "35"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva6() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 6);
        String[] actual = Level1.Matrix;
        String[] expected = {"12", "34", "56"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva7() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 7);
        String[] actual = Level1.Matrix;
        String[] expected = {"31", "52", "64"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva8() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 8);
        String[] actual = Level1.Matrix;
        String[] expected = {"53", "61", "42"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva9() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 9);
        String[] actual = Level1.Matrix;
        String[] expected = {"65", "43", "21"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva10() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 10);
        String[] actual = Level1.Matrix;
        String[] expected = {"46", "25", "13"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva11() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 11);
        String[] actual = Level1.Matrix;
        String[] expected = {"24", "16", "35"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva12() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 12);
        String[] actual = Level1.Matrix;
        String[] expected = {"12", "34", "56"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva13() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 13);
        String[] actual = Level1.Matrix;
        String[] expected = {"31", "52", "64"};
        Assert.assertThat(actual, is(expected));
    }
    @Test
    public void trinadva14() throws Exception {
        //1
        Level1.MatrixTurn(new String[]{"12", "34", "56"}, 3, 2, 14);
        String[] actual = Level1.Matrix;
        String[] expected = {"53", "61", "42"};
        Assert.assertThat(actual, is(expected));
    }

}