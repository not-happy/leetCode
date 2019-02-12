package array.q1;

/**
 * 从排序数组中删除重复项
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/21/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2){
            return nums.length;
        }
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[start] != nums[i]){
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }
}