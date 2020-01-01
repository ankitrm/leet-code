package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TinyCalculator {
  // ((11 + 2 * 3)*3)+2

  public static void main(String[] args) {
    System.out.println(calculateExpression("((11 + 2 * 3)*3)+(2*5)"));
    // Result should be 61
  }

  private static int calculateExpression(String input) {
    String[] inputsArray = getInputsAsArray(input);
    Stack<String> stack = new Stack<>();
    for(String inp: inputsArray) {
      if(!inp.equals(")")) {
        stack.push(inp);
      } else {
        String subCompute = "";
        while (!stack.peek().equals("(")) {
          subCompute = stack.pop() + subCompute;
        }
        stack.pop();
        stack.push(Integer.toString(calculate(subCompute)));
      }
    }

    String expression = "";
    while(!stack.isEmpty()) {
      expression += stack.pop();
    }
    return calculate(expression);

  }

  private static String[] getInputsAsArray(String input) {
    List<String> result = new ArrayList<>();
    Character[] ignore = {'(', ')', '*', '+'};
    List<Character> toIgnore = Arrays.asList(ignore);
    String prevInteger = "";
    for(char ch: input.toCharArray()) {
      if(ch == ' ') {
        if(!prevInteger.equals("")) {
          result.add(prevInteger);
          prevInteger = "";
        }
        continue;
      }
      if(toIgnore.contains(ch)) {
        if(!prevInteger.equals("")) {
          result.add(prevInteger);
          prevInteger = "";
        }
        result.add(Character.toString(ch));
      } else {
        prevInteger += Character.toString(ch);
      }
    }
    String[] res = new String[result.size()];
    result.toArray(res);
    return res;
  }

  // 1+2*3
  private static int calculate(String str) {
    final String operatorPlus = "\\+";
    final String[] splitStr = str.split(operatorPlus);
    List<Integer> remainingToAdd = new ArrayList<>();
    for(String strRemaining: splitStr) {
      int resOfMultiplies = 1;
      for(String strMult: strRemaining.split("\\*")) {
        resOfMultiplies *= Integer.parseInt(strMult.trim());
      }
      remainingToAdd.add(resOfMultiplies);
    }

    int res = 0;
    for(Integer remain: remainingToAdd) {
      res += remain;
    }

    return res;
  }
}
