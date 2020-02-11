
class Solution_26 {
    public static int removeDuplicates(int[] nums) {
        int p = 0;
        for (int q = p+1; q < nums.length;){
            if (nums[p] == nums[q]){
                q++;
            }
            else
            {
                nums[p+1] =nums[q];
                p++;
            }
        }

        return p+1;
    }

    public static int removeDuplicates1(int[] nums) {
        int k = nums.length -1;
        for (int i = 0; i < k+1; i++){
            for (int j = i+1; j <= k; j++){
                if (nums[i] == nums[j]){
                    nums[j] = nums[k];
                    k--;
                }
                else if (nums[i] != nums[j])
                {
                    break;
                }
            }
        }

        return k+1;
    }


    public static void main(String[] args){
//        int[] nums = {0,2,4,4};
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        int[] nums = {1,1,2};
        int iRet = removeDuplicates(nums);
        System.out.println(iRet);
    }
}