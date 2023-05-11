class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;

        int low = 0;
        int high = m;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (totalLength + 1) / 2 - partitionX;

            int maxX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
            int maxY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxX <= minY && maxY <= minX) {
                // Found the correct partition
                if (totalLength % 2 == 0) {
                    // Even number of elements
                    return (Math.max(maxX, maxY) + Math.min(minX, minY)) / 2.0;
                } else {
                    // Odd number of elements
                    return Math.max(maxX, maxY);
                }
            } else if (maxX > minY) {
                // Move left in nums1
                high = partitionX - 1;
            } else {
                // Move right in nums1
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Arrays are not sorted!");
    }
}

// Test cases
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.00000

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        System.out.println(solution.findMedianSortedArrays(nums3, nums4)); // Output: 2.50000
    }
}
