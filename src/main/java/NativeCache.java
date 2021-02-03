import java.lang.reflect.Array;

class NativeCache<T> {
    public int size;
    public String[] slots;
    public T[] values;
    public int[] hits;

    public NativeCache(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);
        hits = new int[size];
    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        int result = 0;
        int minValue = hits[0];
        for (int i = 0; i < size; i++) {
            if (slots[i] == null) {
                result = i;
                return result;
            }
            if (hits[i] < minValue) {
                result = i;
                hits[result] = 0;
                return result;
            }
        }
        hits[result] = 0;
        return result;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == (key)) {
                hits[i]++;
                return true;
            }
        }
        return false;
    }

    public void put(String key, T value) {
        // гарантированно записываем
        // значение value по ключу key
        int keyint = hashFun(key);
        if (keyint != -1) {
            slots[keyint] = key;
            values[keyint] = value;
            hits[keyint]++;
        }
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        for (int i = 0; i < values.length; i++) {
            if (slots[i] == key) {
                hits[i]++;
                return values[i];
            }
        }
        return null;
    }
}