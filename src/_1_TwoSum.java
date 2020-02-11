
//        给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
//        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//        示例:
//
//        给定 nums = [2, 7, 11, 15], target = 9
//
//        因为 nums[0] + nums[1] = 2 + 7 = 9
//        所以返回 [0, 1]
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/two-sum


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
public class _1_TwoSum {

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] iRet = twoSum(nums,target);

        System.out.println("[" + iRet[0] + "," + iRet[1] +"]");
    }

    public static int[] twoSum1(int[] nums, int target)
    {
        int[] iRet = new int[2];

        int[] copy = new int[nums.length];

        System.arraycopy(nums, 0, copy, 0, nums.length);
        Arrays.sort(copy);

        return iRet;
    }

    public static int[] twoSum(int[] nums, int target)
    {
        int[] numbers =  nums;

        int[] iRet = new int[2];

        for (int i = 0; i < numbers.length - 1; i++)
        {
            for (int j = i+1; j < numbers.length; j++)
            {
                if (numbers[i] + numbers[j] == target)
                {
                    iRet[0] = i;
                    iRet[1] = j;

                    return iRet;
                }
            }
        }

        return iRet;

    }

}
