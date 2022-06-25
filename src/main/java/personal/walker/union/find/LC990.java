package personal.walker.union.find;

import personal.walker.Solution;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC990 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(equationsPossible(new String[]{"a==b","c==a"}));
    }


    /**
     * union find,
     * 遇到 != 找root root相等，为false
     * 其他情况都是true
     *
     * @param equations
     * @return
     */
    public boolean equationsPossible(String[] equations) {
        List<String[]> eqList = new ArrayList<>();
        List<String> allEqElements = new ArrayList<>();
        List<String[]> nonEqList = new ArrayList<>();
        for (String equation : equations) {
            if (equation.contains("==")) {
                String[] parts = equation.split("==");
                allEqElements.add(parts[0]);
                allEqElements.add(parts[1]);
                eqList.add(new String[]{parts[0],parts[1]});
            } else {
                String[] parts = equation.split("!=");
                if (parts[0].equals(parts[1])){
                    return false;
                }
                nonEqList.add(new String[]{parts[0],parts[1]});
            }
        }
        UnionFind unionFind = new UnionFind(allEqElements);
        for (String[] eq : eqList){
             unionFind.union(eq[0],eq[1]);
        }
        for (String[] nonEq : nonEqList){
            if (!unionFind.contain(nonEq[0]) || !unionFind.contain(nonEq[1])){
                continue;
            }
             if (unionFind.find(nonEq[0]).equals(unionFind.find(nonEq[1]))){
                return false;
            }
        }
        return true;
    }

    class UnionFind {
        Map<String, String> parent;
        UnionFind(List<String> elements){
            parent = new HashMap<>();
            for (String element : elements){
                parent.put(element,element);
            }
        }
        public boolean contain(String key){
            return parent.containsKey(key);
        }
        public void union(String a, String b) {
            String aRoot = find(a);
            String bRoot = find(b);
            if (aRoot.equals(bRoot)){
                return;
            }
            parent.put(aRoot,bRoot);
        }
        public String find(String a) {
            String root = a;
            while (!parent.get(root).equals(root)) {
                root = parent.get(root);
            }
            // 进行压缩之间将a指向root
            parent.put(a,root);
            return root;
        }
    }

}
