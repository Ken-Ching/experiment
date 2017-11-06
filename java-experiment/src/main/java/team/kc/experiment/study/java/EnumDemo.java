package team.kc.experiment.study.java;

/**
 * 枚举示例。
 * @author KenC
 */
public class EnumDemo {
	public static final String KEY_TYPE_A = "A";
	public static final String KEY_TYPE_B = "B";
	
	/**
	 * 根据keyType和subKey返回对应的key
	 * @param keyType 
	 *   key的类型可以选"A"或"B"，由于参数是String，除了"A"跟"B",还是可以传其他String的，
	 *   万一误传了其他呢，只能通过调试去发现了。
	 * @param subKey
	 * @return 对应的key
	 */
	public static String genKey (String keyType, String subKey) {
		//如果keyType是"A"或者"B"，程序可以给出正确的key，其他的话或者随便给个默认值，也可以抛异常
		if (KEY_TYPE_A.equals(keyType)) { return genKeyForTypeA();}
		if (KEY_TYPE_B.equals(keyType)) { return genKeyForTypeB();}
		return subKey;
	}
	
	enum KeyType { A, B }
	
	/**
	 * 根据keyType和subKey返回对应的key
	 * @param keyType 
	 *    由于KeyType是枚举而不是String，KeyType只能传A或者B了
	 * @param subKey
	 * @return
	 */
	public static String genKey (KeyType keyType, String subKey) {
		if (KeyType.A.equals(keyType)) { return genKeyForTypeA();}
		if (KeyType.B.equals(keyType)) { return genKeyForTypeB();}
		//不会出现默认的情况
		return subKey;
	}
	
	//空的实现方法，想写伪代码但是也不想编译错误
	private static String genKeyForTypeA () { return "";}
	private static String genKeyForTypeB () { return "";}
	
	//除了上面KeyType那么简单的枚举定义外，枚举还可以定义的复杂而强大一些，有点像类的定义
	enum Color {
		//以下定义依赖后面定义的构造函数，而且枚举的这个“列表”定义必须在最前面
		RED("红色", "Red"), GREEN("绿色", "Green"), BLUE("蓝色", "blue"), YELLOW("黄色", "yellow");
		
		private String name;
		private String value;

		//构造方法是private的，不能另外的new一个枚举的对象
		private Color(String name, String value) {
			this.name = name;
			this.value = value;
		}

		//不建议设置public的set方法,改变了可能会影响其他怪异的行为
		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
	}
	
	public static void main (String[] args) {
		System.out.println( Color.RED.getValue() + ":" + Color.RED.getName() );
	}
}
