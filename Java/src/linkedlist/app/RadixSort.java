package app;

import java.util.Arrays;

import javafx.scene.Node;
/**
 * 
 * 基数排序： 基于数组实现的基数排序
 * 1.创建10个桶，桶内不能直接放置数据，因为存在多个次位相同的数据，因此放置其位数相同的个数（进行计数）；
 * 2.根据最大数的位数确定需要多少趟；
 * 3.创建一个临时数组，根据计数器的索引存放数据；
 * 4.每次遍历后，将临时数组赋值给原始数组，并清空临时数组；
 */
public class RadixSort {

    public static final int RADIX = 10; // 以10为基数进行排序

    /**
     * 数组实现基数排序 
     * 
     * @param arr      待排序数组
     * @param maxIndex 数组内最大数的位数
     * @param r        基数
     */
    void radixSortByArray(int[] arr, int maxIndex, int r) {
        // 创建一个临时数组
        int[] tempArray = new int[arr.length];
        // 创建一个数组进行计数，统计每位上数出现的次数
        int count[] = new int[r];

        // 根据最大位数进行遍历
        int radix = 1;
        for (int i = 0; i < maxIndex; i++) {

            // 进行计数，看次位有多少个相同的值
            for (int j = 0; j < arr.length; j++) {
                int index = (arr[j] / radix) % r;
                count[index]++;
            }

            // 统计k位及k位之前有多少个数，因为需要把这些数放在临时数组中，避免覆盖数据
            for (int k = 1; k < r; k++) {
                count[k] = count[k - 1] + count[k];
            }

            // 为啥由大到小遍历数组？因为需要从上到下、从左至右串起来
            for (int m = arr.length - 1; m >= 0; m--) {
                int index = (arr[m] / radix) % 10;
                count[index]--; // 先对计数器count[index]减1
                tempArray[count[index]] = arr[m];
            }

            // 将临时数组赋给原始数组
            for (int n = 0; n < arr.length; n++) {
                arr[n] = tempArray[n];
            }
            // 向前移动1位
            radix *= r;
            // 将计数器重置，下一轮重新计算
            Arrays.fill(count, 0);
            System.out.println("第" + (i + 1) + "次： ");
            printArr(arr);
        }
    }


    /**
     * 打印数组
     * @param arr2
     */
    private void printArr(int[] arr2) {
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
    }

    /**
     * 获取数组中最大数的位数
     * 
     * @param arr
     * @return
     */
    private static int getMaxIndex(int[] arr) {
        int index = 1;
        int max = arr[0];
        // 获取最大值
        for (int j = 0; j < arr.length; j++) {
            if (max < arr[j]) {
                max = arr[j];
            }
        }
        // 计算位数
        while (max / 10 > 0) {
            max = max / 10;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        RadixSort rs = new RadixSort();        
        RadixSortByLinkedList rsl = new RadixSortByLinkedList();
        int[] oriArray = new int[] { 22, 425, 3, 12, 2341, 13, 9, 4 };
        // 得到数组中的最大值有多少位
        int maxIndex = getMaxIndex(oriArray);
        // 基于数组进行排序
        rs.radixSortByArray(oriArray, maxIndex, RADIX);
        // 基于链表进行排序
        rsl.radixSortByLinkedList(oriArray, maxIndex, RADIX);
    }
}
