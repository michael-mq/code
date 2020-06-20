package Algorithm.LeetCode.LeetCode_03_LongestSubstringWIthoutRepeatingCharacters;

class Main {
    public static void main(String[] args) {
        SlidingWindowExtended foo = new SlidingWindowExtended();

        System.out.println(foo.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(foo.lengthOfLongestSubstring("bbbbb"));
        System.out.println(foo.lengthOfLongestSubstring("pwwkew"));
        System.out.println(foo.lengthOfLongestSubstring("au"));
    }
}
