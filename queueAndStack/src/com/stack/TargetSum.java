package com.stack;

/**
 * @projectName: AlgorithmFundamentals
 * @className: TargetSum
 * @author: 赵俊杰
 * @Description: TODO
 * @date: 2021/7/31 11:56
 * @version: 1.0
 */

public class TargetSum {

    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        count = 0;
        searchTarget(nums,target,0,0);
        return count;
    }

    public void searchTarget(int[] nums, int target, int index, int sum){
        if(index == nums.length){
            if(sum == target){
                count++;
            }
        }else {
            searchTarget(nums,target,index+1,sum+nums[index]);
            searchTarget(nums,target,index+1,sum-nums[index]);
        }
    }
}
