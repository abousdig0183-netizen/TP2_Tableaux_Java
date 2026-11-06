
package tp2;

public class MatriceMagique {

    public static boolean estCarreMagique(int[][] m) {

        // Verifier la taille 3x3
        if (m == null || m.length != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (m[i] == null || m[i].length != 3) {
                return false;
            }
        }

        // Somme de reference
        int ref = m[0][0] + m[0][1] + m[0][2];

        // Verifier les lignes
        for (int i = 0; i < 3; i++) {
            int somme = 0;

            for (int j = 0; j < 3; j++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Verifier les colonnes
        for (int j = 0; j < 3; j++) {
            int somme = 0;

            for (int i = 0; i < 3; i++) {
                somme += m[i][j];
            }

            if (somme != ref) {
                return false;
            }
        }

        // Verifier les diagonales
        int diagonale1 = m[0][0] + m[1][1] + m[2][2];
        int diagonale2 = m[0][2] + m[1][1] + m[2][0];

        return diagonale1 == ref && diagonale2 == ref;
    }

    public static void main(String[] args) {

        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };

        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };

        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m4 = {
            {-1, 2, 0},
            {2, 0, -1},
            {0, -1, 2}
        };

        int[][] m5 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 10}
        };

        int[][][] tests = {m1, m2, m3, m4, m5};

        for (int i = 0; i < tests.length; i++) {
            System.out.print("Matrice " + (i + 1) + " : ");

            if (estCarreMagique(tests[i])) {
                System.out.println("Carre magique");
            } else {
                System.out.println("Pas un carre magique");
            }
        }
    }
}
