package personal.walker.algorithm;

import java.util.List;

public class Tarjan {
    /**
     * 寻找图中的强连通分量的数量
     * 强连通分量的数量 : https://zh.wikipedia.org/wiki/强连通分量
     * 算法讲解 ： https://www.youtube.com/watch?v=wUgWX0nc4NY
     * 代码讲解 ： https://www.youtube.com/watch?v=hKhLj7bfDKk
     *
     */

    /**
     *
     * @param n : 节点数量
     * @param connections : 连通关系
     */
    public void doSearch(int n, List<List<Integer>> connections){

    }


    /**
     *  UNVISTED = -1
     *  n = as number of nodes
     *  g = adjacency list with directed ediges
     *
     *  id = 0 // used to give each node a id
     *  sccCount = 0  // number of SCCs(strong connected components )
     *  ids = [0..0] // length is same as n
     *  lows = [0..0] // same as above length is n, the lowest id
     *  onStack = [false..false] // length is same as above, means the weather the node is in the stack.
     *  stack = // empty stack
     *
     *  function findSccs(){
     *      fill(ids,UNVISTED) // 初始化未访问
     *      for  node in ids {
     *          if ids[node] equal_to UNVISTED
     *              then dfs(node)
     *      }
     *  }
     *  function dfs(at){
     *      stack.push(at) //先入栈
     *      onStack[at] = true
     *      ids[at] = low[at] = id++ // 初始化ids 的同时也要初始化low[at]
     *      for (to : g[at]) // 访问neighbors
     *         if (ids[to] == UNVISTED) : dfs(to)
     *         if (onStack[to]) : low[at] = min(low[at],low[to]) // 拿到最小的low
     *      if (ids[at] == low[at]){ // 回到了原点，说明找到了一个强连通分量，pop out stack.
     *          for (node == stack.pop();;node = stack.pop()):
     *            onStack[node] = false
     *            low[node] = ids[at]
     *            if (node == at) : break
     *          sccCount++ // 强联通分量加 1
     *      }
     *  }
     */
}
