package array.q9;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/explore/interview/card/top-interview-questions-easy/1/array/29/
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max){
                max = nums[i];
            }
            if(nums[i] < min){
                min = nums[i];
            }
        }
        int[] index = new int[max - min + 1];
        int other;
        for (int i = 0; i < nums.length; i++) {
            other = target - nums[i];
            System.out.println((nums[i] - min) + " " + (i + 1));
            if(other < min || other > max){
                continue;
            }
            if(index[other - min] > 0){
                return new int[]{index[other - min] - 1, i};
            }
            index[nums[i] - min] = i + 1;

        }
        return null;
    }

    public int[] towSum2(int[] nums, int target){
        Map<Integer, Integer> results = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(results.get(nums[i]) != null){
                return new int[]{results.get(nums[i]), i};
            }
            results.put(target - nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().twoSum(new int[]{2,7,11,15}, 9));
    }

}
