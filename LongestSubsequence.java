//Other details and explanations are written in my PDF file.
public class LongestSubsequence {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 5, 11, 6, 4, 7, 12, 3};
        //in fact the increasing subsequence is not always unique :) but the length of the longest subsequence(s) is unique!
        int[] longest = longestSubsequenceLength(arr);
        System.out.println("And the longest subsequence(which is not always unique) is:");
        for (int i = 0; i < longest.length; i++) {
            System.out.print(longest[i] + "  ");
        }
    }

    public static int[] longestSubsequenceLength(int[] arr) {
        int[] arrOfLengths = new int[arr.length];
        int[] prevIndices = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arrOfLengths[i] = 1;
            //filling the array with 1s, which shows the least possible length of a subsequence ending in ith position
        }
        for (int i = 1; i < arr.length; i++) {
            int max = Integer.MIN_VALUE;
            int temp = 0;
            for (int j = 0; j <= i; j++) {
                if (arr[j] < arr[i]) {
                    temp = arrOfLengths[j] + arrOfLengths[i]; //using the solutions of the previous problems, to solve this problem
                    //in this case
                    if (temp >= max) {
                        max = temp;
                        prevIndices[i] = j;
                    }
                }
            }
            if(max == Integer.MIN_VALUE) {
                arrOfLengths[i] = 1;
            } else{
                arrOfLengths[i] = max;
            }
        }
        int maxLength = 0;
        int maxIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arrOfLengths[i] > maxLength) {
                maxLength = arrOfLengths[i];
                maxIndex = i;
            }
        }
        System.out.println("The length of the longest increasing subsequence is " + maxLength);
        int[] longest = new int[maxLength];
        int i = maxIndex;
        while (maxIndex >= 0 && maxLength - 1 >= 0) {
            longest[maxLength - 1] = arr[i];
            i = prevIndices[i];
            maxLength--;
        }
        return longest;
    }

}

