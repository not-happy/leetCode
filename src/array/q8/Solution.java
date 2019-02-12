package array.q8;

/**
 * 移动零
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/28/
 *
 * @author xuyong
 * @date 2018/8/17 13:55
 **/
public class Solution {

    public void moveZeroes(int[] nums) {
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[cur++] = nums[i];
            }
        }
        for (int i = cur; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
