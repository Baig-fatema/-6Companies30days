/*
 * 497. Random Point in Non-overlapping Rectangles
Solved
Medium
Topics
Companies
You are given an array of non-overlapping axis-aligned rectangles rects where rects[i] = [ai, bi, xi, yi] indicates that (ai, bi) is the bottom-left corner point of the ith rectangle and (xi, yi) is the top-right corner point of the ith rectangle. Design an algorithm to pick a random integer point inside the space covered by one of the given rectangles. A point on the perimeter of a rectangle is included in the space covered by the rectangle.

Any integer point inside the space covered by one of the given rectangles should be equally likely to be returned.

Note that an integer point is a point that has integer coordinates.

Implement the Solution class:

Solution(int[][] rects) Initializes the object with the given rectangles rects.
int[] pick() Returns a random integer point [u, v] inside the space covered by one of the given rectangles.
 */
import java.util.*;

class Solution {
    private int[][] rects;
    private int[] cumulativeAreas;
    private Random random;
    public Solution(int[][] rects) {
        this.rects = rects;
        this.cumulativeAreas = new int[rects.length];
        this.random = new Random();
        int areaSum = 0;
        for (int i = 0; i < rects.length; i++) {
            int[] rect = rects[i];
            int area = (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
            areaSum += area;
            cumulativeAreas[i] = areaSum;
        }
    }
    public int[] pick() {
        int target = random.nextInt(cumulativeAreas[cumulativeAreas.length - 1]) + 1;
        int rectIndex = binarySearch(target);
        int[] rect = rects[rectIndex];
        int x = rect[0] + random.nextInt(rect[2] - rect[0] + 1);
        int y = rect[1] + random.nextInt(rect[3] - rect[1] + 1);

        return new int[]{x, y};
    }
    private int binarySearch(int target) {
        int left = 0, right = cumulativeAreas.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cumulativeAreas[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
public class Question6 {
    public static void main(String[] args) {
       
    }
}
