public class Matrix {
    private int[][] data;
    private int rows;
    private int columns;

    public Matrix(int[][] data) {
        this.data = data;
        this.rows = data.length;
        this.columns = data[0].length;
    }

    public Matrix add(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same.");
        }

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix subtract(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Matrix dimensions must be the same.");
        }

        int[][] result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] - other.data[i][j];
            }
        }

        return new Matrix(result);
    }

    public Matrix multiply(Matrix other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Number of columns in the first matrix must be equal to the number of rows in the second matrix.");
        }

        int[][] result = new int[rows][other.columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                int sum = 0;
                for (int k = 0; k < columns; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result[i][j] = sum;
            }
        }

        return new Matrix(result);
    }

    public void print() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
