package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/13 16:50
 */
import java.io.*;

/*
    若b = x1+x2+x3...
    将a^b 分解成 a^x1 * a^x2 * a^x3...
*/
public class _04BinExp {
    public static long binExp(int a,int b,int p){
        long ans = 1;
        long temp = a;
        while(b != 0){
            if((b & 1) == 1){
                ans = ans * temp % p;
            }
            b >>= 1;
            temp = temp * temp % p;
        }

        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            int p = Integer.parseInt(ss[2]);

            System.out.println(binExp(a,b,p));
        }
    }
}
