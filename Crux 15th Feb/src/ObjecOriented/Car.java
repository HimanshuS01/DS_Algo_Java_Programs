package ObjecOriented;

public class Car extends Vehicle implements VehicleInterface, Comparison<Car>{
	static int numCars = 0;
	public Car() {
		numCars++;
	}
	int numDoors;

	public int getNumDoors() {
		return numDoors;
	}

	public static void blah() {

	}

	public String getVehicleType() {
		return "Car";
	}

	public void print(Vehicle v) {

	}

	public void printDescription() {
		Car c = new Car();
		print(c);
		c.getNumDoors();
		System.out.println("Tires " + numTires + " power " +
				power + " capacity " + tankCapacity + " num doors " + numDoors);
	}

	@Override
	public int getModel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Car o) {
		if (this.power > o.power) {
			return 1;
		} else if (this.power < o.power) {
			return -1;
		} else{
			return 0;
		}
	}

}
