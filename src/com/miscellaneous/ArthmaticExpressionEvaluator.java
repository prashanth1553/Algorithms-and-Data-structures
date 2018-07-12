package com.miscellaneous;

import java.util.Stack;

public class ArthmaticExpressionEvaluator {

	public static void main(String args[]) {

		String expression = "((1+((2+3)*(4*5)))";  // 101.0
	//	String expression = "10+2*6";  // 101.0


		Stack<String> operation = new Stack<>();
		Stack<Double> operand = new Stack<>();

		for (char ch : expression.toCharArray()) {

			String s = "" + ch;

			if (s.equals("(")) {

			} else if (s.equals("+")) {
				operation.push(s);
			} else if (s.equals("*")) {
				operation.push(s);
			} else if (s.equals(")")) {
				double value = operand.pop();
				String op = operation.pop();

				if (op.equals("+")) {
					value = value + operand.pop();
				} else if (op.equals("*")) {
					value = value * operand.pop();
				}
				operand.push(value);
			} else {

				operand.push(Double.parseDouble(s));
			}
		}

		System.out.println("calculated = " + operand.pop());
		
	}
}
