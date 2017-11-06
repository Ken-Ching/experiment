package team.kc.experiment.study.java;

/**
 * 
 * @author KenC
 *
 */
public class ScopeDemo {
}

class BaseClass {
	private   String privateField;
	protected String protectedField;
	public    String publicField;
	
	public String getPrivateField() {
		return privateField;
	}

	public void setPrivateField(String privateField) {
		//do some validate
		if ("6666".equals(privateField)) {
			privateField = "5555";
		}
		this.privateField = privateField;
	}
}

class ChildClass extends BaseClass {
	//这里只是demo才会尝试直接访问field，在面向对象封装的原则下，是不建议其他类，
	//包括子类直接访问field的，可以通过get/set方法去访问
	public void visitBase () {
		//Error!无法访问父类private
		//System.out.println(privateField);
		
		//可以访问父类protected和public的field(method类似)
		System.out.println(this.protectedField);
		System.out.println(this.publicField);
	}
}

class OtherClass {
	public void visitBase () {
		BaseClass aClass = new BaseClass();
		//Error!无法访问父类private
		//System.out.println(aClass.privateField);
		
		//可以访问同包的protected和public的field(method类似)
		//对于可以访问同包的protected，我也是写了这段代码才发现。
		System.out.println(aClass.protectedField);//如果OtherClass是在其他包下的，这一样就报错了
		System.out.println(aClass.publicField);
	}
}
