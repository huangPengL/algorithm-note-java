package math;
/*
结论
假设nn堆石子，石子数目分别是a1,a2,…,ana1,a2,…,an，如果a1⊕a2⊕…⊕an≠0a1⊕a2⊕…⊕an≠0，先手必胜；否则先手必败。

证明
操作到最后时，每堆石子数都是00，0⊕0⊕…0=00⊕0⊕…0=0
在操作过程中，如果 a1⊕a2⊕…⊕an=x≠0a1⊕a2⊕…⊕an=x≠0。那么玩家必然可以通过拿走某一堆若干个石子将异或结果变为0。
证明：不妨设x的二进制表示中最高一位1在第k位，那么在a1,a2,…,ana1,a2,…,an中，必然有一个数aiai，它的第k为时1，且ai⊕x<aiai⊕x<ai，那么从第ii堆石子中拿走(ai−ai⊕x(ai−ai⊕x)个石子，第ii堆石子还剩ai−(ai−ai⊕x)=ai⊕xai−(ai−ai⊕x)=ai⊕x，此时a1⊕a2⊕…⊕ai⊕x⊕…⊕an=x⊕x=0a1⊕a2⊕…⊕ai⊕x⊕…⊕an=x⊕x=0。
在操作过程中，如果 a1⊕a2⊕…⊕an=0a1⊕a2⊕…⊕an=0，那么无论玩家怎么拿，必然会导致最终异或结果不为00。
反证法：假设玩家从第ii堆石子拿走若干个，结果仍是00。不妨设还剩下a′a′个，因为不能不拿，所以0≤a′<ai0≤a′<ai，且a1⊕a2⊕…⊕a′⊕…⊕an=0a1⊕a2⊕…⊕a′⊕…⊕an=0。那么(a1⊕a2⊕…⊕ai⊕…an)⊕(a1⊕a2⊕…⊕a′⊕…⊕an)=ai⊕a′=0(a1⊕a2⊕…⊕ai⊕…an)⊕(a1⊕a2⊕…⊕a′⊕…⊕an)=ai⊕a′=0，则 ai=a′ai=a′，与假设0≤a′<ai0≤a′<ai矛盾。
基于上述三个证明：
1. 如果先手面对的局面是a1⊕a2⊕…⊕an≠0a1⊕a2⊕…⊕an≠0，那么先手总可以通过拿走某一堆若干个石子，将局面变成a1⊕a2⊕…⊕an=0a1⊕a2⊕…⊕an=0。如此重复，最后一定是后手面临最终没有石子可拿的状态。先手必胜。
2. 如果先手面对的局面是a1⊕a2⊕…⊕an=0a1⊕a2⊕…⊕an=0，那么无论先手怎么拿，都会将局面变成a1⊕a2⊕…⊕an≠0a1⊕a2⊕…⊕an≠0，那么后手总可以通过拿走某一堆若干个石子，将局面变成a1⊕a2⊕…⊕an=0a1⊕a2⊕…⊕an=0。如此重复，最后一定是先手面临最终没有石子可拿的状态。先手必败。

*/

import java.io.*;

public class _10NimGame {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        String[] ss = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            ans ^= Integer.parseInt(ss[i]);
        }

        if(ans == 0)    System.out.println("No");
        else    System.out.println("Yes");
    }
}
