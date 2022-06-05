import java.util.ArrayList;

public class BigMinus {
    static String firstvalue;
    static String secondvalue;

    //Убрал объявление переменных в конструктор
    public BigMinus(String first, String second) {
        this.firstvalue = first;
        this.secondvalue = second;
    }

    public static String getDifference() {
        //result - difference
        String difference = "";
        ArrayList<Integer> resultlist = new ArrayList<Integer>();
        //pervoechislo, vtoroechislo - firstValue, secondValue
        Long firstValue = Long.valueOf(firstvalue);
        Long secondValue = Long.valueOf(secondvalue);

        //Первое число равно второму
        if (firstValue.equals(secondValue)) {
            difference = "0";
        }
        //Первое число больше второго
        else if (firstValue > secondValue) {
            resultlist = subtractingShortFromLong(firstvalue, secondvalue);
        } else if (firstValue < secondValue) {
            resultlist = subtractingShortFromLong(secondvalue, firstvalue);
        }

        //Наполняем строку результат символами из списка
        for (int k = 0; k < resultlist.size(); k++) {
            difference += resultlist.get(k);

        }
        return difference;
    }

    public static ArrayList<Integer> subtractingShortFromLong(String longer, String shorter) {
        //first - listСharsLongerNum
        ArrayList<Integer> listСharsLongerNum = poluchaemSpisok(longer, shorter, 1);
        //second - listСharsShorterNum
        ArrayList<Integer> listСharsShorterNum = poluchaemSpisok(longer, shorter, 2);
        //third - listCharsSubtrResult
        ArrayList<Integer> listCharsSubtrResult = new ArrayList<Integer>();
        //Вычитаем посимвольно
        for (int i = 0; i < listСharsLongerNum.size(); i++) {
            //Если символ из первого числа больше или равен символу из второго числа
            if (listСharsLongerNum.get(listСharsLongerNum.size() - 1 - i)
                    >= listСharsShorterNum.get(listСharsShorterNum.size() - 1 - i)) {
                listCharsSubtrResult.add(0, listСharsLongerNum.get(listСharsLongerNum.size() - 1 - i)
                        - listСharsShorterNum.get(listСharsShorterNum.size() - 1 - i));
                continue;
            }
            //Если символ из первого числа меньше чем символ из второго числа и первое число "длиннее" чем второе
            else if (listСharsLongerNum.get(listСharsLongerNum.size() - 1 - i)
                    < listСharsShorterNum.get(listСharsShorterNum.size() - 1 - i)
                    && longer.length() > shorter.length()) {
                listCharsSubtrResult.add(0, (listСharsLongerNum.get(listСharsLongerNum.size() - 1 - i) + 10)
                        - listСharsShorterNum.get(listСharsShorterNum.size() - 1 - i));
                listСharsLongerNum.set(listСharsLongerNum.size() - 2 - i, listСharsLongerNum.get(listСharsLongerNum.size() - 2 - i) - 1);
                continue;
            }
            //Если чила состоят из одной цифры
            else if (listСharsLongerNum.size() == 1 && listСharsShorterNum.size() == 1) {
                listCharsSubtrResult.set(0, listСharsLongerNum.get(0) - listСharsShorterNum.get(0));
                continue;
            }
        }
        //Удаляем артефактный ноль
        if (listCharsSubtrResult.get(0) == 0 && listCharsSubtrResult.size() > 1) {
            listCharsSubtrResult.remove(0);
        }
        return listCharsSubtrResult;
    }

    public static ArrayList<Integer> poluchaemSpisok(String first, String second, int listnumber) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] firstarray = first.split("");
        String[] secondarray = second.split("");

        //Создаем списки из строк
        ArrayList<Integer> firstlist = new ArrayList<Integer>();
        for (int i = 0; i < firstarray.length; i++) {
            firstlist.add(Integer.parseInt(firstarray[i]));
        }
        ArrayList<Integer> secondlist = new ArrayList<Integer>();
        for (int i = 0; i < secondarray.length; i++) {
            secondlist.add(Integer.parseInt(secondarray[i]));
        }

        //Добавляем нули в начало короткого списка
        if (secondlist.size() > firstlist.size()) {
            for (int i = 0; i < secondlist.size() - firstlist.size(); i++) {
                firstlist.add(0, 0);
            }
        } else if (secondlist.size() < firstlist.size()) {
            for (int i = 0; i < firstlist.size(); i++) {
                secondlist.add(0, 0);
            }
        }
        if (listnumber == 1) {
            result = firstlist;
        } else if (listnumber == 2) {
            result = secondlist;
        }
        return result;
    }
}
