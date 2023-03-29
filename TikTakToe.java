package tik_tak_toe_2playes;

import java.util.Scanner;

public class TikTakToe {

	public static void main(String[] args) {
		// print the board
		char[][] board = new char[3][3];
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				board[row][col] = ' ';
			}
		}
		
		char player = 'X';
		boolean gameOver = false;
		Scanner s = new Scanner(System.in);
		
		while(!gameOver) {
			printBoard(board);
			System.out.println("Player " + player + " enter the index: ");
			int row = s.nextInt();
			int col = s.nextInt();
			
			// for exception case
			if(row > 2 || col > 2) {
				System.out.println("Invalid move. start again!");
				return;
			}
			
			if(board[row][col] == ' ') {
				// place the element
				board[row][col] = player;
				
				// call the game algorithm function
				gameOver = hasWon(board, player);
				if(gameOver) {
					System.out.println("Player " + player + " has won!");
					System.out.println("here is the final box:");
					
				} else {
					// switch the current Player
//					if(player == 'X')
//						player = '0';
//					else
//						player = 'X';
					player = (player == 'X') ? '0' : 'X';
				}
			} else {
				System.out.println("Invalid move. Try again!");
			}
		}
		printBoard(board);
	}
	
	public static boolean hasWon(char[][] board, char player) {
		// check rows
		for(int row = 0; row < board.length; row++) {
			if(board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		
		// check columns
		for(int col = 0; col < board.length; col++) {
			if(board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}
		
		// check diagonals
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		if(board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}
	
	public static void printBoard(char[][] board) {
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				System.out.print("| " + board[row][col] + " |");
			}
			System.out.println();
		}
	}

}
