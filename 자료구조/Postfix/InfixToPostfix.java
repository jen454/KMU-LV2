package Postfix;

public class InfixToPostfix {

    public static int getIsp(Charstack stack){
        char topToken = stack.peek();
        switch(topToken){
            case '(':
                return 0;
            case ')':
                return 9;
            case '+':
                return 2;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 3;
            case '%':
                return 3;
            default:
                throw new RuntimeException("Invalid token!");
        }
    }

    public static int getIcp(char token){
        switch(token){
            case '(':
                return 10;
            case ')':
                return 9;
            case '+':
                return 2;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 3;
            case '%':
                return 3;
            default:
                throw new RuntimeException("Invalid token!");
        }
    }

    public static void toPostfix(String expression){
        char token;
        Charstack stack = new Charstack(expression.length());
        for(int i = 0; i < expression.length(); i++){
            token = expression.charAt(i);
            if(48 <= token && token <= 57){ // token = 0~9
                System.out.print(token);
            }else if(token == 41){ // token = )
                while(stack.peek() != 40){
                    System.out.print(stack.pop());
                }
                stack.pop();
            }else{
                if(token == 40 || stack.isEmpty()){
                    stack.add(token);
                    continue;
                }
                while(!stack.isEmpty() && getIsp(stack) >= getIcp(token)){
                    System.out.print(stack.pop());
                }
                stack.add(token);
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println();
        System.out.println("----- END");
    }
}
