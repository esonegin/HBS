
import java.util.*;
import java.util.List;

public class SherlockValidString {
    //v1
    static boolean SherlockValidString(String s) {
        //7.1 - result - isValidString
        boolean isValidString = true;
        ValidatedString ValidatedString = new ValidatedString();
        ArrayList<Integer> kolvolist = getUniqueCount(s);
        Collections.sort(kolvolist);

        ValidatedString.setstr(s);
        ValidatedString.setKolvolist(kolvolist);
        ValidatedString.setKolvoraznih(getUniqueSize(ValidatedString.getKolvolist()));


        if (ValidatedString.getKolvoraznih() == 2
                && (ValidatedString.getKolvolist().get(0) > ValidatedString.getKolvolist().get(1) + 1
                || ValidatedString.getKolvolist().get(0) < ValidatedString.getKolvolist().get(1) - 1)
                || ValidatedString.getKolvoraznih() == 2 && ValidatedString.getstr().length() % 2 == 0
                || ValidatedString.getKolvoraznih() > 2) {
            isValidString = false;
        }
        System.out.println(ValidatedString.getKolvolist());
        System.out.println(ValidatedString.getKolvoraznih());

        return isValidString;
    }

    //mainObject - ValidatedString
    public static class ValidatedString {
        public String str;
        public ArrayList<Integer> kolvolist;
        public int kolvoraznih;

        public void setstr(String str) {
            this.str = str;
        }

        public void setKolvolist(ArrayList<Integer> kolvolist) {
            this.kolvolist = kolvolist;
        }

        public void setKolvoraznih(int kolvoraznih) {
            this.kolvoraznih = kolvoraznih;
        }

        public String getstr() {
            return str;
        }

        public ArrayList<Integer> getKolvolist() {
            return kolvolist;
        }

        public int getKolvoraznih() {
            return kolvoraznih;
        }
    }

    //kolvoRaznih - getUniqueSize
    public static int getUniqueSize(ArrayList<Integer> kolvo) {
        Set<Integer> set = new HashSet<>(kolvo);
        ArrayList<Integer> res = new ArrayList<>();
        kolvo.clear();
        kolvo.addAll(set);
        res.addAll(set);
        return res.size();
    }

    //podshetKolva - getUniqueCount
    public static ArrayList<Integer> getUniqueCount(String s) {
        List<String> result = sortList(s);
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
