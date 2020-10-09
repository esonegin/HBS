
import java.util.*;
import java.util.List;

public class SherlockValidString {
    //v1
    static boolean SherlockValidString(String s) {
        Boolean result = true;
        mainObject mainObject = new mainObject();
        ArrayList<Integer> kolvolist = podshetKolva(s);
        Collections.sort(kolvolist);

        mainObject.setStroka(s);
        mainObject.setKolvolist(kolvolist);
        mainObject.setKolvoraznih(kolvoRaznih(mainObject.getKolvolist()));


        if (mainObject.getKolvoraznih() == 2
                && (mainObject.getKolvolist().get(0) > mainObject.getKolvolist().get(1) + 1
                || mainObject.getKolvolist().get(0) < mainObject.getKolvolist().get(1) - 1)
                || mainObject.getKolvoraznih() == 2 && mainObject.getStroka().length() % 2 == 0
                || mainObject.getKolvoraznih() > 2) {
            result = false;
        }
        System.out.println(mainObject.getKolvolist());
        System.out.println(mainObject.getKolvoraznih());

        return result;
    }

    public static class mainObject {
        public String stroka;
        public ArrayList<Integer> kolvolist;
        public int kolvoraznih;

        public void setStroka(String stroka) {
            this.stroka = stroka;
        }

        public void setKolvolist(ArrayList<Integer> kolvolist) {
            this.kolvolist = kolvolist;
        }

        public void setKolvoraznih(int kolvoraznih) {
            this.kolvoraznih = kolvoraznih;
        }

        public String getStroka() {
            return stroka;
        }

        public ArrayList<Integer> getKolvolist() {
            return kolvolist;
        }

        public int getKolvoraznih() {
            return kolvoraznih;
        }
    }

    public static int kolvoRaznih(ArrayList<Integer> kolvo) {
        int result = 0;
        Set<Integer> set = new HashSet<>(kolvo);
        ArrayList<Integer> res = new ArrayList<>();
        kolvo.clear();
        kolvo.addAll(set);
        res.addAll(set);

        return res.size();
    }

    public static ArrayList<Integer> podshetKolva(String s) {
        List<String> result = sortList(s);
        System.out.println(result);
        String sortresult = "";
        for (int i = 0; i < result.size(); i++) {
            sortresult = sortresult + result.get(i);
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < sortresult.length(); i++) {
            char c = sortresult.charAt(i);
            if (map.containsKey(c)) {
                int cnt = map.get(c);
                map.put(c, ++cnt);
            } else {
                map.put(c, 1);
            }
        }

        ArrayList<Integer> kolvo = new ArrayList<Integer>();
        for (Map.Entry<Character, Integer> entry : map.entrySet())
            kolvo.add(entry.getValue());
        return kolvo;
    }

    public static List<String> sortList(String s) {
        String[] list = s.split("");
        List<String> listOfStrings = new ArrayList<String>();
        Collections.addAll(listOfStrings, list);
        Collections.sort(listOfStrings);

        return listOfStrings;
    }
}
