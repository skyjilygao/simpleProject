package com.sky.interview.oxcoder;

/**
 * 项目需求
 * 用java代码实现原型模式，通过给出一个原型对象来指明所要创建的对象的类型，然后用复制这个原型对象的办法创建出更多同类型的对象
 * 考点：设计模式：原型模式
 * 搜狐面试题
 */
class Prototype implements Cloneable {
    public Prototype clone() {
	//No.1
 	//开始写代码，实现原型模式。Prototype类中的clone方法是不完整的，请将clone方法补充完整
	Prototype prototype =new ConcretePrototype();

		return prototype;

	
	//end_code
	}
}
class ConcretePrototype extends Prototype {
	public void show() {
		System.out.println("原型模式");
	}
}
public class PrototypeTest {
	public static void main(String[] args) {
		ConcretePrototype concretePrototype = new ConcretePrototype();
		for (int i = 0; i < 5; i++) {
			ConcretePrototype cloneConcretePrototype = (ConcretePrototype) concretePrototype.clone();
			cloneConcretePrototype.show();
		}
	}
}