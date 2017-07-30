/**
需求：对毕向东视频中多态理解进行练习
 说明：实现向上转型

 思路：定义猫和狗两个类，并将吃抽象出来作为这两个类的抽象父类
*/
//动物类，包含猫和狗最基本的吃这一模糊方法
abstract class Animal
{
    abstract void eat();
}
class cat extends Animal
{
    //覆盖eat方法
    public void eat()
    {
        System.out.println("吃鱼");
    }
    //猫的独特方法
    public void catchMouse()
    {
        System.out.println("抓老鼠");
    }
}
class dog extends Animal
{
    //覆盖eat方法
    public void eat()
    {
        System.out.println("吃骨头");
    }
    //狗的独特方法
    public void jiao()
    {
        System.out.println("汪汪叫");
    }
}
class DuotaiDemo2
{
    public static void main(String[] args)
    {
        Animal a =new cat();//向上转型
        a.eat();
        cat c=(cat)a;
        c.catchMouse();

        function(new cat());
        function(new dog());
    }
    public static void function(Animal a)
    {
        a.eat();
        //根据是哪一个类实现这种动物的功能
        if(a instanceof cat)
        {
            cat c=(cat)a;
            c.catchMouse();
        }
        else if(a instanceof dog)
        {
            dog d =(dog)a;
            d.jiao();
        }
    }
}