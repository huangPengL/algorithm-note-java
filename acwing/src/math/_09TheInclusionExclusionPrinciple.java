package math;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/5/24 18:31
 */
import java.io.*;

/*
    【容斥原理】：
        1 将1~n中pm的倍数作为一个集合Sm
        2 那么所求的1∼n  中能被 p1,p2,…,pm 中的至少一个数整除的整数有多少个实际上就是容斥原理
        3 集合Sm的个数为n/pm, 集合S1∩S2的个数为n/S1*S2...
*/
public class _09TheInclusionExclusionPrinciple {
    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss = br.readLine().split(" ");
        int n = Integer.parseInt(ss[0]);
        int m = Integer.parseInt(ss[1]);

        int[] prime = new int[m];
        String[] ss1 = br.readLine().split(" ");
        for(int i=0;i<m;i++){
            prime[i] = Integer.parseInt(ss1[i]);
        }


        // 容斥原理O(2^m * O(m))
        long ans = 0;
        int setSize = 1 << m;
        // 枚举每一个集合(素数)选或者不选
        for(int i=1;i<setSize;i++){
            int count = 0;
            long SNum = 1;

            // 查看当前的素数有没有被选中
            for(int j=0;j<m;j++){
                int curNum = i >> j;
                if( (curNum & 1) == 1){
                    count++;
                    SNum *= prime[j];
                    if(SNum > n){       // 如果求解多个素数p的乘积时发现大小超过n，那么就这个情况不会被记录答案
                        SNum = -1;
                        break;
                    }
                }
            }

            if(SNum != -1){
                if(count % 2 == 1){     // +
                    ans += n / SNum;
                }
                else{
                    ans -= n / SNum;
                }
            }
        }
        System.out.println(ans);
    }
}