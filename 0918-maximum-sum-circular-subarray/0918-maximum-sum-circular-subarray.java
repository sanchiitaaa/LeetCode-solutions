class Solution {
    public int kadaneMax(int[] nums, int n)
    {
        int sum = nums[0];
        int maxSum = nums[0];
        for(int i = 1; i < n; i++)
        {
            sum = Math.max(nums[i], nums[i] + sum);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
    public int kadaneMin(int[] nums, int n)
    {
        int sum = nums[0];
        int minSum = nums[0];
        for(int i = 1; i < n; i++)
        {
            sum = Math.min(nums[i], nums[i] + sum);
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int i = 0; i < n ;i++)
        {
            total += nums[i];
        }
        int maxSum = kadaneMax(nums, n);
        int minSum = kadaneMin(nums, n);
        int circularSum = total - minSum;
        if(maxSum > 0)
            return Math.max(maxSum, circularSum);
        
        return maxSum;
    }
}