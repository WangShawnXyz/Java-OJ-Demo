package newcoder.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 Given n points on a 2D plane, find the maximum number of
 points that lie on the same straight line.

 */
class Point {
  int x;
  int y;
  Point() { x = 0; y = 0; }
  Point(int a, int b) { x = a; y = b; }
}
class TMP{
    String k;
    int count;
}
public class MaxPointsNum {
    public int maxPoints(Point[] points) {
        return 0;
    }

    public static void main(String[] args){
        Point[] ps = new Point[5];
        ps[0] = new Point(1, 1);
        ps[1] = new Point(1, 2);
        ps[2] = new Point(2, 1);
        ps[3] = new Point(2, 2);
        ps[4] = new Point(2, 3);

    }
}
