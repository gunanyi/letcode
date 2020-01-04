package gny.str;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String source = "abcabcbb";
        int result = lengthOfLongestSubstring(source);
    }

    private static int lengthOfLongestSubstring(String source) {
        if(null == source || "".equals(source))
            return 0;
        int start =0; // 起始
        int temp;
        int end = 0; // 结束
        List<String> strings = new ArrayList<>();
        for(int i=1; i<source.length(); i++){
            if(!contince(source,start,end,i)){ // 不包含
                end++;
            }else {
                // 是否可滑动
                if(source.charAt(i) == source.charAt(start)){
                    start++;
                    end++;
                }else { // 不可滑动 加入集合
                    strings.add(source.substring(start,end+1));
                    temp = start;
                    while(temp<=end && source.charAt(temp) != source.charAt(i))
                        temp++;
                    start = temp+1;
                    end = i;
                }
            }
        }
        strings.add(source.substring(start,end+1));
        int result =0;
        for(String s:strings){ // 最大长度
            if(s.length() > result)
                result = s.length();
        }
        return result;
    }

    // 判断是否存在该字符
    private static boolean contince(String source, int start, int end, int i) {
        for(int j=start; j<=end; j++){
            if(source.charAt(j) == source.charAt(i))
                return true;
        }
        return false;
    }
}
