/**
 需求：编写一个程序，要求使用包含if语句，while语句，for语句，break语句，continu语句，reaturn语句等控制语句
 完成一个选择运算器，根据整形数  x  的值，进行相应的运算：
 要求完成这样一个运算，给定一个整数值 x ,如果这个值在7至10之间，就进行累加并输出最后数值，且如果  x  大于7，输出累加过程；如果不在这个范围，就输出0

 思路：
 1、需要定义的整形变量 x ，整形变量 sum
 2、定义三个功能：（1）选择功能函数SWITCH，（2）累加函数LeiJia (3)输出函数Print
 3、肯定有作为计数的中间条件变量，因此使用for语句更好;
 */
public class work_1
{
    public static void main(String[] args)
    {
        int x = 10;
        int sum = 0;
        SWITCH(x,sum);
        }

    //用来输出累加和
    public static void Print(int x)
    {
        System.out.println(x);
    }

    //进行累加运算，同时按照要求对特殊值进行处理
    //当 x 值大于7时，按要求输出每次累加过程
    // 为了尽量保持各模块功能独立性，特殊值处理在这里只输出到前一次
    public static int LeiJia(int x)
    {
        int temp = 0;
        for(int i=0;i<=x;i++)
        {
            temp+=i;
            if(x==7||i==x)continue;;
            Print(temp);
        }
        return temp;
    }


    //按照 x 的数值完成功能选择
    public static void SWITCH(int x,int sum)
    {
        switch (x)
        {
            case 7:
                sum=LeiJia(x);
                Print(sum);
                break;
            case 8:
                sum=LeiJia(x);
                Print(sum);
                break;
            case 9:
                sum=LeiJia(x);
                Print(sum);
                break;
            case 10:
                sum=LeiJia(x);
                Print(sum);
                break;
            default:
                System.out.println(0);
                break;
        }
    }
}
