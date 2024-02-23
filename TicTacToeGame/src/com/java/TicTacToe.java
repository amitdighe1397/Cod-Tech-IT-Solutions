package com.java;

import java.util.Scanner;

public class TicTacToe {
	private char[][] board;
	private char currentPlayer;
	private boolean isGameOver;

	public TicTacToe() {
		board = new char[3][3];
		currentPlayer = 'X';
		isGameOver = false;
		initializeBoard();
	}

	private void initializeBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = '-';
			}
		}
	}

	public void printBoard() {
		System.out.println("-------------");
		for (int i = 0; i < 3; i++) {
			System.out.print("| ");
			for (int j = 0; j < 3; j++) {
				System.out.print(board[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public void makeMove(int row, int col) {
		if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
			board[row][col] = currentPlayer;
			if (checkWin(row, col)) {
				System.out.println("Player " + currentPlayer + " wins!");
				isGameOver = true;
			} else if (checkDraw()) {
				System.out.println("It's a draw!");
				isGameOver = true;
			} else {
				currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
			}
		} else {
			System.out.println("Invalid move! Try again.");
		}
	}

	private boolean checkWin(int row, int col) {
		return (board[row][0] == currentPlayer && board[row][1] == currentPlayer && board[row][2] == currentPlayer)
				|| (board[0][col] == currentPlayer && board[1][col] == currentPlayer && board[2][col] == currentPlayer)
				|| (row == col && board[0][0] == currentPlayer && board[1][1] == currentPlayer
						&& board[2][2] == currentPlayer)
				|| (row + col == 2 && board[0][2] == currentPlayer && board[1][1] == currentPlayer
						&& board[2][0] == currentPlayer);
	}

	private boolean checkDraw() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == '-') {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isGameOver() {
		return isGameOver;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TicTacToe game = new TicTacToe();

		while (!game.isGameOver()) {
			game.printBoard();
			System.out.println("Player " + game.currentPlayer + "'s turn");
			System.out.print("Enter row (0-2): ");
			int row = scanner.nextInt();
			System.out.print("Enter column (0-2): ");
			int col = scanner.nextInt();
			game.makeMove(row, col);
		}

		game.printBoard();
		scanner.close();
	}
}
