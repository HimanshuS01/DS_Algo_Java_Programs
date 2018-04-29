package ObjecOriented;


public class StudentUse {
	
	public static void printStudent(Student s1) {
		System.out.println(s1.name + " " + s1);
	}
	
	public static void main(String args[]) {
		//Student s = new Student("abc", 1);
		final int a = 10;
		//a = 20;
		final String s = "abc";
		//s = "duhud";
		
		final int[] ab = {1,2,3};
		//ab = new int[3];
		ab[2] = 10;
		
		final Car c = new Car();
		c.numDoors = 10;
	}
}
