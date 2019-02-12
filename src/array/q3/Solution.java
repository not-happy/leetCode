package array.q3;

/**
 * 旋转数组
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/23/
 */
class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        if(k == 0 || k == nums.length){
            return;
        }
        
        k = k % nums.length;
        int index = 0;
        int len = nums.length;
        do {
            index = reverse(nums, k, len);
            len = k;
            k -= index;
        }while(index > 0);
    }
    
    public int reverse(int[] nums, int start, int end){
        int temp;
        int index = 0;
        for(int i = start; i < end; i++){
            temp = nums[i];
            nums[i] = nums[index];
            nums[index] = temp;
            index = index + 1 == start ? 0 : index + 1;
        }
        return index;
    }
} 