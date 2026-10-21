class Solution {
    public int minOperations(String s) {
        int n = s.length();
        boolean sorted = true;
        for (int i = 1; i < n; i++)
            if (s.charAt(i) < s.charAt(i - 1)) { sorted = false; break; }
        if (sorted) return 0;
        if (n == 2) return -1;

        char mn = 'z', mx = 'a';
        for (char c : s.toCharArray()) {
            mn = (char) Math.min(mn, c);
            mx = (char) Math.max(mx, c);
        }
        char first = s.charAt(0), last = s.charAt(n - 1);

        if (first == mn || last == mx) return 1;

        boolean firstUniqueMax = true, lastUniqueMin = true;
        for (int i = 1; i < n; i++)
            if (s.charAt(i) >= first) firstUniqueMax = false;
        for (int i = 0; i < n - 1; i++)
            if (s.charAt(i) <= last) lastUniqueMin = false;

        return (firstUniqueMax && lastUniqueMin) ? 3 : 2;
    }
}