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
        MassVote mass = new MassVote(5, new int[]{60, 10, 10, 15, 5});
        Assert.assertThat(mass.checkWinner(), is("majority winner 1"));
    }

    @Test
    public void odinCandidateMenshe50Procentov() throws Exception {
        MassVote mass = new MassVote(3, new int[]{10, 15, 10});
        Assert.assertThat(mass.checkWinner(), is("minority winner 2"));
    }

    @Test
    public void twoCandidateMaximum() throws Exception {
        MassVote mass = new MassVote(3, new int[]{50, 10, 50});
        Assert.assertThat(mass.checkWinner(), is("no winner"));
    }

    @Test
    public void twoCandidateVsegoMaximum() throws Exception {
        MassVote mass = new MassVote(2, new int[]{50, 50});
        Assert.assertThat(mass.checkWinner(), is("no winner"));
    }

    @Test
    public void oneCandidateVsego() throws Exception {
        MassVote mass = new MassVote(1, new int[]{50});
        Assert.assertThat(mass.checkWinner(), is("majority winner 1"));
    }

    @Test
    public void twoCandidateOneZero() throws Exception {
        MassVote mass = new MassVote(2, new int[]{0, 1});
        Assert.assertThat(mass.checkWinner(), is("majority winner 2"));
    }

    @Test
    public void twoCandidateTwoZero() throws Exception {
        MassVote mass = new MassVote(2, new int[]{0, 0});
        Assert.assertThat(mass.checkWinner(), is("no winner"));
    }

    @Test
    public void threeCandidateOdinMenshe50Procentov() throws Exception {
        MassVote mass = new MassVote(3, new int[]{23, 50, 27});
        Assert.assertThat(mass.checkWinner(), is("minority winner 2"));
    }

    @Test
    public void threeCandidate70Procentov() throws Exception {
        MassVote mass = new MassVote(3, new int[]{23, 7, 70});
        Assert.assertThat(mass.checkWinner(), is("majority winner 3"));
    }
}