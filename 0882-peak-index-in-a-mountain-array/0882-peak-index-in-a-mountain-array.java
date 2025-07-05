// TC: O(log(n))
// SC: O(1)
class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            
            // if mid -1 and mid+1 is less then mid your at peak
            if (arr[mid] >= arr[mid - 1] && arr[mid] >= arr[mid + 1]) {
                return mid;
            }
       
            // mid > mid -1 you are climmbing to peak, go where slope is incresing or near peak
            if (arr[mid] >= arr[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return -1;
    }
}