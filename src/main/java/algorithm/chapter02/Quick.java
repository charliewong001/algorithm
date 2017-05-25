package algorithm.chapter02;

import java.util.Arrays;

/**
 * 快速排序
 * @author Charlie
 * @description
 */
public class Quick {
    private static int[] arr = new int[] { 3, 2, 5, 4, 1, 0, 0 };

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, 6);
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    public static int partition(int[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int temp = arr[lo];
        while (true) {
            while (less(arr[++i], temp)) {
                //                if (i == hi) {
                //                    break;
                //                }
            }
            while (less(temp, arr[--j])) {
                //不用判断这种情况下的数组越界，因为temp=arr[lo],若j==lo,则arr[j]==arr[lo]
                //而根据less的逻辑,arr[lo]永远都不小于他自己,所以while循环不成立，循环退出,上边的循环同理
                //                if (j == lo) {
                //                    break;
                //                }
            }
            if (i >= j) {
                break;
            }
            exch(arr, i, j);
            System.out.println("inner--" + Arrays.toString(arr));
        }
        exch(arr, lo, j);
        System.out.println("outer--" + Arrays.toString(arr));
        return j;
    }

    /**
     * 
     * @param i
     * @param j
     * @return true if i<=j,false if i>j
     */
    public static boolean less(int i, int j) {
        return i < j;
    }

    /**
     * 交换元素
     */
    public static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
