/*
 * 354. Russian Doll Envelopes
You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.

One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

Note: You cannot rotate an envelope.

 
 */

import java.util.Arrays;

public class Question3 {
    public static int maxEnvelopes(int[][] envelopes) {
        //iterative approach
        Arrays.sort(envelopes,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        int dp[]=new int[envelopes.length];
        int maxlength=0;
        for(int i=0;i<dp.length;i++){
           //find the index of height of envelop
           int index=binarySearch(dp,0,maxlength,envelopes[i][1]);
           dp[index]=envelopes[i][1];
           if(index==maxlength){
            maxlength++;
           }
        }
        return maxlength;
        
    }
    public static int binarySearch(int dp[],int start,int end,int target){
        while(start<end){
            int mid=(start+end)/2;
            if(dp[mid]==target){
                return mid;
            }else if(dp[mid]>target){
                end=mid;

            }else{
                start=mid+1;
            }
        }
        return start;
    }
public static void main(String[] args) {
    int envelopes[][]={{5,4},{6,4},{6,7},{2,3}};
    System.out.println(maxEnvelopes(envelopes));
}    
}
