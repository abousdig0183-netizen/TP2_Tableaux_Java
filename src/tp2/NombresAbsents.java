
package tp2;

public class NombresAbsents {

    public static void afficherElementsManquants(int[] t) {

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        // Marquer les nombres presents
        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        // Afficher les nombres absents
        boolean absent = false;

        for (int i = 1; i <= n; i++) {
            if (!vu[i]) {
                System.out.print(i + " ");
                absent = true;
            }
        }

        if (!absent) {
            System.out.print("Aucun element manquant");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[][] tests = {
            {1, 3, 3, 5},
            {1, 2, 3, 4},
            {3, 3, 3},
            {1, 1, 1, 1},
            {4, 2, 2, 1, 5},
            {1},
            {1, 2, 3, 6}
        };

        for (int i = 0; i < tests.length; i++) {
            System.out.print("Test " + (i + 1) + " : ");
            afficherElementsManquants(tests[i]);
        }
    }
}
