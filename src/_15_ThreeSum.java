
//    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//    注意：答案中不可以包含重复的三元组。
//
//    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//    满足要求的三元组集合为：
//    [
//    [-1, 0, 1],
//    [-1, -1, 2]
//    ]

import java.util.*;

public class _15_ThreeSum {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        int target = 0;

        List<List<Integer>> ret = threeSum(nums, target);

        Iterator<List<Integer>> it = ret.iterator();
        while (it.hasNext())
        {
            List<Integer> list = it.next();

            System.out.println(list.toString());
        }

    }


    public static List<List<Integer>> threeSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -1; i++)
        {
            int j = i+1;
            int k = nums.length-1;

            if (i==0 || (i > 0 && nums[i] != nums[i-1]))
            {
                while (j < k)
                {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (sum == target)
                    {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        // 去除重复的值
                        while (j<k && nums[j] == nums[j+1]) j++;
                        while (j<k && nums[k] == nums[k-1]) k--;

                        j++;
                        k--;
                    }
                    else if (sum < target) j++;
                    else if (sum > target) k--;
                }
            }
        }

        return  result;
    }

}
