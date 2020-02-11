
//

class Solution_169 {
    public static int majorityElement(int[] nums) {

        int count = 1;
        int number = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (count == 0){
                number = nums[i];
                count = 1;
                continue;
            }

            if (number != nums[i])
            {
                count--;
            }else {
                count++;
            }
        }


        return number;
    }

    public static void main(String[] args){
//        int[] nums = {2,2,1,1,1,2,2};
//        int[] nums = {3,2,3};
//        int[] nums = {0,0,0,0,1,1,1};
//        int[] nums = {0,0};
        int[] nums = {-1,1,1,1,2,1};

        int iRet = majorityElement(nums);

        System.out.println();
    }
}
