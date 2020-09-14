import java.util.Scanner;
import java.lang.Math;

public class proj1 {

	public static void main(String[] args) {
		System.out.println("Please enter the number of days you want to simulate at the zoo");
		Scanner input = new Scanner(System.in);
		int numOfDays = input.nextInt();
		
		Zookeeper keeper = new Zookeeper();
		
		Animal[] arr = new Animal[18];
		
		Hippo h1 = new Hippo("Hippo 1");
		Hippo h2 = new Hippo("Hippo 2");
		Elephant e1 = new Elephant("Elephant 1");
		Elephant e2 = new Elephant("Elephant 2");
		Rhino r1 = new Rhino("Rhino 1");
		Rhino r2 = new Rhino("Rhino 2");
		Tiger t1 = new Tiger("Tiger 1");
		Tiger t2 = new Tiger("Tiger 2");
		Lion l1 = new Lion("Lion 1");
		Lion l2 = new Lion("Lion 2");
		Cat c1 = new Cat("Cat 1");
		Cat c2 = new Cat("Cat 2");
		Dog d1 = new Dog("Dog 1");
		Dog d2 = new Dog("Dog 2");
		Wolf w1 = new Wolf("Wolf 1");
		Wolf w2 = new Wolf("Wolf 2");
		Bison b1 = new Bison("Bison 1");
		Bison b2 = new Bison("Bison 2");
		
		arr[0] = h1;
		arr[1] = h2;
		arr[2] = e1;
		arr[3] = e2;
		arr[4] = r1;
		arr[5] = r2;
		arr[6] = t1;
		arr[7] = t2;
		arr[8] = l1;
		arr[9] = l2;
		arr[10] = c1;
		arr[11] = c2;
		arr[12] = d1;
		arr[13] = d2;
		arr[14] = w1;
		arr[15] = w2;
		arr[16] = b1;
		arr[17] = b2;
		
		for(int day = 0; day < numOfDays; day++) {
			String strDay = String.valueOf(day+1); 
			keeper.goToWork(strDay);
			for(Animal x: arr) {
				keeper.wakeUpAnimal(x.name);
				x.wakeUp();
				keeper.countAnimal(x.name);
				x.makeNoise();
				keeper.feedAnimal(x.name);
				x.eat();
				keeper.exerciseAnimal(x.name);
				x.roam();
				keeper.sleepAnimal(x.name);
				x.sleep();
			}
			keeper.leaveZoo(strDay);
			System.out.println();
		}
	}
}

//Zoo employee class that contains methods that all zoo employees do
abstract class ZooEmployee {

	abstract void goToWork(String day);

	abstract void wakeUpAnimal(String name);

	abstract void sleepAnimal(String name);

	void countAnimal(String name) {
		System.out.println(name + " is counted for roll call");
	}

	void leaveZoo(String day) {
		System.out.println("Employee leaves zoo on day " + day);
	}
}

//Provides implementation for abstract method inherited and has its own methods specific to a zookeeper
class Zookeeper extends ZooEmployee {

	void goToWork(String day) {
		System.out.println("Zookeeper arrives to zoo on day " + day);
	}

	void wakeUpAnimal(String name) {
		System.out.println("Zookeeper wakes up " + name);
	}

	void sleepAnimal(String name) {
		System.out.println("Zookeeper tells " + name + " to go to bed");
	}

	void feedAnimal(String name) {
		System.out.println("Zookeeper feeds " + name);
	}

	void exerciseAnimal(String name) {
		System.out.println("Zookeeper exercises " + name);
	}

	@Override
	void leaveZoo(String day) {
		System.out.println("Zookeeper leaves zoo on day " + day);
	}
}

class Animal{
	
	protected String name;
	
	void wakeUp() {
		System.out.println(name + " wakes up");
	}
	void makeNoise() {
		System.out.println(name + " makes noise");
	}
	
	void eat() {
		System.out.println(name + " eats");
	}
	
	void roam() {
		System.out.println(name + " roams");
	}
	
	void sleep() {
		System.out.println(name + " goes to sleep");
	}

}

class Pachyderm extends Animal{
	@Override
	void roam() {
		double charge_chance = Math.random();
		if (charge_chance <= 0.25) {
			System.out.println(name + " charges");
		} else {
			System.out.println(name + " roams");
		}
	}
	
}

class Feline extends Animal{	
	@Override
	void sleep() {
		double sleep_chance = Math.random();
		if (sleep_chance <= 0.3) {
			System.out.println(name + " roams");
		} else if (sleep_chance > 0.3 && sleep_chance <= 0.6) {
			System.out.println(name + " makes noise");
		} else {
			System.out.println(name + " goes to sleep");
		}
	}
}

class Canine extends Animal{
	
}

class Bovidae extends Animal{
	
}

class Hippo extends Pachyderm{
	Hippo(String name){
		super.name = name;
	}
}

class Elephant extends Pachyderm{
	Elephant(String name){
		super.name = name;
	}
}

class Rhino extends Pachyderm{
	Rhino(String name){
		super.name = name;
	}
}

class Tiger extends Feline{
	Tiger(String name){
		super.name = name;
	}
}

class Lion extends Feline{
	Lion(String name){
		super.name = name;
	}
}

class Cat extends Feline{
	Cat(String name){
		super.name = name;
	}
}

class Dog extends Canine{
	Dog(String name){
		super.name = name;
	}
	
	@Override
	void roam() {
		double dig_chance = Math.random();
		if (dig_chance <= 0.25) {
			System.out.println(name + " digs");
		} else {
			System.out.println(name + " roams");
		}
	}
}

class Wolf extends Canine{
	Wolf(String name){
		super.name = name;
	}
}

class Bison extends Bovidae{
	Bison(String name){
		super.name = name;
	}
}

class Goat extends Bovidae{
	Goat(String name){
		super.name = name;
	}
}