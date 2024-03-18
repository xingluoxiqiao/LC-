package another;

import java.util.Random;

public class Sort {
    // 冒泡排序
    public static void bubbleSort(int[] array) {
        int n = array.length;
        // 外层循环控制比较轮数
        for (int i = 0; i < n - 1; i++) {
            // 内层循环控制每一轮比较的次数
            for (int j = 0; j < n - 1 - i; j++) {
                // 如果前面的元素大于后面的元素，交换它们
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }


    // 选择排序
    public static void selectionSort(int[] array) {
        int n = array.length;
        // 外层循环控制当前位置
        for (int i = 0; i < n - 1; i++) {
            // 假设当前位置是最小的
            int minIndex = i;
            // 内层循环从未排序的部分中找到最小元素的索引
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            // 将找到的最小元素与当前位置交换
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }


    // 插入排序
    public static void insertionSort(int[] array) {
        int n = array.length;
        // 外层循环控制未排序部分的当前位置
        for (int i = 1; i < n; i++) {
            // 保存当前要插入的值
            int key = array[i];
            int j = i - 1;
            // 内层循环在已排序部分找到合适的位置插入当前值
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            // 插入当前值到正确的位置
            array[j + 1] = key;
        }
    }


    // 快速排序
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 获取划分位置，并对划分位置左右两部分进行递归排序
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }
    // 划分函数，返回划分位置
    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // 交换元素
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        // 将pivot放到正确的位置
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }

    // 归并排序
    public static void mergeSort(int[] array, int low, int high) {
        if (low < high) {
            // 计算中间位置
            int mid = (low + high) / 2;
            // 对左右两部分进行递归排序
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            // 合并两部分
            merge(array, low, mid, high);
        }
    }
    // 合并函数
    public static void merge(int[] array, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        // 创建临时数组
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        // 复制数据到临时数组 leftArray[] 和 rightArray[]
        for (int i = 0; i < n1; ++i) {
            leftArray[i] = array[low + i];
        }
        for (int j = 0; j < n2; ++j) {
            rightArray[j] = array[mid + 1 + j];
        }
        // 合并临时数组到原数组 array[]
        int i = 0, j = 0, k = low;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // 将剩余元素复制到 array[]
        while (i < n1) {
            array[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }


    // 希尔排序
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i]; int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        //测试排序算法消耗时间
        int[] test=new int[200000];
        Random r=new Random();
        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100000);
        }
        long startTime, endTime;
        startTime = System.currentTimeMillis();
        shellSort(test);
        endTime = System.currentTimeMillis();
        System.out.println("希尔排序消耗时间：" + (endTime - startTime) + "ms");

        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100000);
        }
        startTime = System.currentTimeMillis();
        selectionSort(test);
        endTime = System.currentTimeMillis();
        System.out.println("选择排序消耗时间：" + (endTime - startTime) + "ms");

        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100000);
        }
        startTime = System.currentTimeMillis();
        bubbleSort(test);
        endTime = System.currentTimeMillis();
        System.out.println("冒泡排序消耗时间：" + (endTime - startTime) + "ms");


        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100000);
        }
        startTime = System.currentTimeMillis();
        mergeSort(test, 0, test.length - 1);
        endTime = System.currentTimeMillis();
        System.out.println("归并排序消耗时间：" + (endTime - startTime) + "ms");

        for (int i = 0; i < test.length; i++) {
            test[i] = r.nextInt(100000);
        }
        startTime = System.currentTimeMillis();
        insertionSort(test);
        endTime = System.currentTimeMillis();
        System.out.println("插入排序消耗时间：" + (endTime - startTime) + "ms");


        for (int i = 0; i < test.length; i++) {
            test[i]=r.nextInt(100000);
        }
        startTime=System.currentTimeMillis();
        quickSort(test,0,test.length-1);
        endTime=System.currentTimeMillis();
        System.out.println("快速排序消耗时间："+(endTime-startTime)+"ms");
    }

}
