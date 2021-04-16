class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int tree_size = 1;
        for (int i = 1; i <= depth + 1; i++) {
            tree_size = tree_size * 2;
        }
        tree_size = tree_size - 1;
        HeapArray = new int[tree_size];
        for (int i = 0; i < tree_size; i++) HeapArray[i] = 0;
        HeapArray[0] = getMaxOnArray(a);
        delMax(a, getMaxOnArray(a));

        for (int j : a) {
            Add(j);
        }
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
    }

    public int GetMax() {
        int max = HeapArray[0];
        int index = 0;
        if (HeapArray[0] != 0) {
        for(int i = HeapArray.length - 1; i != 0; i--){
            if(HeapArray[i] != 0){
                index = i;
                break;
            }
        }
        HeapArray[0] = HeapArray[index];
        HeapArray[index] = 0;
            downNode();
            return max;
        }
        // вернуть значение корня и перестроить кучу
        return -1; // если куча пуста
    }

    public boolean Add(int key) {
        if (HeapArray[HeapArray.length - 1] == 0 && key != 0) {
            HeapArray[HeapArray.length - 1] = key;
            upNode();
            return true;
        }
        // добавляем новый элемент key в кучу и перестраиваем её
        return false; // если куча вся заполнена
    }

    public void upNode() {
        for (int i = HeapArray.length - 1; i != 0; i--) {
            if (HeapArray[i - 1] < HeapArray[i]) {
                int r = HeapArray[i];
                HeapArray[i] = HeapArray[i - 1];
                HeapArray[i - 1] = r;
            }
        }
    }

    public void downNode() {
        for (int i = 0; i < HeapArray.length; i++) {
            if (i + 1 < HeapArray.length && HeapArray[i] < HeapArray[i + 1]) {
                int r = HeapArray[i + 1];
                HeapArray[i + 1] = HeapArray[i];
                HeapArray[i] = r;
            }
        }
    }

    public static int getMaxOnArray(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] > maxValue) {
                maxValue = inputArray[i];
            }
        }
        return maxValue;
    }

    public static void delMax(int[] inputArray, int valfordel) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == valfordel) {
                inputArray[i] = 0;
            }
        }
    }

}