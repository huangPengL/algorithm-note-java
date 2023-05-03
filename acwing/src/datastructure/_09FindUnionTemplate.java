package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/28 18:57
 */
import java.io.*;

public class _09FindUnionTemplate {
    private static int[] parent;

    public static void init(int n){
        parent = new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
    }
    public static int find(int num){
        if(parent[num] != num){
            parent[num] = find(parent[num]);
        }
        return parent[num];
    }

    public static void merge(int num1,int num2){
        int root = find(num1);
        int root2 = find(num2);
        if(root!=root2){
            parent[root2] = root;
        }
    }

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ss1 = br.readLine().split(" ");
        int n = Integer.parseInt(ss1[0]);
        int m = Integer.parseInt(ss1[1]);

        init(n);

        StringBuilder ans = new StringBuilder();
        while(m-- != 0){
            String[] ss2 = br.readLine().split(" ");
            char c = ss2[0].charAt(0);
            int num1 = Integer.parseInt(ss2[1]);
            int num2 = Integer.parseInt(ss2[2]);
            if(c == 'M'){
                merge(num1,num2);
            }
            else if(c == 'Q'){
                if(find(num1) == find(num2)){
                    // System.out.println("Yes");
                    ans.append("Yes\n");
                }
                else{
                    // System.out.println("No");
                    ans.append("No\n");
                }
            }
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans.toString());
    }
}
