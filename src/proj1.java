import java.util.Scanner;

public class proj1 {

	public static void main(String[] args) {
		System.out.println("Please enter the number of days you want to simulate at the zoo");
		Scanner input = new Scanner(System.in);
		int numOfDays = input.nextInt();
		Animal[] arr = new Animal[3];
		Rhino r = new Rhino("Rhino");
		Bison b = new Bison("Bison");
		Tiger t = new Tiger("Tiger");
		arr[0] = r;
		arr[1] = b;
		arr[2] = t;
		for(Animal x: arr) {
			x.eat();
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

	
}

class Feline extends Animal{
	
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
