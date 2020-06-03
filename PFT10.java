public class PFT10 {
    public static void main(String[] args) {
        int[] arr = {8, 9, 5, 11, 6, 4, 7, 12, 3};
        //in fact the increasing subsequence is not always unique :) but the length of the longest subsequence(s) is unique!
        int[] longest = findLongest(arr);
        System.out.println("And the longest subsequence(which is not always unique) is:");
        for (int i = 0; i < longest.length; i++) {
            System.out.print(longest[i] + "  ");
        }
    }

    public static int[] findLongest(int[] arr) {
        int n = arr.length;
        int[] arrSeq = new int[n];
        int[] refer = new int[n];

        int size = 0;
        for (int i = 0; i < n; i++) {
            int low = 0;
            int high = size;

            int curr = binarySearch(arr, arrSeq, i, low + 1, high);
            refer[i] = arrSeq[curr - 1];
            arrSeq[curr] = i;
            if (curr > size) {
                size = curr;
            }
        }
        return LongestIncreasingSubsequence(arr, arrSeq, refer, size);
    }
    //I use binary search to see where should be the current element in my new formed subsequence: This takes( O-s(lgn) time)
    public static int binarySearch(int[] arr, int arrSeq[], int i, int low, int high) {
        if (low > high)
            return low; //when no interval, return our low
        else {
            int mid = (low + high) / 2;
            if (arr[i] < arr[arrSeq[mid]])
                return binarySearch(arr, arrSeq, i, low, mid - 1); // search in the left of the middle
            else
                return binarySearch(arr, arrSeq, i, mid + 1, high); // search in the right of the middle
        }
    }

    public static int[] LongestIncreasingSubsequence(int[] arr, int[] arr1, int[] arr2, int size) {
        int[] newArr = new int[size];
        int index = arr1[size];
        for (int i = size - 1; i > -1; i--) {
            newArr[i] = arr[index];
            index = arr2[index];
        }
        return newArr;
    }
}
