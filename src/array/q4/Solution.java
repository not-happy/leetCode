package array.q4;

/**
 * 存在重复
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/24/
 */
class Solution {
    public static boolean containsDuplicate(int[] nums) {
        if(nums.length < 2){
            return false;
        }
        boolean isAll = false;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i - 1]){
                return true;
            }
            if(nums[i] < nums[i - 1] || isAll){
                isAll = true;
                for (int j = i - 1; j >= 0; j--) {
                    if(nums[j] == nums[i]){
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{0, 1, 1}));
    }

}