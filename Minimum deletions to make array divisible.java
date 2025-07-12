import java.util.Arrays;
import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);


       String[] numsStr = scanner.nextLine().split(" ");
       int[] nums = new int[numsStr.length];
       for (int i = 0; i < nums.length; i++) {
           nums[i] = Integer.parseInt(numsStr[i]);
       }


       String[] numsDivideStr = scanner.nextLine().split(" ");
       int[] numsDivide = new int[numsDivideStr.length];
       for (int i = 0; i < numsDivide.length; i++) {
           numsDivide[i] = Integer.parseInt(numsDivideStr[i]);
       }
      
       scanner.close();
      
       int result = minOperations(nums, numsDivide);
       System.out.println(result);
   }
  
   public static int minOperations(int[] nums, int[] numsDivide) {
       int gcd = numsDivide[0];
       for (int i = 1; i < numsDivide.length; i++) {
           gcd = findGCD(gcd, numsDivide[i]);
       }


       Arrays.sort(nums);


       for (int i = 0; i < nums.length; i++) {
           if (gcd % nums[i] == 0) {
               return i;
           }


           if (i > 0 && nums[i] == nums[i-1]) {
               continue;
           }
       }


       return -1;
   }


   private static int findGCD(int a, int b) {
       while (b != 0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
   }
}
