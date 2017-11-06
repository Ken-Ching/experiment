package team.kc.experiment.study.java;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MethodEncapsulation {
	/**
	 * 这是一个我们常见的Service的查询方法 
	 * @param criteria 方便举例而用了Map而已，更多情况下这个可能是一个vo等的POJO
	 * @return
	 */
	public List<Object> aServiceQueryMethod (Map<String, Object> criteria) {
		//**拼接查询需要的
		StringBuilder sql = new StringBuilder()
		.append( "select t.columnA, t.columnB, t.columnC " )
		.append( "from tableName t" )
		.append( "where t.queryColumnA = :criteriaA " )
		.append( aExpression(criteria) ? "and t.queryColumnB = :criteriaB " : "" );
		//上面一行的代码是否比下面的if形式好看？一致？不过也得看表达式长短吧。
//		if ( aExpression() ) {
//			sql.append( "and t.queryColumnB = :criteriaB " );
//		}
		
		//**组装查询参数
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "criteriaA", criteria.get("fieldA") );
		
		Calendar aTime = Calendar.getInstance();
		aTime.set( Calendar.MONTH, Calendar.JANUARY );
		params.put( "criteriaB", aTime.getTime() );
		
		//**查询并返回结果
		return aDaoQueryMethod( sql.toString(), params);
	}
	
	/**
	 * 从aServiceQueryMethod方法中//**的注释可以看到，该查询方法基本分3个步骤，
	 * 但是把所有的细节都写在一个方法的话，每次看这个方法，都会把所有的代码看进眼里，
	 * 也许你这次看代码只是关注sql的拼接，但是参数的组装的代码，很容易就影响你去看看。
	 * 有研究表明，人一次关注的东西超过一定量的话，理解起来就会相对的困难了，所以有个
	 * 相对极端的观念是，每一个方法的代码不要超过5/10行，人理解起来就没有压力了
	 * （书上说的，但是我们也没必要当成教条去执行），不过看那些开源的代码，也会发现，
	 * 大部分的方法，行数都是不多的，的确方便使用者阅读和理解。
	 * 
	 * @param criteria
	 * @return
	 */
	public List<Object> aRefactoringServiceQueryMethod (Map<String, Object> criteria) {
		String sql = getQuerySql(criteria);
		Map<String, Object> params = getQueryParams(criteria);
		
		return aDaoQueryMethod( sql, params);
	}
	
	/**
	 * 根据查询条件criteria获取sql
	 * @param criteria
	 * @return 对应的sql
	 */
	public String getQuerySql (Map<String, Object> criteria) {
		StringBuilder sql = new StringBuilder()
		.append( "select t.columnA, t.columnB, t.columnC " )
		.append( "from tableName t" )
		.append( "where t.queryColumnA = :criteriaA " )
		.append( aExpression(criteria) ? "and t.queryColumnB = :criteriaB " : "" );
		
		return sql.toString();
	}
	
	/**
	 * 根据查询条件criteria获取sql查询需要的参数
	 * @param criteria
	 * @return 参数Map
	 */
	public Map<String, Object> getQueryParams (Map<String, Object> criteria) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put( "criteriaA", criteria.get("fieldA") );
		
		Calendar aTime = Calendar.getInstance();
		aTime.set( Calendar.MONTH, Calendar.JANUARY );
		params.put( "criteriaB", aTime.getTime() );
		
		return params;
	}
	
	public List<Object> aDaoQueryMethod (String sql, Map<String, Object> params) {
		return new ArrayList<>();
	}
	
	public boolean aExpression (Map<String, Object> criteria) { return true;}
	
	/* 对于一个方法里面怎么抽象/重构这些步骤成“子”方法，有一个标准，就是这个方法内的每一个代码，
	 * 它的粒度是相当的/同级的，举个更具体的例子：
	 */
	public void doSomething () {
		//合理的划分：
		//1.站会
		//2.工作
		//3.休息（具体实现：3.1去洗手间，3.2喝水）
		
		//不合理的划分：
		//1.站会
		//2.工作
		//3.1 去洗手间
		//3.2 喝水
	}
}
