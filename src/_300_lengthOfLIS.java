
//        给定一个无序的整数数组，找到其中最长上升子序列的长度。
//
//        示例:
//
//        输入: [10,9,2,5,3,7,101,18]
//        输出: 4
//        解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
//        说明:
//
//        可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
//        你算法的时间复杂度应该为 O(n2) 。
//        进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?


class _300_lengthOfLIS {

    /// M-1
    public static int lengthOfLIS(int[] nums) {
        return lengthofLIS(nums, Integer.MIN_VALUE, 0);
    }

    public static int lengthofLIS(int[] nums, int prev, int curpos){
        if (curpos == nums.length){
            return 0;
        }

        int taken = 0;
        if (nums[curpos] > prev){
            taken = 1+lengthofLIS(nums, nums[curpos], curpos+1);
        }

        int nottaken = lengthofLIS(nums, prev, curpos+1);

        return Math.max(taken, nottaken);
    }

    //////
    ////// M-2
    public static int lengthOfLIS1(int[] nums){

        if (nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;

        for (int i = 1; i < dp.length; i++){
            int maxval = 0;

            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i]){
                    maxval = Math.max(maxval, dp[j]);
                }
            }

            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }

        return maxans;
    }



    public static void main(String[] agrs){
        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {2,5,7,101};
//        int[] nums = {2,5,4,6};

        System.out.println(lengthOfLIS1(nums));
        System.out.println(lengthOfLIS(nums));

    }

}
