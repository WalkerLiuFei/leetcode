package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6183 implements Solution {
    @Override
    public void runTestCases() {
       System.out.println(Arrays.toString(sumPrefixScores(new String[]{"abc","ab","bc","b"}))); ;
    }

    class TrieNode {

        char value;
        // 26个孩子
        TrieNode[] child;
        boolean isEnd;
        // prefix表示以该处节点之前的字符串为前缀的单词数量。
        int prefix;
        // 数量
        int count;

        {
            child = new TrieNode[26];
        }
    }

    public int[] sumPrefixScores(String[] words) {
        TrieNode trieNode = new TrieNode();
        for (String word : words){
            insert(trieNode,word);
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++){
            TrieNode node = trieNode;
            for (char c : words[i].toCharArray()){
                node = node.child[c - 'a'];
                result[i] += node.prefix;
            }
        }
        return result;
    }

    void insert(TrieNode root, String str) {
        if (root == null || str.length() == 0) {
            return;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (root.child[c[i] - 'a'] == null){
                root.child[c[i] - 'a'] = new TrieNode();
            }
            //如果该分支不存在，创建一个新节点
            root = root.child[c[i] - 'a'];
            root.prefix++;//注意，应该加在后面
        }
        //以该节点结尾的单词数+1
        root.count++;
    }

}
