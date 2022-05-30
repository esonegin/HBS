

public class MassVote {

    //Вынес граничное значение для выиграша в константу
    static final int BORDEROFVICTORY = 50;
    static final double ONEHUNDREDPERCENT = 100.00;

    public static String MassVote(int N, int[] allvotes) {
        String result = "";
        if (kolvomax(allvotes) > 1) {
            result = "no winner";
        } else if (candidatePercentage(allvotes, indexmax(allvotes)) > BORDEROFVICTORY) {
            result = "majority winner " + (indexmax(allvotes) + 1);
        } else if (candidatePercentage(allvotes, indexmax(allvotes)) <= BORDEROFVICTORY) {
            result = "minority winner " + (indexmax(allvotes) + 1);
        }
        return result;
    }

    public static int kolvomax(int[] allvotes) {
        int kolvomax = 0;
        for (int i = 0; i < allvotes.length; i++) {
            if (allvotes[i] == maximum(allvotes)) {
                kolvomax++;
            }
        }
        return kolvomax;
    }


    public static int maximum(int[] allvotes) {
        int max = allvotes[0];
        for (int allvote : allvotes) {
            if (max < allvote) {
                max = allvote;
            }
        }
        return max;
    }


    public static int indexmax(int[] Votes) {
        int max = Votes[0];
        int indexmax = 0;
        for (int i = 0; i < Votes.length; i++) {
            if (max < Votes[i]) {
                max = Votes[i];
                indexmax = i;
            }
        }
        return indexmax;
    }

    //Переимановал метод из кириллического procentkandidata - candidatePercentage
    public static double candidatePercentage(int[] votes, int nomer) {
        //Сделал количество голосов вместо double - int
        int kolvogolosov = votes[nomer];
        double odinprocent = numberOfThoseWhoVoted(votes) / ONEHUNDREDPERCENT;
        double result = kolvogolosov / odinprocent;
        //Убрал излишнее преобрзование BigDecimal
        return result;

    }

    //Переимановал метод из кириллического stoprocentov - numberOfThoseWhoVoted
    public static int numberOfThoseWhoVoted(int[] votes) {
        int allvotes = 0;
        for (int i = 0; i < votes.length; i++) {
            allvotes = allvotes + votes[i];
        }
        return allvotes;
    }
}
