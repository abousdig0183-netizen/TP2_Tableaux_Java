package tp2;

public class Kadane {

    public static int maxSubarraySum(int[] t) {

        if (t == null || t.length == 0) {
            throw new IllegalArgumentException("Tableau vide");
        }

        int currentSum = t[0];
        int maxSum = t[0];

        for (int i = 1; i < t.length; i++) {

            currentSum = Math.max(t[i], currentSum + t[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {-2, 1, -3, 4, -1, 2, 1, -5, 4},
            {1, 2, 3, 4},
            {-1, -2, -3},
            {5},
            {-7},
            {-2, -1, 3, 4, -5},
            {1, -1, 1, -1, 1}
        };

        for (int[] t : tests) {
            System.out.println("Somme maximale = " + maxSubarraySum(t));
        }
    }
}