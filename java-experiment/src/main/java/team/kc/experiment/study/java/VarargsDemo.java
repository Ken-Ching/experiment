package team.kc.experiment.study.java;

import java.util.Arrays;

/**
 * 可变参数例子。可变参数在平常中使用的不算多，而且实现中就是当一个数组处理的，
 * 也许在参数中更多会使用数组或者List, 所以知道有这么一种写法，遇到这样定
 * 义方法会用就好了，自己还是尽量不要去定义这样的方法。
 * @author KenC
 */
public class VarargsDemo {
	//可变参数必须是最后一个参数
	public static int sum (int... nums) {
		int result = 0;
		for (int num : nums) { result += num; }
		return result;
	}
	
	public static int sum (int num1, int num2) {
		System.out.println( "calling int sum (int num1, int num2)" );
		return num1+num2;
	}
	
	public static void main (String[] args) {
		System.out.println( sum(1, 2, 3) );
		System.out.println( sum(1, 2, 3, 4) );

		System.out.println( "Which sum method will be call?" );
		//编译器优先使用精确匹配的方法，不过一般不要写这样容易迷惑的方式
		System.out.println( sum(1, 2) );
		
		//可变参数的例子，暂时比较多看到的是这个Arrays.asList的调用
		Arrays.asList( 1, 2);
		Arrays.asList( 1, 2, 2, 3, 4);
	}
}
