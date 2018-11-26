package exp_3.Strack;

public interface Stack<T> {
    abstract boolean isEmpty();
    abstract void push(T x);// 入栈
    abstract T peek();// 返回栈顶
    abstract T pop();//出栈

}
