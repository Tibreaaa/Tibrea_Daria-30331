package Lab1;

public class MatrixOperations {
    public static void main(String[] args) {
        int[][] matrix1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] matrix2 = {{8, 5, 3}, {3, 9, 2}, {2, 7, 3}};

        int[][] sum = new int[3][3];
        int[][] product = new int[3][3];

        // Calculate the sum of the two matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sum[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Calculate the product of the two matrices
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = 0;
                for (int k = 0; k < 3; k++) {
                    value += matrix1[i][k] * matrix2[k][j];
                }
                product[i][j] = value;
            }
        }

        // Print the results
        System.out.println("Matrix 1:");
        printMatrix(matrix1);

        System.out.println("Matrix 2:");
        printMatrix(matrix2);

        System.out.println("Sum:");
        printMatrix(sum);

        System.out.println("Product:");
        printMatrix(product);
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}