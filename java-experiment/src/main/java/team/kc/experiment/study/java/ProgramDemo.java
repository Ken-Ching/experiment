package team.kc.experiment.study.java;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 列举一些编程习惯问题。
 * @author KenC
 *
 */
public class ProgramDemo {
	public static final String A_STR = "type";
	
	/**
	 * NullPointerException是编程中比较常见的异常，而且这个异常往往的跟编程习惯有关，
	 * 好的习惯能避免大多数的NullPointerException
	 */
	public static void nullPointerDemo () {
		//--------字符串----------
		String str = null;
		String str2 = "";
		//str为null的话，以下判断会报空指针异常
		//if (str.equals(A_STR)) {}

		//equals比较时，常量应该放前面，就算str为null也能得到预期的结果
		if (A_STR.equals(str)) {}
		
		//更加推荐用apache commons的库去判断，而且StringUtils提供更多关于字符串的健壮的方法
		if (StringUtils.equals(str, str2)) {}
		if (StringUtils.isEmpty(str)) {}
		if (StringUtils.isBlank(str)) {}
		
		//--------集合----------
		List<Object> list = query();
		
		//如果list为null，报空指针异常
		if (!list.isEmpty()) {}
		
		//需要增加未空判断
		if (null != list && !list.isEmpty()) {}
		
		//采用CollectionUtils或者自己封装的方法，代码更健壮，可读性更好
		//对于复杂的判断表达式，封装成方法，名字表明判断意思，程序可读性更加的好
		if (CollectionUtils.isNotEmpty(list)) {}
	}
	
	//对于一个查询方法，如果结果为空或者有异常的情况下，可能返回的是null或者size为空的List
	private static List<Object> query () {
		return null;
	}
	
	
}
