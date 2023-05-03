package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/5/17 16:31
 */
import java.io.*;

/*
枚举每一列c，
    找到当前列绝对值最大的一行
    用初等行变换(2) 把这一行换到最上面（未确定阶梯型的行，并不是第一行）
    用初等行变换(1) 将该行的第一个数变成 1 （其余所有的数字依次跟着变化）
    用初等行变换(3) 将下面所有行的当且列的值变成 0
*/

// java中的Math.abs()可以用于浮点数取绝对值
// String.format("%.2f",x)  %.2f"为保留两位小数，x为要输出的数字
// 判断浮点数是否为0可以判断其是否小于1e-6
public class _07GaussElimination {
    public static double eps = 0.000001;;

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[][] matrix = new double[n][n+1];
        for(int i=0;i<n;i++){
            String[] ss = br.readLine().split(" ");
            for(int j=0;j<n+1;j++){
                matrix[i][j] = Double.parseDouble(ss[j]);
            }
        }

        int ans = gauss(matrix);
        if(ans > 0){
            for(int i=0;i<n;i++){
                if(Math.abs(matrix[i][n]) < eps)  matrix[i][n] = 0.0;
                System.out.println(String.format("%.2f", matrix[i][n]));
            }
        }
        else if(ans == 0){
            System.out.println("Infinite group solutions");
        }
        else
        {
            System.out.println("No solution");
        }
    }

    public static int gauss(double[][] matrix){
        int n = matrix.length;

        // 1 枚举每一列
        int row = 0;
        for(int j=0;j<n;j++){
            // 2 找到当前列绝对值最大的一行
            int curMaxRow = row;
            for(int i=curMaxRow;i<n;i++){
                if(Math.abs(matrix[i][j]) > Math.abs(matrix[curMaxRow][j])){
                    curMaxRow = i;
                }
            }

            // 若找出来的当前列的绝对值最大的一行为0，那么继续寻找下一列
            if(Math.abs(matrix[curMaxRow][j]) < eps){
                continue;
            }

            // 3 用初等行变换(2) 把这一行换到最上面（未确定阶梯型的行，并不是第一行）
            for(int k=j;k<n+1;k++){
                double temp = matrix[row][k];
                matrix[row][k] = matrix[curMaxRow][k];
                matrix[curMaxRow][k] = temp;
            }

            // 4 用初等行变换(1) 将该行的第一个数变成 1 （其余所有的数字依次跟着变化）
            for(int k=n;k>=j;k--){
                matrix[row][k] = matrix[row][k] / matrix[row][j];
            }

            // 5 用初等行变换(3) 将下面所有行的当前列的值变成 0
            for(int i=row+1;i<n;i++){
                if(Math.abs(matrix[i][j])>eps) {
                    for(int k=n;k>=j;k--){
                        matrix[i][k] = matrix[i][k] - matrix[row][k]*matrix[i][j];
                    }
                }
            }
            row++;
        }

        if(row < n){
            // 无解
            for(int i=row;i<n;i++){
                if(Math.abs(matrix[i][n]) > eps)
                    return -1;
            }
            // 无穷多解
            return 0;
        }

        // 唯一解
        else{
            // 消元
            for(int i=n-1;i>=0;i--){
                for(int x=i-1;x>=0;x--){
                    matrix[x][n] = matrix[x][n] - matrix[i][n]*matrix[x][i];
                }
            }
        }
        return 1;
    }
}