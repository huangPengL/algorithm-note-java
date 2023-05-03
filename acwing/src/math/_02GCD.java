package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/11 13:58
 */
import java.io.*;

public class _02GCD{
    /*
        【欧几里得算法】：O(logn)
        如果g可以整除a,g可以整除b,那么g就可以整除ax+by
        那么gcd(a,b) = gcd(b,a%b=a-a/b*b)
    */
    public static int gcd(int a,int b){
        return b!=0?gcd(b, a%b):a;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while(n-- !=0 ){
            String[] ss = br.readLine().split(" ");
            int num1 = Integer.parseInt(ss[0]);
            int num2 = Integer.parseInt(ss[1]);

            System.out.println(gcd(num1, num2));
        }
    }
}
