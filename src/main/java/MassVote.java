

public class MassVote {

    //Вынес граничное значение для выиграша в константу
    //Значение связывается во время компиляции, поскольку значение половины всегда 50%
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
        if (getNumberOfWinners() > 1) {
            result = "no winner";
        } else if (candidatePercentage(allvotes, getWinnersNumber(allvotes)) > BORDEROFVICTORY) {
            result = "majority winner " + (getWinnersNumber(allvotes) + 1);
        } else if (candidatePercentage(allvotes, getWinnersNumber(allvotes)) <= BORDEROFVICTORY) {
            result = "minority winner " + (getWinnersNumber(allvotes) + 1);
        }
        return result;
    }

    public static int getNumberOfWinners() {
        int kolvomax = 0;
        for (int i = 0; i < allvotes.length; i++) {
            if (allvotes[i] == getMaximumVotes()) {
                kolvomax++;
            }
        }
        return kolvomax;
    }

    public static int getMaximumVotes() {
        int max = allvotes[0];
        for (int allvote : allvotes) {
            if (max < allvote) {
                max = allvote;
            }
        }
        return max;
    }

    public static int getWinnersNumber(int[] votes) {
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

    //Получаем процент голосов за кандидата
    public static double candidatePercentage(int[] votes, int nomer) {
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
