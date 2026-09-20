class Solution {
    int nextIndex(int index, int[] nums)
    {
        int n = nums.length;
        return ((index + nums[index]) % n + n)% n;
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            boolean direction = nums[i] > 0;

            int slow = i;
            int fast = i;

            while (true) {
                int nextSlow = nextIndex(slow, nums);

                if (nextSlow == slow || (nums[nextSlow] > 0) != direction) {
                    break;
                }

                int nextFast = nextIndex(fast, nums);

                if (nextFast == fast || (nums[nextFast] > 0) != direction) {
                    break;
                }

                int nextFast2 = nextIndex(nextFast, nums);

                if (nextFast2 == nextFast || (nums[nextFast2] > 0) != direction) {
                    break;
                }

                slow = nextSlow;
                fast = nextFast2;

                if (slow == fast) {
                    return true;
                }
            }
        }

        return false;
    }
}