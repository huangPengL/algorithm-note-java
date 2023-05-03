package algorithm;
/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/20 19:56
 */

/*
800.数组元素的目标和
 */
import java.util.*;
public class _06TwoPointTheTargetSum {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int x = in.nextInt();

        int[] A = new int[n+10];
        int[] B = new int[m+10];
        for(int i=0;i<n;i++)    A[i] = in.nextInt();
        for(int j=0;j<m;j++)    B[j] = in.nextInt();

        // 双指针处理
        for(int i=0,j=m-1;i<n;i++){
            while(j>=0 && A[i] + B[j] > x){
                j--;
            }

            if(A[i] + B[j] == x){
                System.out.println(i+" "+j);
                break;
            }
        }
    }
}
