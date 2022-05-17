import java.util.ArrayList;


public class Keymaker {

    public static void main(String[] args) {
        for(int i = 0; i < 40; i++){
            System.out.println(Keymaker(i));
        }
    }

    //v1
    public static String Keymaker(int k) {
        String result = "";
        //doors - defaultKeyList
        ArrayList<Integer> defaultKeyList = new ArrayList<>();
        //Заполняем список дефолтными нулями
        for (int i = 0; i < k; i++) {
            defaultKeyList.add(0);
        }
        firststep(defaultKeyList);
        secondstep(defaultKeyList);
        thirdstep(defaultKeyList);

        for (int i = 4; i <= defaultKeyList.size(); i++) {
            otherStep(defaultKeyList, i);
        }

        for (int i = 0; i < defaultKeyList.size(); i++) {
            result = result + defaultKeyList.get(i);
        }
        return result;
    }

    //result - allValuesOneList
    public static ArrayList<Integer> firststep(ArrayList<Integer> allValuesOneList) {
        for (int i = 0; i < allValuesOneList.size(); i++) {
            allValuesOneList.set(i, 1);
        }
        return allValuesOneList;
    }

    //afterfirst - allValuesOneList
    public static ArrayList<Integer> secondstep(ArrayList<Integer> allEvenZeroList) {
        for (int i = 0; i < allEvenZeroList.size(); i++) {
            if (i % 2 != 0) {
                allEvenZeroList.set(i, 0);
            }
        }
        return allEvenZeroList;
    }

    //aftersecond - allEvenZeroList
    public static ArrayList<Integer> thirdstep(ArrayList<Integer> replaceEveryThridList) {
        for (int i = 2; i < replaceEveryThridList.size(); i += 3) {
            if (replaceEveryThridList.get(i) == 0) {
                replaceEveryThridList.set(i, 1);
            } else if (replaceEveryThridList.get(i) == 1) {
                replaceEveryThridList.set(i, 0);
            }
        }
        return replaceEveryThridList;
    }

    public static ArrayList<Integer> otherStep(ArrayList<Integer> otherstep, int step) {
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
