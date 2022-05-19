import java.util.*;

public class TheRabbitsFoot {
    //18.06.2
    //6.1, 6.2, 6.3, 6.4
    public static String TheRabbitsFoot(String encryptionString, boolean encode) {
        if (encode == true) {
            encryptionString = Zashifr(encryptionString, GetMatrix(encryptionString).length);

        } else {
            encryptionString = gluingString(encryptionString);
        }
        return encryptionString;
    }

    //6.1, 6.2, 6.3, 6.4
    public static String gluingString(String decryptedString) {
        //6.2, 6.4
        String bufferChars;
        //6.1, 6.4
        String gluedString = "";
        for (int i = 0; i < GetMatrix(decryptedString).length; i++) {
            bufferChars = Decryption(decryptedString, i);
            gluedString += bufferChars;
        }
        return gluedString;
    }

    public static String Decryption(String rashifr, int element) {

        String[][] Matrix = new String[GetMatrix(rashifr).length][GetMatrix(rashifr).length];
        String results;
        String resultf = "";

        //Массив подстрок разбитых по пробелу
        String[] arrayMessage = rashifr.split(" ");

        //Вывод массива
        for (int i = 0; i < arrayMessage.length; i++) {
            //System.out.print(arrayMessage[i] + "\n");
        }

        //Запись символов элемента по индексу
        for (int i = 0; i < Matrix.length; i++) {
            //Берем подстроку из массива
            String podstr = arrayMessage[i];
            if (element >= podstr.length()) {
                break;
            } else {
                //Кладем в результат символ подстроки по индексу
                results = (podstr.split("")[element]);
                resultf += results;
            }
        }
        return resultf;
    }

    public static String Zashifr(String test, int dlinna) {
        String result = "";
        for (int i = 0; i < dlinna; i++) {
            result += GetString(test, i) + " ";
        }
        return result.trim();
    }


    //Получаем строки из первых символов столбцов
    public static String GetString(String string, int stolbec) {

        String result = "";
        for (int i = 0; i < 5; i++)
            if (GetArrayPoNomeruStolbcaZashifrovka(string, stolbec)[i] != null) {
                result += GetArrayPoNomeruStolbcaZashifrovka(string, stolbec)[i];

            }
        return result;
    }

    //Возвращаем массив по номеру столбца
    public static String[] GetArrayPoNomeruStolbcaZashifrovka(String string, int stolbec) {
        //Получаем матрицу размеров под символы строки
        int[][] Matrix = GetMatrix(string);
        //Получаем массив строк длинной с размеры матрицы
        String[] Result = new String[Matrix.length];
        //Получаем массив символов из строки
        String[] result = ReplacerString(string).split("");

        for (int i = stolbec, j = 0; i < result.length; i += Matrix.length) {
            Result[j] = result[i];
            j++;
        }

        return Result;
    }

    //Удаляем пробелы и возвращаем длинну строки
    public static double ReplacerLength(String s) {
        String resultstr = s.replaceAll(" ", "");
        return resultstr.length();
    }

    //Удаляем пробелы и возвращаем строку
    public static String ReplacerString(String s) {
        String resultstr = s.replaceAll(" ", "");
        return resultstr;
    }

    //Возвращаем матрицу подходящего размера
    public static int[][] GetMatrix(String str) {
        Double verhnyayagr = Math.sqrt(ReplacerLength(str));
        String result = String.format("%.2f", verhnyayagr);

        String verhgran = String.valueOf(verhnyayagr);
        String[] subStr;
        String delimeter = "\\.";
        subStr = verhgran.split(delimeter);
        for (int i = 0; i < subStr.length; i++) {
            if (subStr[i].length() >= 2) {
                subStr[i] = subStr[i].substring(0, 1);
            } else {
                subStr[i] = subStr[i];
            }
        }

        int matrix[][];
        if (str.length() < Integer.parseInt(subStr[0]) * Integer.parseInt(subStr[0])) {
            int matrixfirst[][] = new int[Integer.parseInt(subStr[0])][Integer.parseInt(subStr[1])];
            matrix = matrixfirst;
        } else {
            int matrixfirst[][] = new int[Integer.parseInt(subStr[0]) + 1][Integer.parseInt(subStr[1])];
            matrix = matrixfirst;
        }
        return matrix;
    }
}