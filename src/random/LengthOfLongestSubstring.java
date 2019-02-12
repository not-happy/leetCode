package random;

/**
 * 3. 无重复字符的最长子串 {https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/}
 *
 * @author xuyong
 * @since 2019-02-12 14:11
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int distance = 0;
        int start = 0;
        int i = 0;
        for (; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = start; j < i; j++) {
                if (c == s.charAt(j)) {
                    distance = (i - start) > distance ? (i - start) : distance;
                    start = j + 1;
                    break;
                }
            }
        }
        return (i - start) > distance ? (i - start) : distance;
    }

    public static void main(String[] args) {
        String a = "cdd";

        LengthOfLongestSubstring substring = new LengthOfLongestSubstring();
        System.out.println(substring.lengthOfLongestSubstring(a));
    }

}
