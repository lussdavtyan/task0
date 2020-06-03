// Java program to find length of longest increasing subsequence
// in O(n Log n) time
import java.io.*;
import java.util.*;
import java.lang.Math;

class LIS {
    // Binary search (note boundaries in the caller)
    // A[] is ceilIndex in the caller
    static int CeilIndex(int A[], int l, int r, int key)
    {
        while (r - l > 1) {
            int m = l + (r - l) / 2;
            if (A[m] >= key)
                r = m;
            else
                l = m;
        }

        return r;
    }

    static int LongestIncreasingSubsequenceLength(int A[], int size)
    {
        // Add boundary case, when array size is one

        int[] tailTable = new int[size];
        int len; // always points empty slot
        git change = 5;
        tailTable[0] = A[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (A[i] < tailTable[0])
                // new smallest value
                tailTable[0] = A[i];

            else if (A[i] > tailTable[len - 1])
                // A[i] wants to extend largest subsequence
                tailTable[len++] = A[i];

            else
                // A[i] wants to be current end candidate of an existing
                // subsequence. It will replace ceil value in tailTable
                tailTable[CeilIndex(tailTable, -1, len - 1, A[i])] = A[i];
        }

        return len;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int[] arr = new int[8];
        int n = A.length;
        System.out.println("Length of Longest Increasing Subsequence is " + LongestIncreasingSubsequenceLength(A, n));
        System.out.println(LCS(new int[]{0, 5, 7, -1, 3, 6, 7, 4}, new int[]{5, 3, 0, -1, 6, 4, -7, 9}, 8,8, arr, 8));
    }

    public static int LCS(int[] X, int[] Y, int m, int n, int[] results, int i) {
        if (m == 0 || n == 0)
            return 0;
        if (X[m - 1] == Y[n - 1]) {
            results[--i] = X[m - 1];
            return LCS(X, Y, m - 1, n - 1, results, i) + 1;
        }
        int v1 = LCS(X, Y, m, n - 1, results, i);
        int v2 = LCS(X, Y, m - 1, n, results, i);
        return Integer.max(v1, v2);
    }
}
/* This code is contributed by Devesh Agrawal*/
