package fundamentals;

public class Test {

	static {
		System.out.println("static");
	}

	{
		System.out.println("non static");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t1 = new Test();
		Test t2 = new Test();
	}

}
