package personal.walker.a.notes;

import personal.walker.Solution;
import personal.walker.Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class LC2271 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maximumWhiteTiles_tle(Util.convertTwoDimensionToIntegerArray("[[1,5],[10,11],[12,18],[20,25],[30,32]]"), 10));
        System.out.println(maximumWhiteTiles_tle(Util.convertTwoDimensionToIntegerArray("[[10,11],[1,1]]"), 2));
    }

    class Tile {
        int l;
        int r;

        Tile(int _l, int _r) {
            this.l = _l;
            this.r = _r;
        }
    }

    /**
     * 利用是否 每个 carpetlen 区间的白色砖块数量
     * 利用 滑动窗口
     * sliding window, greedy.
     * @param tiles
     * @param carpetLen
     * @return
     */

    public int maximumWhiteTiles_tle(int[][] tiles, int carpetLen) {
        List<Tile> tileList = new ArrayList<>();
        for (int[] tile : tiles) {
            tileList.add(new Tile(tile[0], tile[1]));
        }
        tileList.sort(Comparator.comparingInt(o -> o.l));
        Stack<Tile> afterMerge = new Stack<>();
        afterMerge.add(tileList.get(0));
        // 合并
        for (int i = 1; i < tileList.size(); i++) {
            if (tileList.get(i).l - 1 <= afterMerge.peek().r) {
                Tile tile = afterMerge.pop();
                tile.r = tileList.get(i).r;
                afterMerge.add(tile);
                continue;
            }
            afterMerge.add(tileList.get(i));
        }

        // 检查能覆盖的最多条目
        int ans = 0;
        int carpetLeft;
        for (int i = 0; i < afterMerge.size(); i++) {
            Tile tile = afterMerge.get(i);
            if (tile.r - tile.l + 1 >= carpetLen) {
                return tile.r - tile.l + 1;
            } else {
                int coveredLen = tile.r - tile.l + 1;
                carpetLeft = carpetLen - coveredLen;
                // TODO : FIXME : 在这一步进行二分搜索，将复杂度降低到 O(lgN)
                // 二分条件 ：
                for (int j = i + 1; j < afterMerge.size() && carpetLeft > 0; j++) {
                    carpetLeft -= afterMerge.get(j).l - tile.r - 1;
                    tile = afterMerge.get(j);
                    // 循环结束
                    if (carpetLeft <= 0) {
                        carpetLeft = 0;
                    } else if (carpetLeft > afterMerge.get(j).r - afterMerge.get(j).l + 1) {
                        coveredLen += afterMerge.get(j).r - afterMerge.get(j).l + 1;
                        carpetLeft -= afterMerge.get(j).r - afterMerge.get(j).l + 1;
                    } else {
                        coveredLen += carpetLeft;
                        carpetLeft = 0;
                    }
                }
                ans = Math.max(coveredLen, ans);
            }
        }
        return ans;
    }
}
