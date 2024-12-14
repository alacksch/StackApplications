public class Stack {

    private char[] stack;
    private int top;
    private int capacity;

    public Stack() {}

    public void create(int size) {
        stack = new char[size];
        top = -1;
        capacity = size;
    }
    public void push(char character) {
        if (isFull()) {
            throw new RuntimeException("Overflow true: cannot push to a full stack");
        }
        stack[++top] = character;
    }
    public char pop() {
        if (isEmpty()) {
            throw new RuntimeException("Underflow true: cannot pop from an empty stack");
        }
        return stack[top--];
    }
    public boolean isFull() {
        return top == capacity - 1;
    }
    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isValidInput(String string) {
        for (char character : string.toCharArray()) {
            if ("(){}[]".indexOf(character) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced(String string) {
        if (!isValidInput(string)) {
            throw new IllegalArgumentException("Input contains invalid characters");
        }
        for (int i = 0; i < string.length(); ++i) {
            char current = string.charAt(i);
            if ("({[".indexOf(current) >= 0) {
                push(current);
            } else if (")}]".indexOf(current) >= 0) {
                if (isEmpty() || !isMatch(pop(), current)) {
                    return false;
                }
            }
        }
        return isEmpty();
    }

    public boolean isMatch(char opening, char closing) {
        return (opening == '(' && closing == ')') ||
                (opening == '[' && closing == ']') ||
                (opening == '{' && closing == '}');
    }
}
