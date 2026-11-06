package tp2;

public class PermutationCirculaire {

    public static boolean estPermutationCirculaire(int[] t) {

        if (t == null || t.length == 0) {
            return false;
        }

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        int pos = -1;

        for (int i = 0; i < n; i++) {

            int x = t[i];

            if (x < 1 || x > n || vu[x]) {
                return false;
            }

            vu[x] = true;

            if (x == 1) {
                pos = i;
            }
        }

        if (pos == -1) {
            return false;
        }

        for (int k = 0; k < n; k++) {

            int idx = (pos + k) % n;

            if (t[idx] != k + 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] tests = {
            {1},
            {1, 2, 3, 4, 5},
            {2, 3, 4, 5, 1},
            {3, 4, 5, 1, 2},
            {4, 5, 1, 2, 3},
            {5, 1, 2, 3, 4},
            {3, 1, 2, 4, 5},
            {2, 1, 3, 4, 5},
            {0, 1, 2, 3, 4},
            {1, 2, 2, 3, 4},
            {1, 2, 3, 4, 6},
            {}
        };

        for (int[] t : tests) {
            System.out.println(
                estPermutationCirculaire(t)
            );
        }
    }
}