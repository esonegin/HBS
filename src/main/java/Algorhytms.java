

public class Algorhytms {

    public static void main(String[] args) {
        countdown(2);
    }

    public static void countdown(int i){
        if(i <= 1) {
            System.out.println(i);
        }
        else {
            countdown(i - 1);
        }
    }

}



