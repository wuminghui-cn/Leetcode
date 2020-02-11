//        LeetCode 39. Combination Sum（组合总数）
//        Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//        The same repeated number may be chosen from candidates unlimited number of times.
//
//        Note:
//        All numbers (including target) will be positive integers.
//        The solution set must not contain duplicate combinations.
//        题目：
//        给定一组候选数字 (候选) (不带重复项) 和目标数字 (目标), 可以在候选数字总和为目标的候选项中查找所有唯一的组合。
//        同样重复的数字可以从候选者无限次数中选择。
//
//        Example 1:
//        Input: candidates = [2,3,6,7], target = 7,
//        A solution set is:
//        [
//            [7],
//            [2,2,3]
//        ]
//
//        Example 2:
//        Input: candidates = [2,3,5], target = 8,
//        A solution set is:
//        [
//            [2,2,2,2],
//            [2,3,3],
//            [3,5]
//        ]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class _39_combinationSum {

    private static List<List<Integer>> result=new ArrayList<List<Integer>>();

    public static List<List<Integer>> combinationSum(int[] candidates,int target) {
        Arrays.sort(candidates);
        List<Integer> list=new ArrayList<Integer>();

        backtracking(candidates, 8, 0, list);

        return result;
    }

    public static void backtracking(int[] candidates,int target,int start, List<Integer> list){
        if (target < 0) return;
        else if (target == 0){
            result.add(new ArrayList<>(list));
        }

        for (int i = start; i < candidates.length; i++){

            list.add(candidates[i]);

            // i+1不允许重复使用
            // backtracking(candidates, target-candidates[i], i+1, list);

            // i ，每次都从0开始，允许重复使用
            backtracking(candidates, target-candidates[i], i, list);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        int[] candidates = {2,3,5};
        System.out.println(combinationSum(candidates, 8));
    }

}
