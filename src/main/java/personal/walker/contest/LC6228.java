package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.ArrayList;
import java.util.List;

public class LC6228 implements Solution {
    @Override
    public void runTestCases() {
        Gson gson = new Gson();
        System.out.println(gson.toJson(twoEditWords(new String[]{"word","note","ants","wood"},new String[]{"wood","joke","moat"})));;
        System.out.println(gson.toJson(twoEditWords(new String[]{"iarapqqk"}, new String[]{"apahhijt", "larapqqk", "isukkcws", "siqqoacj", "nloynmpm"})));


    }


    static class TrieNode {

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
        for (String word : words) {
            insert(trieNode, word);
        }
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            TrieNode node = trieNode;
            for (char c : words[i].toCharArray()) {
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
            if (root.child[c[i] - 'a'] == null) {
                root.child[c[i] - 'a'] = new TrieNode();
            }
            //如果该分支不存在，创建一个新节点
            root = root.child[c[i] - 'a'];
            root.prefix++;//注意，应该加在后面
        }
        //以该节点结尾的单词数+1
        root.count++;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i = 0; i < dictionary.length; i++) {
            insert(root, dictionary[i]);
        }
        for (int i = 0; i < queries.length; i++) {
            if (dfs(queries[i], root, 0, 2)) {
                result.add(queries[i]);
            }
        }
        return result;
    }

    private boolean dfs(String str, TrieNode node, int idx, int count) {
        if (count < 0) {
            return false;
        }
        if (idx == str.length()) {
            return true;
        }

        boolean result = false;
        if (node.child[str.charAt(idx) - 'a'] != null) {
            result = dfs(str, node.child[str.charAt(idx) - 'a'], idx + 1, count);
        }
        if (!result){
            for (int i = 0; i < 26; i++) {
                if (node.child[i] == null) {
                    continue;
                }
                result = dfs(str, node.child[i], idx + 1, count - 1);
                if (result) {
                    break;
                }
            }
        }
        return result;
    }
}
