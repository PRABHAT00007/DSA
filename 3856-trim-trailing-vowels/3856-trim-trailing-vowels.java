class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);

        while (sb.length() > 0 &&
              (sb.charAt(sb.length() - 1) == 'a' ||
               sb.charAt(sb.length() - 1) == 'e' ||
               sb.charAt(sb.length() - 1) == 'i' ||
               sb.charAt(sb.length() - 1) == 'o' ||
               sb.charAt(sb.length() - 1) == 'u')) {

            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }
}