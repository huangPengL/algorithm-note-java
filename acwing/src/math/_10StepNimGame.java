package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/6/4 15:55
 */
/*
此时我们需要将奇数台阶看做一个经典的Nim游戏，如果先手时奇数台阶上的值的异或值为0，则先手必败，反之必胜

证明：
先手时，如果奇数台阶异或非0，根据经典Nim游戏，先手总有一种方式使奇数台阶异或为0，于是先手留了奇数台阶异或为0的状态给后手
于是轮到后手：
①当后手移动偶数台阶上的石子时，先手只需将对手移动的石子继续移到下一个台阶，这样奇数台阶的石子相当于没变，于是留给后手的又是奇数台阶异或为0的状态
②当后手移动奇数台阶上的石子时，留给先手的奇数台阶异或非0，根据经典Nim游戏，先手总能找出一种方案使奇数台阶异或为0
因此无论后手如何移动，先手总能通过操作把奇数异或为0的情况留给后手，当奇数台阶全为0时，只留下偶数台阶上有石子。
（核心就是：先手总是把奇数台阶异或为0的状态留给对面，即总是将必败态交给对面）

因为偶数台阶上的石子要想移动到地面，必然需要经过偶数次移动，又因为奇数台阶全0的情况是留给后手的，因此先手总是可以将石子移动到地面，当将最后一个（堆）石子移动到地面时，后手无法操作，即后手失败。

因此如果先手时奇数台阶上的值的异或值为非0，则先手必胜，反之必败！

*/

import java.io.*;

public class _10StepNimGame {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        String[] ss = br.readLine().split(" ");
        for(int i=1;i<=n;i++){
            if((i & 1) == 1)
                ans ^= Integer.parseInt(ss[i-1]);
        }

        if(ans == 0)    System.out.println("No");
        else    System.out.println("Yes");
    }
}
