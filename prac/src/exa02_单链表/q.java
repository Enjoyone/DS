package exa02_单链表;


class Entry<T>{
    public T data;
    public Entry next;
    public Entry() {
        this.data = null;
        this.next = null;
    }
    public Entry(T data) {
        this.data = data;
        this.next = null;
    }
}
class Link<T>{
    Entry head;
    public Link() {
        head = new Entry();
    }




    /**
     * 头插法
     */
    public void insertHead(T val){
        Entry entry = new Entry(val);
        entry.next = head.next;
        head.next = entry;
    }
    /**
     * 尾插法
     */
    public void insertTail(T val){
        Entry entry = new Entry(val);
        Entry p = head;
        while(p.next != null){
            p = p.next;
        }
        p.next = entry;
    }
    public int getLength(){
        Entry p = head;
        int len = 0;
        while(p.next != null) {
            len++;
            p = p.next;
        }
        return len;
    }
    /**
     * 指定位置插入
     */
    public boolean insert(T val,int pos){
        Entry p = head;
        Entry entry = new Entry(val);
        int len = 0;
        if(pos < 0 ||pos > this.getLength()){
            return false;
        }
        while(p != null){
            if(len == pos){
                entry.next = p.next;
                p.next = entry;
                return true;
            }
            len++;
            p = p.next;
        }
        return false;
    }
    /**
     *
     * @param val
     * @return
     * 删除指定数据
     */
    public boolean delete(T val){
        Entry p = head;
        while(p.next != null){
            if(p.next.data == val){
                p.next = p.next.next;
                return true;
            }
            p = p.next;
        }
        return false;
    }
    public void print(){
        Entry p = head.next;
        while(p != null){
            System.out.print(p.data+"   ");
            p = p.next;
        }
    }
}


