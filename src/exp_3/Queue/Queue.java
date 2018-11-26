package exp_3.Queue;

public interface Queue<T> {
    abstract boolean isEmpty();
    abstract boolean add(T x);//x入队，成功返回true
    abstract T  peek();//返回队头
    abstract T poll();//出队
}
