import java.util.ArrayList;

public class BigMinus {
    private static String firstvalue;
    private static String secondvalue;
    private static String difference;

    public BigMinus(String first, String second) {
        this.firstvalue = first;
        this.secondvalue = second;
        generateDifference();
    }

    public static void generateDifference() {
        ArrayList<Integer> dif = getDifferenceCharList();
        formingStringOfChar(dif);
    }

    public static ArrayList<Integer> getDifferenceCharList() {
        Long firstValue = Long.valueOf(firstvalue);
        Long secondValue = Long.valueOf(secondvalue);
        ArrayList<Integer> resultlist = new ArrayList<Integer>();
        if (firstValue.equals(secondValue)) {
            difference = "0";
            resultlist.add(0);
            return resultlist;
        } else if (firstValue > secondValue) {
            resultlist = subtractingShortFromLong(firstvalue, secondvalue);
        } else if (firstValue < secondValue) {
            resultlist = subtractingShortFromLong(secondvalue, firstvalue);
        }
        return resultlist;
    }


    public static void formingStringOfChar(ArrayList<Integer> resultlist) {
        difference = String.valueOf(resultlist.get(0));
        for (int k = 1; k < resultlist.size(); k++) {
            difference += resultlist.get(k);
        }
    }

    public static ArrayList<Integer> subtractingShortFromLong(String longer, String shorter) {
        //first - listСharsLongerNum
        ArrayList<Integer> listcharslonger = getList(longer, shorter, 1);
        //second - listСharsShorterNum
        ArrayList<Integer> listcharsshorter = getList(longer, shorter, 2);
        //third - listCharsSubtrResult
        ArrayList<Integer> listCharsSubtrResult = new ArrayList<Integer>();
        //Вычитаем посимвольно
        for (int i = 0; i < listcharslonger.size(); i++) {
            //Если символ из первого числа больше или равен символу из второго числа
            if (listcharslonger.get(listcharslonger.size() - 1 - i) >= listcharsshorter.get(listcharsshorter.size() - 1 - i)) {
                listCharsSubtrResult.add(0, listcharslonger.get(listcharslonger.size() - 1 - i) - listcharsshorter.get(listcharsshorter.size() - 1 - i));
                continue;
            }
            //Если символ из первого числа меньше чем символ из второго числа и первое число "длиннее" чем второе
            else if (listcharslonger.get(listcharslonger.size() - 1 - i) < listcharsshorter.get(listcharsshorter.size() - 1 - i) && longer.length() > shorter.length()) {
                listCharsSubtrResult.add(0, (listcharslonger.get(listcharslonger.size() - 1 - i) + 10) - listcharsshorter.get(listcharsshorter.size() - 1 - i));
                listcharslonger.set(listcharslonger.size() - 2 - i, listcharslonger.get(listcharslonger.size() - 2 - i) - 1);
                continue;
            }
            //Если чила состоят из одной цифры
            else if (listcharslonger.size() == 1 && listcharsshorter.size() == 1) {
                listCharsSubtrResult.set(0, listcharslonger.get(0) - listcharsshorter.get(0));
                continue;
            }
        }
        //Удаляем артефактный ноль
        if (listCharsSubtrResult.get(0) == 0 && listCharsSubtrResult.size() > 1) {
            listCharsSubtrResult.remove(0);
        }
        return listCharsSubtrResult;
    }

    public static ArrayList<Integer> getList(String first, String second, int listnumber) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        String[] firstarray = first.split("");
        String[] secondarray = second.split("");
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

    public static String getDifference() {
        return difference;
    }

    public static void setDifference(String dif) {
        BigMinus.difference = dif;
    }
}
