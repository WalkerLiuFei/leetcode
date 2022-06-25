package personal.walker.a.notes;

import personal.walker.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 利用两个堆来实现, 且先定义为 small  heap 和 large heap, small heap 为 大顶堆， large heap 为小顶堆。
 * 在进行addNumber 操作时保持 small heap = n / 2 或者 n / 2 + 1 ， large heap的长度为 n / 2。 这样在计算中间值时只要让两个堆顶的值相加除以2即可。
 *
 * 在进行 addNum操作时，small和large队列的情况如下:
 * (1) length of (small, large) == (k, k)
 * (2) length of (small, large) == (k + 1, k)
 *
 * 进行完addNum操作后的情况:
 * (1) length of (small, large) == (k + 1, k)
 * (2) length of (small, large) == (k + 1, k + 1)
 *
 * 对于第一种情况，我们知道，首先将 num 添加到 large heap 中（因为现在median 为 small heap的堆顶，加了新数num后未必不是这个堆顶，所以要重新整理）， 将num添加到 large heap中
 * large heap size > small heap size ,这是不符合要求的，所以要将large heap 的堆顶pop出，然后加入到 small heap中
 *
 * 第二种情况相反，先加到 small heap中，然后进行接下来的操作。
 *
 *
 *
 */
public class LC295 implements Solution {
    @Override
    public void runTestCases() {

    }



}
