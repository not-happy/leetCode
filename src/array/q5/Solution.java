package array.q5;

/**
 * 只出现一次的数字
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/25/
 *
 * @author xuyong
 * @date 2018/8/13 14:18
 **/
public class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans ^= i;
        }
        return ans;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (int i = 1; i <= 9; i++) {
            sum ^= i;
        }
        System.out.println(sum);
    }

}
