package study;

import java.util.Arrays;
import java.util.Scanner;

public class StringCalculator {
    final String[] OPERATOR_LIST = {"+", "-", "*", "/"};

    String operator = "";
    
    int calculator(String input, int expect) {
        Scanner sc = new Scanner(input);
        String expression = sc.nextLine();
        String[] values = expression.split(" "); 
        int result = 0;
        for (String value : values) {
            if(Arrays.stream(OPERATOR_LIST).anyMatch(value::equals)) {
                operator = value; 
                continue;
            }

            int number = Integer.parseInt(value);

            switch(operator) {
                case "" :
                    result = number;
                    break;
                case "+" :
                    result += number;
                    initializationOperator();
                    break;
                case "-" :
                    result -= number;
                    initializationOperator();
                    break;
                case "*" :
                    result *= number;
                    initializationOperator();
                    break;
                case "/" :
                    result /= number;
                    initializationOperator();
                    break;
             }
        }
        return result;
    }

    private void initializationOperator() {
        operator = "";
    }
    
}