import java.util.ArrayList;


public class Keymaker {

    //v1
    public static String Keymaker(int k) {
        String result = "";
        //doors - defaultKeyList
        ArrayList<Integer> defaultKeyList = new ArrayList<>();
        //Заполняем список дефолтными нулями
        for (int i = 0; i < k; i++) {
            defaultKeyList.add(0);
        }
        changeAllToOne(defaultKeyList);
        changeEvenToZero(defaultKeyList);
        changeThirdRotate(defaultKeyList);

        for (int i = 4; i <= defaultKeyList.size(); i++) {
            changeAfterStepRotate(defaultKeyList, i);
        }

        for (int i = 0; i < defaultKeyList.size(); i++) {
            result = result + defaultKeyList.get(i);
        }
        return result;
    }

    //result - allValuesOneList
    //first - changeValueAllToOne
    public static ArrayList<Integer> changeAllToOne(ArrayList<Integer> allValuesOneList) {
        for (int i = 0; i < allValuesOneList.size(); i++) {
            allValuesOneList.set(i, 1);
        }
        return allValuesOneList;
    }

    //afterfirst - allValuesOneList
    //secondstep - changeEvenToZero
    public static ArrayList<Integer> changeEvenToZero(ArrayList<Integer> allEvenZeroList) {
        for (int i = 0; i < allEvenZeroList.size(); i++) {
            if (i % 2 != 0) {
                allEvenZeroList.set(i, 0);
            }
        }
        return allEvenZeroList;
    }

    //aftersecond - allEvenZeroList
    //thirdstep - changeThirdRotate
    public static ArrayList<Integer> changeThirdRotate(ArrayList<Integer> replaceEveryThirdList) {
        for (int i = 2; i < replaceEveryThirdList.size(); i += 3) {
            if (replaceEveryThirdList.get(i) == 0) {
                replaceEveryThirdList.set(i, 1);
            } else if (replaceEveryThirdList.get(i) == 1) {
                replaceEveryThirdList.set(i, 0);
            }
        }
        return replaceEveryThirdList;
    }

    //otherstep - changeAfterStepRotate
    public static ArrayList<Integer> changeAfterStepRotate(ArrayList<Integer> otherstep, int step) {
        for (int i = step - 1; i < otherstep.size(); i += step) {
            if (otherstep.get(i) == 1) {
                otherstep.set(i, 0);
            } else if (otherstep.get(i) == 0) {
                otherstep.set(i, 1);
            }
        }
        return otherstep;
    }
}
