package com.liujun.lambda;

/**
 * 好处：
 * 避免匿名内部类定义过多
 * 让代码更加简洁
 * 去掉一堆无意义代码，只留下核心逻辑
 */

// 推导lamda表达式
public class TestLambda {
    // 3.静态内部类
    static class Like2 implements ILike{

        @Override
        public void lambda() {
            System.out.println("I like lamda2");
        }
    }

    public static void main(String[] args) {
        ILike iLike = new Like();
        iLike.lambda();

        iLike=new Like2();
        iLike.lambda();

        // 4.局部内部类
        class Like3 implements ILike{
            @Override
            public void lambda() {
                System.out.println("I like lamda3");
            }
        }
        iLike=new Like3();
        iLike.lambda();

        // 5.匿名内部类,没有类的名称，必须借助接口或者父类
        iLike=new ILike(){
            @Override
            public void lambda() {
                System.out.println("I like lamda4");
            }
        };
        iLike.lambda();

        // 6.lamda简化
        iLike=()->{
            System.out.println("I like lamda5");
        };
        iLike.lambda();

    }
}

// 1.定义一个函数式接口
interface ILike{
    void lambda();
}

// 2.实现类
class Like implements ILike{

    @Override
    public void lambda() {
        System.out.println("I like lamda");
    }
}