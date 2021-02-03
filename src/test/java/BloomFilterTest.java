
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;


public class BloomFilterTest {

    @BeforeClass
    public static void globalSetUp() {
    }

    @Before
    public void setUp() {
    }


    @Test
    public void defaultPutCycleTest() {
        BloomFilter bloomFilter = new BloomFilter(32);

        System.out.println(bloomFilter.hash1("0123456789"));
        System.out.println(bloomFilter.hash2("0123456789"));
        bloomFilter.add("0123456789");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("1234567890"));
        System.out.println(bloomFilter.hash2("1234567890"));
        bloomFilter.add("1234567890");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("2345678901"));
        System.out.println(bloomFilter.hash2("2345678901"));
        bloomFilter.add("2345678901");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("3456789012"));
        System.out.println(bloomFilter.hash2("3456789012"));
        bloomFilter.add("3456789012");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("4567890123"));
        System.out.println(bloomFilter.hash2("4567890123"));
        bloomFilter.add("4567890123");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("5678901234"));
        System.out.println(bloomFilter.hash2("5678901234"));
        bloomFilter.add("5678901234");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("6789012345"));
        System.out.println(bloomFilter.hash2("6789012345"));
        bloomFilter.add("6789012345");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("7890123456"));
        System.out.println(bloomFilter.hash2("7890123456"));
        bloomFilter.add("7890123456");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("8901234567"));
        System.out.println(bloomFilter.hash2("8901234567"));
        bloomFilter.add("8901234567");
        System.out.println("***********");

        System.out.println(bloomFilter.hash1("9012345678"));
        System.out.println(bloomFilter.hash2("9012345678"));
        bloomFilter.add("9012345678");
        System.out.println("***********");

    }
    @Test
    public void defaultIsValueCycleTest() {
        BloomFilter bloomFilter = new BloomFilter(32);

        bloomFilter.add("0123456789");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));


        bloomFilter.add("1234567890");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));


        bloomFilter.add("2345678901");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));

        bloomFilter.add("3456789012");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));

        bloomFilter.add("4567890123");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));

        bloomFilter.add("5678901234");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));
        Assert.assertThat(bloomFilter.isValue("5678901234"), is(true));

        bloomFilter.add("6789012345");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));
        Assert.assertThat(bloomFilter.isValue("5678901234"), is(true));
        Assert.assertThat(bloomFilter.isValue("6789012345"), is(true));

        bloomFilter.add("7890123456");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));
        Assert.assertThat(bloomFilter.isValue("5678901234"), is(true));
        Assert.assertThat(bloomFilter.isValue("6789012345"), is(true));
        Assert.assertThat(bloomFilter.isValue("7890123456"), is(true));

        bloomFilter.add("8901234567");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));
        Assert.assertThat(bloomFilter.isValue("5678901234"), is(true));
        Assert.assertThat(bloomFilter.isValue("6789012345"), is(true));
        Assert.assertThat(bloomFilter.isValue("7890123456"), is(true));
        Assert.assertThat(bloomFilter.isValue("8901234567"), is(true));

        bloomFilter.add("9012345678");
        Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        Assert.assertThat(bloomFilter.isValue("2345678901"), is(true));
        Assert.assertThat(bloomFilter.isValue("3456789012"), is(true));
        Assert.assertThat(bloomFilter.isValue("4567890123"), is(true));
        Assert.assertThat(bloomFilter.isValue("5678901234"), is(true));
        Assert.assertThat(bloomFilter.isValue("6789012345"), is(true));
        Assert.assertThat(bloomFilter.isValue("7890123456"), is(true));
        Assert.assertThat(bloomFilter.isValue("8901234567"), is(true));
        Assert.assertThat(bloomFilter.isValue("9012345678"), is(true));

    }
}
