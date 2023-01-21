package personal.walker.contest;

import personal.walker.Solution;

import java.util.Arrays;

public class LC6236 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(maxPalindromes("fttfjofpnpfydwdwdnns",2));
        System.out.println(maxPalindromes("abaccdbbd",3));

    }

    public int maxPalindromes(String s, int k) {
        boolean[] visited = new boolean[s.length()];
        int result = 0;
        if (k == 1){
            result += s.length();
            Arrays.fill(visited,true);
        }
        for (int i = 0; i < s.length(); i++ ){
            int a,b;
            if ( i < s.length() - 1 && !visited[i] && !visited[i + 1] && s.charAt(i) == s.charAt(i+1)){
                a = i;
                b = i+1;
                while ( a >= 0 && b < s.length()  && !visited[a]  && !visited[b] && s.charAt(a) == s.charAt(b)){
                    if (b - a  + 1 >= k){
                        System.out.printf("a: %d, b : %d \n",a , b);
                        result++;
                        Arrays.fill(visited,a,b + 1,true);
                        break;
                    }
                    a--;
                    b++;
                }
            }

            if (i > 0 && i < s.length() - 1 && !visited[i-1] && !visited[i + 1] && s.charAt(i - 1) == s.charAt(i + 1)){
                a = i - 1;
                b = i + 1;
                while ( a >= 0 && b < s.length() && !visited[a]  && !visited[b] && s.charAt(a) == s.charAt(b)){
                    if (b - a  + 1 >= k){
                        System.out.printf("a : %d, b : %d \n",a , b);
                        result++;
                        Arrays.fill(visited,a,b + 1,true);
                        break;
                    }
                    a--;
                    b++;
                }
            }
        }
        return result;
    }

}
