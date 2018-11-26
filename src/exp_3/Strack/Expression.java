package exp_3.Strack;

public class Expression {

    public StringBuffer toPostfix(String infix){
        Stack<String>stack=new SeqStack<String >(infix.length());
        StringBuffer postfix=new StringBuffer(infix.length()*2);//后缀表达式
        int i=0;
        while (i<infix.length()){
            char ch=infix.charAt(i);
            switch (ch){
                case '+': case '-':
                    while (!stack.isEmpty()&&!stack.peek().equals("("))
                        postfix.append(stack.pop());
                    stack.push(ch+"");
                    i++;break;
                case '*': case '/':
                    while (!stack.isEmpty()&&(stack.peek().equals("*")||stack.peek().equals("/")))
                        postfix.append(stack.pop());
                    stack.push(ch+"");
                    i++;break;
                case '(':
                    stack.push(ch+"");
                    i++;break;
                case ')':
                    String out=stack.pop();
                    while (out!=null&&!out.equals("(")){
                        postfix.append(out);
                        out=stack.pop();
                    }
                    i++;break;
                    default:
                        while (i<infix.length()&&ch>='0'&&ch<='9'){
                            postfix.append(ch);
                            i++;
                            if (i<infix.length())
                                ch=infix.charAt(i);
                        }
                    postfix.append(" ");
            }
        }
        while (!stack.isEmpty())
            postfix.append(stack.pop());
        return postfix;
    }

    // STOPSHIP: 2018/11/13  toValue//计算

    public int toValue(StringBuffer postfix){
        Stack<Integer>stack02=new SeqStack<>();
        int value=0;
        for (int i = 0; i < postfix.length(); i++) {
            char ch=postfix.charAt(i);
            if (ch>='0'&&ch<='9')
            {
                value=0;
                while (ch!=' ')
                {
                    value=value*10+ch-'0';
                    ch=postfix.charAt(++i);
                }
                stack02.push(value);
            }
            else
                if (ch!=' ')
                {
                    int y=stack02.pop(),x=stack02.pop();
                    switch (ch){
                        case '+':value=x+y;break;
                        case '-':value=x-y;break;
                        case '*':value=x*y;break;
                        case '/':value=x/y;break;
                    }
                    System.out.println(x+(ch+"")+y+"="+value+", ");
                    stack02.push(value);
                }
        }
        return stack02.pop();
    }



}
