
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


import java.util.*;

class MagicDictionary_ {

    Set<String> words;
    Map<String, Integer> count;

    /** Initialize your data structure here. */
    public MagicDictionary_() {
        words = new HashSet<>();
        count = new HashMap<>();
    }

    private ArrayList<String> genNeb(String word){
        ArrayList<String> ans = new ArrayList<>();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i){
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict){
            this.words.add(word);
            for (String nei : genNeb(word)){
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        for (String nei : genNeb(word)){
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word))
                return true;
        }

        return false;
    }
}


class _676_MagicDictionary_ {
    public static void main(String[] args) {

        MagicDictionary_ dic = new MagicDictionary_();
        String[] dics = {"hello", "hallo", "leetcode", "world"};
        dic.buildDict(dics);

        dic.search("hkllo");
        dic.search("world");

    }
}

