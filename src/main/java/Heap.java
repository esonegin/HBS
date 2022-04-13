import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        int tree_size = 1;
        //Вычисляем размер массива
        for (int i = 1; i <= depth + 1; i++) {
            tree_size = tree_size * 2;
        }
        tree_size = tree_size - 1;
        HeapArray = new int[tree_size];
        Arrays.fill(HeapArray, -1);
        for (int i = 0; i < HeapArray.length && i < a.length; i++) {
            Add(a[i]);
        }
        List<Integer> prom = new ArrayList<>();
        for (int j : HeapArray) {
            if (j != -1) {
                prom.add(j);
            }
        }
        int[] result = new int[prom.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = prom.get(i);
        }
        HeapArray = result;
        // создаём массив кучи HeapArray из заданного
        // размер массива выбираем на основе глубины depth
        // ...
    }


    public boolean Add(int key) {
        int parrent = 0;
        // добавляем новый элемент key в кучу и перестраиваем её
        for (int i = 0; i < HeapArray.length; i++) {
            if (i != 0 && i % 2 == 0) {
                parrent = HeapArray[i / 2 - 1];
            } else if (i != 0) {
                parrent = HeapArray[i / 2];
            }
            //Если свободен корень, кладем значение в корень
            if (i == 0 && HeapArray[0] == -1) {
                HeapArray[0] = key;
                break;
            }
            //Если индекс свободен и родитель больше значения, кладем в индекс
            if (HeapArray[i] == -1 && parrent >= key) {
                HeapArray[i] = key;
                break;
            }
            //Если индекс свободен и родитель меньше значения, ищем подходящий индекс
            if (HeapArray[i] == -1 && parrent <= key) {
                int[] rotate = UpNode(i, key);

                int p = HeapArray[rotate[0]];
                HeapArray[rotate[0]] = key;
                HeapArray[i] = HeapArray[rotate[1]];
                HeapArray[rotate[1]] = p;
                break;
            }


        }
        return false; // если куча вся заполнена
    }


    public int GetMax() {
        int max = HeapArray[0];
        if (HeapArray[0] == -1) {
            return -1; // если куча пуста
        }
        HeapArray[0] = HeapArray[HeapArray.length - 1];
        DownNode(0, HeapArray[0]);

        return max;
    }

    //Опускаем, пока значение не будет больше потомка
    public void DownNode(int index, int key) {
        int[] largerchild = FindLargerChild(index);
        if (index == 0) {
            int[] result = new int[HeapArray.length - 1];
            System.arraycopy(HeapArray, 0, result, 0, result.length);
            HeapArray = result;
        }
        HeapArray[index] = largerchild[1];
        HeapArray[largerchild[0]] = key;
        while (FindLargerChild(largerchild[0]) != null) {
            DownNode(largerchild[0], key);
        }
    }

    public int[] UpNode(int index, int key) {
        int parrent = 0;
        int[] result = new int[2];
        result[0] = index;
        while (HeapArray[parrent] < key) {
            if (result[0] != 0 && result[0] % 2 == 0) {
                parrent = Math.round(result[0] / 2 - 1);
            } else if (result[0] != 0) {
                parrent = Math.round(result[0] / 2);
            }
            result[1] = result[0];
            result[0] = parrent;
            if (result[0] == 0) {
                break;
            }
        }
        return result;
    }

    public int[] FindLargerChild(int index) {
        if (index * 2 + 1 >= HeapArray.length - 1) {
            return null;
        }
        int[] largerchild = new int[2];
        if (index == 0) {
            largerchild[1] = Math.max(HeapArray[1], HeapArray[2]);
            if (HeapArray[index] > largerchild[1]) {
                return null;
            }
            if (HeapArray[1] >= HeapArray[2]) {
                largerchild[0] = 1;
            } else {
                largerchild[0] = 2;
            }
        } else {
            largerchild[1] = Math.max(HeapArray[index * 2 + 1], HeapArray[index * 2 + 2]);
            if (HeapArray[index] > largerchild[1]) {
                return null;
            }
            if (HeapArray[index * 2 + 1] > HeapArray[index * 2 + 2]) {
                largerchild[0] = index * 2 + 1;
            } else {
                largerchild[0] = index * 2 + 2;
            }
        }
        return largerchild;
    }
}