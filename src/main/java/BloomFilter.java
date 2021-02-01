public class BloomFilter {
    public int filter_len;
    public byte[] spisok;
    int prevhash1;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        spisok = new byte[f_len];
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = ((result * 17) + code) % 32;
        }
        return result;
    }

    public int hash2(String str1) {
        // 223
        // реализация ...
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = (int) str1.charAt(i);
            result = ((result * 223) + code) % 32;
        }
        return result;
    }

    public void add(String str1) {
        spisok[hash1(str1)] = 1;
        spisok[hash2(str1)] = 1;
        // добавляем строку str1 в фильтр
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        if(spisok[hash1(str1)] == 1 && spisok[hash2(str1)] == 1){
            return true;
        }

        return false;
    }
}