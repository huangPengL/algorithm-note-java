package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/2/1 18:58
 */
import java.util.*;
import java.io.*;


/*
    开放寻址法
*/
public class _11HashOpenFind {
    static int N = 200003;
    static int INF = 0x3f3f3f3f;
    static int[] map;               // map[i]表示哈希表第i个位置存储的元素,如果为INF则表示没有元素


    // 初始化
    public static void initMap(){
        map = new int[N];

        // 给哈希表所有位置初始化为空
        Arrays.fill(map,INF);
    }

    // 哈希函数
    public static int hashFun(int num){
        return (num%N+N)%N;
    }

    // 找一个空位置插入
    public static void insertMap(int num){
        int k = hashFun(num);
        while(map[k] != INF){
            k++;
            if(k == N)  k = 0;
        }
        map[k] = num;
    }

    // 查询
    public static boolean queryMap(int num){
        int k = hashFun(num);
        while(map[k] != INF && map[k] != num){
            k++;
            if(k == N)  k = 0;
        }
        if(map[k] == num)   return true;
        else                return false;
    }


    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        initMap();

        StringBuilder ans = new StringBuilder();
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            char c = ss[0].charAt(0);
            int num = Integer.parseInt(ss[1]);
            if(c == 'I'){
                insertMap(num);
            }
            else if(c == 'Q'){
                if(queryMap(num)){
                    ans.append("Yes\n");
                }
                else{
                    ans.append("No\n");
                }
            }
        }

        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}