package Algorithm.LeetCode.LeetCode_04_MedianOfTwoSortedArrays;

class Main {
    public static void main(String[] args) {
        BinarySearch foo = new BinarySearch();
        System.out.println(foo.findMedianSortedArrays(new int[]{1, 3, 5, 7, 9, 11}, new int[]{2, 4, 6, 8, 10, 12, 13}));
        BinarySearch1 bar = new BinarySearch1();
        System.out.println(bar.findMedianSortedArrays(new int[]{1, 3, 5, 7, 9, 11}, new int[]{2, 4, 6, 8, 10, 12, 13}));
    }
}
