public class Exercise3 {
    public static void main(String[] args) {
        int arr[] = {-16,3,-2,6,-2,3,-5,-2,6};
        int[] arr1 = maxSubarray(arr);
        System.out.print("The maximum-subarray is  ");
        //printing my subarray
        for(int i = 0; i < arr1.length; i++){
            System.out.print(arr1[i] + "  ");
        }
    }

    public static int[] maxSubarray( int arr[]) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int tempLow = 0;
        int low = 0;
        int high = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (max < sum) {  //here if I write <= instead of < , I can get the largest subarray if there are different subarrays with the same sum.
                max = sum;
                low = tempLow;
                high = i;
            }
            if (sum < 0) {
                sum = 0;
                tempLow = i + 1;
            }
        }
        System.out.println("The first index of the subarray is " + low + " and the last index of the subarray is " + high); //this is not always unique!
        System.out.println("The maximum sum is " + max);
        int myArr[] = new int[high - low+1]; //creating new array which keeps the maximum-subarray.
        for (int i = low, j = 0; i <= high; i++, j++) {
            myArr[j] = arr[i];
        }
        return myArr;
    }
}
