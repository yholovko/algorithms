package basic;

import java.util.Arrays;

public class BinarySearch {
    private static String bsNonRecursive(int key, int[] arr){
        int from = 0;
        int to = arr.length-1;
        int iterations = 0;
        
        while (from <= to){
            iterations++;
            int mid = (from+to)/2;
            if (key < arr[mid]){
                to = mid-1;
            }else if (key > arr[mid]){
                from = mid+1;
            }else{
                return String.format("Found. Array size = %d; Iterations = %d", arr.length-1, iterations);
            }
        }
        return String.format("Not found. Array size = %d; Iterations = %d", arr.length-1, iterations);
    }
    
    private static String bsRecursive(int key, int[] arr, int from, int to, int iterations){
        if (from > to) return String.format("Not found. Array size = %d; Iterations = %d", arr.length-1, iterations);
        
        int mid = (from+to)/2;

        if (key < arr[mid]) {
            return bsRecursive(key, arr, from, mid - 1, ++iterations);
        } else if (key > arr[mid]) {
            return bsRecursive(key, arr, mid + 1, to, ++iterations);
        } else {
            return String.format("Found. Array size = %d; Iterations = %d", arr.length-1, ++iterations);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2,5,1,6,4,8,7,14,12,3,17};
        int key = 4;
        Arrays.sort(arr);

        System.out.println(bsNonRecursive(key, arr));
        System.out.println(bsRecursive(key, arr, 0, arr.length-1, 0));
    }
}