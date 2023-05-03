package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/12 13:53
 */
import java.io.*;

public class _03GetSumOfEuler {
    static int N = 1000010;
    static int cnt = 0;
    static boolean[] visited = new boolean[N];
    static int[] primes = new int[N];
    static int[] phi = new int[N];


    // 线性筛法求解1~n的欧拉函数之和
    public static long getSumOfEuler(int n){
        // 1的欧拉函数等于1
        phi[1] = 1;

        for(int i=2;i<=n;i++){
            if(!visited[i]){
                primes[cnt++] = i;
                // 质数p的欧拉函数等于p-1
                phi[i] = i-1;
            }
            for(int j=0;primes[j] <= n/i;j++){
                visited[primes[j]*i] = true;

                // 合数k的欧拉函数使用公式k*((p1-1)/p1)*((p2-1)/p2)...
                if(i % primes[j] == 0){
                    // 如果primes[j]是i的一个质因数，那么i的所有质因数等价于i*primes[j]的所有质因数
                    phi[primes[j] * i] = phi[i] * primes[j];
                    break;
                }

                // 如果primes[j]不是i的一个质因数，那么i*primes[j]的所有质因数比i的所有质因数多一个primes[j]
                phi[primes[j] * i] = phi[i] * (primes[j]-1);
            }
        }

        long ans = 0;
        for(int i=1;i<=n;i++){
            ans += phi[i];
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.println(getSumOfEuler(n));
    }
}