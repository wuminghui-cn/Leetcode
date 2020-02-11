import java.util.HashMap;

class Trie {

    class Node{
        public char element;
        boolean wordEnd;
        HashMap<Character, Node> childdren = null;

        public Node(){
            this.wordEnd = false;
            childdren = new HashMap<>();
        }

        public Node(char item){
            this.element = item;
            this.wordEnd = false;
            childdren = new HashMap<>();
        }
    }

    public Node root;

    public Trie(){
        root = new Node();
    }

    public boolean insert(String word){
        if (word == null || word.length() == 0){
            return false;
        }

        Node cur = root;
        char[] chars = word.toCharArray();

        int i = 0;

        while (i < word.length() && cur.childdren.containsKey(chars[i])){
            cur = cur.childdren.get(chars[i]);
            i++;
        }

        if (i == word.length()){
            cur.wordEnd = true;
        }
        else{
            Node parNode = cur;
            for (int j = i; j < word.length(); j++ ){
                // 生成新节点
                char ch = chars[j];
                Node curNew = new Node(ch);
                parNode.childdren.put(ch, curNew);
                parNode = curNew;

                // 单词插入结束
                if (j == word.length() -1){
                    curNew.wordEnd = true;
                }
            }
        }

        return false;
    }

    public boolean search(String word){
        Node cur = root;
        int i = 0;
        char[] chars = word.toCharArray();

        while (i < word.length() && cur.childdren.containsKey(chars[i])){
            cur = cur.childdren.get(chars[i]);
            i++;
        }

        if (i == word.length() && cur.wordEnd == true){
            return true;
        }

        return false;
    }

    public boolean startWith(String word){
        Node cur = root;
        int i = 0;
        char[] chars = word.toCharArray();

        while (i < word.length() && cur.childdren.containsKey(chars[i])){
            cur = cur.childdren.get(chars[i]);
            i++;
        }

        if (i == word.length()){
            return true;
        }

        return false;
    }

}

public class t_Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("春天");
        trie.insert("春天来了");
        trie.insert("夏天");
        trie.insert("秋天");

        System.out.println("=====严格匹配======");
        System.out.println("春天：" + trie.search("春天"));
        System.out.println("春天来：" + trie.search("春天来"));
        System.out.println("春天来了：" + trie.search("春天来了"));
        System.out.println("春天来了吗：" + trie.search("春天来了吗"));
        System.out.println("秋天：" + trie.search("秋天"));
        System.out.println("冬天：" + trie.search("冬天"));

        System.out.println("=====前缀匹配======");
        System.out.println("春天：" + trie.startWith("春天"));
        System.out.println("春天来：" + trie.startWith("春天来"));
        System.out.println("春天来了：" + trie.startWith("春天来了"));
        System.out.println("春天来了吗：" + trie.startWith("春天来了吗"));
        System.out.println("秋天：" + trie.startWith("秋天"));
        System.out.println("冬天：" + trie.startWith("冬天"));
    }
}
