import java.util.ArrayList;

public class Level1 {


    public static void main(String[] args) {
        //Создали объект spisok и положили туда текущее кол-во открытых, закрытых и требуемое кол-во открытых
        SpisokVsehVariantov spisok = new SpisokVsehVariantov(0, 0, 1);
        formirovanieStroki(spisok);
        System.out.println(spisok.getVariants());
    }

    //v2
    public static String BalancedParentheses(int N) {
        String result = "";

        return result;
    }

    public static void formirovanieStroki(SpisokVsehVariantov spisok) {
        while (spisok.closed < spisok.trebmaxopen) {
            if (spisok.open > spisok.closed) {
                spisok.setTekushee(spisok.getTekushee() + ")");
                spisok.setClosed(spisok.getClosed() + 1);
                formirovanieStroki(spisok);
            }
            if (spisok.open < spisok.trebmaxopen) {
                spisok.setTekushee(spisok.getTekushee() + "(");
                spisok.setOpen(spisok.getOpen() + 1);
                formirovanieStroki(spisok);
            }
            if (spisok.open == spisok.closed) {
                spisok.setVariants(spisok.getTekushee());
            }
        }
    }


    public static class SpisokVsehVariantov {
        int open;
        int closed;
        int trebmaxopen;
        String tekushee = "";
        ArrayList<String> variants = new ArrayList<>();

        public SpisokVsehVariantov(int open, int closed, int trebmaxopen) {
            this.open = open;
            this.closed = closed;
            this.trebmaxopen = trebmaxopen;
            this.tekushee = tekushee;
        }

        public int getOpen() {
            return open;
        }

        public int getClosed() {
            return closed;
        }

        public int getTrebmaxopen() {
            return trebmaxopen;
        }

        public String getTekushee() {
            return tekushee;
        }

        public ArrayList<String> getVariants() {
            return variants;
        }

        public void setOpen(int open) {
            this.open = open;
        }

        public void setClosed(int closed) {
            this.closed = closed;
        }

        public void setTekushee(String tekushee) {
            this.tekushee = tekushee;
        }

        public void setVariants(String stroka) {
            variants.add(stroka);
        }
    }
}
