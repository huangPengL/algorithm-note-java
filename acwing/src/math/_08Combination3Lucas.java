package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/5/22 10:57
 */
import java.io.*;

public class _08Combination3Lucas {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");

            long a = Long.parseLong(ss[0]);
            long b = Long.parseLong(ss[1]);
            long p = Long.parseLong(ss[2]);

            System.out.println(lucas(a, b, p));
        }
    }


    // 卢卡斯定理
    public static long lucas(long a, long b, long p){

        if(a < p && b < p){
            return C(a, b, p);
        }
        return C(a%p, b%p, p) * lucas(a/p, b/p, p) % p;
    }

    // 从定义出发求组合数O(10^5 * log10^5)
    public static long C(long a, long b, long p){
        long res = 1;
        for(long i=1,j=a;i<=b;i++,j--){
            res = res * j % p;
            res = res * qmi(i, p-2, p) % p;
        }
        return res;
    }
    public static long qmi(long a,long b,long p){
        long res = 1;
        long temp = a;
        while(b != 0){
            if((b & 1) == 1){
                res = res * temp % p;
            }

            temp = temp * temp % p;
            b >>= 1;
        }
        return res;
    }
}
