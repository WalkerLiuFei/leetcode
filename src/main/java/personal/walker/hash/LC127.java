package personal.walker.hash;

import com.google.gson.Gson;
import personal.walker.Solution;
import personal.walker.Util;

import java.util.*;

public class LC127 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("dot","hot",  "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(ladderLength("a", "c", Arrays.asList("a","b","c")));
        System.out.println(ladderLength("a", "a", Arrays.asList("a","b","c")));
        System.out.println(ladderLength("qa", "sq", Arrays.asList("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye")));

    }

    /**
     * 最短路径，用bfs!!!!!

     * @return
     */

    long[] constants;
    private void preload(int length){
        constants = new long[length];
        for (int i =0; i < length; i++){
            constants[i] = (long)Math.pow(26,i);
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)){
            return 1;
        }
        preload(beginWord.length());
        HashMap<Long, List<String>>[] hashTables = new HashMap[beginWord.length()];
        for (int i = 0; i < beginWord.length(); i++) {
            hashTables[i] = calculateHashes(wordList, i);
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int levelNum = 1;
        int result = 1;
        HashSet<String> visited = new HashSet<>();
        boolean flag = false;
        while (!queue.isEmpty()){
            int newLevelNum = 0;

            while (levelNum > 0 && !queue.isEmpty()){
                String wordInQueue = queue.remove();

                HashSet<String> nextLevelStrings = new HashSet<>();
                for (int i = 0; i < wordInQueue.length(); i++ ){
                    if (hashTables[i].containsKey(calculateHash(wordInQueue,i))){
                        for (String s : hashTables[i].get(calculateHash(wordInQueue,i))){
                            if (!visited.contains(s)){
                                nextLevelStrings.add(s);
                            }
                            visited.add(wordInQueue);
                        }
                    }
                }
                flag = nextLevelStrings.contains(endWord);
                if (flag){
                    break;
                }
                newLevelNum += nextLevelStrings.size();
                queue.addAll(nextLevelStrings);
                levelNum--;
            }
            levelNum = newLevelNum;
            result ++;
            if (flag){
                break;
            }
        }
        if (!flag){
            return 0;
        }
        return result;
    }


    public Long calculateHash(String word, int skipIndex) {
        long result = 0;
        for (int i = 0; i < word.length(); i++) {
            if (i == skipIndex) {
                continue;
            }
            result += (word.charAt(i) - 'a') * constants[i];
        }
        return result;
    }

    public HashMap<Long, List<String>> calculateHashes(List<String> wordList, int skipIndex) {
        HashMap<Long, List<String>> hashes = new HashMap<>();
        for (String s : wordList) {
            Long hash = calculateHash(s, skipIndex);
            hashes.putIfAbsent(hash, new ArrayList<>());
            hashes.get(hash).add(s);
        }
        return hashes;
    }
}


