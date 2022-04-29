package personal.walker.contest;

import com.google.gson.Gson;
import personal.walker.Solution;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class LC6042 implements Solution {
    @Override
    public void runTestCases() {
        System.out.println(countLatticePoints(new int[][]{{2,2,2},{3,4,1}}));
        System.out.println(countLatticePoints(new int[][]{{2,2,1}}));

    }

    /**
     * 双指针，Math.abs((x^2 + y^2) - (circles[i][0]^2 + circle[i][1]^2)) <= circles[i][2] ^ 2
     *
     * @return
     */
    class  Point{
        int x;
        int y;
        Point(int x,int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public int countLatticePoints(int[][] circles) {
        int result = 0;
        Set<Point> pointSet = new HashSet<>();
        for (int[] circle : circles){
            for (int x =circle[0] - circle[2] ;x <=  circle[2] + circle[0]; x++){
                for ( int y = circle[1] - circle[2];y <= circle[2] + circle[1];y++){
                    if (Math.abs(((x - circle[0]) * (x - circle[0]) + (y - circle[1]) *  (y - circle[1]))) <= circle[2] * circle[2]){
                        pointSet.add(new Point(x,y));
                        result++;
                    }
                }
            }
        }
        Gson gson = new Gson();
        System.out.println(gson.toJson(pointSet));
        return pointSet.size();

    }
}
