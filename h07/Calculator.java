package edu.ics211.h07;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Declares the class Calculator, which implements ICalculator.
 * @author Caleb Cheshire
 *        found help for two of the method implementations at: https://github.com/soeux/ics211/tree/master/src/edu/ics211
 *        found help for the isNumber method at: https://regexr.com/4113k
 *        also received help from Prof. Moore in class 2/27/19
 *        worked with Justin Chen
 */
public class Calculator implements ICalculator {
  private static Calculator instance;
  private Stack<Number> calcStack = new Stack<Number>();

  /**
   * Creates single instance of Calculator.
   */
  private Calculator() {}

  /**
   * Check if Calculator exists. If not, create instance.
   * @return instance of Calculator.
   */
  public static Calculator getInstance() {
    if (instance == null) {
      instance = new Calculator();
    }
    return instance;
  }

  /**
   * Clears the Calculator.
   */
  @Override
  public void clear() {
    while (!calcStack.empty()) {
      calcStack.pop();
    }
  }

  /**
   * Converts input number from String to either Double or Integer depending if it has a decimal.
   * @param token input number.
   * @return Double or Integer representation of token.
   */
  private Number convertNumber(String token) {
    // Checks if number is a double with regex and return as number accordingly.
    if (token.matches("\\.?\\d+(\\.\\d+)")) {
      return Double.parseDouble(token);
    } else {
      return Integer.parseInt(token);
    }
  }

  /**
   * Checks if a String is an operator.
   * @param token value we're checking.
   * @return true if it's an operator; false otherwise.
   */
  private boolean isOperator(String token) {
    switch (token) {
      case "+":
      case "-":
      case "*":
      case "/":
        return true;
      default:
        return false;
    }
  }

  /**
   * Checks if a String is a number with regex.
   * @param token value we're checking.
   * @return true if number; false otherwise.
   */
  private boolean isNumber(String token) {
    // # credit: found how to do this @ https://regexr.com/4113k
    return token.matches("-?\\.?\\d+(\\.\\d+)?");
  }

  /**
   * Calculates the answer to the post-fix expression and returns it as a Number.
   * @param expression the post-fix expression.
   * @return The answer as a Number.
   * @throws InvalidExpressionException if the expression is invalid.
   */
  @Override
  public Number postFixCalculate(String expression) throws InvalidExpressionException {
    // # credit: found clarification for this method at: https://github.com/soeux/ics211/tree/master/src/edu/ics211
    String[] tokens = expression.split("\\s+");
    
    for (int i = 0; i < tokens.length; i++) {
      String token = tokens[i];

      if (isNumber(token)) {
        calcStack.push(convertNumber(token));
      } else if (isOperator(token)) {
        calculatePostFix(token);
      } else {
        throw new InvalidExpressionException();
      }
    }

    Number result = calcStack.pop();
    if (!calcStack.empty()) {
      throw new InvalidExpressionException();
    }
    return result;
  }

  /**
   * Calculates the answer to the pre-fix expression and returns it as a Number.
   * Optional method for extra credit.
   * @param expression the pre-fix expression.
   * @return The answer as a Number.
   * @throws InvalidExpressionException if the expression is invalid.
   */
  @Override
  public Number preFixCalculate(String expression) throws InvalidExpressionException {
    // # credit: found help for this method at: https://github.com/soeux/ics211/tree/master/src/edu/ics211
    String[] tokens = expression.split("\\s+");

    // Loops through the expression
    calcStack.clear();
    for (int i = tokens.length - 1; i >= 0; i--) {
      String token = tokens[i];

      // Uses if and else if statements to check the state of the stack.
      if (isNumber(token)) {
        calcStack.push(convertNumber(token));
      } else if (isOperator(token)) {
        calculatePreFix(token);
      } else {
        throw new InvalidExpressionException();
      }
    }

    // gets the answer and makes sure everything was calculated
    Number result = calcStack.pop();
    if (!calcStack.empty()) {
      throw new InvalidExpressionException();
    }
    return result;
  }

  /**
   * Does actual postfix calculation.
   * @param token The operator used to do the calculation.
   * @throws InvalidExpressionException If the expression was incorrect.
   */
  private void calculatePostFix(String token) throws InvalidExpressionException {
    // Checks if we have two operands so we can calculate
    Number second;
    Number first;
    try {
      second = calcStack.pop();
      first = calcStack.pop();
    } catch (EmptyStackException e) {
      throw new InvalidExpressionException();
    }

    // Checks if any of the numbers are doubles
    // if one operand is a double, then the whole thing will be double.
    if (second instanceof Double || first instanceof Double) {
      Double dubOne = first.doubleValue();
      Double dubTwo = second.doubleValue();

      // Uses switch statement to work through the calculation.
      switch (token) {
        case "+":
          calcStack.push(dubOne + dubTwo);
          break;
        case "-":
          calcStack.push(dubOne - dubTwo);
          break;
        case "*":
          calcStack.push(dubOne * dubTwo);
          break;
        case "/":
          calcStack.push(dubOne / dubTwo);
          break;
        default:
          break;
      }
    // If there aren't any doubles, then do Integer math.
    } else { 
      Integer intOne = first.intValue();
      Integer intTwo = second.intValue();

      switch (token) {
        case "+":
          calcStack.push(intOne + intTwo);
          break;
        case "-":
          calcStack.push(intOne - intTwo);
          break;
        case "*":
          calcStack.push(intOne * intTwo);
          break;
        case "/":
          calcStack.push(intOne / intTwo);
          break;
        default:
          break;
      }
    }
  }

  /**
   * Does actual prefix calculations.
   * @param token The operator used to do the calculation.
   * @throws InvalidExpressionException If the expression is incorrect.
   */
  private void calculatePreFix(String token) throws InvalidExpressionException {
    // Checks if we have two operands to calculate
    Number second;
    Number first;
    try {
      // Since it's looping backwards, we must change the order in which we pop items off the stack
      first = calcStack.pop();
      second = calcStack.pop();
    } catch (EmptyStackException e) {
      throw new InvalidExpressionException();
    }

    // Checks if any operand is a double; if so, the whole thing is double
    if (second instanceof Double || first instanceof Double) {
      Double dubOne = first.doubleValue();
      Double dubTwo = second.doubleValue();

      switch (token) {
        case "+":
          calcStack.push(dubOne + dubTwo);
          break;
        case "-":
          calcStack.push(dubOne - dubTwo);
          break;
        case "*":
          calcStack.push(dubOne * dubTwo);
          break;
        case "/":
          calcStack.push(dubOne / dubTwo);
          break;
        default:
          break;
      }
    // Do integer math if there aren't any doubles.
    } else { 
      Integer intOne = first.intValue();
      Integer intTwo = second.intValue();

      switch (token) {
        case "+":
          calcStack.push(intOne + intTwo);
          break;
        case "-":
          calcStack.push(intOne - intTwo);
          break;
        case "*":
          calcStack.push(intOne * intTwo);
          break;
        case "/":
          calcStack.push(intOne / intTwo);
          break;
        default:
          break;
      }
    }
  }
}