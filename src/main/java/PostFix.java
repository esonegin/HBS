public class PostFix {

    public <T> Integer postfixCheck(Stack<T> stack1) {
        Stack<T> stack2 = new Stack<T>();
        for (int i = 0; stack1.size() > 0; i++) {
            if (stack1.peek() instanceof Integer) {
                stack2.push(stack1.pop());
            } else if (stack1.peek() == "+") {
                stack2.push((Integer) stack2.pop() + (Integer) stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "-") {
                stack2.push((Integer) stack2.pop() - (Integer) stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "*") {
                stack2.push((Integer) stack2.pop() * (Integer) stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "/") {
                stack2.push((Integer) stack2.pop() / (Integer) stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "=") {
                break;
            }
        }
        return (Integer) stack2.peek();
    }
}
