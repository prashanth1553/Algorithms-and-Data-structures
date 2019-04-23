package com.smi;

public class Sudoku {

	public static boolean solveSudoku(int[][] numbers, int currentRow, int currentColumn, int gridSize,
			int numberOfSlotsUsed) {
		System.out.println("currentRow " + currentRow + " currentColumn" + currentColumn + " gridSize" + gridSize
				+ " numberOfSlotsUsed" + numberOfSlotsUsed);

		if (numberOfSlotsUsed > gridSize * gridSize) {
			print2Darray(numbers);
			return true;
		}
		if (currentColumn >= gridSize) {
			currentRow++;
			currentColumn = 0;
			if (currentRow >= gridSize) {
				return false;
			}
		}
		for (int i = 0; i < gridSize; i++) {
			if (valid(numbers, i + 1, currentRow, currentColumn, gridSize)) {
				numbers[currentRow][currentColumn] = i + 1;
				boolean isPassed = solveSudoku(numbers, currentRow, currentColumn + 1, gridSize, numberOfSlotsUsed + 1);
				if (isPassed) {
					return true;
				}
				numbers[currentRow][currentColumn] = -1;
			}
		}
		return false;
	}

	private static boolean valid(int[][] numbers, int number, int row, int column, int totalRows) {

		for (int i = 0; i < totalRows; i++) {
			if (numbers[i][column] == number) {
				return false;
			}

		}
		for (int i = 0; i < totalRows; i++) {
			if (numbers[row][i] == number) {
				return false;
			}

		}

		int sqrt = (int) Math.sqrt(totalRows);
		row++;
		column++;
		row = row - (row % sqrt == 0 ? sqrt : row % sqrt);
		column = column - (column % sqrt == 0 ? sqrt : column % sqrt);
		for (int i = row; i < (row + sqrt); i++) {
			for (int j = column; j < (column + sqrt); j++) {
				if (numbers[i][j] == number) {
					return false;
				}
			}
		}

		return true;
	}

	private static void print2Darray(int[][] numbers) {
		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers[i].length; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String args[]) {
		int grid = 9;
		int array[][] = new int[grid][grid];
		solveSudoku(array, 0, 0, grid, 1);
	}
}
