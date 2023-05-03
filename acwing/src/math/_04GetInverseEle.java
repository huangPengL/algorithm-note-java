package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/13 17:08
 */
import java.io.*;

/*
    【乘法逆元的定义】：
        a存在乘法逆元的充要条件是 a与模数 m 互质。当模数 m 为质数时，a^m−2 即为 a 的乘法逆元。
*/
public class _04GetInverseEle {
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
            int p = Integer.parseInt(ss[1]);

            // 由于数据保证了p是个质数，所以若a跟p不互质 有a % p == 0
            if(a % p == 0){
                System.out.println("impossible");
            }
            else{
                System.out.println(binExp(a, p-2, p));
            }
        }
    }
}
