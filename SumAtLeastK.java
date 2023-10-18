//issue #113
import java.util.ArrayDeque;

public class ShortestSubarraySumK {
    public static int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        // Calculate the prefix sum
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        int minLen = n + 1;
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i <= n; i++) {
            // Check if the current prefix sum allows us to find a subarray with sum >= k
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                minLen = Math.min(minLen, i - deque.pollFirst());
            }

            // Maintain a non-decreasing deque to efficiently find subarrays
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offerLast(i); // Add the current index to the deque
        }

        return minLen <= n ? minLen : -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1};
        int k1 = 1;
        System.out.println(shortestSubarray(nums1, k1)); // Output: 1

        int[] nums2 = {1, 2};
        int k2 = 4;
        System.out.println(shortestSubarray(nums2, k2)); // Output: -1

        int[] nums3 = {2, -1, 2};
        int k3 = 3;
        System.out.println(shortestSubarray(nums3, k3)); // Output: 3
    }
}


/*Given an integer array nums and an integer k, return the length of the shortest non-empty subarray of nums with a sum of at least k. If there is no such subarray, return -1.

A subarray is a contiguous part of an array.

Example 1:

Input: nums = [1], k = 1
Output: 1

Example 2:

Input: nums = [1,2], k = 4
Output: -1

Example 3:

Input: nums = [2,-1,2], k = 3
Output: 3*/
