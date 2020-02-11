class Solution_80 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int q = 1;
        int p = 1;
        int count = 1;

        while (p < nums.length){
            // p指针一直往后找，直到找到不同的数字后，将计数器恢复，同时准备将新值替换到q处。q指针后移
            if (nums[p] == nums[p-1]){
                count++;
            }
            else {
                count=1;
            }

            if (count < 3){
                nums[q] = nums[p];
                q++;
            }

            p++;
        }

        return q;
    }



    public static void main(String[] args){
//        int[] nums = {0,2,4,4};
        int[] nums = {0,0,0,1,1,1};
//        int[] nums = {1,1,2};
        int iRet = removeDuplicates(nums);
        System.out.println(iRet);
    }
}