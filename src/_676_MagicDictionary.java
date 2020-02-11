
//    实现一个带有buildDict, 以及 search方法的魔法字典。
//
//    对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
//
//    对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
//
//    示例 1:
//
//    Input: buildDict(["hello", "leetcode"]), Output: Null
//    Input: search("hello"), Output: False
//    Input: search("hhllo"), Output: True
//    Input: search("hell"), Output: False
//    Input: search("leetcoded"), Output: False


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MagicDictionary {

    Map<Integer, ArrayList<String>> buckets;

    /** Initialize your data structure here. */
    public MagicDictionary() {
        buckets = new HashMap<>();
//        root = new Node();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict){
            buckets.computeIfAbsent(word.length(), key -> new ArrayList<>()).add(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {

        // 长度不相匹配，返回失败
        if (!buckets.containsKey(word.length()))
            return false;

        for (String candidate: buckets.get(word.length())){
            int mismatch = 0;
            for (int i = 0; i < word.length(); i++){
                if (word.charAt(i) != candidate.charAt(i))
                {
                    if (++mismatch > 1)
                        break;
                }
            }

            if (mismatch == 1)
                return true;
        }

        return false;
    }
}


class _676_MagicDictionary {
    public static void main(String[] args) {

        MagicDictionary_ dic = new MagicDictionary_();
        String[] dics = {"hello", "leetcode", "world"};
        dic.buildDict(dics);

        //dic.search("春天");
        dic.search("春来");
        dic.search("春天去了");
        dic.search("秋天");
    }
}

