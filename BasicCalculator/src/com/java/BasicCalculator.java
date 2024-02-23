package com.java;

import java.util.Scanner;

public class BasicCalculator {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Welcome to Basic Calculator!");
		System.out.println("Available operations: ");
		System.out.println("1. Addition (+)");
		System.out.println("2. Subtraction (-)");
		System.out.println("3. Multiplication (*)");
		System.out.println("4. Division (/)");

		System.out.print("Enter the first number: ");
		double num1 = scanner.nextDouble();

		System.out.print("Enter the second number: ");
		double num2 = scanner.nextDouble();

		System.out.print("Choose an operation (1/2/3/4): ");
		int operation = scanner.nextInt();

		double result = 0;

		switch (operation) {
		case 1:
			result = num1 + num2;
			System.out.println("Result: " + result);
			break;
		case 2:
			result = num1 - num2;
			System.out.println("Result: " + result);
			break;
		case 3:
			result = num1 * num2;
			System.out.println("Result: " + result);
			break;
		case 4:
			if (num2 != 0) {
				result = num1 / num2;
				System.out.println("Result: " + result);
			} else {
				System.out.println("Error: Cannot divide by zero!");
			}
			break;
		default:
			System.out.println("Error: Invalid operation!");
		}

		scanner.close();
	}
}
