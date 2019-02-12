package array.q7;

/**
 * 加一
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/27/
 */
public class Solution {

    public int[] plusOne(int[] digits) {
        digits[digits.length - 1]++;
        for (int i = digits.length - 1; i > 0; i--) {
            if(digits[i] == 10){
                digits[i] = 0;
                digits[i - 1] = digits[i - 1] + 1;
            }
        }
        if(digits[0] == 10){
            digits[0] = 0;
            int[] results = new int[digits.length + 1];
            results[0] = 1;
            for (int i = 1; i < results.length; i++) {
                results[i] = digits[i - 1];
            }
            return results;
        }
        return digits;
    }

}
