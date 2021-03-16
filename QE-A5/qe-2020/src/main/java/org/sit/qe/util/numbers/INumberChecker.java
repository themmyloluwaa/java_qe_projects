package org.sit.qe.util.numbers;

public interface INumberChecker {
    /**
     *
     * The method takes a string as input and checks if it is a valid hexadecimal number.
     * It returns a boolean value that is:
     *      - true, if the string is a valid hexadecimal number
     *      - false, if the string is not a valid hexadecimal number
     *
     * A valid hexadecimal number is given by a string that satisfies the following conditions:
     *      - the string can start with a sign (+/- are the only signs accepted as starting char)
     *      - the first character of a hexadecimal number is a '0'
     *      - the second character of a hexadecimal number is an 'x' or an 'X'
     *      - the following characters of a hexadecimal number are decimal digits (from 0 to 9) or
     *        a letter of the alphabet between 'a' and 'f' (both lowercase and uppercase letters are valid)
     *
     * Examples of valid hexadecimal strings:
     *      - +0x47f8eca1d
     *      - 0Xadc4790da
     *      - 0xAB78cd3Ab
     *
     * Examples of invalid hexadecimal strings:
     *      - +07934abc (the pattern '0x' is not respected)
     *      - +-0xa45cb (the string can contain only '+' or '-', but not both)
     *      - xabCd73aC (the pattern '0x' is not respected)
     *      - 0xABd19Vc ('V' is not a valid character)
     *
     * @param str the string that needs to be checked
     * @return the boolean result of the checking, that is, true if {@code str}
     * is a valid hexadecimal number and false otherwise
     *
     * */
    boolean isHexNumber(final String str);
}
