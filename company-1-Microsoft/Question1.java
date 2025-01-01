/*
 * 1401. Circle and Rectangle Overlapping
You are given a circle represented as (radius, xCenter, yCenter) and an axis-aligned rectangle represented as (x1, y1, x2, y2), where (x1, y1) are the coordinates of the bottom-left corner, and (x2, y2) are the coordinates of the top-right corner of the rectangle.
Return true if the circle and rectangle are overlapped otherwise return false. In other words, check if there is any point (xi, yi) that belongs to the circle and the rectangle at the same time.

 */
public class Question1{
    public static boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int close_Xaxis = Math.max(x1,Math.min(x2,xCenter));
        int close_Yaxis = Math.max(y1,Math.min(y2,yCenter));

        int distanceX = xCenter - close_Xaxis;
        int distanceY = yCenter - close_Yaxis;
        if(distanceX * distanceX + distanceY*distanceY <= radius*radius){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int radius=1;
        int xCenter=0;
        int yCenter=0;
        int x1=1;
        int y1=-1;
        int x2=3;
        int y2=1;
        System.out.println(checkOverlap(radius, xCenter, yCenter, x1, y1, x2, y2));
    }
}