package algorithm.chapter01;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
    /**
     * 二分法查找
     * @param key
     * @param source
     * @return
     */
    public static int rank(int key, int[] source) {
        int low = 0;
        int high = source.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key > source[mid]) {
                low = mid + 1;
            } else if (key < source[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * 遍历查找
     * @param key
     * @param source
     * @return
     */
    public static int noRank(int key, int[] source) {
        for (int i = 0; i < source.length - 1; i++) {
            if (key == source[i]) {
                return key;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] whitelist = new In(args[0]).readAllInts();
        Arrays.sort(whitelist);
        while (!StdIn.isEmpty()) {
            //读取输入的数字,若不在白名单中则打印
            int key = StdIn.readInt();
            if (noRank(key, whitelist) < 0) {
                StdOut.println(key);
            }
        }
    }
}
