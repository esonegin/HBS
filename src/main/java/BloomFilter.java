public class BloomFilter {
    public int filter_len;
    public byte[] bitArray;

    public BloomFilter(int f_len) {
        filter_len = f_len;
        // создаём битовый массив длиной f_len ...
        bitArray = new byte[f_len];
    }

    // хэш-функции
    public int hash1(String str1) {
        // 17
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = (result + code) * 17 % 32;
        }
        return result;
    }

    public int hash2(String str1) {
        int result = 0;
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i);
            result = (result + code) * 223 % 32;
        }
        return result;
    }

    public void add(String str1) {
        bitArray[hash1(str1)] = 1;
        bitArray[hash2(str1)] = 1;
        // добавляем строку str1 в фильтр
    }

    public boolean find(String str1) {
        boolean result = false;
        if (hash1(str1) == 1 && hash2(str1) == 1) {
            result = true;
        }
        return result;
    }

    public boolean isValue(String str1) {
        // проверка, имеется ли строка str1 в фильтре
        for(int i = 0; i < bitArray.length - 1; i++) {
            if (bitArray[hash1(str1)] == 1 && bitArray[hash2(str1)] == 1) {
                return true;
            }
        }
        return false;
    }
}