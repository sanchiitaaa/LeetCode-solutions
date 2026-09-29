class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int maxAns = Math.abs(nums[0]);
        for(int i = 1; i < nums.length; i++)
        {
            maxSum = Math.max(maxSum + nums[i], nums[i]);
            minSum = Math.min(minSum + nums[i], nums[i]);

            int absMaxSum = Math.abs(maxSum);
            int absMinSum = Math.abs(minSum);
            maxAns = Math.max(maxAns, Math.max(absMaxSum, absMinSum));
        }
        

        return maxAns;
    }
}