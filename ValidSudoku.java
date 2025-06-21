// Time Complexity : O(m*n)
// Space Complexity : O(9) which is  O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

// I'm checking for each row and column and each 3*3 grid if there are duplicate values stored in hashset
// Your code here along with comments explaining your approach
class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        // checking if any row has duplicate values
        for (int i = 0; i < m; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (hs.contains(board[i][j]))
                    return false;
                if (board[i][j] != '.')
                    hs.add(board[i][j]);
            }
        }
        // checking if any columns has duplicate values
        for (int j = 0; j < n; j++) {
            HashSet<Character> hs = new HashSet<>();
            for (int i = 0; i < m; i++) {
                if (hs.contains(board[i][j]))
                    return false;
                if (board[i][j] != '.')
                    hs.add(board[i][j]);
            }
        }
        // checking for all subsets of size 3*3
        for (int r = 0; r < m; r+=3) {
            for (int c = 0; c < n; c+=3) {
                HashSet<Character> hs = new HashSet<>();
                for (int sr = c; sr < c + 3; sr++) {
                    for (int sc = r; sc < r + 3; sc++) {
                        if (hs.contains(board[sr][sc]))
                            return false;
                        if (board[sr][sc] != '.')
                            hs.add(board[sr][sc]);

                    }
                }
            }
        }
        return true;
    }

}

