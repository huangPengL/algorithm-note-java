package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/10 11:02
 */

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
import java.io.*;

public class _01IsPrime {
    public static boolean isPrime(int n){
        if(n < 2)   return false;
        for(int i=2;i<=n/i;i++){
            if(n % i == 0)  return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- != 0){
            int num = Integer.parseInt(br.readLine());
            if(isPrime(num)){
                System.out.println("Yes");
            }
            else{
                System.out.println("No");
            }
        }
    }
}
