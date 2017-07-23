import java.util.Random;
import java.util.Scanner;
/**
 需求：
 1、用户输入数字给出大或小的反馈，给出大或者小的反馈，知道猜对为止，记录猜测的次数。游戏要有开始，退出，再来一次的选项

 思路
 首先肯定有一个用户类：记录用户的名字和猜的次数和输入的数

 功能定义：
 1、用户决定开始或者结束游戏
 2、随机生成一个数字


 */
//玩家信息类，只要是玩家信息，不论哪个玩家都是这样
class Player
{
     public  Player()
    {
        num=0;
    }

    public static String name;
    public static int num;
    public static int time=0;
}

//工具类，作为静态的方法存放在方法区，可以随时调用
class tool
{

    //反馈大小
    public static void bijiao(int n1,int n2)
    {
        if(n1>n2)System.out.println("大了");
        else if(n1<n2)System.out.println("小了");
    }

    //反馈最终信息
    public static void print(String name,int num,int time)
    {
        System.out.println("Player:"+name+"  uesd  "+time+"  time");
        System.out.println("The answer is:  "+num);
    }



    //提示游戏开始或者结束
    public static void jieshu()
    {
        System.out.println("游戏结束");
    }
    public static void kaishi()
    {
        System.out.println("游戏开始");
    }

    //提供随机标准数，作为猜测的目标数值
    public static int suiji()
    {
        Random rand = new Random();
        return rand.nextInt(101)+0;
    }

    //因为只有两种不同的询问方法（输入名字或者数字），没必要单独建立一个类抽象出来
    //直接引用更快
    public static void xunwen(String str)
    {
        System.out.println("请输入"+str);
    }
}
public class caidaxiao
{
    public static void main(String[] args)
    {
        System.out.println("这是一个猜数字的游戏，值的范围在1~100");

        //直接使用java定义的类，从键盘输入开始的关键字
        Scanner s = new Scanner(System.in);
        int str ;
        System.out.println("按0开始游戏，其他键退出游戏");
        str = s.nextInt();

        //根据输入判断
        //输入为0开始游戏，输入不为0结束游戏
        if(str==0)
        {
            int sta = tool.suiji();//定义并初始化随机数
            //直接使用java定义的类，从键盘输入玩家姓名
            Player p = new Player();
            tool.xunwen("name");
            Scanner playerName = new Scanner(System.in);
            String playername ;
            p.name = playerName.next();
            while (p.num!=sta)//循环体，直到猜到目标数字结束，同时记录次数
            {
                System.out.println("请输入猜测的数字");
                Scanner guesnum = new Scanner(System.in);
                p.num = guesnum.nextInt();
                tool.bijiao(p.num,sta);
                p.time++;
            }
            tool.print(p.name,p.num,p.time);
            tool.jieshu();
        }
        else
            tool.jieshu();
            return;
    }
}
