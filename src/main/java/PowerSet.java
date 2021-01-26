public class PowerSet {
    public int size;
    public String[] slots;
    public int prevslot;


    public PowerSet(int sz) {
        size = sz;
        slots = new String[size];
        prevslot = -1;
        // ваша реализация хранилища

    }

    public int size() {
        // количество элементов в множестве
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (slots[i] != null) {
                result++;
            }
        }
        return result;
    }


    public void put(String value) {
        // всегда срабатывает
        boolean doublecheck = doubleCheck(value);
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == null && doublecheck) {
                slots[i] = value;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot == -1) {
                slots[i] = value;
                prevslot = i;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot != -1 && prevslot < slots.length - 1) {
                slots[prevslot + 1] = value;
                prevslot++;
                break;
            } else if (slots[slots.length - 1] != null && doublecheck && prevslot != -1 && prevslot >= slots.length - 1) {
                prevslot = 0;
                slots[prevslot] = value;
                //prevslot++;
                break;
            }
        }
    }

    public boolean doubleCheck(String value) {
        // всегда срабатывает
        for (String val : slots) {
            if (val == value) {
                return false;
            }
        }
        return true;
    }

    public boolean get(String value) {
        // возвращает true если value имеется в множестве,
        // иначе false
        boolean result = false;
        for (String val : slots) {
            if (val != null && val.equals(value)) {
                result = true;
                break;
            }
        }
        return result;
    }

    public boolean remove(String value) {
        // возвращает true если value удалено
        // иначе false
        boolean result = false;
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] != null && slots[i].equals(value)) {
                slots[i] = null;
                result = true;
                break;
            }
        }
        return result;
    }

    public PowerSet intersection(PowerSet set2) {
        // пересечение текущего множества и set2
        //int resultlen = 0;
        PowerSet result = new PowerSet(20000);
        if (set2.size >= slots.length) {
            for (String val : slots) {
                for (int j = 0; j < set2.size; j++) {
                    if (val != null && val.equals(set2.slots[j])) {
                        result.put(val);
                    }
                }
            }
        } else if (set2.size < slots.length) {
            for (int i = 0; i < set2.size; i++) {
                for (String val : slots) {
                    if (set2.slots[i] != null && set2.slots[i].equals(val)) {
                        result.put(set2.slots[i]);
                    }
                }
            }
        }
        return result;
    }

    public PowerSet union(PowerSet set2) {
        // объединение текущего множества и set2
        PowerSet result = new PowerSet(size + set2.size);
        for (int i = 0; i < set2.size; i++) {
            result.put(set2.slots[i]);
        }
        for (String val : slots) {
            result.put(val);
        }

        return result;
    }

    public PowerSet difference(PowerSet set2) {
        // разница текущего множества и set2
        PowerSet result = new PowerSet(size);
        for (String val : slots) {
            if (val != null && !set2.get(val)) {
                result.put(val);
            }
        }
        return result;
    }

    public boolean isSubset(PowerSet set2) {
        // возвращает true, если set2 есть
        // подмножество текущего множества,
        // иначе false
        int j = 0;
        for (int i = 0; i < set2.size; i++) {
            if (set2.get(slots[i])) {
                j++;
            }
        }
        if (j == set2.size()) {
            return true;
        }
        return false;
    }
}