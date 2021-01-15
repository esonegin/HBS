public class HashTable {
    public int size;
    public int step;
    public String[] slots;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        // всегда возвращает корректный индекс слота
        int result = 0;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].equals(value)) {
                result = i;
            }
        }
        return result;
    }

    public int seekSlot(String value) {
        // находит индекс пустого слота для значения, или -1
        int result = -1;
        for (int i = 0; i < slots.length + step; i += step) {
            //Если следующий слот меньше длинны хранилища и пустой
            if (i < slots.length && slots[i] == null) {
                result = i;
                break;
            }
            //Если следующий слот больше хранилища и пустой
            else if (i > slots.length && slots[i - slots.length] == null) {
                result = i - slots.length;
                break;
            }
            //Если следующий слот больше хранилища и не пустой
            else if (i > slots.length && slots[i - slots.length] != null) {
                i = i - slots.length;
            }
        }
        return result;
    }

    public int put(String value) {
        // записываем значение по хэш-функции
        if (seekSlot(value) != -1) {
            slots[seekSlot(value)] = value;
            return seekSlot(value);
        } else {
            return -1;
        }
        // возвращается индекс слота или -1
        // если из-за коллизий элемент не удаётся разместить
    }

    public int find(String value) {
        // находит индекс слота со значением, или -1
        int result = -1;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].equals(value)) {
                result = i;
            }
        }
        return result;
    }
}