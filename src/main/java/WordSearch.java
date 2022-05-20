import java.util.Arrays;
import java.util.regex.Pattern;


public class WordSearch {
//10.06.4

    public static int[] WordSearch(int len, String s, String subs) {
        int[] result = new int[0];
        //Разбиваем строку по ширине переносом
        String splitstring = splittingWithLineFeed(s, len);
        //Создаем массив подстрок по признаку перехода на новую строку
        String[] podstroki = splitstring.split("\\r?\\n");
        String[] splitArray = s.split(" ");

        if ((splitArray.length - 1) > 1) {
            result = getContCountOneSpace(podstroki, subs);
        } else if (splitArray.length - 1 == 1) {
            result = getContCountSeveralSpace(podstroki, subs);
        } else if (splitArray.length - 1 == 0) {
            result = getContCountWithoutSpace(podstroki, subs);
        }
        return result;
    }


    //Считаем количество вхождений искомой строки в массив для строки с несколькими пробелами
    //SearchInArrayWithOneProbel - getContCountOneSpace
    public static int[] getContCountOneSpace(String[] podstroki, String subs) {
        int[] result = new int[podstroki.length];
        for (int i = 0; i < podstroki.length; i++) {
            if (podstroki[i].contains(" " + subs + " ")
                    || podstroki[i].contains(" " + subs + "\n")
                    || podstroki[i].contains("\n" + subs + "\n")
                    || podstroki[i].contains("\n" + subs + " ")
                    || podstroki[i].contains(" " + subs + "")
                    || podstroki[i].contains("" + subs + " ")) {
                result[i] = 1;
            } else result[i] = 0;
        }
        return result;
    }

    //Считаем количество вхождений искомой строки в массив для строки с несколькими пробелами
    //SearchInArrayWithoutProbel - getContCountSeveralSpace
    public static int[] getContCountSeveralSpace(String[] podstroki, String subs) {
        int[] result = new int[podstroki.length];
        for (int i = 0; i < podstroki.length; i++) {
            if (podstroki[i].contains(" " + subs + " ")
                    || podstroki[i].contains(" " + subs + "\n")
                    || podstroki[i].contains("\n" + subs + "\n")
                    || podstroki[i].contains("\n" + subs + " ")
                    || podstroki[i].contains("" + subs + " ")) {
                result[i] = 1;
            } else result[i] = 0;
        }
        return result;
    }

    //Считаем количество вхождений искомой строки в массив для строки без пробела
    //SearchInArrayWithoutProbel - getContCountWithoutSpace
    public static int[] getContCountWithoutSpace(String[] podstroki, String subs) {
        int[] result = new int[podstroki.length];


        for (int i = 0; i < podstroki.length; i++) {
            if (podstroki[i].contains(" " + subs + " ")
                    || podstroki[i].contains(" " + subs + "\n")
                    || podstroki[i].contains("\n" + subs + "\n")
                    || podstroki[i].contains("\n" + subs + " ")
                    || podstroki[i].contains(" " + subs + "")
                    || podstroki[i].contains("" + subs + " ")) {
                result[i] = 1;
            } else result[i] = 0;
        }
        return result;
    }


    //Разбиваем строку по ширине
    //Razbienie - splittingWithLineFeed
    public static String splittingWithLineFeed(String s, int len) {
         Pattern p = Pattern.compile("\\s*(?:(\\w{10,})|(.{1," + len + "})(?!\\w))\\s*", Pattern.UNICODE_CHARACTER_CLASS);
        String first = (p.matcher(s).replaceAll(" " + "$1$2\n"));

        String second = (p.matcher(s).replaceAll("$1$2"));
        String finalstring = "";

        if (s.contains(" ")) {
            finalstring = first;

        } else {
            String newStr = second.replaceAll("(.{" + len + "})", "$1|");
            String[] newStrings = newStr.split("\\|");
            for (int j = 0; j < newStrings.length; j++) {
                finalstring += " " + newStrings[j] + "\n";
            }
        }
        return finalstring;
    }
}












