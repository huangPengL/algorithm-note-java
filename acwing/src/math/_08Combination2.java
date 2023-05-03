package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/4/6 17:55
 */
import java.io.*;

/*

    fact[i]表示i!   infact[i]表示i!的逆元
    若计算Cab = a!/b!*(a-b)! = fact[a] * infact[b] * infact[a-b];

    因此，我们可以预处理0~100000的fact和infact。使用的方法为快速幂求逆元

*/
public class _08Combination2 {
    private static final int MOD = 1000000007;

    // 求快速幂模板
    public static int qmi(int a, int k, int p){
        int temp = a;
        int ans = 1;
        while(k != 0){
            if( (k & 1) == 1 ){
                ans = (int)( (long) ans * temp % p );
            }
            temp = (int)( (long) temp * temp  % p );

            k >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 预处理fact和infact
        int[] fact = new int[100001];
        int[] infact = new int[100001];
        fact[0] = infact[0] = 1;
        for(int i=1;i<=100000;i++){
            fact[i] = (int)((long)fact[i-1] * i % MOD);         // 注意这里取模后仍然为long型，需要强转为int
            infact[i] = (int)((long)infact[i-1] * qmi(i, MOD-2, MOD) % MOD);
        }

        // 输出
        while(n != 0){

            String[] ss = br.readLine().split(" ");
            int a = Integer.parseInt(ss[0]);
            int b = Integer.parseInt(ss[1]);
            int ans =  (int)((long)fact[a] * infact[b] % MOD);
            ans = (int)((long)ans * infact[a-b] % MOD);
            System.out.println(ans);
            n--;
        }
    }
}