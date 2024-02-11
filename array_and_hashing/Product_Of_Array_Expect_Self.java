package array_and_hashing;

// Question :- https://leetcode.com/problems/product-of-array-except-self/description/

public class Product_Of_Array_Expect_Self {

    public static int[] productExceptSelf(int[] nums) {
       int[] left =  new int[nums.length];
       int[] right = new int[nums.length];
       int[] answer = new int[nums.length];

       left[0] = 1;

       for(int i=1; i<nums.length; i++){
           left[i] = nums[i-1] * left[i-1];
       }

       right[nums.length - 1]  = 1;
       for(int i= nums.length - 2; i>=0; i--){
           right[i] = nums[i+1] * right[i+1];
       }

       for(int i=0; i<nums.length; i++){
           answer[i] = left[i] * right[i];
       }

       return answer;
    }



    public static int[] productExpectSelfOptimised(int[] nums){
        int[] answer = new int[nums.length];

        answer[0] = 1;
        // left product
        for(int i=1; i<nums.length; i++){
            answer[i] = answer[i-1] * nums[i-1];
        }

        //right product
        int rightProduct = 1;
        for(int i=nums.length-1; i>=0; i--){
           answer[i] = answer[i] * rightProduct;
           rightProduct = rightProduct * nums[i];
        }

        return answer;
    }
    public static void main(String[] args){

       int[] nums = {1,2,3,4};
       int[] answer = productExceptSelf(nums);
        for(int i=0; i<answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }

}
