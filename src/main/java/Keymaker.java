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
        ArrayList<Integer> doors = new ArrayList<>();
        //Заполняем список дефолтными нулями
        for (int i = 0; i < k; i++) {
            doors.add(0);
        }

        firststep(doors);
        secondstep(doors);
        thirdstep(doors);

        for (int i = 4; i <= doors.size(); i++) {
            otherStep(doors, i);
        }

        for (int i = 0; i < doors.size(); i++) {
            result = result + doors.get(i);
        }

        //System.out.println(result);
        return result;
    }

    public static ArrayList<Integer> firststep(ArrayList<Integer> defaultlist) {
        for (int i = 0; i < defaultlist.size(); i++) {
            defaultlist.set(i, 1);
        }
        return defaultlist;
    }

    public static ArrayList<Integer> secondstep(ArrayList<Integer> afterfirst) {
        for (int i = 0; i < afterfirst.size(); i++) {
            if (i % 2 != 0) {
                afterfirst.set(i, 0);
            }
        }
        return afterfirst;
    }

    public static ArrayList<Integer> thirdstep(ArrayList<Integer> aftersecond) {
        for (int i = 2; i < aftersecond.size(); i += 3) {
            if (aftersecond.get(i) == 0) {
                aftersecond.set(i, 1);
            } else if (aftersecond.get(i) == 1) {
                aftersecond.set(i, 0);
            }
        }
        return aftersecond;
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
