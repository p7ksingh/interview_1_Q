package com.example.demoapplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Sort intervals based on start times
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastInterval = merged.get(merged.size() - 1);

            if (currentInterval[0] <= lastInterval[1]) {
                // Update end time if there is an overlap
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                // Add a new interval to the result list
                merged.add(currentInterval);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        int[][] result1 = merge(intervals1);
        System.out.println("Output 1: " + Arrays.deepToString(result1));

        int[][] intervals2 = {{6, 8}, {1, 9}, {2, 4}, {4, 7}};
        int[][] result2 = merge(intervals2);
        System.out.println("Output 2: " + Arrays.deepToString(result2));
    }
}

