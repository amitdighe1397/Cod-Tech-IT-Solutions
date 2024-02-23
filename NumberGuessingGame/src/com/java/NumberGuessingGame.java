package com.java;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();

		int secretNumber = random.nextInt(100) + 1;
		int attempts = 0;
		int maxAttempts = 10;

		System.out.println("Welcome to the Number Guessing Game!");
		System.out.println("I've selected a random number between 1 and 100.");
		System.out.println("You have " + maxAttempts + " attempts to guess it.");

		while (attempts < maxAttempts) {
			System.out.print("Enter your guess: ");
			int guess = scanner.nextInt();
			scanner.nextLine(); 
			attempts++;

			if (guess == secretNumber) {
				System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in "
						+ attempts + " attempts.");
				break;
			} else if (guess < secretNumber) {
				System.out.println("Too low! Try again.");
			} else {
				System.out.println("Too high! Try again.");
			}
		}

		if (attempts == maxAttempts) {
			System.out.println("Sorry, you've run out of attempts!");
			System.out.println("The correct number was: " + secretNumber);
		}

		scanner.close();
	}
}
