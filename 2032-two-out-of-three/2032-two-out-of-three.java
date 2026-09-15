import java.util.*;

class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> set3 = new HashSet<>();

        for (int x : nums1)
            set1.add(x);

        for (int x : nums2)
            set2.add(x);

        for (int x : nums3)
            set3.add(x);

        Set<Integer> result = new HashSet<>();

        for (int x : set1) {
            if (set2.contains(x))
                result.add(x);
        }

        for (int x : set1) {
            if (set3.contains(x))
                result.add(x);
        }

        for (int x : set2) {
            if (set3.contains(x))
                result.add(x);
        }

        return new ArrayList<>(result);
    }
}