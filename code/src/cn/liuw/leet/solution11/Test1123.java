package cn.liuw.leet.solution11;

import java.util.Arrays;

/**
 * 在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横坐标就足够了。开始坐标总是小于结束坐标。
 * <p>
 * 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。
 * <p>
 * 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。
 * <p>
 * 输入：points = [[10,16],[2,8],[1,6],[7,12]]
 * 输出：2
 * 解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球
 *
 * @author liuw
 * @date 2020/11/23
 */
public class Test1123 {

    public static void main(String[] args) {
        int[][] data = {{4, 5}, {2, 3}, {-2147483646, -2147483645}};
        printArrays(data);
        int result = findMinArrowShots(data);
        printArrays(data);
        System.out.println("shooting " + result);
    }

    public static int findMinArrowShots(int[][] points) {

        if (points.length < 1) {
            return 0;
        }

        // 排序
        Arrays.sort(points, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        // 计数
        int count = 1;
        // 第一箭的横坐标
        int axis = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            if(axis < points[i][0]) {
                count++;
                axis = points[i][1];
            }
        }
        
        return count;
    }

    public static void printArrays(int[][] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i][0] + "," + args[i][1]);
        }
    }
}
