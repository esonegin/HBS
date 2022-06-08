import java.util.*;


public class BalancedParentheses {

    //v8
    public static String balancedParentheses(int n) {
        String result = "";
        //Создае список - передаем в метод создания количество открывающих скобок
        ArrayList<String> resultlist = generateParens(n);

        for (int i = 0; i < resultlist.size(); i++) {
            result = result + resultlist.get(i) + " ";
        }
        return result.trim();
    }

    //Передаем список
    public static void addParent(ArrayList<String> list, int leftRem, int rightRem, char[] str, int count) {
        if (leftRem < 0 || rightRem < leftRem) {
            return;
        }
        if (leftRem == 0 && rightRem == 0) {
            String s = String.copyValueOf(str);
            list.add(s);
        } else {
            if (leftRem > 0) {
                str[count] = '(';
                addParent(list, leftRem - 1, rightRem, str, count + 1);
            }

            if (rightRem > leftRem) {
                str[count] = ')';
                addParent(list, leftRem, rightRem - 1, str, count + 1);
            }
        }
    }

    public static ArrayList<String> generateParens(int count) {
        //Создаем массив символов длинной = кол-открытых скобок умноженому на 2
        char[] str = new char[count * 2];
        //Создаем список
        ArrayList<String> list = new ArrayList<String>();
        addParent(list, count, count, str, 0);
        return list;
    }
}
