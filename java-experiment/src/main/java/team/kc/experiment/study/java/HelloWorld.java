package team.kc.experiment.study.java;

/**
 * 对于很多半路出家，没什么基础就直接投入到项目中学习编程的程序员来说，太多的系统框架的东西在里面，
 * 而且迫于任务压力，只能是copy代码的照葫芦画瓢，很难真正的入门一门语言，等copy了一定数量的代码后，
 * 反过来回顾一下语言的本质，应该会有助于更好的理解这门语言，或者编程的本质。<br/>
 * HelloWorld，几乎是程序教程必有的范例，它的作用如下:<br/>
 * 1.检查对应的基本开发环境，对于java而言，就是jdk/jre有没有配置好。
 * 2.对这门语言的一些基本语法有一个大致的了解，搭起了一个大致可运行的程序代码“框架”，为后面自己尝试更多的语法做铺垫。
 * 3.它足够简单，一般不会挫败初学者的信心（这是凑字数的理由吗？）
 * @author KenC
 *
 */
public class HelloWorld {//public的类名与本java文件的文件名一直
	
	private String name;//类的内部变量，private代表该变量只能类的内部访问
	
	public HelloWorld(String name) {//类的构造方法，确定了一个类可以怎么去被new
		this.name = name;
	}
	
	public String sayHello () {//类方法，public代表了该方法可以被其他类调用
		return "Hello "+this.name+", welcome to Java!";//类方法可以直接掉调用private的属性，但是别的类就不行了
	}

	public static void main (String[] args) {
		//public下的main方法是程序的入口，一个可运行的程序(编译后的.class或.jar)只能指定一个入口
		
		//System.out.println("Hello World, welcome to Java!");//学习程序最常用的输入结果方法System.out，但到了项目中一般转成log输出
		
		HelloWorld helloWorld = new HelloWorld("Ken");
		System.out.println( helloWorld.sayHello() );
		//helloWorld.name是不允许的，涉及的是封装的概念
	}
	
}
