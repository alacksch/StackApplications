import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("1. Balanced parenthesis");
        System.out.println("2. String inversion");
        System.out.print("Please select an option => ");
        int option = scanner.nextInt();
        switch (option) {
            case 1 -> {
                try {
                    System.out.println(isBalanced());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    main(args);
                }
            }
            case 2 -> {
                try {
                    System.out.println(invert());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    main(args);
                }
            }
            default -> {
                System.out.println("Invalid option, please select an option from the menu.");
                main(args);
            }
        }
    }

    public static String isBalanced() {
        System.out.print("Enter your string with parenthesis: ");
        String string = scanner.next();
        Stack stack = new Stack();
        stack.create(string.length() + 1);
        if(!stack.isBalanced(string)) {
            return "Your string is not balanced.";
        } else if(stack.isBalanced(string)) {
            return "Your string is balanced.";
        }
        return null;
    }
    public static String invert() {
        StringBuilder inverted = new StringBuilder();
        System.out.print("Enter your string: ");
        String string = scanner.next();
        Stack stack = new Stack();
        stack.create(string.length() + 1);
        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));
        }
        while (!stack.isEmpty()) {
            inverted.append(stack.pop());
        }
        return "Input string is: " + string + "\n" + "Inverted string is: " + inverted;
    }
}