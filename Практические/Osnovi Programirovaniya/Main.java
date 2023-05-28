public class Main {
    public static void main(String[] args) {
        int[][] data1 = {{3, 2, 3}, {4, 2, 1}};
        int[][] data2 = {{4, 1, 9}, {14, 1, 13}};
        
        Matrix matrix1 = new Matrix(data1);
        Matrix matrix2 = new Matrix(data2);
        
        Matrix sum = matrix1.add(matrix2);
        System.out.println("Сумма матриц:");
        sum.print();
        
        Matrix difference = matrix1.subtract(matrix2);
        System.out.println("Разность матриц:");
        difference.print();
        
        Matrix product = matrix1.multiply(matrix2);
        System.out.println("Произведение матриц:");
        product.print();
    }
}
