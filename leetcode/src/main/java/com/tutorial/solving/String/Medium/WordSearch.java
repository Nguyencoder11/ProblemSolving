package com.tutorial.solving.String.Medium;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == word.charAt(0) && dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        if (index == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                dfs(board, word, r - 1, c, index + 1) ||
                dfs(board, word, r, c + 1, index + 1) ||
                dfs(board, word, r, c - 1, index + 1);
        board[r][c] = temp;

        return found;
    }

    private static void printBoard(char[][] board) {
        System.out.print("board = [");
        for (int i = 0; i < board.length; i++) {
            System.out.print("[");
            for (int j = 0; j < board[0].length; j++) {
                System.out.print("\"" + board[i][j] + "\"");
                if (j < board[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < board.length - 1) {
                System.out.print(",");
            }
        }
        System.out.print("]");
    }

    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        // Test 1
        char[][] board1 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word1 = "ABCCED";
        System.out.println("Testcase 1:");
        System.out.println("Input: ");
        printBoard(board1);
        System.out.print(", word = " + word1);
        System.out.println("\nOutput: " + solution.exist(board1, word1)); // Output: true

        // Test 2
        char[][] board2 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word2 = "SEE";
        System.out.println("Testcase 2:");
        System.out.println("Input: ");
        printBoard(board2);
        System.out.print(", word = " + word2);
        System.out.println("\nOutput: " + solution.exist(board2, word2)); // Output: true

        // Test 3
        char[][] board3 = {
                { 'A', 'B', 'C', 'E' },
                { 'S', 'F', 'C', 'S' },
                { 'A', 'D', 'E', 'E' }
        };
        String word3 = "ABCB";
        System.out.println("Testcase 3:");
        System.out.println("Input: ");
        printBoard(board3);
        System.out.print(", word = " + word3);
        System.out.println("\nOutput: " + solution.exist(board3, word3)); // Output: false
    }
}
