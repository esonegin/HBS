
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
        System.out.println("***********");
        System.out.println(bloomFilter.hash1("1234567890"));
        System.out.println(bloomFilter.hash2("1234567890"));
        System.out.println("***********");
        System.out.println(bloomFilter.hash1("2345678901"));
        System.out.println(bloomFilter.hash2("2345678901"));


        bloomFilter.add("0123456789");
        bloomFilter.add("1234567890");



        //Assert.assertThat(bloomFilter.isValue("0123456789"), is(true));
        //Assert.assertThat(bloomFilter.isValue("1234567890"), is(true));
        //Assert.assertThat(bloomFilter.isValue("3456789012"), is(false));


        /*
        bloomFilter.add("0123456789");
        bloomFilter.add("1234567890");
        bloomFilter.add("2345678901");
        bloomFilter.add("3456789012");
        bloomFilter.add("4567890123");
        bloomFilter.add("5678901234");
        bloomFilter.add("6789012345");
        bloomFilter.add("7890123456");
        bloomFilter.add("8901234567");
        bloomFilter.add("9012345678");*/
    }
}
