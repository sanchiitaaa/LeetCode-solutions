class Solution {

    public int calcIndex(int nums[], int curr) {
        return ((curr + nums[curr]) % nums.length + nums.length) % nums.length;
    }

    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                continue;
            }

            boolean isPos = nums[i] > 0;
            int slow = i;
            int fast = i;

            while (true) {

                int nextSlow = calcIndex(nums, slow);

                if (nums[nextSlow] == 0 ||
                    (nums[nextSlow] > 0) != isPos ||
                    nextSlow == slow) {
                    break;
                }

                slow = nextSlow;

                int nextFast = calcIndex(nums, fast);

                if (nums[nextFast] == 0 ||
                    (nums[nextFast] > 0) != isPos ||
                    nextFast == fast) {
                    break;
                }

                fast = nextFast;

                nextFast = calcIndex(nums, fast);

                if (nums[nextFast] == 0 ||
                    (nums[nextFast] > 0) != isPos ||
                    nextFast == fast) {
                    break;
                }

                fast = nextFast;

                if (slow == fast) {
                    return true;
                }
            }

            int curr = i;

            while (nums[curr] != 0 &&
                   (nums[curr] > 0) == isPos) {

                int next = calcIndex(nums, curr);
                nums[curr] = 0;
                curr = next;
            }
        }

        return false;
    }
}