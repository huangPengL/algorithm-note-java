package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/10 12:16
 */
import java.io.*;

/*
    【质数的定义】： 对于大于1的自然数，满足只包含1和其本身这两个数就叫做质数
    【质数的判定】：试除法 O(n^(1/2))
    【分解质因数】：试除法 O(n^(1/2))
    【筛选质数】：
        [埃式筛法]
            1 朴素筛法（去除所有数字的倍数）： O(nlogn)
            2 优化筛法（去除所有质数的倍数）： O(n) （1-n中质数的个数为n/lnn）
        [线性筛法]
            每一个合数仅仅被最小的质数筛掉，保证是线性的O(n)
 */
public class _01GetPrimeLinear {

    static int cnt = 0;
    static int[] primes = new int[1000010];
    static boolean[] visited = new boolean[1000010];

    /*
        [埃式筛法]
            朴素筛法（去除所有数字的倍数）： O(nlogn)
            优化筛法（去除所有质数的倍数）： O(n) （1-n中质数的个数为n/lnn）
        [线性筛法]
            每一个合数仅仅被最小的质数筛掉，保证是线性的O(n)
    */
    public static void getPrimes(int n){
        for(int i=2;i<=n;i++){
            if(!visited[i]){
                primes[cnt++] = i;
            }
            for(int j=0;primes[j] <= n/i;j++){
                visited[primes[j] * i] = true;
                if(i % primes[j] == 0)  break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        getPrimes(n);   // 晒选出1~n以内的所有质数

        System.out.println(cnt);
    }
}