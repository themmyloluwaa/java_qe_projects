package org.sit.qe.util.numbers;

public class NumberChecker implements INumberChecker {

    /**
     * The NumberChecker constructor. Do not use this constructor directly in
     * test cases.
     */
    public NumberChecker() {
    }

    /**
     * {@inheritDoc}
     * See documentation of interface method {@code INumberChecker.isHexNumber}. 
     * The implementation of this method is an adapted excerpt of the method
     * org.apache.commons.lang3.math.NumberUtils.isCreatable in the Apache
     * Commons Lang library.
     *
     * @param str the string that needs to be checked
     * @return true if {@code str} is a valid hexadecimal number and false
     * otherwise
     */
    public boolean isHexNumber(final String str) {
        if (str == null || "".equals(str)){
            return false;
        }
        boolean isHex = true;
        final char[] chars = str.toCharArray();
        int sz = chars.length;
        int start = 0;
        // leading sign
        if(chars[0] == '-' || chars[0] == '+')
          start = 1;

        if (sz > start + 1){
            if(chars[start] == '0') {
                if (chars[start + 1] == 'x' || chars[start + 1] == 'X') {
                    int i = start + 2;
                    if (i == sz) {
                        isHex = false; // str == "0x"
                    } else {
                        // checking hex digits (it can't be anything else)
                        for (; i < chars.length; i++) {
                            if ((chars[i] < '0' || chars[i] > '9')
                                    && (chars[i] < 'a' || chars[i] > 'f')
                                    && (chars[i] < 'A' || chars[i] > 'F')) {
                                isHex = false;
                            }
                        }
                    }
                } else {
                    isHex = false;
                }
            } else {
                isHex = false;
            }
        } else {
            isHex = false;
        }
        return isHex;
    }
}
