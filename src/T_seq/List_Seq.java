package T_seq;

public interface List_Seq<T> {
    boolean isEmpty();//是否空
    int insert(int i, T x);//插入x作为第i个元素
    T remove(int i);//删除第i个元素并返回被删除对象
    int search(T key);//查找，返回首次出现的关键字为key元素

    int size();//返回线性表长度
    T get(int i);//返回第i（i≥0）个元素
    void set(int i, T x);//设置第i个元素值为x
    void removeAll();//删除线性表所有元素
    //void clear();
    //boolean contains(T x);
    //void append(T x);//在线性表最后插入x元素
}
