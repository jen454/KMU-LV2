package ParenthesesChecker;

public class ParenthesesChecker {
    public char[] open;
    public char[] close;
    public CharArrayStack stack;
    public ParenthesesChecker(char[] open, char[] close) {
        this.open = open;
        this.close = close;
        stack = new CharArrayStack(100);
    }

    public boolean isParenthese(char p) {
        boolean ans = false;
        for (int i=0; i<open.length; i++) {
            if (open[i] == p) {
                ans = true;
                break;
            }
        }
        if (ans == false) {
            for (int i=0; i<close.length; i++) {
                if (close[i] == p) {
                    ans = true;
                    break;
                }
            }
        }
        return ans;
    }

    public boolean isOpen(char p) {
        for (int i=0; i<open.length; i++) {
            if (open[i] == p) {
                return true;
            }
        }
        return false;
    }

    public boolean isClose(char p) {
        for (int i=0; i<close.length; i++) {
            if (close[i] == p) {
                return true;
            }
        }
        return false;
    }

    public boolean isMatch(char p1, char p2) {
        int i1 = -1;
        int i2 = -1;
        for (int i = 0; i < open.length; i++) {
            if (p1 == open[i]) {
                i1 = i;
                break;
            }
        }
        for (int i = 0; i < close.length; i++) {
            if (p2 == close[i]) {
                i2 = i;
                break;
            }
        }
        return i1 == i2;
    }

    public boolean validate(String expression) {
        stack.clear();
        for (int i = 0; i < expression.length(); i++) {
            char test = expression.charAt(i);
            if (!isParenthese(test)) continue;
            if (isOpen(test)) {
                stack.add(test);
            } else if (isClose(test)) {
                char last = stack.delete();
                if (!isMatch(last, test)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        char[] open = {'<', '(', '['};
        char[] close = {'>', ')', ']'};

        ParenthesesChecker pc = new ParenthesesChecker(open, close);

        String e1 = "(1 + 2)";
        String e2 = "2 + (2 + [3 + < 4 * 5 >] - 9) / 2";
        String e3 = "(3 + (3 + < 4 * 5 >] - 9) / 2";
        String e4 = "(4 * [1 + (3 - 5]))";
        String e5 = "5 + (5 + 6 * 7 + (9 + [2 / 5])";

        System.out.println(pc.validate(e1));
        System.out.println(pc.validate(e2));
        System.out.println(pc.validate(e3));
        System.out.println(pc.validate(e4));
        System.out.println(pc.validate(e5));

    }
}
