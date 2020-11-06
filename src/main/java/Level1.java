import java.util.ArrayList;

public class Level1 {


    public static void main(String[] args) {

        BalancedParentheses(3);

    }

    //v3
    public static String BalancedParentheses(int N) {
        String result = "";
        SpisokVsehVariantov spisok = new SpisokVsehVariantov(N, 0, "");

        recurs(spisok);
        System.out.println(spisok.getVariants());
        return result;
    }

    public static void recurs(SpisokVsehVariantov spisok) {
        int kolvopen = spisok.getOpen();
        int kolvoclosed = spisok.getClosed();
        String tekvar = spisok.getTekushee();

        if (kolvopen == 0 && kolvoclosed == 0) {
            spisok.setVariants(tekvar);
        }
        if (kolvopen > 0) {
            spisok.setOpen(spisok.getOpen() - 1);
            spisok.setClosed(spisok.getClosed() + 1);
            spisok.setTekushee(tekvar + "(");

            recurs(spisok);
        }
        if (kolvoclosed > 0) {
            spisok.setClosed(spisok.getClosed() - 1);
            spisok.setTekushee(tekvar + ")");
            recurs(spisok);
        }
    }

    public static class SpisokVsehVariantov {
        int open;
        int closed;
        String tekushee = "";
        ArrayList<String> variants = new ArrayList<>();

        public SpisokVsehVariantov(int open, int closed, String tekushee) {
            this.open = open;
            this.closed = closed;
            this.tekushee = tekushee;
        }

        public int getOpen() {
            return open;
        }

        public int getClosed() {
            return closed;
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
