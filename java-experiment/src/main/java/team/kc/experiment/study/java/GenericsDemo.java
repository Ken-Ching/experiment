package team.kc.experiment.study.java;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author KenC
 *
 */
public class GenericsDemo {
	
	/**
	 * 获取list中最大的字符串
	 * @param list
	 * @return 最大的字符串
	 */
	public static String maxString (List<String> list) {
		if (null == list) {return null;} 
		if (list.size() == 1) {return list.get(0);}
		
		String maxElement = list.get(0);
		for (int i = 1; i < list.size(); ++i) {
			if (maxElement.compareTo(list.get(i)) < 0) {
				maxElement = list.get(i);
			}
		}
		return maxElement;
	}

	/**
	 * 获取list中最大的元素，元素类型只要实现了Comparable接口即可
	 * @param list
	 * @return 最大的元素
	 */
	public static <T extends Comparable<T>> T maxGenerics (List<T> list) {
		if (null == list) {return null;} 
		if (list.size() == 1) {return list.get(0);}
		
		T maxElement = list.get(0);
		for (int i = 1; i < list.size(); ++i) {
			if (maxElement.compareTo(list.get(i)) < 0) {
				maxElement = list.get(i);
			}
		}
		return maxElement;
	}
	
	public static void main (String[] args) {
		List<String> listStr = Arrays.asList("A", "C", "B");
		System.out.println( "maxString: " + maxString(listStr) );
		System.out.println( "maxGenerics: " + maxGenerics(listStr) );
		
		List<Integer> listInt = Arrays.asList(1, 2, 5, 4, 3);
		System.out.println( "maxGenerics: " + maxGenerics(listInt) );
	}
	
}

/**
 * 举一个我们常用的分页类为例子
 * @author KenC
 *
 * @param <T> 分页元素的类型
 */
class Page<T> {
	private int pageNo;
	private int pageSize;
	//如果不是用泛型，每种类型都得定义一个类，区分类型，例如List<String>,
	//获取不加类型直接是用List，但是list里面的元素就无法保证了，可以恶意add一个其他类型的。
	private List<T> list;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
