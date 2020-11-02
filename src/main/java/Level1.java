import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Level1 {
    //v1
    public static String BalancedParentheses(int N) {
        SpisokVsehVariantov spisok = new SpisokVsehVariantov();
        spisok.setMaxopen(N);
        String result = "";
        for (int i = 0; i < VseVariantiPoDlinne(spisok).size(); i++) {
            result = result + VseVariantiPoDlinne(spisok).get(i) + " ";
            //System.out.println(VseVariantiPoDlinne(spisok).get(i));
        }
        return result.trim();
    }

    public static ArrayList<String> VseVariantiPoDlinne(SpisokVsehVariantov spisok) {
        String chisla = "";
        for (int i = 0; i < spisok.getMaxopen(); i++) {
            chisla = chisla + "()";
        }
        chisla = (chisla.replace("(", "1").replace(")", "2"));
        Rearrange("", chisla, spisok);
        ArrayList<String> result = new ArrayList<>();
        Set<String> set = spisok.getSet();

        for (String s : set) {
            if (s.length() == spisok.getMaxopen() * 2 && s.substring(0, 1).equals("1") && s.substring(s.length() - 1).equals("2")) {
                result.add(s.replace("1", "(").replace("2", ")"));
            }
        }

        for (int i = 0; i < result.size(); i++) {
            String testString = result.get(i).substring(0, result.get(i).length() / 2);
            int occurrencesCount1 = testString.length() - testString.replace("(", "").length();
            int occurrencesCount2 = testString.length() - testString.replace(")", "").length();
            if (occurrencesCount2 > occurrencesCount1) {
                result.remove(i);
            }
        }

        return result;
    }

    public static String recurs(SpisokVsehVariantov spisok) {
        String result = "";
        if (spisok.getClosed() == spisok.getMaxopen()) {
            spisok.setSpisok(spisok.getTekushaya());

            return result;

        } else if (spisok.getOpen() > spisok.getClosed()) {
            spisok.setTekushaya(spisok.getTekushaya() + ")");
            spisok.setClosed(spisok.getClosed() + 1);
            recurs(spisok);

        } else if (spisok.getOpen() < spisok.getMaxopen()) {
            spisok.setTekushaya(spisok.getTekushaya() + "(");
            spisok.setOpen(spisok.getOpen() + 1);
            recurs(spisok);
        }


        for (int i = 0; i < spisok.getSpisok().size(); i++) {
            result = result + spisok.getSpisok().get(i) + " ";
        }
        return result;
    }


    public static void Rearrange(String prefix, String str, SpisokVsehVariantov spisok) {
        spisok.setSet(prefix);
        for (char ch : str.toCharArray())
            Rearrange(prefix + ch, str.replaceFirst(ch + "", ""), spisok);
    }


    public static class SpisokVsehVariantov {
        ArrayList<String> spisok = new ArrayList<>();
        ArrayList<String> vsevarianty = new ArrayList<>();
        String tekushaya = "";
        int open;
        int closed;
        int maxopen;
        Set<String> set = new HashSet();

        public void setOpen(int open) {
            this.open = open;
        }

        public void setSet(String string) {
            set.add(string);
        }

        public void setClosed(int closed) {
            this.closed = closed;
        }

        public void setMaxopen(int maxopen) {
            this.maxopen = maxopen;
        }

        public void setSpisok(String el) {
            spisok.add(el);
        }

        public void setTekushaya(String tekushaya) {
            this.tekushaya = tekushaya;
        }

        public void setVsevarianty(String el) {
            vsevarianty.add(el);
        }

        public ArrayList<String> getSpisok() {
            return spisok;
        }

        public int getOpen() {
            return open;
        }

        public int getClosed() {
            return closed;
        }

        public int getMaxopen() {
            return maxopen;
        }

        public String getTekushaya() {
            return tekushaya;
        }

        public ArrayList<String> getVsevarianty() {
            return vsevarianty;
        }

        public Set<String> getSet() {
            return set;
        }
    }


}
