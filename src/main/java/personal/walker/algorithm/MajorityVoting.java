package personal.walker.algorithm;

/**
 * 多数投票算法，非常适合用于流式的数据的多数， 是一种用来寻找一组元素中占多数元素的常数空间级时间复杂度算法。
 * <p>
 * <p>
 * 初始化元素m并给计数器i赋初值i = 0
 * 对于输入队列中每一个元素x：
 * 若i = 0, 那么 m = x and i = 1
 * 否则若m = x, 那么 i = i + 1
 * 否则 i = i − 1
 * 返回 m
 * 即便输入序列没有多数元素，这一算法也会返回一个序列元素。然而如果能够进行第二轮遍历，检验返回元素的出现次数，就能判断返回元素是否为多数元素。
 * 因此算法需要两次遍历，亚线性空间算法无法通过一次遍历就得出输入中是否存在多数元素。[3]
 * <p>
 * <p>
 * 输入：{1,2,1,3,1,1,2,1,5}
 * 1. 从第一个数字1开始，我们想要把它和一个不是1的数字一起从数组里抵消掉，但是目前我们只扫描了一个1，所以暂时无法抵消它，把它加入到array，
 * 2. array变成了{1}，result由于没有抵消任何元素所以还是原数组{1,2,1,3,1,1,2,1,5}。
 * 3. 然后继续扫描第二个数，是2，我们可以把它和一个不是2的数字抵消掉了，因为我们之前扫描到一个1，所以array变成了{}，result变成了{1,3,1,1,2,1,5}
 * 4. 继续扫描第三个数1，无法抵消，于是array变成了{1},result还是{1,3,1,1,2,1,5};
 * 5. 接下来扫描到3,可以将3和array数组里面的1抵消,于是array变成了{},result变成了{1,1,2,1,5}
 * 6. 接下来扫描到1，此时array为空，所以无法抵消这个1，array变成了{1},result还是{1,1,2,1,5}
 * 7. 接下来扫描到1，此时虽然array不为空，但是array里也是1，所以还是无法抵消，把它也加入这个array,于是array变成了{1,1}
 * 8.（其实到这我们可以发现，array里面只可能同时存在一种数，因为只有array为空或当前扫描到的数和array里的数字相同时才把这个数字放入array）,
 * 9. result还是{1,1,2,1,5}接下来扫描到2，把它和一个1抵消掉，至于抵消哪一个1，无所谓，
 * array变成了{1},result是{1,1,5}接下来扫描到1，不能抵消，array变成了{1,1}，result{1,1,5}接下来扫描到5，可以将5和一个1抵消，array变成了{1},result变成了{1}
 */
public class MajorityVoting {
    public static void main(String[] args) {
        int[] inputs = new int[]{1,2,3,4,5,6,3,4,4};
        Integer majority = null;
        int count = 0;
        for (int input : inputs){
             if (count == 0) {
                majority = input;
            }
            if (input == majority) {
                count++;
            } else {
                count--;
            }

        }
        System.out.println(majority);
    }

}