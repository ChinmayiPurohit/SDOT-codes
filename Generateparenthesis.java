import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       scanner.close();
      
       List<String> result = generateParenthesis(n);
       for (String s : result) {
           System.out.println(s);
       }
   }
  
   public static List<String> generateParenthesis(int n) {
       List<String> result = new ArrayList<>();
       backtrack(result, "", 0, 0, n);
       return result;
   }
  
   private static void backtrack(List<String> result, String current, int open, int close, int max) {


       if (current.length() == max * 2) {
           result.add(current);
           return;
       }


       if (open < max) {
           backtrack(result, current + "(", open + 1, close, max);
       }


       if (close < open) {
           backtrack(result, current + ")", open, close + 1, max);
       }
   }
}
