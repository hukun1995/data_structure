package data_structure.string;

import java.util.stream.IntStream;

/**
 * @author kun.hu
 * BF pattern matching algorithm
 */
public class BFMatching {

    /**
     * BF模式匹配函数
     * @param s 主串
     * @param t 子串
     * @return 匹配成功, 返回index; 匹配失败, 返回-1
     */
    public static int match(String s, String t){
        // 主串第i轮迭代
        for(int i = 0; i <= s.length()-t.length(); i++){
            // 判断是否都一样
            boolean allMatch = true;
            // 判断是否完全匹配
            for(int j = 0; j<t.length(); j++){
                if(s.charAt(i+j) != t.charAt(j)){
                    allMatch = false;
                    break;
                }
            }

            // 完全匹配直接返回, 否则继续循环
            if(allMatch){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(match("hello world !", "ab"));
        System.out.println(match("hello world !", "wo"));
    }

}
