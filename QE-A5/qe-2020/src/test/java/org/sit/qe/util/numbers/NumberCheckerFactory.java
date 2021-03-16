package org.sit.qe.util.numbers;

public class NumberCheckerFactory {
    public static INumberChecker create(){
        return new NumberChecker();
    }
}
