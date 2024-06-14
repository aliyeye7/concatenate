package com.concatenate;

public class StringProcessor {

    /**
     * For a given string that only contains alphabet characters a-z, if 3 or more consecutive
     * characters are identical, remove them from the string. Repeat this process until
     * there is no more than 3 identical characters sitting besides each other.
     * Example:
     * Input: aabcccbbad
     * Output:
     * -> aabbbad
     * -> aaad
     * -> d
     */
    public String removeConsecutiveChars(String input) {
        String result = input;
        boolean changed;
        do {
            changed = false;
            StringBuilder sb = new StringBuilder();
            char[] chars = result.toCharArray();
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    count++;
                } else {
                    if (count >= 3) {
                        changed = true;
                    } else {
                        for (int j = 0; j < count; j++) {
                            sb.append(chars[i - 1]);
                        }
                    }
                    count = 1;
                }
            }
            if (count < 3) {
                for (int j = 0; j < count; j++) {
                    sb.append(chars[chars.length - 1]);
                }
            }
            result = sb.toString();
        } while (changed);
        return result;
    }


    /**
     * #Stage 2 - advanced requirement
     * Instead of removing the consecutively identical characters, replace them with a
     * single character that comes before it alphabetically.
     * Example:
     * ccc -> b
     * bbb -> a
     * Input: abcccbad
     * Output:
     * -> abbbad, ccc is replaced by b
     * -> aaad, bbb is replaced by a
     * -> d
     */
    public String replaceConsecutiveChars(String input) {
        String result = input;
        boolean changed;
        do {
            changed = false;
            StringBuilder sb = new StringBuilder();
            char[] chars = result.toCharArray();
            int count = 1;
            for (int i = 1; i < chars.length; i++) {
                if (chars[i] == chars[i - 1]) {
                    count++;
                } else {
                    if (count >= 3) {
                        char replacement = (char) ((int) chars[i - 1] - 1);
                        if (replacement >= 'a') {
                            sb.append(replacement);
                            changed = true;
                        }
                    } else {
                        for (int j = 0; j < count; j++) {
                            sb.append(chars[i - 1]);
                        }
                    }
                    count = 1;
                }
            }
            if (count < 3) {
                for (int j = 0; j < count; j++) {
                    sb.append(chars[chars.length - 1]);
                }
            } else if (count >= 3) {
                char replacement = (char) ((int) chars[chars.length - 1] - 1);
                if (replacement >= 'a') {
                    sb.append(replacement);
                    changed = true;
                }
            }
            result = sb.toString();
        } while (changed);
        return result;
    }
}
