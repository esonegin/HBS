
public class LineAnalysis {
    static String line;

    //Убрал объявление переменных в конструктор
    public LineAnalysis(String inline) {
        this.line = inline;
    }

    public static boolean getAnalyze() {
        //7.1 result - isValidLine
        boolean isValidLine = true;
        char first = line.charAt(0);
        char posledniy = line.charAt(line.length() - 1);
        if (first != '*' || posledniy != '*') {
            isValidLine = false;
        } else {
            String[] myArray = line.split("\\*");
            for (int i = 2; i < myArray.length; i++) {
                if (myArray[i].equals(myArray[1])) {
                    isValidLine = true;
                } else {
                    isValidLine = false;
                    break;
                }
            }
        }
        return isValidLine;
    }
}
