package algorithm;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/20 20:41
 */
import java.util.*;
import java.io.*;

/**
    【801. 二进制中1的个数】
    位运算的两个基本操作
    1 判断第k位数字是否为1   n>>k&1
    2 返回最后一位1
    获取x最后一位1的位数k(右边最后一位为0位),返回2^k
    lowbit(x){
        return x&(-x)
    }
 **/

public class _07BitOperateNumOfOneInBinary {
    public static void main(String[] args) throws IOException{
        // 输入
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int[] arr = new int[n+10];
        for(int i=0;i<n;i++)   arr[i] = in.nextInt();

        for(int i=0;i<n;i++){
            int count = 0;
            // 方法一：
            //  for(int k=0;k<=31;k++){
            //      count += (arr[i] >> k) & 1;
            //  }

            // 方法二
            int x = arr[i];
            while(x != 0){
                x -= lowbit(x);         // 减去最后一位1（101010000减去后变为101000000）
                count++;
            }

            System.out.print(count+" ");
        }
    }
    public static int lowbit(int x){
        return x&(-x);
    }
}
