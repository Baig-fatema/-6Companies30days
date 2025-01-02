import java.util.Arrays;
public class Question5 {
        public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int median, ans;
        ans=0;
        if(n%2==0){
            //even number
            median=(nums[n/2-1]+nums[n/2])/2;

        }else{
          median=nums[n/2];
        }
        for(int i:nums){
            ans+=Math.abs(i-median);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nums[]={1,2,3};
        System.out.println(minMoves2(nums));
    }
}
