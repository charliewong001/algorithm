package algorithm.chapter02;

import java.util.Arrays;

/**
 * 插入排序
 * 
 * @author Charlie
 * @description
 */
public class InsertionSort {

    private static int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };

    public static void main(String[] args) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}
