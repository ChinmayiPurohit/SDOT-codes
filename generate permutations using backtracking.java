import java.util.*;

public class Main {
    
    public static void permuteArray(List<Integer> nums, List<Integer> path, boolean[] used, List<List<Integer>> result) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(nums.get(i));
                permuteArray(nums, path, used, result);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) numList.add(num);
        permuteArray(numList, new ArrayList<>(), new boolean[nums.length], result);
        return result;
    }

    public static void permuteString(char[] chars, int left, int right, List<String> result) {
        if (left == right) {
            result.add(new String(chars));
            return;
        }
        
        for (int i = left; i <= right; i++) {
            swap(chars, left, i);
            permuteString(chars, left + 1, right, result);
            swap(chars, left, i); // Backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        if (input.startsWith("[") && input.endsWith("]")) {
            input = input.replaceAll("[\\[\\]]", "");
            String[] parts = input.split(",\\s*");
            int[] nums = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();
            
            List<List<Integer>> permutations = permute(nums);
            for (List<Integer> perm : permutations) {
                System.out.println(perm);
            }
        } else {
            List<String> result = new ArrayList<>();
            permuteString(input.toCharArray(), 0, input.length() - 1, result);
            Collections.sort(result); // Ensures lexicographical order
            for (String perm : result) {
                System.out.println(perm);
            }
        }
    }
}
