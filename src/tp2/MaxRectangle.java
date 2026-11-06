package tp2;

import java.util.Stack;

public class MaxRectangle {

    static class Rectangle {
        int top, left, bottom, right, area;

        Rectangle(int top, int left, int bottom, int right, int area) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
            this.area = area;
        }
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {

        if (m == null || m.length == 0 || m[0].length == 0) {
            return new Rectangle(-1, -1, -1, -1, 0);
        }

        int rows = m.length;
        int cols = m[0].length;

        int[] heights = new int[cols];

        Rectangle best = new Rectangle(-1, -1, -1, -1, 0);

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                heights[j] = (m[i][j] == 1) ? heights[j] + 1 : 0;
            }

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j <= cols; j++) {

                int current = (j == cols) ? 0 : heights[j];

                while (!stack.isEmpty()
                        && heights[stack.peek()] > current) {

                    int height = heights[stack.pop()];

                    int left = stack.isEmpty() ? 0 : stack.peek() + 1;
                    int right = j - 1;

                    int area = height * (right - left + 1);

                    if (area > best.area) {
                        best = new Rectangle(
                            i - height + 1,
                            left,
                            i,
                            right,
                            area
                        );
                    }
                }

                stack.push(j);
            }
        }

        return best;
    }

    public static void main(String[] args) {

        int[][][] tests = {
            {{0}},
            {{1}},
            {
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}
            },
            {
                {1, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 0, 1, 1}
            },
            {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
            },
            {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
            }
        };

        for (int i = 0; i < tests.length; i++) {

            Rectangle r = trouverMaxRectangle(tests[i]);

            System.out.println("Test " + (i + 1));
            System.out.println("Aire maximale : " + r.area);

            if (r.area > 0) {
                System.out.println("Top : " + r.top);
                System.out.println("Left : " + r.left);
                System.out.println("Bottom : " + r.bottom);
                System.out.println("Right : " + r.right);
            } else {
                System.out.println("Aucun rectangle de 1");
            }

            System.out.println();
        }
    }
}