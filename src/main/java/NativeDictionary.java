import java.lang.reflect.Array;

class NativeDictionary<T> {
    public int size;
    public String[] slots;
    public T[] values;

    public NativeDictionary(int sz, Class clazz) {
        size = sz;
        slots = new String[size];
        values = (T[]) Array.newInstance(clazz, this.size);

    }

    public int hashFun(String key) {
        // всегда возвращает корректный индекс слота
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (slots[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }

    public boolean isKey(String key) {
        // возвращает true если ключ имеется,
        // иначе false
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == (key)) {
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
        }
    }

    public T get(String key) {
        // возвращает value для key,
        // или null если ключ не найден
        for (int i = 0; i < values.length; i++) {
            if (slots[i] == key) {
                return values[i];
            }
        }
        return null;
    }
}