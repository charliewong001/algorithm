package algorithm.chapter02;

import java.util.Arrays;

/**
 * 归并排序
 * 所谓归并是指将若干个已排好序的部分合并成一个有序的部分
 * @author Charlie
 * @description
 */
public class Merge {

    private static int[] arr = new int[] { 5, 4, 3, 2, 1, 0 };
    private static int[] aux = new int[arr.length];

    public static void main(String[] args) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
        FromBottom.sort(arr);

    }

    private static class Original {
        /**
         * 原地归并排序
         * 无法正确完全排序
         * 若是数组两部分分别是有序的，则可以完成排序,例如[5,4,3,2,1,0]可以排序为[0,1,2,3,4,5]
         */
        public static void merge(int[] arr, int lo, int mid, int hi) {
            System.out.println(
                    "进入merge--- lo = " + lo + ",mid=" + mid + ",hi=" + hi);
            int i = lo;
            int j = mid + 1;
            for (int k = lo; k <= hi; k++) {
                aux[k] = arr[k];
            }
            for (int k = lo; k <= hi; k++) {
                if (i > mid) {
                    arr[k] = aux[j++];
                } else if (j > hi) {
                    arr[k] = aux[i++];
                } else {
                    if (aux[j] < aux[i]) {
                        arr[k] = aux[j++];
                    } else {
                        arr[k] = aux[i++];
                    }
                }
                System.out.println("in merge --- " + Arrays.toString(arr));
            }
        }

    }

    /**
     * 自顶向下的归并排序
     * @author Charlie
     * @description
     */
    private static class FromTop {
        public static void sort(int[] arr, int lo, int hi) {
            if (hi <= lo)
                return;
            int mid = lo + (hi - lo) / 2;
            sort(arr, lo, mid);
            sort(arr, mid + 1, hi);
            Original.merge(arr, lo, mid, hi);
        }

        public static void sort(int[] arr) {
            sort(arr, 0, arr.length - 1);
        }
    }

    /**
     * 自底向上的归并排序
     * @author Charlie
     * @description
     */
    private static class FromBottom {
        public static void sort(int[] arr) {
            int N = arr.length;
            for (int sz = 1; sz < N; sz = sz + sz) {
                for (int lo = 0; lo < N - sz; lo += sz + sz) {
                    Original.merge(arr, lo, lo + sz - 1,
                            Math.min(lo + sz + sz - 1, N - 1));
                }
            }
        }
    }
}
