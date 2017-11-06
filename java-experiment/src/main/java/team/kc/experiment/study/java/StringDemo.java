package team.kc.experiment.study.java;

/**
 * String 类是不可改变的，所以你一旦创建了 String 对象，那它的值就无法改变了。
 * 如果需要对字符串做很多修改，那么应该选择使用 StringBuffer & StringBuilder类。
 * @author KenC
 *
 */
public class StringDemo {

	public static void main (String[] args) {
		testImmutableString();
		testFormat();
		testModifiableString();
	}
	
	public static void testImmutableString () {
		String s = "Google";
		System.out.println("s = " + s);

		s = "Runoob";//相当于new String("Runoob");是应用改变了，不是原来的"Google"改变了
		System.out.println("s = " + s);
	}
	
	/** 可以通过System.out.printf和String.format格式化字符串*/
	public static void testFormat() {
		float floatVar = 1.0f;
		int intVar = 2;
		String stringVar = "Str";
		
		System.out.printf(
			"浮点型变量的值为 %f, 整型变量的值为  %d, 字符串变量的值为  %s",
			floatVar, intVar, stringVar);
		
		System.out.println();
		
		String fs = String.format(
			"浮点型变量的值为 %f, 整型变量的值为  %d, 字符串变量的值为  %s", 
			floatVar, intVar, stringVar);
		System.out.println(fs);

	}
	
	/**
	 * 当对字符串进行修改的时候，需要使用 StringBuffer和 StringBuilder类。
	 * 和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，
	 * 并且不产生新的未使用对象。 StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 
	 * 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
	 *  StringBuilder相较于 StringBuffer有速度优势，所以多数情况下建议使用 StringBuilder类。
	 *  然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类。 
	 */
	public static void testModifiableString () {
		StringBuilder sql = new StringBuilder()
		.append( "select t.columnA, t.columnB " )
		.append( "from table t " );
		
		System.out.println( sql.toString() );
	}
}
