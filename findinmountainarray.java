import java.util.Scanner;
public class Main{
    public static int findInMain(int[] mountainArr, int target) {
        int peakIndex = findPeakIndex(mountainArr);
        int leftResult = binarySearchAscending(mountainArr, 0, peakIndex, target);
        if (leftResult != -1) {
            return leftResult;
        }
        return binarySearchDescending(mountainArr, peakIndex, mountainArr.length - 1, target);
    }    
    private static int findPeakIndex(int[] arr) {
        int left = 0;
        int right = arr.length - 1;        
        while (left < right) {
            int mid = left + (right - left) / 2;            
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }        
        return left;
    }    
    private static int binarySearchAscending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }        
        return -1;
    }
    private static int binarySearchDescending(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }        
        return -1;
    }    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] mountainArr = new int[n];
        for (int i = 0; i < n; i++) {
            mountainArr[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        int result = findInMain(mountainArr, target);
        System.out.println(result);        
        scanner.close();
    }
}

