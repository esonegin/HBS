public class HashTable {
    public int size;
    public int step;
    public String[] slots;
    public int prevslot;

    public HashTable(int sz, int stp) {
        size = sz;
        step = stp;
        slots = new String[size];
        prevslot = 0;
        for (int i = 0; i < size; i++) slots[i] = null;
    }

    public int hashFun(String value) {
        // всегда возвращает корректный индекс слота

        //Каждый вызов должны прибавлять к предыдущему слоту шаг,
        // если после прибавления > slots.length то увеливаем шаг
        int result = prevslot;
        if (prevslot == 0 && slots[0] == null) {
            result = 0;
        } else if (prevslot == 0 && slots[0] != null) {
            result = step;
        } else if (prevslot > 0 && result + step < slots.length) {
            result += step;
        } else if (prevslot > 0 && result + step >= slots.length) {
            //Написать вариант, когда вышли за границы
            result = (result + step) - slots.length;
        }

        return result;
    }

    public int seekSlot(String value) {
        // находит индекс пустого слота для значения, или -1
        int result = -1;
        int slot = hashFun(value);

        //Если расчитаный хэш-функцией слот пустой - передаем номер слота
        if (slots[slot] == null) {
            result = hashFun(value);

            //Если расчитаный хэш-функцией слот не пустой и
            // меньше шага - прибавляем к предыдущему +1 и вызываем рекурсивно
        } else if (slots[slot] != null && slot < step - 1) {
            prevslot++;
            result = seekSlot(value);
        }

        return result;
    }

    public int put(String value) {
        // записываем значение по хэш-функции
        if (seekSlot(value) != -1) {
            prevslot = seekSlot(value);
            slots[prevslot] = value;

            return prevslot;
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
            if (slots[i] == (value)) {
                result = i;
                break;
            }
        }
        return result;
    }
}
