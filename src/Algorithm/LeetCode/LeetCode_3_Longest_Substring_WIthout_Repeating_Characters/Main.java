package Algorithm.LeetCode.LeetCode_3_Longest_Substring_WIthout_Repeating_Characters;

class Main {
    public static void main(String[] args) {
        SlidingWindowExtended foo = new SlidingWindowExtended();

        System.out.println(foo.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(foo.lengthOfLongestSubstring("bbbbb"));
        System.out.println(foo.lengthOfLongestSubstring("pwwkew"));
        System.out.println(foo.lengthOfLongestSubstring("au"));
    }
}
