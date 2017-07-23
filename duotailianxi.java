import java.util.Scanner;

/**
需求，做一个简单的多态理解练习，分辨基础学生和进阶学生，
 基础学生：
 初学java，做练习
 进阶学生：
 学习java，做项目

 思路：
 1、建立两个类，基础学生和进阶学生
 2、基础学生和进阶学生只是学习内容不同因此可以将学习抽象出来
 3、根据输入的内容，输出对应应做的事
 4、建立一个静态方法类用于提供服务
 */

/*
从两种学生中抽象出的模糊方法：学习
 */
abstract class study
{
    abstract void study();
}

/*
基础学生类
 */
class BaseStudent extends study
{
    public void study() {System.out.println("初学java");}
    public void train() {System.out.println("做练习");}
}
/*
进阶学生类
 */
class AdvStudent extends study
{
    public void study() {System.out.println("学习java");}
    public void zuoxiangmu() {System.out.println("做项目");}
}
/*
服务内容：
1、哪种学生判定
2、输出任务
 */
class service
{
    static  void who(String a)
    {
        if(a.equals("BaseStudent"))
        {
            function(new BaseStudent());
        }
        else if (a.equals("AdvStudent"))
        {
            function(new AdvStudent());
        }
        else System.out.println("Entered wrong");
    }
    public static void function(study a)
    {
        if(a instanceof BaseStudent)
        {
            BaseStudent stu = (BaseStudent) a;
            stu.study();
            stu.train();
        }
        else if(a instanceof AdvStudent)
        {
            AdvStudent Stu =(AdvStudent) a;
            Stu.study();
            Stu.zuoxiangmu();
        }
    }
}
/*
主函数，询问类别并反馈对应内容
 */
public class duotailianxi
{
    public static void main(String[] args)
    {
        System.out.println("BaseStudent or AdvStudent?");
        System.out.println("Input :");
        Scanner scan = new Scanner(System.in);
        String who =scan.next();
        service.who(who);

    }
}
