import java.lang.reflect.Array;

//v1
public class DynArray<T> {
    public T[] array; //указатель на блок памяти нужной ёмкости
    public int count; //текущее количество элементов в массиве
    public int capacity; //текущая ёмкость буфера (исходно 16 единиц)
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        count = 0;
        makeArray(16);
    }

    public void makeArray(int new_capacity) {
        //Если массив = null, то создаем ноаый
        if (array == null) {
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            //В противном случае создаем новый массив с новой длинной и копируем в него старый
        } else if (new_capacity > capacity) {
            T[] myArray = (T[]) new Integer[new_capacity];
            System.arraycopy(array, 0, myArray, 0, capacity);
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            array = (T[]) myArray.clone();
            capacity = new_capacity;
        } else if (new_capacity < capacity) {
            T[] myArray = (T[]) new Integer[new_capacity];
            System.arraycopy(array, 0, myArray, 0, new_capacity - 1);
            array = (T[]) Array.newInstance(this.clazz, new_capacity);
            array = (T[]) myArray.clone();
            capacity = new_capacity;
        }
        //Если размер буфера = 0, присваиваем ему нвоое значение
        if (capacity == 0) {
            capacity = new_capacity;
            //Если размер буфера при делится на 16, то увеличивеам буфер на 2
        } else if (count + 1 % 16 == 0) {
            capacity = (capacity * 2);
        }
    }

    //Получение объекта по его индексу
    public T getItem(int index) throws IndexOutOfBoundsException {
        //В этот метод встроим проверку корректности индекса в
        // рамках границ, и генерацию соответствующего
        // исключения, если обращение некорректно;
        T result = null;
        for (int i = 0; i < capacity; i++) {
            if (index == i) {
                result = array[index];
            }
        }
        if (result == null) {
            throw new IndexOutOfBoundsException("По данному индексу нет значения");
        }
        return result;
    }

    //добавление нового элемента в конец массива
    public void append(T itm) {
        //Если количество элементов меньше размера буфера, то добавляем по индексу количества
        if (count < capacity) {
            array[count] = itm;
            count += 1;
            //В противном случае создаем новый массив с увеличенным на 16 размером буфера
            // и копируем в него старый массив
        } else {
            makeArray(capacity * 2);
            array[count] = itm;
            count += 1;

        }

    }

    public void insert(T itm, int index) throws IndexOutOfBoundsException {
        count += 1;
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Данный индекс вне массива");
        }
        if (count - 1 < capacity) {
            for (int i = count - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = itm;
        } else {
            makeArray(capacity + 16);
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = itm;
        }

    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Данный индекс вне массива");
        }

        if (count - 1 < capacity / 2 && capacity / 2 >= 16) {
            makeArray((int) (capacity / 1.5));
            for (int i = index; i < count; i++)
                array[i] = array[i + 1];
        } else if (count - 1 > capacity / 2 && capacity / 2 < 16) {
            makeArray(16);
            for (int i = index; i < count; i++)
                array[i] = array[i + 1];
        } else {
            for (int i = index; i < count; i++)
                array[i] = array[i + 1];

        }
        count -= 1;
    }

}