package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/11 10:49
 */
import java.util.*;
import java.io.*;
/*
    【求一个数的所有约数】：试除法 O(n * sqrt(num))
    【求多个数字乘积的约数个数】：
        - 假如num可以分解成若干不同的质因数相乘：P1^a1 * P2^a2 * P3^a3 ... （其中ak是质因数出现的次数）
            约数的个数 = (a1+1) * (a2+1) * (a3+1)......
        - [理解1]：求2 * 6 * 8 = 96的约数个数
            2 = 2
            6 = 2 * 3
            8 = 2 * 2 * 2
            所以96的约数个数为  (5 + 1) * (1 + 1) = 12
        - [理解2]：96 = 2^5 * 3^1
            96的每一个约数的取法如下：
                1: 0个2 0个3
                2：1个2 0个3
                4：2个2 0个3
                8：3个2 0个3
                16：4个2 0个3
                32：5个2 0个3
                3: 0个2 1个3
                6：1个2 1个3
                12：2个2 1个3
                24：3个2 1个3
                48：4个2 1个3
                96：5个2 1个3
    【求多个数字乘积的约数之和】：
        - 假如num可以分解成若干不同的质因数相乘：P1^a1 * P2^a2 * P3^a3 ... （其中ak是质因数出现的次数）
            约数之和 = (P1^0 + P1^1 + P1^2...) * (P2^0 + P2^1 + P2^2...) *...* (Pk^0 + Pk^1 + Pk^2...)
        - [理解1]：96 = 2^5 * 3^1
            96的每一个约数的取法如下：
                1: 0个2 0个3
                2：1个2 0个3
                4：2个2 0个3
                8：3个2 0个3
                16：4个2 0个3
                32：5个2 0个3
                3: 0个2 1个3
                6：1个2 1个3
                12：2个2 1个3
                24：3个2 1个3
                48：4个2 1个3
                96：5个2 1个3


 */
public class _02GetDivisors {

    // O(n * sqrt(num))
    public static void getDivisors(int num){
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=num/i;i++){
            if(num % i == 0){
                list.add(i);
                if(i != num / i){
                    list.add(num / i);
                }
            }
        }
        Collections.sort(list);

        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- != 0){
            int num = Integer.parseInt(br.readLine());
            getDivisors(num);
        }
    }
}
