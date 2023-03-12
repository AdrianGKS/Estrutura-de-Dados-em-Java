package stack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Stack <Carro> stack = new Stack<>();

        stack.push(new Carro("Ford"));
        stack.push(new Carro("Chevrolet"));
        stack.push(new Carro("Fiat"));

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        System.out.println(stack.peek());
        System.out.println(stack);

        System.out.println(stack.empty());
    }
}
