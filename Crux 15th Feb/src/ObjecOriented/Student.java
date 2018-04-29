package ObjecOriented;


public class Student {
	public String name;
	final int rollNumber;
	static int numStudents;
	
	public int getRollNumber() {
		return rollNumber;
	}
	
	public Student(String name) {
		this.name = name;
		rollNumber = 1000;
	}
	
	
	public static void main(String args[]) {
		Student s1 = new Student("Ankush");
		System.out.println(s1.name);
		//s1.name = "Geet";
		Student s2 = new Student("Prashant");
		
		s2 = new Student("");
		s2.name = "blah";
		System.out.println(s2.rollNumber);
		StudentUse2.printStudent(s1);
//		Student[] students = new Student[100];
//		int i = 0;
//		while (i < 100) {
//			students[i] = new Student();
//		}
//		
//		System.out.println(s1.name + " " + s1.rollNumber + " " + s1.numStudents);
		//System.out.println(s2.name + " " + s2.rollNumber+ " " + s2.numStudents);
	}
}
