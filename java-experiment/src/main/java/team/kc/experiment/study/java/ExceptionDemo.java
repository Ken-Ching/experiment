package team.kc.experiment.study.java;

public class ExceptionDemo {
	
	/**
	 * 一个会产生异常的方法
	 * @param exceptionType
	 * @throws DBException
	 * @throws ServiceException
	 * @throws ServiceVldException
	 */
	private static void method (int exceptionType) 
			throws DBException, ServiceException, ServiceVldException {
		if (exceptionType == 1) {
			throw new DBException("DBException throwed!");
		} else if (exceptionType == 2) {
			throw new ServiceVldException("ServiceVldException throwed!");
		}else if (exceptionType == 3) {
			throw new ServiceException("ServiceException throwed!");
		}
	}
	
	public static void main (String[] args) {
		try {
			method(3);
			
			//method抛出异常的话,try块后面的其他语句不会被执行.
			System.out.println("Method call successfully!");
		} catch (DBException e) {
			System.out.println( e.getMessage());
		} catch (ServiceVldException e) {//如果父子类异常同时声明处理，子类异常必须在父类前
			System.out.println( e.getMessage() );
		} catch (ServiceException e) {
			System.out.println( e.getMessage() );
		} finally {//finally块是可选的
			//无论是否发生异常，finally 代码块中的代码总会被执行。
			//在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。
			System.out.println("Finally block!");
		}
		
		try {
			method(3);
			
			//method抛出异常的话,try块后面的其他语句不会被执行.
			System.out.println("Method call successfully!");
		} catch (Exception e) {
			System.out.println( e.getMessage());
		} finally {
			//无论是否发生异常，finally 代码块中的代码总会被执行。
			//在 finally 代码块中，可以运行清理类型等收尾善后性质的语句。
			System.out.println("Finally block!");
		}
	}
}

/** 数据库异常 */
class DBException extends Exception {
	private static final long serialVersionUID = 1L;

	public DBException(String message) {
		super(message);
	}
}

/** Service层异常 */
class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String message) {
		super(message);
	}
}

/** Service层验证类异常 */
class ServiceVldException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceVldException(String message) {
		super(message);
	}
}
