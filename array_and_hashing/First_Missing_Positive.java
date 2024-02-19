package array_and_hashing;

// Question:- https://leetcode.com/problems/first-missing-positive/

public class First_Missing_Positive {

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int contains  = 0;

        // sanity check if 1 is present in the array or not
        for(int i=0; i<n; i++){
            if(nums[i] == 1){
                contains = contains + 1;
                break;
            }
        }

        if(contains == 0){
            return 1;
        }

        //  Data Cleanup
           // 1. > n
           // 2. > -ve
           // 3. 0 (Zero)
        for(int i=0; i<n; i++){
           if(nums[i] <=0 || nums[i] > n){
               nums[i] = 1;
           }
        }

        // Hashing concept
        for(int i=0; i<n; i++){
            int a = Math.abs(nums[i]);
            if(a == n){
                nums[0] = - Math.abs(nums[0]);
            }else{
                nums[a] = - Math.abs(nums[a]);
            }
        }

        // checking element from 1 to n for answer
        for(int i=1; i<n; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        // checking Oth index
        if(nums[0] > 0){
            return n;
        }

        return n+1;
    }


    public static void main(String[] args){
      int[] arr = {1,2,0};
      int ans = firstMissingPositive(arr);
      System.out.print(ans);
    }
}
