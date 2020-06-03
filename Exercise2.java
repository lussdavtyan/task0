public class Exercise2 {
    public static void main(String[] args) {
        int[] p = {0, 1, 3, 5, 5, 7, 8, 9, 10};
        theOptimalCuts(p);
    }

    public static int[][] cutTheRod(int[] p) {
        int[][] arrRandS = new int[2][p.length];  //in arrRandS[0][i] are stored the values of array r(you can see this in my PDF file)
                                                  // and in arrRandS[1][i] are stored values of array s(you can see this in my PDF file)
        arrRandS[0][0] = 0;  //i.e. r[0] = 0
        arrRandS[1][0] = 0;  //i.e. s[0] = 0
        for (int i = 1; i < p.length; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                if (max < p[j] + arrRandS[0][i - j]) {
                    max = p[j] + arrRandS[0][i - j];
                    arrRandS[1][i] = j;              //filling my array s[] which keeps the optimal cut indices.
                }
            }
            arrRandS[0][i] = max;  //filling my array r[] which keeps the maximal revenues.
        }
        return arrRandS;
    }

    public static void theOptimalCuts(int[] p) {
        int[][] arr = cutTheRod(p);
        int i = p.length - 1;
        System.out.println("The maximum revenue for length 8 is " + arr[0][8]);
        System.out.print("The sequence of cuts: ");
        while (i > 0) {
            System.out.print(arr[1][i] + "  "); //the optimal cut indices
            i -= arr[1][i];
        }
    }
}
