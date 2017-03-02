package algorithm.chapter02;

import java.util.Arrays;

/**
 * 希尔排序
 * @author Charlie
 * @description
 */
public class ShellSort {

    private static int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        int N = arr.length;
        int h = 1;
        while (h < N / 3)
            h = h * 3 + 1;
        while (h >= 1) {
            System.out.println("-----> h = " + h);
            for (int i = h; i < N; i++) {
                System.out.println("-------------------> i = " + i);
                for (int j = i; j >= h; j -= h) {
                    if (arr[j - h] > arr[j]) {
                        int min = arr[j];
                        arr[j] = arr[j - h];
                        arr[j - h] = min;
                        System.out.println(Arrays.toString(arr));
                    }
                }
            }
            h = h / 3;
        }
    }

}
