package com.liujun.lambda;

/**
 * 总结：
 * lambda表达式只能有一行代码的情况下才能简化,如果有多行，就用代码块包裹
 * 前提是接口是函数式接口
 * 多个参数也可以去掉参数类型，要去掉就都去掉
 */
public class ExampleLambda {
    static class Love2 implements Ilove{
        @Override
        public void love(int a) {
            System.out.println("I love you1-->"+a);
        }
    }
    public static void main(String[] args) {
        Ilove ilove=null;

        ilove=new Love1();
        ilove.love(1);

        ilove=new Love2();
        ilove.love(2);

       ilove=new Ilove() {
           @Override
           public void love(int a) {
               System.out.println("I love you3-->"+a);
           }
       };
        ilove.love(3);

        ilove=(int a)->{
            System.out.println("I love you4-->"+a);
        };
        ilove.love(4);

        // 去掉参数类型
        ilove=(a)->{
            System.out.println("I love you5-->"+a);
        };
        ilove.love(5);

        // 去掉括号
        ilove=a->{
            System.out.println("I love you6-->"+a);
        };
        ilove.love(6);

        // 去掉花括号
        ilove=a-> System.out.println("I love you7-->"+a);
        ilove.love(7);
    }
}

interface Ilove{
    void love(int a);
}
class Love1 implements Ilove{
    @Override
    public void love(int a) {
        System.out.println("I love you1-->"+a);
    }
}
