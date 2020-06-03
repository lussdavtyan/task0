public class Exercise1 {
    public static void main(String[] args) {
        System.out.println(f_buDP(17));
        System.out.println(f_rec(17));
        System.out.println(f_tdDP(17));
    }

    //(a)
    public static int f_rec(int n) {
        if (n == 1)
            return 1;
        return f_rec(n / 2) + f_rec((int) Math.sqrt(n)) + n;
    }

    //(b)
    public static int f_tdDP(int n) {
        int[][] matrix = new int[n][2];
        return func_tDP(n, matrix);
    }

    public static int func_tDP(int n, int[][] matrix) { //in my matrix I'm keeping solutions of f(n/2) and f(sqrt(n))
        if (n == 1) {
            return 1;
        }
        //I'm doing some checks for not computing the same thing again
        if (matrix[n - 1][0] == 0) {
            matrix[n - 1][0] = func_tDP(n / 2, matrix);
            if (matrix[n - 1][1] == 0) {
                matrix[n - 1][1] = func_tDP((int) Math.sqrt(n), matrix);
                return matrix[n - 1][0] + matrix[n - 1][1] + n;
            } else {
                return matrix[n - 1][0] + matrix[n - 1][1] + n;
            }
        } else {
            if (matrix[n - 1][1] == 0) {
                matrix[n - 1][1] = func_tDP((int) Math.sqrt(n), matrix);
            }
            return matrix[n - 1][0] + matrix[n - 1][1] + n;
        }
    }

    //(c)
    public static int f_buDP(int n) {
        int sumArr[] = new int[n + 1];
        sumArr[1] = 1;
        for (int i = 2; i < n + 1; i++) { //iterating from 2 as we already defined what's in the 1st position(base c.)
            sumArr[i] = sumArr[i / 2] + sumArr[(int) Math.sqrt(i)] + i; //using the solutions of previously solved small problems
        }
        return sumArr[n];
    }
}
