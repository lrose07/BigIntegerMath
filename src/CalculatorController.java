class CalculatorController {

    private StackTracker stackTracker;

    private boolean negativeResultFlag = false;

    CalculatorController() {
        new CalculatorGUI(this);
    }

    void doAddition(String num1, String num2) {
        stackTracker = new StackTracker(this, num1, num2);
        int currentNum1;
        int currentNum2;
        int stack1Size = stackTracker.getNum1StackSize();
        int stack2Size = stackTracker.getNum2StackSize();
        int startStackMax = Integer.max(stack1Size, stack2Size);
        for (int i = 0; i < startStackMax; i++) {
            currentNum1 = i > stack1Size + 1 ? 0 : stackTracker.getStack1Num();
            currentNum2 = i > stack2Size + 1 ? 0 : stackTracker.getStack2Num();

            int totalResult = currentNum1 + currentNum2 + stackTracker.getCarry();

            Integer digit = totalResult % 10;

            if (totalResult >= 10) {
                stackTracker.setCarry(1);
            } else {
                stackTracker.setCarry(0);
            }
            stackTracker.pushResult(digit);

        }

        if (stackTracker.getCarry() == 1) {
            stackTracker.pushResult(1);
        }
    }

    void doSubtraction(String num1, String num2) {
        if (swapNeeded(num1, num2)) {
            stackTracker = new StackTracker(this, num2, num1);
            negativeResultFlag = true;
        } else {
            stackTracker = new StackTracker(this, num1, num2);
            negativeResultFlag = false;
        }
        int currentNum1;
        int currentNum2;
        int stack1Size = stackTracker.getNum1StackSize();
        int stack2Size = stackTracker.getNum2StackSize();
        int startStackMax = Integer.max(stack1Size, stack2Size);
        System.out.println("startStackMax " + startStackMax);
        for (int i = 0; i < startStackMax; i++) {
            currentNum1 = i > stack1Size - 1 ? 0 : stackTracker.getStack1Num();
            currentNum2 = i > stack2Size - 1 ? 0 : stackTracker.getStack2Num();

            if (stackTracker.getCarry() == 1) {
                currentNum1--;
                stackTracker.setCarry(0);
            }

            if (currentNum1 < currentNum2) {
                currentNum1 += 10;
                stackTracker.setCarry(1);
            }

            int totalResult = currentNum1 - currentNum2;

            stackTracker.pushResult(totalResult);

        }
    }

    private boolean swapNeeded(String sa, String sb) {
        if (sa.length() > sb.length()) {
            return false;
        } else if (sa.length() < sb.length()) {
            return true;
        } else {
            int i = 0;
            do {
                if (Character.getNumericValue(sa.charAt(i)) > Character.getNumericValue(sb.charAt(i))) {
                    return false;
                } else if (Character.getNumericValue(sa.charAt(i)) < Character.getNumericValue(sb.charAt(i))) {
                    return true;
                }
                i++;
            } while ((i < sb.length()) && (sa.charAt(i) == sb.charAt(i)));
        }
        return false;
    }

    String getResult() {
        String result = "";
        int size = stackTracker.getResultStackSize();
        for (int i = 0; i < size; i++) {
            result = result + stackTracker.getResultNum().toString();
        }

        if (negativeResultFlag) {
            result = "-" + result;
        }
        return result;
    }
}
