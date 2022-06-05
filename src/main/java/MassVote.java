

public class MassVote {

    //Вынес граничное значение для выиграша в константу
    static final int BORDEROFVICTORY = 50;
    static final double ONEHUNDREDPERCENT = 100.00;
    static int candidatescount;
    static int[] allvotes;

    //Убрал объявление переменных в конструктор
    public MassVote(int count, int[] votes) {
        this.candidatescount = count;
        this.allvotes = votes;
    }

    public static String checkWinner() {
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


    public static int indexmax(int[] votes) {
        int max = votes[0];
        int indexmax = 0;
        for (int i = 0; i < votes.length; i++) {
            if (max < votes[i]) {
                max = votes[i];
                indexmax = i;
            }
        }
        return indexmax;
    }

    //Переимановал метод из кириллического procentkandidata - candidatePercentage
    public static double candidatePercentage(int[] votes, int nomer) {
        //Удалил лишние переменные
        return votes[nomer] / (numberOfThoseWhoVoted(votes) / ONEHUNDREDPERCENT);

    }

    //Переименовал метод из кириллического stoprocentov - numberOfThoseWhoVoted
    public static int numberOfThoseWhoVoted(int[] votes) {
        int allvotes = 0;
        //Упростил цикл убрав счетчик
        for (int vote : votes) {
            allvotes = allvotes + vote;
        }
        return allvotes;
    }
}
