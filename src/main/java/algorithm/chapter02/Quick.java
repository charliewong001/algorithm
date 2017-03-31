package algorithm.chapter02;

/**
 * 快速排序
 * @author Charlie
 * @description
 */
public class Quick {
    private static int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };

    public static void main(String[] args) {
        sort(arr, 0, 5);
    }

    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo)
            return;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j - 1);
        sort(arr, j + 1, hi);
    }

    private static int partition(int[] arr, int lo, int hi) {
        return 0;
    }
}
