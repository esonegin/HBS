import java.util.*;

class Heap {
    public int[] HeapArray; // хранит неотрицательные числа-ключи

    public Heap() {
        HeapArray = null;
    }

    public void MakeHeap(int[] a, int depth) {
        //Определяем размер итогового массива согласно заданной глубине
        int tree_size = (int) (Math.pow(2, depth) - 1);
        //Заполняем массив отрицательными числами
        HeapArray = new int[tree_size];
        Arrays.fill(HeapArray, -1);
        //Добавляем значение в кучу и перестраиваем
        for (int i = 0; i < HeapArray.length && i < a.length; i++) {
            Add(a[i]);
        }
        //Удаляем отрицательные числа и формируем итоговый массив
        DeleteNegativeValue();
    }


    public boolean Add(int key) {

        // добавляем новый элемент key в кучу и перестраиваем её
        int freeindex = -2;
        //Ищем свободный элемент
        for (int i = 0; i < HeapArray.length; i++) {
            if (HeapArray[i] == -1) {
                freeindex = i;
                break;
            }
        }
        // если куча вся заполнена возвращаем false
        if (freeindex == -2) {
            return false;
        }

        //Если свободен корень, кладем значение в корень
        if (freeindex == 0) {
            HeapArray[0] = key;
            return true;
        }
        //Ищем индексы родителя
        int[] parrent = FindParrent(freeindex);
        //Если индекс свободен и родитель больше значения, кладем в индекс
        if (parrent[1] >= key) {
            HeapArray[freeindex] = key;
            return true;
        }
        //Если индекс свободен и родитель меньше значения, ищем подходящий индекс
        UpNode(freeindex, key);
        return true;
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
        if (largerchild[0] >= HeapArray.length) {
            return;
        }
        HeapArray[index] = largerchild[1];
        HeapArray[largerchild[0]] = key;
        while (FindLargerChild(largerchild[0]) != null && FindLargerChild(largerchild[0])[1] != key) {
            DownNode(largerchild[0], key);
        }
    }

    public void UpNode(int index, int key) {
        if (index == 0) {
            return;
        }
        while (index != 0 && FindParrent(index)[1] < key) {
            int p = FindParrent(index)[1];
            HeapArray[FindParrent(index)[0]] = key;
            HeapArray[index] = p;
            index = FindParrent(index)[0];
        }

    }

    public int[] FindParrent(int index) {
        if (index == 0) {
            return null;
        }
        int[] parrent = new int[2];
        if (index == 1) {
            parrent[1] = HeapArray[0];
        }
        if (index % 2 == 0) {
            parrent[0] = index / 2 - 1;
        } else {
            parrent[0] = index / 2;
        }
        parrent[1] = HeapArray[parrent[0]];
        return parrent;
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

    public void DeleteNegativeValue() {
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
    }
}