package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return isHorizontalWin(board) || isVerticalWin(board);
    }

    public static boolean isHorizontalWin(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != 1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean isVerticalWin(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                for (int j = 0; j < board.length; j++) {
                    if (board[j][i] != 1) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
