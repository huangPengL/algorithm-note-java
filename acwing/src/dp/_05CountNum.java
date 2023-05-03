package dp;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/3/3 10:58
 */
import java.util.*;
import java.io.*;

public class _05CountNum {
    /*
        计算1-n中第x出现的次数，先考虑x = 1 ~ 9
        思路：依次计算x在每一位中出现的次数
        以x = 1为例，依次计算x在每一位出现的次数
        现计算1在第4位出现的次数，？把这个数字分割成了[l, i, r]三部分
        123 ？ 3210
        1. ？ > 1 时 前三位可以取0-122， 后四位可以取0-9999，总共123*1e4 种
                  前三位取123时，？处取1时，后四位可以取0-9999，共1额e4种
                  这种情况共 124*1e4种

        2. ？ = 1 时 前三位取0-122时，后四位可以取0-9999，总共123*1e4 种
                  前三位取123时，后四位可以取0-3210，共3211种
                  这种情况共 123*1e4 + 3211

        3. ？ < 1时 如果要想第四位取1，前三位只能取0-122，后四位共有123 * 1e4种

        现考虑特殊情况x = 0， 当前数字为123？3210， 0在？位置出现的次数
        1. 当？ > 0 时，前三位取1-122时，后四位可以取0-9999  （前三位取0时这种情况无效）
                     前三位取123时， 后四位可取0-9999
                     总共123*1e4种

        2. 当？ = 0 时，为了保证这个数字是有效的，前三位取1-123
                     前三位为1-122时，总共122*1e4种
                     前三位取123时，后四位可取0-3210
                     总共122*1e4 + 3211种

    */

    public static int count(int n, int x){
        List<Integer> list = new LinkedList<>();
        while(n != 0){
            list.add(0, n % 10);
            n /= 10;
        }

        int len = list.size();
        int ans = 0;
        for(int i=0;i<len;i++){     // 枚举n的第i位为x时的情况
            if(x != 0){
                if(list.get(i) > x){
                    ans += (getNum(list,0, i-1)+1) * ((int)Math.pow(10, len-i-1));
                }
                else if(list.get(i) == x){
                    ans += (getNum(list,0 ,i-1)) * ((int)Math.pow(10, len-i-1));
                    ans += getNum(list,i+1, len-1)+1;
                }
                else{
                    ans += (getNum(list,0 ,i-1)) * ((int)Math.pow(10, len-i-1));
                }
            }
            else{
                if(list.get(i) > 0){
                    ans += (getNum(list,0, i-1)) * ((int)Math.pow(10, len-i-1));
                }
                else if(list.get(i) == 0){
                    ans += (getNum(list,0 ,i-1)-1) * ((int)Math.pow(10, len-i-1));
                    ans += getNum(list,i+1, len-1)+1;
                }
            }
        }
        return ans;
    }

    // 求在list中第l位到第r位构成的数字
    public static int getNum(List<Integer> list, int l, int r){
        int ans = 0;
        for(int i=l;i<=r;i++){
            ans *= 10;
            ans += list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ss = br.readLine().split(" ");
        int a = Integer.parseInt(ss[0]);
        int b = Integer.parseInt(ss[1]);
        while(a!=0 && b!=0){
            if(a > b){
                int temp = a;
                a = b;
                b = temp;
            }

            // count(n, x) 表示计算1~x数字i出现的次数
            for(int i=0;i<10;i++){
                System.out.print(count(b, i) - count(a-1, i)+" ");    // 前缀和思想
            }
            System.out.println();
            String[] ss2 = br.readLine().split(" ");
            a = Integer.parseInt(ss2[0]);
            b = Integer.parseInt(ss2[1]);
        }
    }
}
