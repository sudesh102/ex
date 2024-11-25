import java.util.Scanner;

public class Matrix {
    public static void setMatrix(int[][] mat, Scanner sc) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
    }

    public static void getMatrix(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void Add(int[][] mat1, int[][] mat2, int[][] mat) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                mat[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
    }

    public static void Sub(int[][] mat1, int[][] mat2, int[][] mat) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                mat[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
    }

    public static void Mul(int[][] mat1, int[][] mat2, int[][] mat) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat2[0].length; j++) {
                mat[i][j] = 0; // Initialize result matrix element to 0
                for (int k = 0; k < mat2.length; k++) {
                    mat[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
    }

    public static void Div(int[][] mat1, int[][] mat2, int[][] mat) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                if (mat2[i][j] != 0) {
                    mat[i][j] = mat1[i][j] / mat2[i][j];
                } else {
                    System.out.println("Division by zero detected at (" + i + "," + j + "). Setting result to 0.");
                    mat[i][j] = 0;
                }
            }
        }
    }

    public static void scalarMul(int[][] mat1, int scalar, int[][] result) {
        for (int i = 0; i < mat1.length; i++) {
            for (int j = 0; j < mat1[i].length; j++) {
                result[i][j] = mat1[i][j] * scalar;
            }
        }
    }

    public static void transpose(int[][] mat, int[][] result) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                result[j][i] = mat[i][j];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the matrix: ");
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] mat1 = new int[row][col];
        int[][] mat2 = new int[row][col];
        int[][] mat = new int[row][col];
        int[][] result = new int[col][row]; // For transpose

        System.out.println("Enter elements of matrix 1:");
        setMatrix(mat1, sc);
        System.out.println("The first matrix is:");
        getMatrix(mat1);

        System.out.println("Enter elements of matrix 2:");
        setMatrix(mat2, sc);
        System.out.println("The second matrix is:");
        getMatrix(mat2);

        while (true) {
            System.out.println("Enter your choice:");
            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Scalar Multiplication\n6. Transpose\n7. Exit");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("The Addition of matrices is:");
                    Add(mat1, mat2, mat);
                    getMatrix(mat);
                    break;
                case 2:
                    System.out.println("The Subtraction of matrices is:");
                    Sub(mat1, mat2, mat);
                    getMatrix(mat);
                    break;
                case 3:
                    System.out.println("The Multiplication of matrices is:");
                    Mul(mat1, mat2, mat);
                    getMatrix(mat);
                    break;
                case 4:
                    System.out.println("The Division of matrices is:");
                    Div(mat1, mat2, mat);
                    getMatrix(mat);
                    break;
                case 5:
                    System.out.println("Enter scalar value:");
                    int scalar = sc.nextInt();
                    scalarMul(mat1, scalar, mat);
                    System.out.println("The Scalar Multiplication result is:");
                    getMatrix(mat);
                    break;
                case 6:
                    System.out.println("The Transpose of the first matrix is:");
                    transpose(mat1, result);
                    getMatrix(result);
                    break;
                case 7:
                    System.exit(0);
                default:
                    System.out.println("Enter a valid choice.");
            }
        }
    }
}
