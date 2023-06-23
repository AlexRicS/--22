import java.util.Random;

public class Matrix {
    private int[][] matrix1;
    private int[][] matrix2;

    public Matrix() {
        matrix1 = new int[3][3];
        matrix2 = new int[3][3];
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix1[i][j] = random.nextInt(9) + 1;
                matrix2[i][j] = random.nextInt(9) + 1;
            }
        }
    }

    public int[][] getMatrix1() {
        return matrix1;
    }

    public int[][] getMatrix2() {
        return matrix2;
    }

    public int[][] addMatrices() {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] subtractMatrices() {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    public int[][] transposeMatrix(int matrixChoice) {
        int[][] result = new int[3][3];
        int[][] matrix;
        if (matrixChoice == 1) {
            matrix = matrix1;
        } else {
            matrix = matrix2;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    public int[][] multiplyMatrices() {
        int[][] result = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    public int calculateDeterminant(int[][] matrix) {
        return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix();

        System.out.println("Матрица 1:");
        printMatrix(matrix.getMatrix1());

        System.out.println("Матрица 2:");
        printMatrix(matrix.getMatrix2());

        System.out.println("Сложение матриц:");
        printMatrix(matrix.addMatrices());

        System.out.println("Вычитание матриц:");
        printMatrix(matrix.subtractMatrices());

        System.out.println("Транспонирование Матрицы 1:");
        printMatrix(matrix.transposeMatrix(1));

        System.out.println("Транспонирование Матрицы 2:");
        printMatrix(matrix.transposeMatrix(2));

        System.out.println("Умножение матриц:");
        printMatrix(matrix.multiplyMatrices());

        System.out.println("Определитель Матрицы 1: " + matrix.calculateDeterminant(matrix.getMatrix1()));
        System.out.println("Определитель Матрицы 2: " + matrix.calculateDeterminant(matrix.getMatrix2()));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
