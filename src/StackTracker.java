import java.util.Stack;

class StackTracker {

    private CalculatorController controller;

    private Stack<Integer> num1Stack;
    private Stack<Integer> num2Stack;
    private Stack<Integer> resultStack = new Stack<>();
    private Integer carry = 0;

    StackTracker(CalculatorController cont, String num1, String num2) {
        controller = cont;
        num1Stack = new Stack<>();
        num2Stack = new Stack<>();
        fillStacks(num1, num2);
    }

    private void fillStacks(String sa, String sb) {
        for (int i = 0; i < sa.length(); i++) {
            num1Stack.push(Character.getNumericValue(sa.charAt(i)));
            System.out.println("something was pushed");
        }

        for (int i = 0; i < sb.length(); i++) {
            num2Stack.push(Character.getNumericValue(sb.charAt(i)));
        }
    }

    void pushResult(Integer n) {
        resultStack.push(n);
    }

    Integer getStack1Num() {
        return num1Stack.pop();
    }

    Integer getStack2Num() {
        return num2Stack.pop();
    }

    Integer getResultNum() {
        return resultStack.pop();
    }

    Integer getCarry() {
        return carry;
    }

    void setCarry(Integer num) {
        carry = num;
    }

    int getNum1StackSize() {
        return num1Stack.size();
    }

    int getNum2StackSize() {
        return num2Stack.size();
    }

    int getResultStackSize() {
        return resultStack.size();
    }
}
