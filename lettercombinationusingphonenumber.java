import java.util.*;
import java.lang.*;
import java.io.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}
public class Main {
    private static final Map<Character, String> PHONE_MAP = new HashMap<>();    
    static {
        PHONE_MAP.put('2', "abc");
        PHONE_MAP.put('3', "def");
        PHONE_MAP.put('4', "ghi");
        PHONE_MAP.put('5', "jkl");
        PHONE_MAP.put('6', "mno");
        PHONE_MAP.put('7', "pqrs");
        PHONE_MAP.put('8', "tuv");
        PHONE_MAP.put('9', "wxyz");
    }
    public void flatten(TreeNode root) {
        if (root == null) return;        
        TreeNode right = root.right;
        root.right = root.left;
        root.left = null;        
        TreeNode current = root;
        while (current.right != null) {
            current = current.right;
        }        
        current.right = right;
        flatten(right);
    }    
    public TreeNode createTree(String input) {
        if (input == null || input.length() == 0) return null;        
        String[] values = input.split("");
        Queue<TreeNode> queue = new LinkedList<>();        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);        
        int i = 1;
        while (!queue.isEmpty() && i < values.length) {
            TreeNode current = queue.poll();            
            if (i < values.length && !values[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.left);
            }
            i++;            
            if (i < values.length && !values[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(values[i]));
                queue.offer(current.right);
            }
            i++;
        }        
        return root;
    }    
    public void printFlattenedList(TreeNode root) {
        TreeNode current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
        System.out.println();
    }    
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) return new ArrayList<>();        
        List<String> result = new ArrayList<>();
        generateCombinations(digits, 0, new StringBuilder(), result);
        Collections.sort(result);        
        return result;
    }
    private static void generateCombinations(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = PHONE_MAP.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));
            generateCombinations(digits, index + 1, current, result);
            current.setLength(current.length() - 1);
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String digits = br.readLine().trim();
        
        List<String> combinations = letterCombinations(digits);
        System.out.println(String.join(" ", combinations));
    }
} 

