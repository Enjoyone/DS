package exa01_顺序表;

public class SeqList<T> extends Object implements LList<T> {
    protected Object[] element;//对象数组
    protected int n;//顺序表长度

    public SeqList() {//默认构造方法，创建默认容量的空表
        this(64);
    }

    public SeqList(int size) {//构造方法，创建容量为size的空表
        this.element = new Object[size];
        this.n = 0;
    }

    public boolean isEmpty() {//判断顺序表是否空
        return this.n == 0;
    }

    public int length() {//返回顺序表长度
        return this.n;
    }

    public T get(int i) {//返回第i（≥0）个元素
        if (i >= 0 && i < this.n) {
            return (T) this.element[i];
        }
        return null;
    }

    /**
     * 设置第i（≥0）个元素值为x。若i<0或大于表长则抛出序号越界异常；若x==null，不操作
     */
    @Override
    public void set(int i, T x) {
        if (x == null)
            return;

        if (i >= 0 && i < this.n) {
            this.element[i] = x;
        } else {
            throw new IndexOutOfBoundsException(i + ""); // 抛出序号越界异常
        }
    }

    /**
     * 顺序表的插入操作 插入第i（≥0）个元素值为x。若x==null，不插入。 若i<0，插入x作为第0个元素；若i大于表长，插入x作为最后一个元素
     */
    @Override
    public void insert(int i, T x) {
        if (x == null)
            return;

        // 若数组满，则扩充顺序表容量
        if (this.n == element.length) {
            // temp也引用elements数组
            Object[] temp = this.element;
            // 重新申请一个容量更大的数组
            this.element = new Object[temp.length * 2];
            // 复制数组元素，O(n)
            for (int j = 0; j < temp.length; j++) {
                this.element[j] = temp[j];
            }
        }

        // 下标容错
        if (i < 0)
            i = 0;

        if (i > this.n)
            i = this.n;

        // 元素后移，平均移动len/2
        for (int j = this.n - 1; j >= i; j--) {
            this.element[j + 1] = this.element[j];
        }
        this.element[i] = x;
        this.n++;
    }


    /**
     * 在顺序表最后插入x元素
     */
    @Override
    public void append(T x) {
        insert(this.n, x);
    }

    /**
     * 顺序表的删除操作 删除第i（≥0）个元素，返回被删除对象。若i<0或i大于表长，不删除，返回null。
     */
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int i) {
        if (this.n == 0 || i < 0 || i >= this.n) {
            return null;
        }

        T old = (T) this.element[i];
        // 元素前移，平均移动len/2
        for (int j = i; j < this.n - 1; j++) {
            this.element[j] = this.element[j + 1];
        }
        this.element[this.n - 1] = null;
        this.n--;
        return old;
    }

    /**
     * 删除线性表所有元素
     */
    @Override
    public void removeAll() {
        this.n = 0;
    }

    /**
     * 查找，返回首次出现的关键字为key元素
     */
    @SuppressWarnings("unchecked")
    @Override
    public T search(T key) {
        int find = this.indexOf(key);
        return find == -1 ? null : (T) this.element[find];
    }

    /**
     * 顺序表比较相等 比较两个顺序表是否相等 ，覆盖Object类的equals(obj)方法，O(n)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj instanceof SeqList) {
            SeqList<T> list = (SeqList<T>) obj;
            // 比较实际长度的元素，而非数组容量
            for (int i = 0; i < this.length(); i++) {
                if (!this.get(i).equals(list.get(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * 顺序查找关键字为key元素，返回首次出现的元素，若查找不成功返回-1
     *
     * @param key
     *            可以只包含关键字数据项，由T类的equals()方法提供比较对象相等的依据
     * @return
     */
    public int indexOf(T key) {
        if (key != null) {
            for (int i = 0; i < this.n; i++) {
                // 对象采用equals()方法比较是否相等
                if (this.element.equals(key)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // 返回顺序表所有元素的描述字符串，形式为“(,)”，覆盖Object类的toString()方法
    public String toString() {
        String str = "(";
        if (this.n > 0)
            str += this.element[0].toString();
        for (int i = 1; i < this.n; i++)
            str += ", " + this.element[i].toString();
        return str + ") "; // 空表返回()
    }
}
