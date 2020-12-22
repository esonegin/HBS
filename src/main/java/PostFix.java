public class PostFix {

    public <T> Integer postfixCheck(Stack<T> stack1) {
        Stack<Integer> stack2 = new Stack<>();
        while (stack1.size() > 0) {
            if (stack1.peek() instanceof Integer) {
                stack2.push((Integer) stack1.pop());
            } else if (stack1.peek() == "+") {
                stack2.push(stack2.pop() + stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "-") {
                stack2.push(stack2.pop() - stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "*") {
                stack2.push(stack2.pop() * stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "/") {
                stack2.push(stack2.pop() / stack2.pop());
                stack1.pop();
            } else if (stack1.peek() == "=") {
                break;
            }
        }
        return stack2.peek();
    }
}
