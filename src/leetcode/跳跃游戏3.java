package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 跳跃游戏3 {


    public static void main(String[] args) {
        int[] arr = {58, 48, 64, 36, 19, 19, 67, 13, 32, 2, 59, 50, 29, 68, 50, 0, 69, 31, 54, 20, 22, 43, 30, 9, 68, 71, 20, 22, 48, 74, 2, 65, 27, 54, 30, 5, 66, 24, 64, 68, 9, 31, 50, 59, 15, 72, 6, 49, 11, 71, 12, 61, 5, 66, 30, 1, 2, 39, 59, 35, 53, 21, 76, 17, 71, 40, 68, 57, 64, 53, 70, 21, 50, 49, 25, 63, 35};
        int start = 46;
        System.out.println(new 跳跃游戏3().canReach(arr, start));
    }

    public boolean canReach(int[] arr, int start) {

        if (arr[start] == 0) {
            return true;
        }

        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            int index = stack.pop();

            int left = index - arr[index];
            if (left >= 0 && left < arr.length && !visited.contains(left)) {
                if (arr[left] == 0) {
                    return true;
                }
                stack.push(left);
                visited.add(left);
            }

            int right = index + arr[index];
            if (right >= 0 && right < arr.length && !visited.contains(right)) {
                if (arr[right] == 0) {
                    return true;
                }
                stack.push(right);
                visited.add(right);
            }
        }
        return false;
    }
}
