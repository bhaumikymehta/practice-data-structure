package leetcode150;

import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new LinkedList<>();
        for (int[] interval : intervals) {
            if (interval[1] < newInterval[0]) {
                list.add(interval);
            }
        }
        System.out.println(list);

        return null;
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = { { 1, 2 }, { 6, 9 } };
        int[] newInterval = { 3, 5 };
        insertInterval.insert(intervals, newInterval);

    }

}
