package exp_3.Sparse_Matrix;


public class SeqList2<Triple> extends Object{
    protected Object[] element;
    protected int n;

    public SeqList2(int length) {
        this.element = new Object[length];
        this.n = 0;
    }

    public SeqList2() {
        this(64);
    }

    public SeqList2(Triple[] values) {
        this(values.length);
        for (int i = 0; i < values.length; i++) {
            this.element[i] = values[i];
        }
        this.n = this.element.length;
    }


    public boolean isEmpty() {
        return this.n == 0;
    }

    public int size() {
        return this.n;
    }

    public Triple get(int i) {
        if ((i >= 0) && (i < this.n)) {
            return (Triple) this.element[i];
        }
        return null;
    }

    public void set(int i, Triple x) {
        if (x == null)
            throw new NullPointerException("x==null");
        if (i >= 0 && i < this.n)
            this.element[i] = x;
        else throw new IndexOutOfBoundsException(i + "");
    }

    public String toString() {
        String str = getClass().getName() + "(";
        if (this.n > 0) {
            str = str + this.element[0].toString();
        }
        for (int i = 1; i < this.n; i++) {
            str = str + "," + this.element[i].toString();
        }
        return str + ")";
    }

    public int insert(int i, Triple x) {
        if (x == null) {
            throw new NullPointerException("x==null");
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.n) {
            i = this.n;
        }
        Object[] source = this.element;
        if (this.n == this.element.length) {
            this.element = new Object[source.length * 2];
            for (int k = 0; k < i; k++) {
                this.element[k] = source[k];
            }
        }
        for (int j = this.n - 1; j >= i; j--) {
            this.element[(j + 1)] = source[j];
        }
        this.element[i] = x;
        this.n += 1;
        return i;
    }

    public int append(Triple x)                                 //顺序表尾插入x元素，返回x序号。成员方法重载
    {
        return this.insert(this.n, x);                     //插入操作中，this.n加1
    }


    public Triple remove(int i) {
        if ((this.n > 0) && (i >= 0) && (i < this.n)) {
            Triple old = (Triple) this.element[i];
            for (int j = i; j < this.n - 1; j++) {
                this.element[j] = this.element[(j + 1)];
            }
            this.element[(this.n - 1)] = null;
            this.n -= 1;
            return old;
        }
        return null;
    }


    public void removeAll() {
        this.n = 0;
    }


    public int search(Triple key) {
        for (int i = 0; i < this.n; i++)
            if (key.equals(this.element[i]))
                return i;
        return -1;
    }

    //a)	删除递增有序顺序表中所有值大于mink且小于maxk的元素。
    public void removeMINtoMAX(Triple x, Triple y) {
        if (((String) x).compareTo((String) y) >= 0) {
            throw new NullPointerException("mink>=maxk");
        }
        if (((String) x).compareTo((String) y) < 0) {
            for (int i = 0; i < this.n; i++) {
                if (((String) element[i]).compareTo((String) x) > 0 && ((String) element[i]).compareTo((String) y) < 0) {
                    this.remove(i);
                    i--;
                }
            }
        }
        /*for (int i = 0; i < this.n; i++) {
            System.out.println(element[i]);
        }*/
    }


    //b)	将x插入到顺序表的适当位置上，以保持顺序表中元素的有序性。
    public void insertKeepSeq(Triple x) {
        //先执行排序
        if (x == null)
            throw new NullPointerException("x==null");
        for (int i = 0; i < this.n; i++) {
            if (((String) x).compareTo((String) element[i]) >= 0 && ((String) x).compareTo((String) element[i + 1]) <= 0) {
                this.insert(i + 1, x);
                break;
            }
        }
        /*for (int i = 0; i < this.n; i++) {
            System.out.println(element[i]);
        }*/

    }

    //c)	将顺序表进行逆置。
    public Object[] inversion() {
        Object[] temp = {""};
        for (int i = this.n - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                temp[0] = element[j];
                element[j] = element[j + 1];
                element[j + 1] = temp[0];
            }
        }
        /*for (int i = 0; i < this.n; i++) {
            System.out.println(element[i]);
        }*/
        return this.element;
    }

    //Strack)	将两个有序顺序表合并为一个顺序表，合并后依然有序。
    public void combine(SeqList2 A, SeqList2 B, SeqList2 C) {
        int i = 0, j = 0, k = 0;
        while (i < A.n && j < B.n) {
            if (((String) A.element[i]).compareTo(((String) B.element[j])) <= 0)
                C.element[k++] = A.element[i++];
            else
                C.element[k++] = B.element[j++];
        }
        //可能数量不等
        while (i <A.n)
            C.element[k++] = A.element[i++];
        while (j < B.n)
            C.element[k++] = B.element[j++];
        C.n = k;
        /*for (int g = 0; g < C.n; g++) {
            System.out.println(C.element[g]);
        }*/
    }


    //e)	若两个元素按值递增有序排列的顺序表A和B，且同一表中的元素值各不相同。试构造一个顺序表C，其元素为A和B中元素的交集，且表C中的元素也按值递增有序排列。
    public void intersection(SeqList2 A, SeqList2 B, SeqList2 C){
        int k=0;
        int h=0;
        for (int i = 0; i < A.n; i++) {
            for (int j = 0; j < B.n; j++) {
                if (((String)A.element[i]).compareTo((String)B.element[j])==0) {
                    C.element[k++] = A.element[i];
                    h++;
                }
            }
        }
        C.n=h;
        //for (int i = 0; i <h; i++) {
        //    System.out.println(C.element[i]);
        //}
    }

}