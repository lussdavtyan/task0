public class LongestIncreasingSubsequence {
    public static int binarySearch(int[] arr, int arrSeq[], int i, int low, int high) {
        if (low > high)
            return low; // interval empty; no match
        else {
            int mid = (low + high) / 2;
            if (arr[i] < arr[arrSeq[mid]])
                return binarySearch(arr, arrSeq, i, low, mid - 1); // recur left of the middle
            else
                return binarySearch(arr, arrSeq, i, mid + 1, high); // recur right of the middle
        }
    }

    public static void LIS(int X[])
    {
        int parent[]= new int[X.length]; //Tracking the predecessors/parents of elements of each subsequence.
        int increasingSub[]= new int[X.length + 1]; //Tracking ends of each increasing subsequence.
        int length = 0; //Length of longest subsequence.

        for(int i=0; i<X.length; i++)
        {
//            Binary search
            int low = 1;
            int high = length;
//            while(low <= high)
//            {
//                int mid = ((low + high)/2);
//
//                if(X[increasingSub[mid]] < X[i])
//                    low = mid + 1;
//                else
//                    high = mid - 1;
//            }

            int pos = binarySearch(X, increasingSub, i, low,high);
            //update parent/previous element for LIS
            parent[i] = increasingSub[pos-1];
            //Replace or append
            increasingSub[pos] =  i;

//            Update the length of the longest subsequence.
            if(pos > length)
                length=pos;
        }

        //Generate LIS by traversing parent array
        int LIS[] = new int[length];
        int k 	= increasingSub[length];
        for(int j=length-1; j>=0; j--)
        {
            LIS[j] =  X[k];
            k = parent[k];
        }


        for(int i=0; i<length; i++)
        {
            System.out.println(LIS[i]);
        }


    }

    public static void main(String args[])
    {
        int X[] = {8,9,-4,5,11,6,4,7,12,3}; //3,1,5,0,6,4,9
        LIS(X);
    }
}
