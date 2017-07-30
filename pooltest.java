import com.sun.org.apache.regexp.internal.RE;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 需求：实现一个线程池，并编写测试类进行测试。
 说明：线程池大小固定
        需要实现java.util.concurrent.Executor接口。
 按照生产者消费者模型，建立一个线程池，大小为4，其中生产者两名，消费者两名。
 如果按照常理，两名生产者，两名消费者应该最后消费完刚好剩余0.

 思路：
 1、建立in和out类，并实现Runnable类作为线程
 2、将两者共性提取出来，建立一个Resource类
 3、在Resource类中分别定义出对应的同步函数
 4、建立主函数，并建立好线程池
 5、提交任务并执行

 同步思路：每次拿到监视器后根据flag的值来防止出现一次提交两次执行的安全问题
 */


class Resource
{
    private static int count=0;
    private static boolean flag=false;
    //特别设定的变量，防止出现一次输入两次执行的问题
    public synchronized void in()
    //保存着作为生产者的提交方法
    {
            while (flag)
                //拿到监视器就判断，如果值为真就说明已经提交过了，将监视器让渡给执行方
                try{wait();}catch (Exception e){}
                //必须解决Exception问题，否则会唤醒异常
             ++count;
            System.out.println(Thread.currentThread().getName()+"......提交后任务数"+count);
            flag=true;//完成一次提交，让执行方拥有使用监视器的权利
            notifyAll();
    }
    public synchronized void out()//
    {
            while (!flag)
                //拿到监视器就判断，如果值为假就说明已经执行过了，将监视器让渡给提交方
                try {wait();}catch (Exception e){}
            count--;
            System.out.println(Thread.currentThread().getName()+"......执行后任务数"+count);
            flag=false
            ;//完成一次执行，让提交方拥有使用监视器的权利
            notifyAll();
    }
}
class out implements Runnable
{
    Resource res;
    public out(Resource res)
    {
        this.res=res;
    }
    public void run()
    {
        try {
            //调用执行方法
            while (true)
                res.out();
        }
        catch (IllegalMonitorStateException e){}
    }
}
class in implements Runnable
{
    Resource res;
    public in(Resource res)
    {
        this.res=res;
    }
    public void run()
    {

        try {
            //调用提交方法
            while (true)
                res.in();
        }
        catch (IllegalMonitorStateException e){}
    }
}
public class pooltest
{
    public static void main(String[] args)
    {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        //建立一个线程池，大小为4.
        Resource r=new Resource();
        in input=new in(r);
        out output = new out(r);
        //建立提交和执行线程
        pool.execute(input);
        pool.execute(input);
        pool.execute(output);
        pool.execute(output);
        //不建立新的线程，利用线程池复用线程
        pool.shutdown();
    }
}
