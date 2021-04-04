import java.util.*;


public class AlgorithmsDataStructures2
{
    public static int[] GenerateBBSTArray(int[] a)
    {
        Arrays.sort(a);

        int[] result = new int[a.length];

        //8
        result[0] = centralElement(a);

        //4
        result[1] = centralElement(Arrays.copyOfRange(a, 0, result.length / 2));

        //12
        result[2] = centralElement(Arrays.copyOfRange(a, result.length / 2, result.length));

        //2
        result[3] = centralElement(Arrays.copyOfRange(a, 0, result.length / 2 / 2));

        //6
        result[4] = centralElement(Arrays.copyOfRange(a, result.length / 2 / 2, result.length));

        return result;
    }

    public static int centralElement(int[] array){
        return array[array.length / 2];
    }
}