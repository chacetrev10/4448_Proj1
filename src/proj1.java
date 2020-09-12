import java.util.Scanner;

public class proj1 {

	public static void main(String[] args) {
		System.out.println("Please enter the number of days you want to simulate at the zoo");
		Scanner input = new Scanner(System.in);
		int numOfDays = input.nextInt();
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
	
	private String name;
	Animal(String name){
		this.name= name;
	}
	
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

class Pachyderm{
	
}

class Feline{
	
}

class Canine{
	
}

class Bovidae{
	
}

class Hippo{

}

class Elephant{
	
}

class Rhino{
	
}

class Tiger{
	
}

class Lion{
	
}

class Cat{
	
}

class Dog{
	
}

class Wolf{
	
}

class Bison{
	
}

class Goat{
	
}
