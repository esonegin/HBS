

public class Algorhytms {

    public void main(String[] args) {

        Array array = new Array();
        array.setArray(new int[]{5, 3, 6, 2, 10});
        array.setSmallest(findSmallest(array.getArray()));
        selectionSort(array);
    }

    public static int findSmallest(int[] array) {
        int smallest = array[0];
        int smallest_index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                smallest_index = i;
            }
        }

        return smallest_index;
    }

    public void selectionSort(Array array) {
        int[] result = new int[0];

        for (int i = 0; i < array.getArray().length; i++) {
            array.setSmallest(findSmallest(array.getArray()));
            result[i] = array.getSmallest();
            //array[i] = null;
        }
    }
}


class Array {
    int[] array;
    int smallest;
    int smallest_index;

    public void setArray(int[] array) {
        this.array = array;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public void setSmallest_index(int smallest_index) {
        this.smallest_index = smallest_index;
    }

    public int[] getArray() {
        return array;
    }

    public int getSmallest() {
        return smallest;
    }

    public int getSmallest_index() {
        return smallest_index;
    }
}



