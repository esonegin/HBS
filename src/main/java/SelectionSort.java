public class SelectionSort {

    public static void main(String[] args) {
       int[] res = selectionSort(new int[]{10, 1, 8, 7, 6, 3, 4, 3, 2, 9});
       for(int i = 0; i < res.length; i++){
           System.out.println(res[i]);
       }
    }

    public static int[] selectionSort(int[] array) {
        int min;
        int k = 0;
        for(int i = 0; i < array.length - 2; i++){
            if(array[i] < array[i + 1]){
                min = array[i];
                array[i] = array[i + 1];
            }
            else{
                min = array[i + 1];
                array[i + 1] = array[i];
            }
            array[k] = min;
            k++;
        }
        return array;
    }
}
