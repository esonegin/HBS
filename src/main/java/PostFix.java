public class PostFix<T> {
    Stack<T> symbols;

    public PostFix(Stack<T> s) {
        this.symbols = s;
    }


    public <T> Integer postfixCheck() {
        Stack<Integer> stack2 = new Stack<>();
        while (symbols.size() > 0) {
            if (symbols.peek() instanceof Integer) {
                stack2.push((Integer) symbols.pop());
            } else if (symbols.peek() == "+") {
                stack2.push(stack2.pop() + stack2.pop());
                symbols.pop();
            } else if (symbols.peek() == "-") {
                stack2.push(stack2.pop() - stack2.pop());
                symbols.pop();
            } else if (symbols.peek() == "*") {
                stack2.push(stack2.pop() * stack2.pop());
                symbols.pop();
            } else if (symbols.peek() == "/") {
                stack2.push(stack2.pop() / stack2.pop());
                symbols.pop();
            } else if (symbols.peek() == "=") {
                break;
            }
        }
        return stack2.peek();
    }
}
