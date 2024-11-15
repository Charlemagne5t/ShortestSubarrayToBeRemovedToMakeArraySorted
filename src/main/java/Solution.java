class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int max1 = 1;
        int max2 = 1;
        int max3 = Integer.MAX_VALUE;
        int n = arr.length;
        for(int i = 1; i < n; i++) {
            if(arr[i] >= arr[i - 1]){
                max1++;
            }else break;
        }
        int l = max1 - 1;
        max1 = n - max1;

        for(int i = n - 2; i>=0; i--) {
            if(arr[i] <= arr[i + 1]){
                max2++;
            }else break;
        }
        max2 = n - max2;
        if(max1 == 0 || max2 == 0 ) {
            return 0;
        }
        int r = max2;
        for(int i = r; i < n; i++) {
            int index =  bs(arr, l, arr[i]);
            if(index != -1) {
                max3 = Math.min(max3, n - (index + 1 + n - i));
            }
        }

        return Math.min(max1, Math.min(max2, max3));
    }

    int bs(int[] nums, int r, int target) {
        int l = 0;
        int mid;
        int res = -1;

        while(l <= r) {
            mid = l + (r - l) / 2;

            if(nums[mid] <= target) {
                l = mid + 1;
                res = mid;
            }else {
                r = mid - 1; 
            }

        }

        return res;
    } 
}