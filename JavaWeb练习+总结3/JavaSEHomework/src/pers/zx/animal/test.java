package pers.zx.animal;

public class test {

	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.eat();
		dog.lookHome();
		cat.eat();
		cat.catchMouse();
	  //向下转型调用猫和狗的eat
	 Animal animal = new Dog();;
	    animal.eat();
	   Animal animal1=new Cat();
	   animal1.eat();

	}
}
