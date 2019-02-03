package com.atguigu.se.annotation;
//作者:lhh 创建时间:2019年2月1日 上午8:55:05 

@Dog(name = "xingoo", age = 25)
@SuppressWarnings("all")
public class AnnotationTest1 {
	public static void print(Class c) {
		System.out.println(c.getName());

		// java.lang.Class的getAnnotation方法，如果有注解，则返回注解。否则返回null
		Dog dog = (Dog) c.getAnnotation(Dog.class);

		if (dog != null) {
			System.out.println("name:" + dog.name() + " age:" + dog.age());
		} else {
			System.out.println("person unknown!");
		}
	}

	public static void main(String[] args) {
		AnnotationTest1.print(AnnotationTest1.class);
	}
}