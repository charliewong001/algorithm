package algorithm.chapter02;

import java.util.Arrays;

/**
 * 选择排序
 * 选出数组中最小的元素与数组中第一个元素交换
 * @author Charlie
 * @description
 */
public class SelectionSort {

    private static int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };

    public static void main(String[] args) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int change = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < temp) {
                    change = j;
                    temp = arr[j];
                }
            }
            arr[change] = arr[i];
            arr[i] = temp;
            System.out.println(Arrays.toString(arr));

        }
    }
}
