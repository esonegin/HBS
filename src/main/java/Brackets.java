public class Brackets {

    public <T> Boolean balanceCheck(String stroka) {
        Stack<T> stack = new Stack<T>();
        for (int i = 0; i < stroka.length(); i++) {
            if (stroka.charAt(i) == '(') {
                stack.push((T) "(");
                continue;
            } else if (stack.size() == 0) {
                return false;
            } else {
                stack.pop();
            }
        }
        return (stack.size() == 0);
    }
}
