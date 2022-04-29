package personal.walker.design;

import personal.walker.Solution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 前缀树
public class LC211 implements Solution {
    //    public int firstBadVersion(int n) {
//        int left = 1,right= n;
//        while (left < right){
//            int mid  = (right - left)  / 2 + left;
//            if (isBadVersion(mid)){
//                right = mid;
//            }else{
//                left = mid + 1;
//            }
//        }
//        return left;
//    }
    @Override
    public void runTestCases() {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("abdc");
        wordDictionary.addWord("xcdx");
        wordDictionary.addWord("bcd");
        wordDictionary.addWord("x");
        System.out.println(wordDictionary.search("abdc"));
        System.out.println(wordDictionary.search("cdc"));
        System.out.println(wordDictionary.search("cdx"));
        System.out.println(wordDictionary.search("x"));
        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search("b"));
        System.out.println(wordDictionary.search("cdc."));
    }

    class WordDictionary {
        // index -> byte > word

        class Node {
            // next
            Node[] children;

            // only isEnd is true means it's a word;
            boolean isEnd;

            Node() {
                children = new Node[26];
            }
        }

        Node root;

        public WordDictionary() {
            root = new Node();
            root.children = new Node[26];
        }

        public void addWord(String word) {
            Node node = root;
            for (byte b : word.getBytes()) {
                if (node.children[b - 'a'] == null) {
                    node.children[b - 'a'] = new Node();
                }
                node = node.children[b - 'a'];
            }
            node.isEnd = true;
        }

        public boolean search(String word) {
           return recursive(root,word.getBytes(),0);
        }

        public boolean recursive(Node node, byte[] bytes, int index) {
            if (node == null) {
                return false;
            }
            if (index == bytes.length){
                return node.isEnd;
            }
            byte b = bytes[index];
            boolean flag = true;


            if (b == '.') {
                for (Node child : node.children) {
                    if (child != null) {
                        if (recursive(child, bytes, index + 1)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            return recursive(node.children[b - 'a'],bytes,index+1);
        }
    }
}
