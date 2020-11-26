public class Part1 {
    public static void main(String[] args) {
        testPrintAllGenes();
    }

    public static int findStopCodon(String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex + 3);

        if ((currIndex - (startIndex + 3)) > 0
                && (currIndex - (startIndex + 3)) % 3 == 0
                && currIndex != -1) {
            return currIndex;
        } else {
            return dna.length();

        }
    }

    public static void testFindStopCodon() {
        System.out.println(findStopCodon("ATGTAA", 0, "TAA"));
        System.out.println(findStopCodon("ATGTTTTTTTTTT", 0, "TAA"));
        System.out.println(findStopCodon("TATGTTTTAA", 1, "TAA"));

    }

    public static String findGene(String dna) {
        int atgIndex = dna.indexOf("ATG");
        String result = "";
        if (atgIndex == -1) {
            return result;
        } else if (findStopCodon(dna, atgIndex, "TAA") < findStopCodon(dna, atgIndex, "TAG")) {
            result = dna.substring(atgIndex, findStopCodon(dna, atgIndex, "TAA") + 3);
        } else if (findStopCodon(dna, atgIndex, "TAA") > findStopCodon(dna, atgIndex, "TAG")) {
            result = dna.substring(atgIndex, findStopCodon(dna, atgIndex, "TAG") + 3);
        }
        return result;
    }

    public static void testFindGene() {
        System.out.println("TTTTTTTT" + " " + findGene("TTTTTTTT"));
        System.out.println("ATGTTTTAG" + " " + findGene("ATGTTTTAG"));
        System.out.println("ATGTTTTAGUYYGUTAA" + " " + findGene("ATGTTTTAGUYYGUTAA"));
    }

    public static String printAllGenes(String dna) {
        //String result = findGene(dna);
        int currindex = 0;
        String res = dna;

        while(findGene(dna) != ""){
            if(currindex == 0) {
                return findGene(dna);
            }
            currindex = findGene(dna).length();
            res = res.substring(currindex);
        }
        return res;
    }

    public static void testPrintAllGenes() {
        System.out.println(printAllGenes("ATGTTTTAGUYATGYGUTAA"));
    }
}