package T_Single;

public interface List_Single<T>{
    boolean isEmpty();//是否空
    Node<T> insert(int i, T x);//插入x作为第i个元素
    T remove(int i);//删除第i个元素并返回被删除对象
    int search(T key);//查找，返回首次出现的关键字为key元素
    //根据位置查找
    int length();

    T DeleteX(T key);
}
