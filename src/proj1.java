import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Math;

public class proj1 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Please enter the number of days you want to simulate at the zoo");
		Scanner input = new Scanner(System.in);
		int numOfDays = input.nextInt();
		
		Zookeeper keeper = new Zookeeper();
		Animal[] zoo = new Animal[20];
		
		
		zoo[0] = new Hippo("Harry the Hippo");
		zoo[1] = new Hippo("Hector the Hippo");
		zoo[2] = new Elephant("Eugene the Elephant");
		zoo[3] = new Elephant("Eric the Elephant");
		zoo[4] = new Rhino("Rory the Rhino");
		zoo[5] = new Rhino("Randy the Rhino");
		zoo[6] = new Tiger("Titus the Tiger");
		zoo[7] = new Tiger("Terry the Tiger");
		zoo[8] = new Lion("Larry the Lion");
		zoo[9] = new Lion("Lenny the Lion");
		zoo[10] = new Cat("Candy the Cat");
		zoo[11] = new Cat("Carol the Cat");
		zoo[12] = new Dog("Donovan the Dog");
		zoo[13] = new Dog("Dax the Dog");
		zoo[14] = new Wolf("Wyatt the Wolf");
		zoo[15] = new Wolf("Willy the Wolf");
		zoo[16] = new Bison("Billy the Bison");
		zoo[17] = new Bison("Brandon the Bison");
		zoo[18] = new Goat("Gary the Goat");
		zoo[19] = new Goat("Grayson the Goat");
		
		
		
//	Uncomment this is you want the output printed to a file
//	Referenced https://stackoverflow.com/questions/1994255/how-to-write-console-output-to-a-txt-file
		PrintStream out = new PrintStream(new FileOutputStream("dayatthezoo.out"));
		System.setOut(out);
		
	
		for(int day = 0; day < numOfDays; day++) {
			String strDay = String.valueOf(day+1); 
			keeper.goToWork(strDay);
			for(Animal x: zoo) {
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
	@Override
	void eat() {
		System.out.println(name + " grazes on grass");
	}
}

class Goat extends Bovidae{
	Goat(String name){
		super.name = name;
	}
	@Override
	void eat() {
		System.out.println(name + " tries to eat your shoe");
	}
}