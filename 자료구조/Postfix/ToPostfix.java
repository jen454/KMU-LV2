package Postfix;

public class ToPostfix {
    public static void main(String[] args) {
        String s = "1+2*3";
        InfixToPostfix.toPostfix(s);

        String ss = "15+(5-2)*4";
        InfixToPostfix.toPostfix(ss);
    }
}

