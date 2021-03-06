package com.youkeda;

import java.util.Arrays;

public class QuickSort {

  // 快速排序
  public static void quickSort(int[] array) {
    // 调用快速排序的核心，传入left，right
    quickSortCore(array, 0, array.length - 1);
  }

  // 快速排序的核心，同样也是递归函数
  public static void quickSortCore(int[] array, int left, int right) {
    // 递归基准条件，left >= right 即表示数组只有1个或者0个元素。
    if (left >= right) {
      return;
    }
    // 根据轴分区
    int pivotIndex = partition(array, left, right);

    // 递归调用左侧和右侧数组分区
    quickSortCore(array, left, pivotIndex - 1);
    quickSortCore(array, pivotIndex + 1, right);
  }

  // 对数组进行分区，并返回当前轴所在的位置
  public static int partition(int[] array, int left, int right) {
    int pivot = array[right];
    int leftIndex = left;
    int rightIndex = right-1;
    
    while(true){
      
      while(array[leftIndex]<=pivot&&leftIndex<right){
        leftIndex++;
      }
      while(array[rightIndex]>=pivot&&rightIndex>0){
        rightIndex--;
      }
      if(leftIndex>=rightIndex){
        break;
      }else{
        swap(array,leftIndex,rightIndex);
      }
    }
    
    swap(array, leftIndex, right);
    return leftIndex;
  }
  public static void swap(int []array,int left,int right){
    int temp = array[left];
    array[left] = array[right];
    array[right] = temp;
  }
  
  public static void main(String[] args) {
    int[] array = {9, 2, 4, 7, 5, 3};
    // Arrays.toString 可以方便打印数组内容
    System.out.println("raw: " + Arrays.toString(array));
    quickSort(array);
    System.out.println("result: " + Arrays.toString(array));
  }
}
