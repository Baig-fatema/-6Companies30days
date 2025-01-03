public class Question8 {
    public static int numberOfSubarrays(int[] nums, int k) {
        //  for(int i=0;i<nums.length;i++){
        //     if(nums[i]%2==0){
        //         nums[i]=0;
        //     }else{
        //         nums[i]=1;
        //     }
        //  }
        //  int count=0;
        //  int subcount=0;
        //  for(int i=0;i<nums.length;i++){
        //     subcount=0;
        //     for(int j=i;j<nums.length;j++){
        //         if(nums[j]==1) subcount++;
        //         if(subcount==k){
        //             count++;
        //             break;
        //         } 
        //     }
        //  }
        // return count;
        int n = nums.length;
        int[] cnt = new int[n + 1];
        cnt[0] = 1;
        int ans = 0, t = 0;
        for (int v : nums) {
            t += v & 1;
            if (t - k >= 0) {
                ans += cnt[t - k];
            }
            cnt[t]++;
        }
        return ans;

    }
    public static void main(String[] args) {
        int nums[]={2,4,6};
        int k=1;
        System.out.println(numberOfSubarrays(nums, k));
    }
}
