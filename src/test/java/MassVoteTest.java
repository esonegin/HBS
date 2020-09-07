import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class MassVoteTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void odinCandidateBolshe50Procentov() throws Exception {
        String actual = MassVote.MassVote(5, new int[]{60, 10, 10, 15, 5});
        String expected = "majority winner 1";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void odinCandidateMenshe50Procentov() throws Exception {
        String actual = MassVote.MassVote(3, new int[]{10, 15, 10});
        String expected = "minority winner 2";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void twoCandidateMaximum() throws Exception {
        String actual = MassVote.MassVote(3, new int[]{50, 10, 50});
        String expected = "no winner";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void twoCandidateVsegoMaximum() throws Exception {
        String actual = MassVote.MassVote(2, new int[]{50, 50});
        String expected = "no winner";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void twoCandidateVsegoRaznie() throws Exception {
        String actual = MassVote.MassVote(2, new int[]{50, 55});
        String expected = "majority winner 2";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void oneCandidateVsego() throws Exception {
        String actual = MassVote.MassVote(1, new int[]{50});
        String expected = "majority winner 1";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void twoCandidateOneZero() throws Exception {
        String actual = MassVote.MassVote(2, new int[]{0, 1});
        String expected = "majority winner 2";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void twoCandidateTwoZero() throws Exception {
        String actual = MassVote.MassVote(2, new int[]{0, 0});
        String expected = "no winner";
        Assert.assertThat(actual, is(expected));
    }

    @Test
    public void threeCandidateOdinMenshe50Procentov() throws Exception {
        String actual = MassVote.MassVote(3, new int[]{23, 50, 27});
        String expected = "minority winner 2";
        Assert.assertThat(actual, is(expected));
    }
}