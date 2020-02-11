//        给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。
//        示例 2：
//
//        输入: "cbbd"
//        输出: "bb"

//        中心扩散法怎么去找回文串？从每一个位置出发，向两边扩散即可。遇到不是回文的时候结束。
//        举个例子，str = "acdbbdaa"。我们需要寻找从第一个b（位置为3）出发最长回文串为多少。怎么寻找？
//        首先往左寻找与当期位置相同的字符，直到遇到不相等为止。
//        然后往右寻找与当期位置相同的字符，直到遇到不相等为止。
//        最后左右双向扩散，直到左和右不相等


class Solution_5 {



    public static String longestPalindrome1(String s) {
        if (null == s || s.length() < 2) {
            return s;
        }

        int iLen = s.length();
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;

        boolean[][] dp = new boolean[iLen][iLen];

        for (int r = 1; r < iLen; r++){

            for (int l = 0; l < r; l++){

                if (s.charAt(l) == s.charAt(r) && ((r-1) <= 2 || dp[l+1][r-1])){
                    dp[l][r] = true;

                    if (r - l + 1 > maxLen){
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }

        String strRet = s.substring(maxStart , maxEnd + 1);
        return strRet;
    }

    public static String longestPalindrome(String s) {
        if (null == s || s.length() < 1){
            return "";
        }

        int left = 0;
        int right = 0;
        int len = 0;
        int maxLen = 0;
        int maxStart = 0;

        for (int i = 0; i < s.length(); i++){
            left = i - 1;
            right = i + 1;

            while (left >=0 && s.charAt(left) == s.charAt(i)){
                len++;
                left--;
            }

            while (right < s.length() && s.charAt(right) == s.charAt(i)){
                len++;
                right++;
            }

            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
                len = len + 2;
            }

            if (len > maxLen)
            {
                maxLen = len;
                maxStart = left;
            }

            len = 1;
        }

        String strRet = s.substring(maxStart + 1, maxStart + maxLen + 1);


        return strRet;
    }


    public static void main(String[] args){
        String str = "dbbd";

        System.out.println(longestPalindrome1(str));
    }
}
