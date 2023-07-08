package platform.sort;

import java.util.Arrays;

/**
 * 归并排序模板
 */
public class MergeSort {


    public static void main(String[] args) {
        int[] nums = {10,9,6,8,2,3,5,4,1};
        new MergeSort().mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        Arrays.stream(nums).forEach(System.out::println);
    }


    public void mergeSort(int[] nums, int left, int right, int[] temp){
        if(left >= right){
            return;
        }
        int mid = (left + right) >>> 1;

        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);

        if(nums[mid] <= nums[mid + 1]){
            return;
        }

        merge2Arr(nums, left, mid, right, temp);
    }


    public static void merge2Arr(int []nums, int left, int mid, int right, int []temp){

        System.arraycopy(nums, left, temp, left, right - left + 1);
        int i = left;
        int j = mid + 1;
        for(int k = left; k <= right; k ++){
            if(i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if(j == right + 1){
                nums[k] = temp[i];
                i++;
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else{
                nums[k] = temp[j];
                j++;
            }
        }
    }
}

