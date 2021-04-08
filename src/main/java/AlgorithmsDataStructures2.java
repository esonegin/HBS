import java.util.*;


public class AlgorithmsDataStructures2 {

    public static int[] GenerateBBSTArray(int[] a) {

        int[] result = new int[a.length];
        Arrays.sort(a);

        result[0] = centralElement(a);

        for (int i = 1; i < 2; i++) {
            result[i] = centralElement(leftPiece(a));
            result[i + i] = centralElement(rightPiece(a));
        }


        result[2 * (2 * 0 + 1) + 1] = centralElement(leftPiece(leftPiece(a)));
        result[2 * (2 * 0 + 1) + 2] = centralElement(rightPiece(leftPiece(a)));

        result[2 * (2 * 0 + 2) + 1] = centralElement(leftPiece(rightPiece(a)));
        result[2 * (2 * 0 + 2) + 2] = centralElement(rightPiece(rightPiece(a)));

        return result;
    }

    public static int[] leftPiece(int[] a) {
        return Arrays.copyOfRange(a, 0, a.length / 2);
    }

    public static int[] rightPiece(int[] a) {
        return Arrays.copyOfRange(a, a.length / 2, a.length);
    }

    public static int centralElement(int[] array) {
        return array[array.length / 2];
    }

}