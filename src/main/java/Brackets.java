public class Brackets {

    public <T> Boolean balanceCheck(String str) {
        Stack<T> stack = new Stack<T>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
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
