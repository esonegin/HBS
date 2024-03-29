import java.lang.reflect.Array;


public class DynArray<T> {
    public T[] array; //указатель на блок памяти нужной ёмкости
    public int count; //текущее количество элементов в массиве
    public int capacity; //текущая ёмкость буфера (исходно 16 единиц)
    //Вынес магическое число в дефолтное значение
    final int DEFAULTCAPACITY = 16;
    Class clazz;

    public DynArray(Class clz) {
        clazz = clz; // нужен для безопасного приведения типов
        count = 0;
        makeArray(DEFAULTCAPACITY);
    }

    public void makeArray(int new_capacity) {
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
            array = myArray.clone();
            capacity = new_capacity;
        }
        //Если размер буфера = 0, присваиваем ему нвоое значение
        if (capacity == 0) {
            capacity = new_capacity;
            //Если размер буфера при делится на 16, то увеличивеам буфер на 2
        } else if (count + 1 % DEFAULTCAPACITY == 0) {
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
        if (count < capacity) {
            array[count] = itm;
            count += 1;
        } else {
            makeArray(capacity * 2);
            array[count] = itm;
            count += 1;
        }

    }

    public void insert(T itm, int index) throws IndexOutOfBoundsException {
        if (index > count || index < 0) {
            throw new IndexOutOfBoundsException("Данный индекс вне массива");
        }
        count += 1;
        if (count - 1 < capacity) {
            for (int i = count - 1; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = itm;
        } else {
            makeArray(capacity * 2);
            for (int i = count; i > index; i--) {
                array[i] = array[i - 1];
            }
            array[index] = itm;
        }

    }

    public void remove(int index) throws IndexOutOfBoundsException {
        //Если индекс боль чем количество или меньше 0
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException("Данный индекс вне массива");
        }
        //Если заполняемость буфера меньше 50% и размер буфера после уменьшения больше либо равен 16
        if (count - 1 < capacity / 2 && capacity / 2 >= DEFAULTCAPACITY) {
            makeArray((int) (capacity / 1.5));
            for (int i = index; i < count; i++)
                array[i] = array[i + 1];
            //Если заполняемость буфера меньше 50% и размер буфера после уменьшения меньше 16 - устанавливаем минимум - 16
        } else if (count - 1 < capacity / 2 && capacity / 2 < DEFAULTCAPACITY) {
            makeArray(DEFAULTCAPACITY);
            for (int i = index; i < count - 1; i++) {
                array[i] = array[i + 1];
            }
            //Если удаляется последнее значение, то устанавливаем его в null
        } else if (index == count - 1) {
            array[index] = null;
        } else {
            for (int i = index; i < count; i++)
                if (i + 1 < count) {
                    array[i] = array[i + 1];
                } else {
                    array[i] = null;
                }
        }
        array[count - 1] = null;
        count -= 1;
    }

}