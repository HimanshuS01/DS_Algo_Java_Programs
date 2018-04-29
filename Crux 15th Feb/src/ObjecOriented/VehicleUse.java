package ObjecOriented;

import java.util.Arrays;
import java.util.Scanner;

public class VehicleUse {

	public static void main(String args[]) {
		Vehicle v = new Car();

		Car c = new Car();
		c.getNumDoors();
		c.printDescription();

		Vehicle[] vehicles = new Vehicle[10];

		//	vehicles[0] = new Vehicle();
		vehicles[1] = new Car();

		//		Scanner s = new Scanner(System.in);
		//		int n = s.nextInt();
		//		
		Vehicle v1;
		v1 = new Car();
		v1.printDescription();



		//Integer[] a = new Integer[10];
		Car[] vA = new Car[10];
		for (int i = 0; i < 10; i++) {
			vA[i] = new Car();
			vA[i].power = 10-i;
			System.out.println(vA[i].power);
		}
		System.out.println("Sorting");
		//Arrays.sort(vA, 0, 10);
		Sorter.bubbleSort(vA);
		for (int i =0; i < 10; i++) {
			System.out.println(vA[i].power);
		}
		int i = 10;
		//pair<Car, Integer> p = new pair<Car, Integer>();
		//p.getFirst()
	}
}
