package team.kc.experiment.study.oop.pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * MVC 模式表示 模型-视图-控制器 模式。
 * 从名称我们可以看到，MVC模式涉及三个部分:
 * Model（模型）- 
 *    模型表示携带数据的对象。它也可以具有逻辑来更新控制器，如果其数据改变。
 * View（视图）- 
 *    视图表示模型包含的数据的可视化。通常它有UI逻辑。
 * Controller（控制器） - 
 *    控制器引用模型和视图。它控制数据流进入模型对象，并在数据更改时更新视图。它保持视图和模型分开。
 *    
 * @author KenC
 */
public class MVCPattern {
	
	public static void main (String[] args) {
		
	}
}

/** 模型Model */
class EmployeeModel {
	private String name;
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
}

/** 视图View */
class EmployeeView {
	/** 为了比较贴近我们的实际使用，特意采用html作为view，在java中可以理解成JSP，
	 *  对于具体的场景，我们还可以创建不同的view，生成不同的视图，View跟Model没有耦合一起 */
	public void print (Map<String, String> attrMap) {
		StringBuilder view = new StringBuilder()
		.append( "<html>..." )
		.append( "  <span>名字：</span><input value=\""+attrMap.get("name")+"\"/>")
		.append( "...</html>" );
		
		System.out.println( view.toString() );
	}
}

/** 控制器Controller */
class EmployeeController {
	private EmployeeModel model;
	private EmployeeView view;
	
	public void updateView () {
		Map<String, String> attrMap = new HashMap<String, String>();
		attrMap.put("name", model.getName());
		
		view.print( attrMap );
	}

	public EmployeeModel getModel() {
		return model;
	}

	public void setModel(EmployeeModel model) {
		this.model = model;
	}

	public EmployeeView getView() {
		return view;
	}

	public void setView(EmployeeView view) {
		this.view = view;
	}
}