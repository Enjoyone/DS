package T_Single;
//一元多项式

public class TermX implements Comparable<TermX>,Addible<TermX>{

    protected int xishu, cifang;

    public TermX(int xishu, int cifang)                       //构造一项
    {
        this.xishu = xishu;
        this.cifang = cifang;
    }
    public TermX(TermX term)                               //拷贝
    {
        this(term.xishu, term.cifang);
    }

    public void add(TermX x){

    }
    public TermX(String termstr)
    {
        if (termstr.charAt(0)=='+')                        //去掉+号
            termstr=termstr.substring(1);
        int i = termstr.indexOf('x');
        if (i==-1)                                         //没有x，即指数为0
        {
            this.xishu = Integer.parseInt(termstr);         //获得系数
            this.xishu = 0;
        }
        else                                               //有x，x之前为系数，x^之后为指数
        {
            if (i==0)                                      //以x开头，即系数为1
                this.xishu = 1;
            else
            {
                String sub=termstr.substring(0,i);         //x之前子串表示系数
                if (sub.equals("-"))                       //系数只有-号，即系数为-1
                    this.xishu=-1;
                else
                    this.xishu = Integer.parseInt(sub);     //获得系数
            }
            i = termstr.indexOf('^');
            if (i==-1)
                this.cifang=1;                              //没有^，即指数为1
            else
                this.cifang = Integer.parseInt(termstr.substring(i+1));//获得指数
        }
    }


    public String toString()
    {
        String str=this.xishu>0 ? "+" : "-";                //系数的符号位
        if (this.cifang==0 || this.cifang>0 && this.xishu!=1 && this.xishu!=-1)
            str+=Math.abs(this.xishu);                      //系数绝对值，省略系数1
        if (this.cifang>0)
            str+="x";                                      //指数为0时，省略x^0，只写系数
        if (this.cifang>1)
            str+="^"+this.cifang;                            //指数为1时，省略^1，只写x
        return str;
    }
    public void substraction(TermX term){
        if (this.compareTo(term)==0)
            this.xishu -= term.xishu;
        else
            throw new IllegalArgumentException("两项的指数不同，不能相减。");
    }

    public boolean removable(){
        return this.xishu==0;
    }

    public int compareTo(TermX term){
        if (this.cifang==term.cifang)
            return 0;
        return this.cifang<term.cifang?-1:1;
    }
    public boolean equals(Object obj)
    {
        if (this==obj)
            return true;
        if (!(obj instanceof TermX))
            return false;
        TermX term=(TermX)obj;
        return this.xishu==term.xishu && this.cifang==term.cifang;
    }
}
