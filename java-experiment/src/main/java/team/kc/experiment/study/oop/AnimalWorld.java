package team.kc.experiment.study.oop;

import java.util.Calendar;

/**
 * 一个例子对入门者解析面向对象的概念
 * @author KenC
 *
 */
public class AnimalWorld {
	
	public static void main (String[] args) {
		Mammal mammal = new Mammal();
		Bird bird = new Bird();
		Fish fish = new Fish();
		Animal animal = new Fish();
		
		System.out.println("//重写(override)例子");
		mammal.move();
		fish.move();
		
		System.out.println("//重载(overload)列子");
		bird.move();
		bird.move(true);
		bird.move(false);

		System.out.println("//多态列子");
		fish.move();
		animal.move();
	}

}

/**
 * 在这个动物世界里，所有的东西都是动物，都会有动物所有的属性/行为
 */
class Animal {
	//动物的属性,属性是封装的
	//封装性是一种信息隐蔽技术，他体现于类的说明，是对象重要的特性。
	//封装使得数据和操作数据的方法封装为一个整体，想成独立性很强的模块，
	//使得用户只能看到对象的外部特性（对象可以接受拿些信息，可以进行何种处理），
	//而对象的内部特性（内部私有属性和实现处理能力的算法）用户是看不到的。简而言之就是说，
	//封装使对象的设计者与对象的使用者分开，使用者只要知道对象可以做什么就可以了，
	//无需知道具体是怎么实现的。借助封装有助于提高类和系统的安全性。
	private Calendar bornTime;
	
	/** 生成Animal，并记录当前产生时间 */
	public Animal() {
		this.born();
	}

	/**
	 * 生成Animal，并记录出生时间
	 * @param bornTime 出生时间
	 */
	public Animal(Calendar bornTime) {
		this.bornTime = bornTime;
	}

	/** 记录当前时间为出生时间 */
	private void born () {
		this.bornTime = Calendar.getInstance();
	}
	
	/**
	 * 获取年龄
	 * @return 年龄
	 */
	public Integer getAge () {
		return Calendar.getInstance().get(Calendar.YEAR) - this.bornTime.get(Calendar.YEAR);
	}
	
	/** 移动 */
	public void move () {
		System.out.println("Animal moving");
	}
}

class Mammal extends Animal {
	public void suckle () {
		System.out.println("Mammal suckling");
	}
}

class Bird extends Animal{
	/**
	 * 重载(overload)move方法，对于Bird来说就存在move()和move(boolean) 
	 * @param inSky 是否在天空中移动
	 */
	public void move (boolean inSky) {
		if (inSky) {
			System.out.println("Bird flying");
		} else {
			System.out.println("Bird moving");
		}
	}
}

class Fish extends Animal{
	/**
	 * 重写(override)Animal的move方法
	 */
	public void move () {
		System.out.println("Fish swimming");
	}
}
