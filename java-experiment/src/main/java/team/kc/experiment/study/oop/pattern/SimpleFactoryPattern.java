package team.kc.experiment.study.oop.pattern;

/**
 * 工厂模式是一种创建模式，因为此模式提供了更好的方法来创建对象。
 * 工厂模式主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的
 * @author KenC
 *
 */
public class SimpleFactoryPattern {
	public static void main(String[] args) {
		ShapeFactory shapeFactory = new ShapeFactory();

		// get an object of Circle and call its draw method.
		Shape circle = shapeFactory.getShape(ShapeFactory.SHAPE_CIRCLE);
		// call draw method of Circle
		circle.draw();

		// get an object of Rectangle and call its draw method.
		Shape rectangle = shapeFactory.getShape(ShapeFactory.SHAPE_RECTANGLE);
		// call draw method of Rectangle
		rectangle.draw();

	}
}

/** 工厂产生对象的基类 */
interface Shape {
	void draw();
}

class Rectangle implements Shape {
	public void draw() {
		System.out.println("Inside Rectangle::draw() method.");
	}
}

class Circle implements Shape {
	public void draw() {
		System.out.println("Inside Circle::draw() method.");
	}
}

/** 产生对象的工厂  */
class ShapeFactory {
	public static final String SHAPE_CIRCLE = "CIRCLE";
	public static final String SHAPE_RECTANGLE = "CIRCLE";

	// use getShape method to get object of type shape
	public Shape getShape (String shapeType) {
		if (shapeType.equalsIgnoreCase(SHAPE_CIRCLE)) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase(SHAPE_RECTANGLE)) {
			return new Rectangle();
		} 
		return null;
	}
}