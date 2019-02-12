package array.q10;

/**
 * 有效的数独
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/30/
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        int[][] nums = new int[10][10];
        int temp;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                temp = board[i][j] - 48;
                if((temp) > 0 && nums[temp] != null){
                    for (int k = 0; k < nums[temp].length; k += 2) {
                        if(nums[temp][k] == 0){
                            nums[temp][k] = (i + 1);
                            nums[temp][k + 1] = (j + 1);
                            break;
                        }
                        if(i == (nums[temp][k] - 1)
                                || j == (nums[temp][k + 1] - 1)
                                || ((nums[temp][k] - 1) / 3 == i / 3 && (nums[temp][k + 1] - 1) / 3 == j / 3)){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] nums = new char[9][9];
        nums[0] = new char[]{'5','3','.', '.','7','.', '.','.','.'};
        nums[1] = new char[]{'6','.','.', '1','9','5', '.','.','.'};
        nums[2] = new char[]{'.','9','8', '.','.','.', '.','6','.'};

        nums[3] = new char[]{'8','.','.', '.','6','.', '.','.','3'};
        nums[4] = new char[]{'4','.','.', '8','.','3', '.','.','1'};
        nums[5] = new char[]{'7','.','.', '.','2','.', '.','.','6'};

        nums[6] = new char[]{'.','6','.', '.','.','.', '2','8','.'};
        nums[7] = new char[]{'.','.','.', '4','1','9', '.','.','5'};
        nums[8] = new char[]{'.','.','.', '.','8','.', '.','7','9'};

        System.out.println(new Solution().isValidSudoku(nums));

    }

}
