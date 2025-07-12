import java.util.Scanner;


public class Main {
    public static int numberOfSubstrings(String s) {
        // TODO: Implement logic here
        int start=0, end=0, count=0;
        int[] hash=new int[26];
        while(end<s.length()){
            hash[s.charAt(end)-'a']++;
            while(hash['a'-'a']>0 && hash['b'-'a']>0 && hash['c'-'a']>0){
                count+=s.length()-end;
                hash[s.charAt(start)-'a']--;
                start++;
            }
            end++;
        }
        return count; 
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next(); 
        scanner.close();
        
        int result = numberOfSubstrings(s);
        System.out.println(result); 
    }
}
