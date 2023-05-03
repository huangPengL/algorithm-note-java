package datastructure;

/**
 * @Author: HPL
 * @Description: Input description of class in here
 * @Date: 2022/1/27 10:44
 */
import java.io.*;

class TrieNode{
    TrieNode[] children;    //若为children[i]为null，表示没有这个字符（i为ASCII码）
    int count;

    public TrieNode(){
        children = new TrieNode[26];
        count = 0;
    }
}
class Trie {
    //根节点
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i)-'a';     //将字符转化为数字，a-0,b-1,c-2......
            //若当前字符并没有创建，则创建
            if(curNode.children[index] == null){
                curNode.children[index] = new TrieNode();
            }
            curNode = curNode.children[index];
        }
        //记录这个单词的个数
        curNode.count++;
    }

    /** Returns if the word is in the trie. */
    public int search(String word) {
        TrieNode curNode = root;
        for(int i=0;i<word.length();i++){
            int index = word.charAt(i) - 'a';
            if(curNode.children[index] == null){
                return 0;
            }
            curNode = curNode.children[index];
        }
        return curNode.count;
    }
}

public class _08TrieTrieNode {

    public static void main(String[] args) throws IOException{
        // 输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Trie trie = new Trie();
        StringBuilder ans = new StringBuilder();
        while(n-- != 0){
            String[] ss = br.readLine().split(" ");
            if(ss[0].equals("I")){
                trie.insert(ss[1]);
            }
            else{
                ans.append(trie.search(ss[1])).append("\n");
            }
        }
        ans.deleteCharAt(ans.length()-1);
        System.out.println(ans);
    }
}
