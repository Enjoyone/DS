package exp_3;

import exp_3.Queue.LinkedQueue;

public class Queue_test {
    public static void main(String[] args) {
//        队列
//    以链表实现队列，请实现队列的以下操作：
//    a)	队列初始化
        LinkedQueue<Integer> queue=new LinkedQueue<Integer>();
        System.out.println("判空：");
        System.out.println(queue.isEmpty());
        System.out.println("1入队：");
        queue.add(1);
        System.out.println("判空：");
        System.out.println(queue.isEmpty());
        System.out.println("出队：");
        System.out.println(queue.poll());

        for (int i = 0; i < 5; i++) {
            Integer intobj = new Integer(i);
            queue.add(intobj);
        }
        System.out.println(queue.toString());

        System.out.println("三个元素依次出队：");
        int h=0;
        while (!queue.isEmpty()&&h<3) {
            System.out.print(queue.poll() + " ");
            h++;
        }
        System.out.println("状态及判空：");
        System.out.println(queue.isEmpty());
        System.out.println(queue.toString());
        System.out.println("剩余两个出队：");
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
        System.out.println("状态及判空：");
        if (!queue.isEmpty())
            System.out.println(queue.toString());
        else System.out.println(queue.isEmpty());
        System.out.println();

//    b)	判断队列状态
//    c)	入队
//    d)	出队
//    e)	打印队列中的所有元素（即从队头到队尾依次在屏幕输出栈中元素）
//    利用上述算法完成下面的各操作，并在每一操作后输出队列状态。
//    f)	5个元素逐一入队，入队后输出队列状态：5个元素
//    g)	3个元素出队　　　  状态：２个元素
//    h)	再２个元素出队　　状态：队空
    }
}
