import java.util.ArrayList;

public class A2_Q1 {




	public static int[] game(String[][] board){

		int balls = 0;
		int moves = 0;
		int minBalls = 0;
		int minMoves = 0;


		for (int i = 0; i < board.length; i++) {

			for (int j = 0; j < board[i].length; j++) {

				if (board[i][j].equals("o")) {

					balls += 1;
				}

			}

		}

		minBalls = balls;




		int[] getBallsandMoves = solve(board, balls, 0, minBalls, 0);



		//return solve(board, balls, 0, minBalls, 0);

		return getBallsandMoves;


	}



	public static boolean canMoveRight(String[][] board, int row, int col){
		if(col + 1 >= board[row].length || col + 2 >= board[row].length){
			return false;
		}
		if(board[row][col].equals("o")){
			if(board[row][col + 1].equals("o")){
				return board[row][col + 2].equals(".");
			}
		}
		return false;
	}

	public static boolean canMoveLeft(String[][] board, int row, int col){

		if(col - 1 < 0 || col - 2 < 0){
			return false;
		}
		if(board[row][col].equals("o")){
			if(board[row][col - 1].equals("o")){
				return board[row][col - 2].equals(".");
			}
		}
		return false;
	}

	public static boolean canMoveBottom(String[][] board, int row, int col) {
		if (row + 1 >= board.length || row + 2 >= board.length) {
			return false;
		}

		if (board[row][col].equals("o")) {
			if (board[row + 1][col].equals("o")) {
				return board[row + 2][col].equals(".");
			}
		}
		return false;
	}

	private static boolean canMoveTop(String[][] board, int row, int col){
		if(row - 1 < 0 || row - 2 < 0){
				return false;
		}

		if(board[row][col].equals("o")){
			if(board[row-1][col].equals("o")){
				return board[row - 2][col].equals(".");
			}
		}
		return false;
	}





	public static int[] solve(String[][] board, int balls, int moves, int minBalls, int minMoves){

		//int row, col;



		//int count = 0;


		for (int a = 0; a < board.length; a++) {

			for (int b = 0; b < board[a].length; b++) {

				if (board[a][b].equals("#")) {

					continue;
				}
				// make right move


				if (canMoveRight(board, a, b)) {

					board[a][b] = ".";
					board[a][b + 1] = ".";
					board[a][b + 2] = "o";
					moves += 1;
					balls -= 1;
					//count ++;

					int[] getArraySolve = solve(board, balls, moves, minBalls, minMoves);

					if (getArraySolve[0] < minBalls){

						minBalls = getArraySolve[0];
						minMoves = getArraySolve[1];

					}

					else if(minBalls == getArraySolve[0] && minMoves < getArraySolve[1]){

						minMoves = getArraySolve[1];
					}


					board[a][b] = "o";
					board[a][b + 1] = "o";
					board[a][b + 2] = ".";
					moves -= 1;
					balls += 1;

				}


				if (canMoveLeft(board, a, b)) {

					board[a][b] = ".";
					board[a][b - 1] = ".";
					board[a][b - 2] = "o";
					moves += 1;
					balls -= 1;


					int[] getArraySolve = solve(board, balls, moves, minBalls, minMoves);

					if (getArraySolve[0] < minBalls){

						minBalls = getArraySolve[0];
						minMoves = getArraySolve[1];

					}

					else if(minBalls == getArraySolve[0] && minMoves < getArraySolve[1]){

						minMoves = getArraySolve[1];
					}

					//solve(board, balls, moves, a, b - 2);


					board[a][b] = "o";
					board[a][b - 1] = "o";
					board[a][b - 2] = ".";
					//this.left = 0;
					moves -= 1;
					balls += 1;

				}


				if (canMoveBottom(board, a, b)) {

					board[a][b] = ".";
					board[a + 1][b] = ".";
					board[a + 2][b] = "o";
					balls -= 1;
					moves += 1;


					//solve(board, balls, moves, a, b);
					int[] getArraySolve = solve(board, balls, moves, minBalls, minMoves);


					if (getArraySolve[0] < minBalls){

						minBalls = getArraySolve[0];
						minMoves = getArraySolve[1];

					}
					else if (minBalls == getArraySolve[0] && minMoves < getArraySolve[1]){

						minMoves = getArraySolve[1];

					}


					board[a][b] = "o";
					board[a + 1][b] = "o";
					board[a + 2][b] = ".";
					moves -= 1;
					balls += 1;
				}


				if (canMoveTop(board, a, b)) {


					board[a][b] = ".";
					board[a - 1][b] = ".";
					board[a - 2][b] = "o";
					moves += 1;
					balls -= 1;


					//solve(board, balls, moves, a, b);
					int[] getArraySolve = solve(board, balls, moves, minBalls, minMoves);

					if (getArraySolve[0] < minBalls){

						minBalls = getArraySolve[0];
						minMoves = getArraySolve[1];

					}

					else if(minBalls == getArraySolve[0] && minMoves < getArraySolve[1]){

						minMoves = getArraySolve[1];
					}

					board[a][b] = "o";
					board[a - 1][b] = "o";
					board[a - 2][b] = ".";
					moves -= 1;
					balls += 1;

				}
			}

			//return false;

		}

		int[] getArray = new int[2];

		if (balls < minBalls){

			getArray[0] = balls;
			getArray[1] = moves;
		}

		else if(balls == minBalls && moves < minMoves){
			getArray[0] = balls;
			getArray[1] = moves;
		}

		else{

			getArray[0] = minBalls;
			getArray[1] = minMoves;
		}


		return getArray;

	}


	/*



	public static void main(String[] args) {


		A2_Q1 b = new A2_Q1();

		String[][] board = {{"#", "#", "#", ".", "o", ".", "#", "#", "#"}, {".", ".", "o", "o", "o", ".", ".", ".", "."}, {".", ".", ".", ".", ".", "o", "o", ".", "."},
				{".", ".", ".", ".", ".", ".", ".", ".", "."}, {"#", "#", "#", ".", "o", ".", "#", "#", "#"}};
		//b.valid(board, 0, 0);
		int[] array;
		array = b.game(board);

		System.out.println(array);

	}


	 */







}
