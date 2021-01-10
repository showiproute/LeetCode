import java.util.Scanner;

public class yuewen04 {

    public static void rotate(int[][] matrix) {
        int length = matrix.length;
        for (int i = 0; i < length / 2; i++) {
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j - 1][i];
                matrix[length - j - 1][i] = matrix[length - i - 1][length - j - 1];
                matrix[length - i - 1][length - j - 1] = matrix[j][length - i - 1];
                matrix[j][length - i - 1] = temp;
            }
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(i==matrix.length-1 && j==matrix[0].length-1){
                    sb.append(matrix[i][j]);
                }else{
                    sb.append(matrix[i][j]).append(",");
                }
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            sc.nextLine();
            int[][] matrix = new int[n][n];
            for(int i = 0;i<n;i++){
                String[] split = sc.nextLine().split(",");
                for(int j= 0;j<split.length;j++){
                    int value = Integer.parseInt(split[j]);
                    matrix[i][j] = value;
                }
            }
            rotate(matrix);
        }


    }
}

