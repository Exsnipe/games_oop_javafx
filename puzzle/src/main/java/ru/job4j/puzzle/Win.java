package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        int cell = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                cell = i;
                break;
            }
        }
        return isHorizontalWin(board, cell) || isVerticalWin(board, cell);
    }

    public static boolean isHorizontalWin(int[][] board, int cell) {
        boolean result = true;
        for (int i = 0; i < board[cell].length; i++) {
            if (board[cell][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean isVerticalWin(int[][] board, int cell) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][cell] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
