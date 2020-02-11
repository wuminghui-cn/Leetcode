
//        给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
//        示例:
//
//        输入: [1,1,2]
//        输出:
//        [
//            [1,1,2],
//            [1,2,1],
//            [2,1,1]
//        ]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class _47_permutations {

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> retList = new ArrayList<>();



        ArrayList<Integer> numsList = new ArrayList<>();

        Arrays.sort(nums);
        for (int num : nums){
            numsList.add(num);
        }

        backtrack(numsList, retList, new ArrayList<>(), nums.length);

        return retList;
    }


    public static void backtrack(List<Integer> numList,
                                 List<List<Integer>> retList,
                                 List<Integer> itemList,
                                 int n) {
        if (itemList.size() == n) {
            retList.add(new ArrayList<>(itemList));
            return;
        }

        Integer preNum = null;

        for (int i = 0; i < numList.size(); i++) {
            if (preNum != null && preNum.equals(numList.get(i))) {
                //重复数字，不重复取
                continue;
            }

            Integer item = numList.remove(i);
            itemList.add(item);
            backtrack(numList, retList, itemList, n);
            itemList.remove(itemList.size() - 1);
            numList.add(i, item);
            preNum = item;
        }


    }


    public static void main(String[] args){
        int[] nums = {1,1,3};

        System.out.println(permuteUnique(nums));
    }

}
