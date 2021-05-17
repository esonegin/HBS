import java.util.Scanner;

public class Calc {
    public static Integer first = 0;
    public static Integer second = 0;
    public static String operation = "";
    public static String romainresult = "";
    public static boolean romain;

    public static void main(String[] args) {
        elementGen(stringInArray(scan()));
        String result = "";
        switch (operation) {
            case "+":
                result = String.valueOf(slozhenie());
                break;
            case "-":
                result = String.valueOf(vichitanie());
                break;
            case "*":
                result = String.valueOf(umnozhenie());
                break;
            case "/":
                result = String.valueOf(delenie());
                break;
        }

        if (romain = true) {
            result = arabianRomainConverter(Integer.parseInt(result));
        }
        System.out.println(result);

    }

    //Считываем строку с консоли
    public static String scan() {
        Scanner console = new Scanner(System.in);
        return console.nextLine();
    }

    //Разбиваем строку на элементы
    public static String[] stringInArray(String str) {
        return str.split(" ");
    }

    //Определяем элементы массива как члены операции
    public static void elementGen(String[] result) {
        if (result[0].matches("[IVXLC&&[^1-10]]")
                && result[2].matches("[IVXLC&&[^1-10]]")) {
            result[0] = romainArabianConvert(result[0]);
            result[2] = romainArabianConvert(result[2]);
            romain = true;
        }
        first = Integer.parseInt(result[0]);
        operation = result[1];
        second = Integer.parseInt(result[2]);
        if (first <= 0 || first > 10
                || second < 0 || second > 10) {
            throw new NullPointerException("Одно из чисел не в диапазоне 1-10");
        }
        if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
            throw new NullPointerException("Данная операция невозможна");
        }
    }

    //Перевод из римских в арабские
    public static String romainArabianConvert(String rom) {
        String[] arr = rom.split("");
        StringBuilder result = new StringBuilder();
        for (String s : arr) {
            switch (s) {
                case "I":
                    result.append("1 ");
                    break;
                case "V":
                    result.append("5 ");
                    break;
                case "X":
                    result.append("10 ");
                    break;
                case "L":
                    result.append("50 ");
                    break;
                case "C":
                    result.append("100 ");
                    break;
            }
        }

        String[] arr2 = result.toString().split(" ");

        int finres = 0;
        if (Integer.parseInt(arr2[arr2.length - 1]) > Integer.parseInt(arr2[0])) {
            finres = Integer.parseInt(arr2[arr2.length - 1]);
            for (int i = arr2.length - 2; i >= 0; i--) {
                finres = finres - Integer.parseInt(arr2[i]);
            }
        } else if (Integer.parseInt(arr2[arr2.length - 1]) <= Integer.parseInt(arr2[0])) {
            finres = Integer.parseInt(arr2[0]);
            for (int i = 1; i < arr2.length; i++) {
                finres = finres + Integer.parseInt(arr2[i]);
            }
        }
        return String.valueOf(finres);
    }

    //Перевод из арабских в римские
    public static String arabianRomainConverter(int arabian) {
        if (arabian >= 90) {
            return "C";
        }
        if (arabian >= 50) {
            romainresult += "L";
            arabian += -50;
            arabianRomainConverter(arabian);
        } else if (arabian >= 10) {
            romainresult += "X";
            arabian += -10;
            arabianRomainConverter(arabian);
        } else if (arabian >= 5) {
            romainresult += "V";
            arabian += -5;
            arabianRomainConverter(arabian);
        } else if (arabian >= 1) {
            romainresult += "I";
            arabian += -1;
            arabianRomainConverter(arabian);
        }
        return romainresult;
    }

    public static int slozhenie() {
        return first + second;
    }

    public static int vichitanie() {
        return first - second;
    }

    public static int umnozhenie() {
        return first * second;
    }

    public static int delenie() {
        return first / second;
    }
}

