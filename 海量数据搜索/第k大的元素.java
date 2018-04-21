import java.util.*;
class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        // 用一个小根堆来盛放最大的k个数
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        // 记录第k大的元素
        int kNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (minHeap.size() < k) {
                minHeap.offer(nums[i]);
            } else if (minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }
        Integer[] kNums = new Integer[k];
        minHeap.toArray(kNums);
        return kNums[0];
    }
};