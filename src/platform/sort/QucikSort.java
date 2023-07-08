package platform.sort;

import java.util.Arrays;

public class QucikSort {

    public static void main(String[] args) {
        int[] nums = {10,9,6,8,2,3,5,4,1};
        new QucikSort().quickSort(nums, 0, nums.length - 1);
        Arrays.stream(nums).forEach(System.out::println);
    }


    private void quickSort(int[] nums, int left, int right){

        if(left < right){
            int pIndex = partition(nums, left, right);
            quickSort(nums, left, pIndex - 1);
            quickSort(nums, pIndex + 1, right);
        }
    }

    private int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        int lt = left;
        // 循环不变量：
        // all in [left + 1, lt] < pivot
        // all in [lt + 1, i) >= pivot
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                lt++;
                swap(nums, i, lt);
            }
        }
        swap(nums, left, lt);
        return lt;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
