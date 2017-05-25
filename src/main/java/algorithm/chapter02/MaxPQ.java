package algorithm.chapter02;

import java.util.Arrays;

/**
 * 优先队列
 * 二叉堆
 * @author Charlie
 * @description
 */
public class MaxPQ {

    private int[] pq;
    private int N;//存储于pq[1..N]中，pq[0]不使用

    public MaxPQ(int maxN) {
        pq = new int[maxN];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(int v) {
        pq[++N] = v;
        swim(N);
    }

    public int delMax() {
        int max = pq[1];//从根节点获取最大元素
        exch(1, N--);//将其和最后一个节点交换
        pq[N + 1] = -1;//防止越界
        sink(1);//恢复堆的有序性
        return max;
    }

    private boolean less(int i, int j) {
        return pq[i] < pq[j];
    }

    private void exch(int i, int j) {
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k < N) {
            int j = 2 * k;
            if (less(j, k)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    private static int[] arr = new int[] { 6, 1, 5, 7, 2, 4, 3 };

    public static void main(String[] args) {
        MaxPQ m = new MaxPQ(8);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("insert:" + arr[i]);
            m.insert(arr[i]);
            System.out.println(Arrays.toString(m.pq));
        }
    }

}
