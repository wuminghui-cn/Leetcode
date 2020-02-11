//        给定一个没有重复数字的序列，返回其所有可能的全排列。
//
//        示例:
//
//        输入: [1,2,3]
//        输出:
//        [
//            [1,2,3],
//            [1,3,2],
//            [2,1,3],
//            [2,3,1],
//            [3,1,2],
//            [3,2,1]
//        ]


import java.util.*;

public class _46_permute {

    public static List<List<Integer>> permute(int[] nums){

        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> numsList = new ArrayList<>();

        for (int num : nums){
            numsList.add(num);
        }

        int n = nums.length;
        backtrack(n, numsList, result, 0);
        
        return result;
    }


    public static void backtrack(int n,
                          ArrayList<Integer> nums,
                          List<List<Integer>> output,
                          int first) {
        if (first == n) {
            output.add(new ArrayList<>(nums));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            backtrack(n, nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    /////////////////////////////////////////////////////////////////////////////

    public static void main(String[] args){

        int[] nums = {1,2,3};

        System.out.println(permute(nums));

    }
}
